package GUI.Panel.UserInfoPanelPackage;

import Dao.UserInfoDao;
import GUI.MyIconButton;
import GUI.MyTabel;
import GUI.Panel.UserInfoPanel;
import tables.UserInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SettingPanelDeleteone extends JPanel {
    JLabel labelid;
    JTextField textid;
    MyIconButton buttonid;

    DefaultTableModel model;
    public static MyTabel table;
    private static Object[][] tableDatas;
    JScrollPane panelScroll;

    static MyIconButton buttondelete;
    JLabel info;

    public SettingPanelDeleteone() {
        initialize();
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
        panelGridSetting.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 20));

        //初始化组件
        labelid = new JLabel("输入id编号");

        textid = new JTextField();

        ImageIcon icon_id = new ImageIcon("src/resources/icon/findbyid.png");
        ImageIcon icon_id_enable = new ImageIcon("src/resources/icon/findbyidEnable.png");
        ImageIcon icon_id_disable = new ImageIcon("src/resources/icon/findbyidDisable.png");
        buttonid = new MyIconButton(icon_id, icon_id_enable, icon_id_disable, "id");

        // 字体
        Font font = new Font("微软雅黑", 0, 13);
        labelid.setFont(font);
        textid.setFont(font);
        buttonid.setFont(font);

        // 大小
        labelid.setPreferredSize(new Dimension(100, 30));
        textid.setPreferredSize(new Dimension(250, 24));

        panelGridSetting.add(labelid);
        panelGridSetting.add(textid);
        panelGridSetting.add(buttonid);

        model = new DefaultTableModel(tableDatas, new String[]{"编号", "姓名", "管理员", "所在区域", "在岗状态", ""});
        table = new MyTabel(model);
        panelScroll = new JScrollPane(table) {
            public Dimension getPreferredSize() {
                return new Dimension(300, 200);
            }
        };
        panelScroll.setBackground(Color.white);


        panelCenter.add(panelGridSetting);
        panelCenter.add(panelScroll);
        return panelCenter;
    }

    private JPanel getDownPanel() {
        JPanel panelDown = new JPanel();
        panelDown.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelDown.setPreferredSize(new Dimension(0, 50));

        JPanel panelbutton = new JPanel();
        panelbutton.setLayout(new FlowLayout(FlowLayout.RIGHT, 30, 0));
        panelbutton.setPreferredSize(new Dimension(630, 35));


        ImageIcon icon_start = new ImageIcon("src/resources/icon/confirm.png");
        ImageIcon icon_start_enable = new ImageIcon("src/resources/icon/confirmEnable.png");
        ImageIcon icon_start_disable = new ImageIcon("src/resources/icon/confirmDisable.png");

        buttondelete = new MyIconButton(icon_start, icon_start_enable, icon_start_disable, "add");
        panelbutton.add(buttondelete);
        info = new JLabel("输入添加内容");
        Font font = new Font("微软雅黑", 0, 12);
        panelDown.setFont(font);

        panelDown.add(panelbutton);
        panelDown.add(info);

        return panelDown;
    }

    private void addListener() {
        buttonid.addActionListener(e -> {
            String id = textid.getText();
            if (id.equals("")) {
                info.setText("ID不能为空");
                return;
            }
            inittabledatabyid(id);
            model = new DefaultTableModel(tableDatas, new String[]{"编号", "姓名", "管理员", "所在区域", "在岗状态", ""});
            table.setModel(model);
            table.Beautiful(false);
            info.setText("根据id查询记录完成");
        });

        buttondelete.addActionListener(e -> {
            String id = textid.getText();
            if (id.equals("")) {
                info.setText("ID不能为空");
                return;
            }
            if (tableDatas.length == 0) {
                info.setText("没有查询到需要删除的记录");
                return;
            }
            UserInfoDao.deleteOneUser(id);
            info.setText("已删除");
            UserInfoPanel.settingPanelMain.removeAll();
            UserInfoPanel.settingPanelMain.add(new SettingPanelShowall());
            UserInfoPanel.settingPanelMain.updateUI();
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

    public static void setadmin() {
        buttondelete.setEnabled(false);
    }
}
