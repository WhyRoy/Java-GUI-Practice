package view;

import Dao.EleInfoDao;
import tables.EleInfo;

import java.util.List;

public class EleInfoView {
    //输出topbar
    public static void topbar() {
        System.out.print("\t电梯ID");
        System.out.print("\t电梯型号");
        System.out.print("\t创建日期");
        System.out.print("\t所在区域");
        System.out.print("\t所在地址");
        System.out.print("\t最近检修日期");
        System.out.print("\n");
    }

    //输出单条记录
    public static void showOneEleInfo(EleInfo s) {
        System.out.print("\t" + s.getEleid());
        System.out.print("\t" + s.getEletype());
        System.out.print("\t" + s.getElecreatedate());
        System.out.print("\t" + s.getElerange());
        System.out.print("\t" + s.getEleaddress());
        System.out.print("\t" + s.getElelastmtdate());
        System.out.print("\n");
    }

    //输出所有记录
    public static void allEleInfo() {
        int n = 0;
        List<EleInfo> list = EleInfoDao.allEleInfo();
        topbar();
        for (EleInfo s : list) {
            n++;
            showOneEleInfo(s);
        }
    }

    //输出指定eleid的第一条记录
    public static void oneEleInfo(String eleid) {
        EleInfo s;
        s = EleInfoDao.findbyeleid(eleid);
        if (s != null) {
            showOneEleInfo(s);
        }
    }

    //输出指定elerange的第一条记录
    public static void allElerange(String elerange) {
        int n = 0;
        List<EleInfo> list = EleInfoDao.findbyelerange(elerange);
        for (EleInfo s : list) {
            n++;
            showOneEleInfo(s);
        }
    }
}
