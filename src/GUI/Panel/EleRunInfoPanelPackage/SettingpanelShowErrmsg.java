package GUI.Panel.EleRunInfoPanelPackage;

import Dao.EleRunInfoDao;
import GUI.MyTabel;
import tables.EleRunInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SettingpanelShowErrmsg extends JPanel {
    DefaultTableModel model;
    public static MyTabel table;
    private static Object[][] tableDatas;

    public SettingpanelShowErrmsg() {
        initialize();
        inittableDate();
        addComponent();
    }

    /**
     * 初始化
     */
    private void initialize() {
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());
    }

    /**
     * 添加组件
     */
    private void addComponent() {
        this.add(getCenterPanel(), BorderLayout.CENTER);
        this.add(getDownPanel(), BorderLayout.SOUTH);
    }

    public JPanel getCenterPanel() {
        JPanel panelCenter = new JPanel();
        panelCenter.setBackground(Color.white);
        panelCenter.setLayout(new GridLayout(1, 1));

        model = new DefaultTableModel(tableDatas, new String[]{"编号", "电梯运行状况", "电梯持续运行时间(分钟)", "电梯错误信息", "", ""});
        table = new MyTabel(model);
        table.Beautiful(true);

        //设置滚动条
        JScrollPane panelScroll = new JScrollPane(table);
        panelScroll.setBackground(Color.white);
        panelCenter.add(panelScroll, BorderLayout.CENTER);


        return panelCenter;
    }

    private JPanel getDownPanel() {
        JPanel panelDown = new JPanel();
        JLabel info = new JLabel("数据查询完成");

        Font font = new Font("微软雅黑", 0, 12);
        panelDown.setFont(font);
        panelDown.add(info);

        return panelDown;
    }

    private static void inittableDate() {
        List<EleRunInfo> list = EleRunInfoDao.stopEleInfomsg();
        Object[][] result = new Object[list.size()][6];

        int i = 0;
        for (EleRunInfo ele : list) {
            result[i][0] = ele.getEleid();
            result[i][1] = ele.isEleisrunning();
            result[i][2] = ele.getElerunningtime();
            result[i][3] = ele.getEleerrormsg();
            i++;
        }
        tableDatas = result;
    }
}
