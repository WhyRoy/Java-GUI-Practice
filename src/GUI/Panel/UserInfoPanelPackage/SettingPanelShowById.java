package GUI.Panel.UserInfoPanelPackage;

import Dao.UserInfoDao;
import GUI.MyIconButton;
import GUI.MyTabel;
import tables.UserInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SettingPanelShowById extends JPanel {
    JLabel labelid;
    JLabel labelrange;
    JLabel labelonline;

    JTextField textid;
    JTextField textrange;
    JCheckBox boxonline;

    MyIconButton buttonid;
    MyIconButton buttonrange;
    MyIconButton buttonrangeandonline;

    JLabel info;

    DefaultTableModel model;
    public static MyTabel table;
    private static Object[][] tableDatas;
    JScrollPane panelScroll;

    public SettingPanelShowById() {
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
        labelid = new JLabel("输入用户id编号");
        labelrange = new JLabel("输入用户区域");
        labelonline = new JLabel("用户是否在线");

        textid = new JTextField();
        textrange = new JTextField();
        boxonline = new JCheckBox("在岗");

        boxonline.setBackground(Color.white);

        ImageIcon icon_id = new ImageIcon("src/resources/icon/findbyid.png");
        ImageIcon icon_id_enable = new ImageIcon("src/resources/icon/findbyidEnable.png");
        ImageIcon icon_id_disable = new ImageIcon("src/resources/icon/findbyidDisable.png");

        ImageIcon icon_range = new ImageIcon("src/resources/icon/findbyrange.png");
        ImageIcon icon_range_enable = new ImageIcon("src/resources/icon/findbyrangeEnable.png");
        ImageIcon icon_range_disable = new ImageIcon("src/resources/icon/findbyrangeDisable.png");

        ImageIcon icon_all = new ImageIcon("src/resources/icon/rangeandonline.png");
        ImageIcon icon_all_enable = new ImageIcon("src/resources/icon/rangeandonlineEnable.png");
        ImageIcon icon_all_disable = new ImageIcon("src/resources/icon/rangeandonlineDisable.png");

        buttonid = new MyIconButton(icon_id, icon_id_enable, icon_id_disable, "id");
        buttonrange = new MyIconButton(icon_range, icon_range_enable, icon_range_disable, "range");
        buttonrangeandonline = new MyIconButton(icon_all, icon_all_enable, icon_all_disable, "range");

        // 字体
        Font font = new Font("微软雅黑", 0, 13);
        labelid.setFont(font);
        labelrange.setFont(font);
        labelonline.setFont(font);
        textid.setFont(font);
        textrange.setFont(font);
        boxonline.setFont(font);

        // 大小
        Dimension SIZE = new Dimension(100, 30);
        labelid.setPreferredSize(SIZE);
        labelrange.setPreferredSize(SIZE);
        labelonline.setPreferredSize(SIZE);

        SIZE = new Dimension(250, 24);
        textid.setPreferredSize(SIZE);
        textrange.setPreferredSize(SIZE);
        boxonline.setPreferredSize(SIZE);

        panelGridSetting.add(labelid);
        panelGridSetting.add(textid);
        panelGridSetting.add(buttonid);
        panelGridSetting.add(labelrange);
        panelGridSetting.add(textrange);
        panelGridSetting.add(buttonrange);
        panelGridSetting.add(labelonline);
        panelGridSetting.add(boxonline);
        panelGridSetting.add(buttonrangeandonline);


        //表格设置
        model = new DefaultTableModel(tableDatas, new String[]{"编号", "姓名", "管理员", "所在区域", "在岗状态", ""});
        table = new MyTabel(model);
        table.Beautiful(false);

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
        buttonid.addActionListener(e -> {
            String id = textid.getText();
            if (id.equals("")) {
                info.setText("ID不允许为空");
                JOptionPane.showMessageDialog(this, "ID不允许为空");
                return;
            }

            inittabledatabyid(id);
            model = new DefaultTableModel(tableDatas, new String[]{"编号", "姓名", "管理员", "所在区域", "在岗状态", ""});
            table.setModel(model);
            table.Beautiful(false);
            info.setText("已更新");
        });

        buttonrange.addActionListener(e -> {
            String range = textrange.getText();
            if (range.equals("")) {
                info.setText("range不允许为空");
                JOptionPane.showMessageDialog(this, "range不允许为空");
                return;
            }

            inittabledatabyrange(range);
            model = new DefaultTableModel(tableDatas, new String[]{"编号", "姓名", "管理员", "所在区域", "在岗状态", ""});
            table.setModel(model);
            table.Beautiful(false);
            info.setText("已更新");

        });

        buttonrangeandonline.addActionListener(e -> {
            String range = textrange.getText();
            boolean online = boxonline.isSelected();
            if (range.equals("")) {
                info.setText("range不允许为空");
                JOptionPane.showMessageDialog(this, "range不允许为空");

                return;
            }

            inittabledatabyidandrange(range, online);
            model = new DefaultTableModel(tableDatas, new String[]{"编号", "姓名", "管理员", "所在区域", "在岗状态", ""});
            table.setModel(model);
            table.Beautiful(false);
            info.setText("已更新");
        });
    }


    public static void inittabledatabyid(String id) {
        UserInfo list = UserInfoDao.findbyuserid(id);
        Object[][] result = new Object[1][5];

        int i = 0;

        result[i][0] = list.getUserid();
        result[i][1] = list.getUsername();
        result[i][2] = list.isUseradmin();
        result[i][3] = list.getUserrange();
        result[i][4] = list.isUseronline();

        tableDatas = result;
    }

    public static void inittabledatabyrange(String range) {
        List<UserInfo> list = UserInfoDao.findbyuserrange(range);
        Object[][] result = new Object[list.size()][5];

        int i = 0;
        for (UserInfo user : list) {
            result[i][0] = user.getUserid();
            result[i][1] = user.getUsername();
            result[i][2] = user.isUseradmin();
            result[i][3] = user.getUserrange();
            result[i][4] = user.isUseronline();
            i++;
        }

        tableDatas = result;
    }

    public static void inittabledatabyidandrange(String range, boolean online) {
        List<UserInfo> list = UserInfoDao.findbyRangeAndOnline(range, online);
        Object[][] result = new Object[list.size()][5];

        int i = 0;
        for (UserInfo user : list) {
            result[i][0] = user.getUserid();
            result[i][1] = user.getUsername();
            result[i][2] = user.isUseradmin();
            result[i][3] = user.getUserrange();
            result[i][4] = user.isUseronline();
            i++;
        }

        tableDatas = result;
    }

}
