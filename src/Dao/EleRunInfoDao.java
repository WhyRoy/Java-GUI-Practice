package Dao;

import tables.EleRunInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EleRunInfoDao {
    //转换
    private static EleRunInfo convertEleRunInfo(ResultSet rs) {
        EleRunInfo Info = new EleRunInfo();
        try {
            Info.setEleid(rs.getString("eleid"));
            Info.setEleisrunning(rs.getBoolean("eleisrunning"));
            Info.setElerunningtime(rs.getInt("elerunningtime"));
            Info.setEleerrormsg(rs.getString("eleerrormsg"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Info;
    }

    //查询所有电梯的运行状况
    public static List<EleRunInfo> allEleRunInfo() {
        try {
            List<EleRunInfo> list = new ArrayList<>();
            String sql = "SELECT * FROM EleRunInfo";
            System.out.println("执行: " + sql);
            ResultSet rs = BaseDao.executeQuery(sql);
            while (rs.next()) {
                EleRunInfo info = convertEleRunInfo(rs);
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

    //查询所有未正常运行电梯的错误信息
    public static List<EleRunInfo> stopEleInfomsg() {
        try {
            List<EleRunInfo> list = new ArrayList<>();
            String sql = "SELECT * FROM EleRunInfo WHERE eleisrunning = false";
            System.out.println("执行: " + sql);
            ResultSet rs = BaseDao.executeQuery(sql);
            while (rs.next()) {
                EleRunInfo info = convertEleRunInfo(rs);
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

    //查询连续运行时间超过某个阈值的电梯记录
    public static List<EleRunInfo> findruntimegreater(int time) {
        try {
            List<EleRunInfo> list = new ArrayList<>();
            String sql = "SELECT * FROM EleRunInfo WHERE elerunningtime > " + time;
            System.out.println("执行: " + sql);
            ResultSet rs = BaseDao.executeQuery(sql);
            while (rs.next()) {
                EleRunInfo info = convertEleRunInfo(rs);
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

    //查询所有电梯个数
    public static int countall() {
        try {
            int cnt = 0;
            String sql = "SELECT * FROM EleRunInfo";
            System.out.println("执行: " + sql);
            ResultSet rs = BaseDao.executeQuery(sql);
            while (rs.next()) {
                cnt++;
            }
            rs.close();
            BaseDao.dbClose();
            return cnt;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    //查询未正常运行的电梯个数
    public static int counterror() {
        try {
            int cnt = 0;
            String sql = "SELECT * FROM EleRunInfo WHERE eleisrunning = false";
            System.out.println("执行: " + sql);
            ResultSet rs = BaseDao.executeQuery(sql);
            while (rs.next()) {
                cnt++;
            }
            rs.close();
            BaseDao.dbClose();
            return cnt;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    //启动程序时自动更新运行时间
    public static void initruntime() {
        try {
            String sql = "SELECT * FROM EleRunInfo ";
            ResultSet rs = BaseDao.executeQuery(sql);
            while (rs.next()) {
                String eleid = rs.getString("eleid");
                sql = "UPDATE eleruninfo \n" +
                        "SET elerunningtime = ( TIMESTAMPDIFF( HOUR, ( SELECT elelastmtdate FROM eleinfo WHERE eleid = '" + eleid + "' ), curdate( ) ) ) \n" +
                        "WHERE\n" +
                        "\t( eleid = '" + eleid + "' AND eleisrunning = TRUE )";
                int n = BaseDao.executeUpdate(sql);
            }
            rs.close();
            BaseDao.dbClose();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
