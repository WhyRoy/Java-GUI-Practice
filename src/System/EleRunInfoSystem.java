package System;

import view.EleRunInfoView;

import java.util.Scanner;

public class EleRunInfoSystem {
    public static void showmenu() {
        System.out.println("1.显示所有电梯运行状况");
        System.out.println("2.查询出错的电梯信息");
        System.out.println("3.查询电梯运行时间");
        System.out.println("");
        System.out.println("0.返回上一级");
    }

    public static void showall() {
        EleRunInfoView.showallEleRunInfo();
    }

    public static void showerrormsg() {
        EleRunInfoView.showstopEleInfo();
    }

    public static void runningtime() {
        Scanner cin = new Scanner(System.in);
        System.out.print("输入阈值(hours): ");
        int time = cin.nextInt();
        EleRunInfoView.showruntimegreater(time);
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
                    showerrormsg();
                    break;
                case 3:
                    runningtime();
                    break;
            }
            showmenu();
            n = cin.nextByte();
        }
    }
}
