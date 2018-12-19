package Dao;

import tables.UserInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDao {

    //转换
    private static UserInfo convertUserInfo(ResultSet rs) {
        UserInfo Info = new UserInfo();
        try {
            Info.setUserid(rs.getString("userid"));
            Info.setUsername(rs.getString("username"));
            Info.setUseradmin(rs.getBoolean("useradmin"));
            Info.setUserrange(rs.getString("userrange"));
            Info.setUseronline(rs.getBoolean("useronline"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Info;
    }

    //查询所有记录
    public static List<UserInfo> allUserInfo() {
        try {
            List<UserInfo> list = new ArrayList<>();
            String sql = "SELECT * FROM UserInfo";
            System.out.println("执行: " + sql);
            ResultSet rs = BaseDao.executeQuery(sql);
            while (rs.next()) {
                UserInfo info = convertUserInfo(rs);
                list.add(info);
            }
            rs.close();
            BaseDao.dbClose();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //根据userid查询记录
    public static UserInfo findbyuserid(String userid) {
        try {
            UserInfo one = new UserInfo();
            String sql = "SELECT * FROM UserInfo WHERE userid = '" + userid + "'";
            System.out.println("执行: " + sql);
            ResultSet rs = BaseDao.executeQuery(sql);
            if (rs.next()) {
                one = convertUserInfo(rs);
            }
            rs.close();
            BaseDao.dbClose();
            return one;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //根据所处位置查询记录
    public static List<UserInfo> findbyuserrange(String userrange) {
        try {
            List<UserInfo> list = new ArrayList<>();
            String sql = "SELECT * FROM UserInfo WHERE userrange = '" + userrange + "'";
            System.out.println("执行: " + sql);
            ResultSet rs = BaseDao.executeQuery(sql);
            while (rs.next()) {
                UserInfo info = convertUserInfo(rs);
                list.add(info);
            }
            rs.close();
            BaseDao.dbClose();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //根据所处位置以及是否在线
    public static List<UserInfo> findbyRangeAndOnline(String userrange, boolean useronline) {
        try {
            List<UserInfo> list = new ArrayList<>();
            String sql = "SELECT * FROM UserInfo WHERE userrange = '" + userrange + "' AND useronline = " + useronline;
            System.out.println("执行: " + sql);
            ResultSet rs = BaseDao.executeQuery(sql);
            while (rs.next()) {
                UserInfo info = convertUserInfo(rs);
                list.add(info);
            }
            rs.close();
            BaseDao.dbClose();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //添加一名用户
    public static void addOneUser(UserInfo User, String pwd) {
        String sql = "insert into UserInfo values('"
                + User.getUserid() + "', '"
                + User.getUsername() + "', "
                + User.isUseradmin() + ", '"
                + User.getUserrange() + "', "
                + User.isUseronline() + ")";
        System.out.println("执行: " + sql);
        int r = BaseDao.executeUpdate(sql);
        sql = "insert into UserLoginInfo values('"
                + User.getUserid() + "', '"
                + pwd + "', "
                + User.isUseradmin() + ")";
        System.out.println("执行: " + sql);
        int n = BaseDao.executeUpdate(sql);
        if (n > 0) {
            System.out.println("成功添加" + r + "名用户");
        }
        BaseDao.dbClose();
    }

    //删除一名用户
    public static void deleteOneUser(String userid) {
        String sql = "delete from UserInfo where userid = '" + userid + "'";
        System.out.println("执行: " + sql);
        int r = BaseDao.executeUpdate(sql);
        sql = "delete from UserLoginInfo where userid = '" + userid + "'";
        System.out.println("执行: " + sql);
        int n = BaseDao.executeUpdate(sql);
        if (r > 0 || n > 0)
            System.out.println("成功删除" + r + "名用户");
        BaseDao.dbClose();
    }

    //更改一名用户的状态
    public static void updateOneuserOnlineByuserid(String userid, boolean isonline) {
        String sql = "UPDATE UserInfo SET useronline = " + isonline + " WHERE userid = '" + userid + "'";
        System.out.println("执行: " + sql);
        int r = BaseDao.executeUpdate(sql);
        if (r > 0)
            System.out.println("成功更新" + r + "名用户状态");
        BaseDao.dbClose();
    }

    //查找名字类似的维修人员
    public static List<UserInfo> searchUsername(String name) {
        try {
            List<UserInfo> list = new ArrayList<>();
            String sql = "SELECT * FROM userinfo WHERE username LIKE '%" + name + "%'";
            System.out.println("执行: " + sql);
            ResultSet rs = BaseDao.executeQuery(sql);
            while (rs.next()) {
                UserInfo info = convertUserInfo(rs);
                list.add(info);
            }
            rs.close();
            BaseDao.dbClose();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //验证用户是否为管理员
    public static boolean isadmin(String userid) {
        try {
            boolean bool = false;
            String sql = "SELECT useradmin FROM UserInfo WHERE userid = '" + userid + "'";
            System.out.println("执行: " + sql);
            ResultSet rs = BaseDao.executeQuery(sql);
            if (rs.next()) {
                bool = rs.getBoolean("useradmin");
            }
            rs.close();
            BaseDao.dbClose();
            return bool;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //升级用户为管理员
    public static void updateadmin(String id) {
        String sql = "update UserInfo set useradmin = " + true + " WHERE userid = '" + id + "'";
        System.out.println("执行: " + sql);
        int r = BaseDao.executeUpdate(sql);
        if (r > 0)
            System.out.println("成功升级" + r + "名用户为管理员");
        BaseDao.dbClose();
    }
}
