package GUI.Panel.EleRunInfoPanelPackage;

import Dao.EleRunInfoDao;
import GUI.MyIconButton;
import GUI.MyTabel;
import tables.EleRunInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SettingPanelRunningTime extends JPanel {
    JLabel labeltime;

    JTextField texttime;

    MyIconButton buttontime;

    JLabel info;

    DefaultTableModel model;
    public static MyTabel table;
    private static Object[][] tableDatas;
    JScrollPane panelScroll;

    public SettingPanelRunningTime() {
        initialize();
        tableDatas = new Object[1][6];
        addComponent();
        addListener();
    }

    private void initialize() {
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());
    }

    private void addComponent() {
        this.add(getCenterPanel(), BorderLayout.CENTER);
        this.add(getDownPanel(), BorderLayout.SOUTH);
    }

    private JPanel getCenterPanel() {
        JPanel panelCenter = new JPanel();
        panelCenter.setBackground(Color.white);
        panelCenter.setLayout(new GridLayout(2, 1));


        //设置Grid
        JPanel panelGridSetting = new JPanel();
        panelGridSetting.setBackground(Color.white);
        panelGridSetting.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 30));

        //初始化组件
        labeltime = new JLabel("设置Time阈值");

        texttime = new JTextField();

        ImageIcon icon_settime = new ImageIcon("src/resources/icon/settime.png");
        ImageIcon icon_settime_enable = new ImageIcon("src/resources/icon/settimeEnable.png");
        ImageIcon icon_settime_disable = new ImageIcon("src/resources/icon/fsettimeDisable.png");

        buttontime = new MyIconButton(icon_settime, icon_settime_enable, icon_settime_disable, "time");

        // 字体
        Font font = new Font("微软雅黑", 0, 13);
        labeltime.setFont(font);
        texttime.setFont(font);

        // 大小
        Dimension SIZE = new Dimension(100, 30);
        labeltime.setPreferredSize(SIZE);

        SIZE = new Dimension(250, 24);
        texttime.setPreferredSize(SIZE);

        panelGridSetting.add(labeltime);
        panelGridSetting.add(texttime);
        panelGridSetting.add(buttontime);

        //表格设置
        model = new DefaultTableModel(tableDatas, new String[]{"编号", "电梯运行状况", "电梯持续运行时间(分钟)", "电梯错误信息", "", ""});
        table = new MyTabel(model);
        table.Beautiful(true);

        //设置滚动条
        panelScroll = new JScrollPane(table) {
            public Dimension getPreferredSize() {
                return new Dimension(300, 60);
            }
        };
        panelScroll.setBackground(Color.white);


        panelCenter.add(panelGridSetting);
        panelCenter.add(panelScroll);

        return panelCenter;

    }

    private JPanel getDownPanel() {
        JPanel panelDown = new JPanel();
        info = new JLabel("输入查询内容");

        Font font = new Font("微软雅黑", 0, 12);
        panelDown.setFont(font);
        panelDown.add(info);

        return panelDown;
    }

    private void addListener() {
        buttontime.addActionListener(e -> {
            String input = texttime.getText();
            if (input.equals("")) {
                info.setText("Time不能为空");
                JOptionPane.showMessageDialog(this, "Time不能为空");
                return;
            }
            int time = Integer.parseInt(input);

            inittabledatabyid(time);

            model = new DefaultTableModel(tableDatas, new String[]{"编号", "电梯运行状况", "电梯持续运行时间(分钟)", "电梯错误信息", "", ""});
            table.setModel(model);
            table.Beautiful(true);
            info.setText("Success");
        });
    }

    public static void inittabledatabyid(int time) {

        List<EleRunInfo> list = EleRunInfoDao.findruntimegreater(time);
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
