package GUI.Panel.UserInfoPanelPackage;

import Dao.UserInfoDao;
import Dao.UserLoginInfoDao;
import GUI.MyIconButton;

import javax.swing.*;
import java.awt.*;

public class SettingPanelUpdateone extends JPanel {
    JLabel labelid;
    JLabel labeloldpassword;
    JLabel labelnewpassword;
    JLabel labelcheck;

    JTextField textid;
    JPasswordField textoldpassword;
    JPasswordField textnewpassword;
    JPasswordField textcheck;

    MyIconButton buttonupdatepassword;
    static MyIconButton buttonupdatedamin;

    JLabel info;

    public SettingPanelUpdateone() {
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
        panelCenter.setLayout(new GridLayout(1, 1));

        //设置Grid
        JPanel panelGridSetting = new JPanel();
        panelGridSetting.setBackground(Color.white);
        panelGridSetting.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 20));

        //初始化组件
        labelid = new JLabel("输入id编号");
        labeloldpassword = new JLabel("输入旧密码");
        labelnewpassword = new JLabel("输入新密码");
        labelcheck = new JLabel("重复输入新密码");

        textid = new JTextField("");
        textoldpassword = new JPasswordField("");
        textnewpassword = new JPasswordField("");
        textcheck = new JPasswordField("");

        ImageIcon icon_updateadmin = new ImageIcon("src/resources/icon/updateadmin.png");
        ImageIcon icon_icon_updateadmin_enable = new ImageIcon("src/resources/icon/updateadminEnable.png");
        ImageIcon icon_icon_updateadmin_disable = new ImageIcon("src/resources/icon/updateadminDisable.png");

        ImageIcon icon_updatepassword = new ImageIcon("src/resources/icon/updatepassword.png");
        ImageIcon icon_updatepassword_enable = new ImageIcon("src/resources/icon/updatepasswordEnable.png");
        ImageIcon icon_updatepassword_disable = new ImageIcon("src/resources/icon/updatepasswordDisable.png");

        buttonupdatedamin = new MyIconButton(icon_updateadmin, icon_icon_updateadmin_enable, icon_icon_updateadmin_disable, "admin");
        buttonupdatepassword = new MyIconButton(icon_updatepassword, icon_updatepassword_enable, icon_updatepassword_disable, "password");

        // 字体
        Font font = new Font("微软雅黑", 0, 13);
        labelid.setFont(font);
        textid.setFont(font);
        labeloldpassword.setFont(font);
        labelnewpassword.setFont(font);
        textnewpassword.setFont(font);
        textoldpassword.setFont(font);
        labelcheck.setFont(font);
        textcheck.setFont(font);


        // 大小
        labelid.setPreferredSize(new Dimension(100, 30));
        labeloldpassword.setPreferredSize(new Dimension(100, 30));
        labelnewpassword.setPreferredSize(new Dimension(100, 30));
        labelcheck.setPreferredSize(new Dimension(100, 30));
        textid.setPreferredSize(new Dimension(380, 24));
        textnewpassword.setPreferredSize(new Dimension(380, 24));
        textoldpassword.setPreferredSize(new Dimension(380, 24));
        textcheck.setPreferredSize(new Dimension(380, 24));


        panelGridSetting.add(labelid);
        panelGridSetting.add(textid);
        panelGridSetting.add(labeloldpassword);
        panelGridSetting.add(textoldpassword);
        panelGridSetting.add(labelnewpassword);
        panelGridSetting.add(textnewpassword);
        panelGridSetting.add(labelcheck);
        panelGridSetting.add(textcheck);
        panelGridSetting.add(buttonupdatepassword);
        panelGridSetting.add(buttonupdatedamin);


        panelCenter.add(panelGridSetting);
        return panelCenter;
    }


    private JPanel getDownPanel() {
        JPanel panelDown = new JPanel();
        info = new JLabel("输入添加内容");
        Font font = new Font("微软雅黑", 0, 12);
        panelDown.setFont(font);
        panelDown.add(info);

        return panelDown;
    }

    private void addListener() {
        buttonupdatepassword.addActionListener(e -> {
            String id = textid.getText();
            String oldpwd = new String(textoldpassword.getPassword());
            String newpwd = new String(textnewpassword.getPassword());
            String check = new String(textcheck.getPassword());
            String correctpwd = UserLoginInfoDao.findpwdbyid(id);

            if (id.equals("")) {
                info.setText("id不允许为空");
                JOptionPane.showMessageDialog(this, "id不允许为空");
                return;
            }
            if (!correctpwd.equals(oldpwd)) {
                info.setText("当前密码输入错误");
                JOptionPane.showMessageDialog(this, "当前密码输入错误");

                return;
            }
            if (!check.equals(newpwd)) {
                info.setText("密码重复错误");
                JOptionPane.showMessageDialog(this, "密码重复错误");

                return;
            }
            UserLoginInfoDao.updatepassword(newpwd, id);
            info.setText("修改密码成功");
        });

        buttonupdatedamin.addActionListener(e -> {
            String id = textid.getText();
            if (id.equals("")) {
                info.setText("id不允许为空");
                JOptionPane.showMessageDialog(this, "id不允许为空");
                return;
            }

            UserInfoDao.updateadmin(id);
            info.setText("提升管理员权限成功");
        });


    }

    public static void setadmin() {
        buttonupdatedamin.setEnabled(false);
    }
}
