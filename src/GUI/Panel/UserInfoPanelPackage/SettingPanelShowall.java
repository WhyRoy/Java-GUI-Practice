package GUI.Panel.UserInfoPanelPackage;

import Dao.UserInfoDao;
import GUI.MyTabel;
import tables.UserInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SettingPanelShowall extends JPanel {
    DefaultTableModel model;
    public static MyTabel table;
    private static Object[][] tableDatas;

    public SettingPanelShowall() {
        initialize();
        inittableDate();
        addComponent();
    }

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

        model = new DefaultTableModel(tableDatas, new String[]{"编号", "姓名", "管理员", "所在区域", "在岗状态", ""});
        table = new MyTabel(model);
        table.Beautiful(false);

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
        List<UserInfo> list = UserInfoDao.allUserInfo();
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

