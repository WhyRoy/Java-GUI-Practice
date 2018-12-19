package view;

import Dao.UserInfoDao;
import tables.UserInfo;

import java.util.List;

public class UserInfoView {

    //输出单条记录
    public static void showOneUserInfo(UserInfo s) {
        System.out.print("\t" + s.getUserid());
        System.out.print("\t" + s.getUsername());
        if (s.isUseradmin()) {
            System.out.print("\t是");
        } else {
            System.out.print("\t否");
        }
        System.out.print("\t" + s.getUserrange());
        if (s.isUseronline()) {
            System.out.print("\t是");
        } else {
            System.out.print("\t否");
        }
        System.out.print("\n");
    }

    //输出所有记录
    public static void allUserInfo() {
        int n = 0;
        List<UserInfo> list = UserInfoDao.allUserInfo();
        for (UserInfo s : list) {
            n++;
            showOneUserInfo(s);
        }
    }

    //输出指定userid的第一条记录
    public static void oneUserInfo(String userid) {
        UserInfo s;
        s = UserInfoDao.findbyuserid(userid);
        if (s != null) {
            showOneUserInfo(s);
        }
    }

    //输出指定所有指定区域的用户
    public static void showAllRangeUser(String userrange) {
        int n = 0;
        List<UserInfo> list = UserInfoDao.findbyuserrange(userrange);
        for (UserInfo s : list) {
            n++;
            showOneUserInfo(s);
        }
    }

    //输出根据所处位置以及是否在线
    public static void showUserByRangeAndOnline(String userrange, boolean useronline) {
        int n = 0;
        List<UserInfo> list = UserInfoDao.findbyRangeAndOnline(userrange, useronline);
        for (UserInfo s : list) {
            n++;
            showOneUserInfo(s);
        }
    }

    public static void searchByName(String name) {
        int n = 0;
        List<UserInfo> list = UserInfoDao.searchUsername(name);
        for (UserInfo s : list) {
            n++;
            showOneUserInfo(s);
        }
    }
}
