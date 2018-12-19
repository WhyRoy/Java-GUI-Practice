package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BaseDao {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/elevator?characterEncoding=gbk";
    private static String dbUser = "root";                                           //数据库用户名
    private static String dbPwd = "";                                                  //数据库密码
    private static Connection conn = null;
    private static Statement stmt = null;

    public static void dbConnect() {
        try {
            if (conn == null) {
                Class.forName(driver);                                        //加载数据库驱动
                conn = DriverManager.getConnection(url, dbUser, dbPwd);        //建立数据库连接
            } else
                return;
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    /**
     * 执行数据库查询操作
     *
     * @param sql
     * @return
     */
    public static ResultSet executeQuery(String sql) {
        try {
            if (conn == null)
                dbConnect();
            return conn.createStatement().executeQuery(sql);            //执行数据库查询
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {

        }
    }

    /**
     * 执行数据库更新操作
     *
     * @param sql
     * @return
     */
    public static int executeUpdate(String sql) {

        try {
            if (conn == null)
                dbConnect();
            return conn.createStatement().executeUpdate(sql);                //执行数据库更新
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        } finally {

        }
    }

    public static void dbClose() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }

    public static Statement dbConnectForTransaction() {

        try {
            if (conn == null) {
                Class.forName(driver);                                        //加载数据库驱动
                conn = DriverManager.getConnection(url, dbUser, dbPwd);        //建立数据库连接
                conn.setAutoCommit(false);
                stmt = conn.createStatement();
            } else
                return null;
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        return stmt;


    }

    public static void transactionCommit() {
        try {
            conn.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void transactionRollback() {
        try {
            conn.rollback();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void dbCloseForTransaction() {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            conn = null;
        }

    }

}

