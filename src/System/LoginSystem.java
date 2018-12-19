package System;

import Dao.UserLoginInfoDao;

import java.util.Scanner;

public class LoginSystem {
    public static boolean Login() {
        Scanner cin = new Scanner(System.in);
        System.out.print("请输入你的id:");
        String userid = cin.next();
        String pwd = UserLoginInfoDao.findpwdbyid(userid);
        System.out.print("请输入你的密码:");
        String input = cin.next();
        return input.equals(pwd);
    }
}
