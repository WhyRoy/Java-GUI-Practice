package System;

import Dao.EleRunInfoDao;
import view.EleRunInfoView;

import java.util.Scanner;

public class MainSystem {
    public static void showmenu() {
        System.out.println("1.电梯信息");
        System.out.println("2.用户信息");
        System.out.println("3.电梯运行情况");
        System.out.println("");
        System.out.println("0.退出");
    }

    public static void choose() {
        Scanner cin = new Scanner(System.in);

        if (!LoginSystem.Login()) {
            System.out.println("密码错误");
            return;
        }

        System.out.println("正在初始化系统......");
        EleRunInfoDao.initruntime();
        int all = EleRunInfoView.showcountall();
        int err = EleRunInfoView.showcounterror();
        int normal = all - err;
        System.out.println("初始化完成！");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("**********************************");
        System.out.println("当前系统监测中的电梯共有" + all + "台");
        System.out.println("其中正常运行共有" + normal + "台");
        System.out.println("其中非正常运行共有" + err + "台");
        System.out.println("进入系统查看详情");
        System.out.println("**********************************");

        byte n = 0;
        showmenu();
        n = cin.nextByte();
        while (n != 0) {
            switch (n) {
                case 1:
                    EleInfoSystem.choose();
                    break;
                case 2:
                    UserInfoSystem.choose();
                    break;
                case 3:
                    EleRunInfoSystem.choose();
                    break;
            }
            showmenu();
            n = cin.nextByte();
        }
        System.out.println("Bye!");
    }
}
