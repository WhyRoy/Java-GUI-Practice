package view;

import Dao.EleRunInfoDao;
import tables.EleRunInfo;

import java.util.List;

public class EleRunInfoView {
    //输出单条记录
    public static void showOneEleInfo(EleRunInfo s) {
        System.out.print("\t" + s.getEleid());
        if (s.isEleisrunning()) {
            System.out.print("\t正在运行");
        } else {
            System.out.print("\t停止运行");
        }
        System.out.print("\t" + s.getElerunningtime() + "Hours");
        if (s.getEleerrormsg() != null) {
            System.out.print("\t" + s.getEleerrormsg());
        }
        System.out.print("\n");
    }

    public static void showallEleRunInfo() {
        int n = 0;
        List<EleRunInfo> list = EleRunInfoDao.allEleRunInfo();
        for (EleRunInfo s : list) {
            n++;
            showOneEleInfo(s);
        }
    }

    public static void showstopEleInfo() {
        int n = 0;
        List<EleRunInfo> list = EleRunInfoDao.stopEleInfomsg();
        for (EleRunInfo s : list) {
            n++;
            showOneEleInfo(s);
        }
    }

    public static void showruntimegreater(int time) {
        int n = 0;
        List<EleRunInfo> list = EleRunInfoDao.findruntimegreater(time);
        for (EleRunInfo s : list) {
            n++;
            showOneEleInfo(s);
        }
    }

    public static int showcounterror() {
        return EleRunInfoDao.counterror();
    }

    public static int showcountall() {
        return EleRunInfoDao.countall();
    }
}
