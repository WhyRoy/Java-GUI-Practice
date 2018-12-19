package Dao;

import tables.EleInfo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EleInfoDao {

    //转换
    private static EleInfo convertEleInfo(ResultSet rs) {
        EleInfo Info = new EleInfo();
        try {
            Info.setEleid(rs.getString("eleid"));
            Info.setEletype(rs.getString("eletype"));
            Info.setElecreatedate(rs.getDate("elecreatedate"));
            Info.setElerange(rs.getString("elerange"));
            Info.setEleaddress(rs.getString("eleaddress"));
            Info.setElelastmtdate(rs.getDate("elelastmtdate"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Info;
    }

    //查询所有记录
    public static List<EleInfo> allEleInfo() {
        try {
            List<EleInfo> list = new ArrayList<>();
            String sql = "SELECT * FROM EleInfo";
            System.out.println("执行: " + sql);
            ResultSet rs = BaseDao.executeQuery(sql);
            while (rs.next()) {
                EleInfo info = convertEleInfo(rs);
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

    //根据eleid查询记录
    public static EleInfo findbyeleid(String eleid) {
        try {
            EleInfo one = new EleInfo();
            String sql = "SELECT * FROM EleInfo WHERE eleid = '" + eleid + "'";
            System.out.println("执行: " + sql);
            ResultSet rs = BaseDao.executeQuery(sql);
            if (rs.next()) {
                one = convertEleInfo(rs);
            }
            rs.close();
            BaseDao.dbClose();
            return one;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //根据elerange来查询数据
    public static List<EleInfo> findbyelerange(String elerange) {
        try {
            List<EleInfo> list = new ArrayList<>();
            String sql = "SELECT * FROM EleInfo WHERE elerange = '" + elerange + "'";
            ResultSet rs = BaseDao.executeQuery(sql);
            while (rs.next()) {
                EleInfo info = convertEleInfo(rs);
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

    //根据elerange和eleid来查询
    public static List<EleInfo> findbyrangeandid(String id, String range) {
        try {
            List<EleInfo> list = new ArrayList<>();
            String sql = "SELECT * FROM EleInfo WHERE ( elerange = '" + range + "' AND eleid = '" + id + "' )";
            ResultSet rs = BaseDao.executeQuery(sql);
            while (rs.next()) {
                EleInfo info = convertEleInfo(rs);
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

    //添加电梯
    public static void addOneEle(EleInfo Ele) {
        String sql = "insert into EleInfo values('"
                + Ele.getEleid() + "', '"
                + Ele.getEletype() + "', '"
                + Ele.getElecreatedate() + "', '"
                + Ele.getElerange() + "', '"
                + Ele.getEleaddress() + "', '"
                + Ele.getElelastmtdate() + "')";
        System.out.println("执行: " + sql);
        int r = BaseDao.executeUpdate(sql);
        sql = "insert into EleRunInfo values('"
                + Ele.getEleid() + "', "
                + false + ", "
                + 0 + ", "
                + null + ")";
        System.out.println("执行: " + sql);
        int n = BaseDao.executeUpdate(sql);
        if (r > 0 && n > 0) {
            System.out.println("成功添加" + r + "个电梯");
        }
        BaseDao.dbClose();
    }

    //删除电梯
    public static void deleteOneEle(String eleid) {
        String sql = "delete from EleInfo where eleid = '" + eleid + "'";
        System.out.println("执行: " + sql);
        int r = BaseDao.executeUpdate(sql);
        sql = "delete from EleRunInfo where eleid = '" + eleid + "'";
        System.out.println("执行: " + sql);
        int n = BaseDao.executeUpdate(sql);
        if (r > 0 & n > 0)
            System.out.println("成功删除" + r + "个电梯");
        BaseDao.dbClose();
    }

    //更新日期
    public static void updateMtdate(Date date, String eleid) {
        String sql = "UPDATE EleInfo SET elelastmtdate = '" + date + "' WHERE eleid = '" + eleid + "'";
        System.out.println("执行: " + sql);
        int r = BaseDao.executeUpdate(sql);
        if (r > 0) {
            System.out.println("成功更新" + r + "个电梯最近维修日期");
        }
        BaseDao.dbClose();
    }
}
