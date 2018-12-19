package Dao;


import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginInfoDao {
    //根据userid查询password
    public static String findpwdbyid(String userid) {
        try {
            String pwd = "";
            String sql = "SELECT userpwd FROM UserLoginInfo WHERE userid = '" + userid + "'";
            System.out.println("执行: " + sql);
            ResultSet rs = BaseDao.executeQuery(sql);
            if (rs.next()) {
                pwd = rs.getString("userpwd");
            }
            rs.close();
            BaseDao.dbClose();
            return pwd;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //更改密码
    public static void updatepassword(String pwd, String id) {
        String sql = "update UserLoginInfo set userpwd = '" + pwd + "' WHERE userid = '" + id + "'";
        System.out.println("执行: " + sql);
        int r = BaseDao.executeUpdate(sql);
        if (r > 0) {
            System.out.println("成功更新" + r + "个用户密码");
        }
        BaseDao.dbClose();
    }
}
