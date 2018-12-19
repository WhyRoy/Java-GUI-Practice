package System;

import Dao.UserInfoDao;
import tables.UserInfo;
import view.UserInfoView;

import java.util.Scanner;

public class UserInfoSystem {
    public static void showmenu() {
        System.out.println("1.显示所有记录");
        System.out.println("2.根据维修人员id查询记录");
        System.out.println("3.查询某区域所有维修人员");
        System.out.println("4.查询某地区目前可调用的维修人员");
        System.out.println("5.添加新的人员记录");
        System.out.println("6.删除人员记录");
        System.out.println("7.更新人员在岗状态");
        System.out.println("8.查找人员");
        System.out.println("");
        System.out.println("0.返回上一级");
    }

    public static void showall() {
        UserInfoView.allUserInfo();
    }

    public static void showbyid() {
        Scanner cin = new Scanner(System.in);
        System.out.print("输入维修人员id:");
        String id;
        id = cin.next();
        UserInfoView.oneUserInfo(id);
    }

    public static void showbyrange() {
        Scanner cin = new Scanner(System.in);
        System.out.print("输入所在区域:");
        String range;
        range = cin.next();
        UserInfoView.showAllRangeUser(range);
    }

    public static void showbyrangeandonline() {
        Scanner cin = new Scanner(System.in);
        System.out.print("输入所在区域:");
        String range2 = cin.next();
        System.out.print("查询是否在岗 y/n: ");
        String choice = cin.next();
        boolean online;
        if (choice.equals("Y") || choice.equals("y"))
            online = true;
        else if (choice.equals("N") || choice.equals("n"))
            online = false;
        else {
            System.out.print("非法输入，请重试");
            return;
        }
        UserInfoView.showUserByRangeAndOnline(range2, online);
    }

    public static void addone() {
        Scanner cin = new Scanner(System.in);
        UserInfo add = new UserInfo();
        System.out.println("----------正在添加一条新用户记录----------");
        System.out.print("用户ID: ");
        add.setUserid(cin.next());
        System.out.print("用户姓名: ");
        add.setUsername(cin.next());
        System.out.print("是否为管理员(y/n): ");
        String choice = cin.next();
        if (choice.equals("Y") || choice.equals("y"))
            add.setUseradmin(true);
        else if (choice.equals("N") || choice.equals("n"))
            add.setUseradmin(false);
        else {
            System.out.print("非法输入，请重试");
            return;
        }
        System.out.print("输入用户密码(6位数字): ");
        String pwd = cin.next();
        if (!InputCheck.pwdcheck(pwd)) {
            System.out.print("非法输入，请重试");
            return;
        }
        System.out.print("用户所在区域: ");
        add.setUserrange(cin.next());
        System.out.print("用户当前是否在岗(y/n): ");
        choice = cin.next();
        if (choice.equals("Y") || choice.equals("y"))
            add.setUseronline(true);
        else if (choice.equals("N") || choice.equals("n"))
            add.setUseronline(false);
        else {
            System.out.print("非法输入，请重试");
            return;
        }
        UserInfoDao.addOneUser(add, pwd);
    }

    public static void deleteone() {
        Scanner cin = new Scanner(System.in);
        System.out.print("输入删除用户ID: ");
        String del = cin.next();
        UserInfoDao.deleteOneUser(del);
    }

    public static void updateoneonline() {
        Scanner cin = new Scanner(System.in);
        System.out.print("输入用户ID: ");
        String userid = cin.next();
        System.out.print("输入用户状态(y/n): ");
        String choice = cin.next();
        if (choice.equals("Y") || choice.equals("y"))
            UserInfoDao.updateOneuserOnlineByuserid(userid, true);
        else if (choice.equals("N") || choice.equals("n"))
            UserInfoDao.updateOneuserOnlineByuserid(userid, false);
        else {
            System.out.print("非法输入，请重试");
            return;
        }
    }

    public static void searchone() {
        Scanner cin = new Scanner(System.in);
        System.out.print("输入用户姓名: ");
        String name = cin.next();
        UserInfoView.searchByName(name);
    }

    public static void choose() {
        Scanner cin = new Scanner(System.in);
        byte n = 0;
        showmenu();
        n = cin.nextByte();
        while (n != 0) {
            switch (n) {
                case 1:
                    showall();
                    break;
                case 2:
                    showbyid();
                    break;
                case 3:
                    showbyrange();
                    break;
                case 4:
                    showbyrangeandonline();
                    break;
                case 5:
                    addone();
                    break;
                case 6:
                    deleteone();
                    break;
                case 7:
                    updateoneonline();
                    break;
                case 8:
                    searchone();
                    break;
            }
            showmenu();
            n = cin.nextByte();
        }
    }
}
