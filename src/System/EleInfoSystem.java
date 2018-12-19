package System;

import Dao.EleInfoDao;
import tables.EleInfo;
import view.EleInfoView;

import java.sql.Date;
import java.util.Scanner;

public class EleInfoSystem {
    public static void showmenu() {
        System.out.println("1.显示所有记录");
        System.out.println("2.根据电梯id查询记录");
        System.out.println("3.查询某区域所有电梯");
        System.out.println("4.添加电梯记录");
        System.out.println("5.删除电梯记录");
        System.out.println("6.更新电梯最近维检日期");
        System.out.println("");
        System.out.println("0.返回上一级");
    }

    public static void showall() {
        EleInfoView.allEleInfo();
    }

    public static void showbyid() {
        Scanner cin = new Scanner(System.in);
        System.out.print("输入电梯id:");
        String id;
        id = cin.next();
        EleInfoView.oneEleInfo(id);
    }

    public static void showbyrange() {
        Scanner cin = new Scanner(System.in);
        System.out.print("输入电梯区域:");
        String range;
        range = cin.next();
        EleInfoView.allElerange(range);
    }

    public static void addone() {
        Scanner cin = new Scanner(System.in);
        EleInfo add = new EleInfo();
        System.out.println("----------正在添加一条新电梯记录----------");
        System.out.print("电梯ID: ");
        add.setEleid(cin.next());
        System.out.print("电梯型号: ");
        add.setEletype(cin.next());
        System.out.print("电梯安装日期(YYYY-MM-DD): ");
        String date = cin.next();
        if (InputCheck.datecheck(date) == false) {
            System.out.println("错误:输入时间逻辑错误 请重试\n");
            return;
        }
        add.setElecreatedate(Date.valueOf(date));
        System.out.print("电梯所在区域: ");
        add.setElerange(cin.next());
        System.out.print("电梯所在地址: ");
        add.setEleaddress(cin.next());
        System.out.print("最近维修检查时间(YYYY-MM-DD): ");
        date = cin.next();
        if (InputCheck.datecheck(date) == false) {
            System.out.println("错误:输入时间逻辑错误 请重试\n");
            return;
        }
        add.setElelastmtdate(Date.valueOf(date));
        if (add.getElelastmtdate().before(add.getElecreatedate()) == true) {
            System.out.println("错误:输入时间逻辑错误 请重试\n");
            return;
        }
        EleInfoDao.addOneEle(add);
    }

    public static void deleteone() {
        Scanner cin = new Scanner(System.in);
        System.out.print("输入删除电梯ID:");
        String del = cin.next();
        EleInfoDao.deleteOneEle(del);
    }

    public static void updateone() {
        Scanner cin = new Scanner(System.in);
        System.out.print("输入电梯ID： ");
        String eleid = cin.next();
        System.out.print("是否使用当前时间(y/n)");
        String choice = cin.next();
        String date;
        Date currentDate;
        if (choice.equals("Y") || choice.equals("y")) {
            currentDate = new Date(System.currentTimeMillis());
        } else if (choice.equals("N") || choice.equals("n")) {
            System.out.print("输入最近维修日期(yyyy-MM-dd)： ");
            date = cin.next();
            if (InputCheck.datecheck(date) == false) {
                System.out.println("错误:输入时间逻辑错误 请重试\n");
                return;
            }
            currentDate = Date.valueOf(date);
        } else {
            System.out.print("非法输入，请重试");
            return;
        }
        EleInfoDao.updateMtdate(currentDate, eleid);
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
                    addone();
                    break;
                case 5:
                    deleteone();
                    break;
                case 6:
                    updateone();
                    break;
            }
            showmenu();
            n = cin.nextByte();
        }
    }
}
