package GUI.Panel.UserInfoPanelPackage;

import Dao.UserInfoDao;
import GUI.MyIconButton;
import GUI.Panel.UserInfoPanel;
import com.sun.org.apache.xpath.internal.operations.Bool;
import tables.UserInfo;

import javax.swing.*;
import java.awt.*;

public class SettingPanelAddone extends JPanel {
    JLabel labelid;
    JLabel labelname;
    JLabel labeladmin;
    JLabel labelrange;
    JLabel labelonline;
    JLabel labelpassword;

    JLabel info;

    JTextField textid;
    JTextField textname;
    JTextField textrange;
    JPasswordField textpassword;

    JCheckBox boxadmin;
    JCheckBox boxonline;

    MyIconButton buttonclear;
    static MyIconButton buttonadd;

    public SettingPanelAddone() {
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
        panelCenter.setLayout(new GridLayout(0, 1));

        JPanel panelGridSetting = new JPanel();
        panelGridSetting.setBackground(Color.white);
        panelGridSetting.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 18));

        labelid = new JLabel("编号");
        labelname = new JLabel("姓名");
        labeladmin = new JLabel("管理员");
        labelrange = new JLabel("区域");
        labelonline = new JLabel("在岗");
        labelpassword = new JLabel("密码");

        textid = new JTextField();
        textname = new JTextField();
        textrange = new JTextField();
        textpassword = new JPasswordField();

        boxadmin = new JCheckBox("是");
        boxonline = new JCheckBox("是");

        // 字体
        Font font = new Font("微软雅黑", 0, 13);
        labelid.setFont(font);
        labelname.setFont(font);
        labeladmin.setFont(font);
        labelrange.setFont(font);
        labelonline.setFont(font);
        labelpassword = new JLabel("密码");
        textid.setFont(font);
        textname.setFont(font);
        textrange.setFont(font);
        textpassword = new JPasswordField();
        boxadmin.setFont(font);
        boxonline.setFont(font);

        // 大小
        Dimension SIZE = new Dimension(78, 30);
        labelid.setPreferredSize(SIZE);
        labelname.setPreferredSize(SIZE);
        labeladmin.setPreferredSize(SIZE);
        labelrange.setPreferredSize(SIZE);
        labelonline.setPreferredSize(SIZE);
        labelpassword.setPreferredSize(SIZE);

        SIZE = new Dimension(400, 24);
        textid.setPreferredSize(SIZE);
        textname.setPreferredSize(SIZE);
        textrange.setPreferredSize(SIZE);
        textpassword.setPreferredSize(SIZE);
        boxadmin.setPreferredSize(SIZE);
        boxonline.setPreferredSize(SIZE);

        boxadmin.setBackground(Color.white);
        boxonline.setBackground(Color.white);


        panelGridSetting.add(labelid);
        panelGridSetting.add(textid);
        panelGridSetting.add(labelname);
        panelGridSetting.add(textname);
        panelGridSetting.add(labeladmin);
        panelGridSetting.add(boxadmin);
        panelGridSetting.add(labelrange);
        panelGridSetting.add(textrange);
        panelGridSetting.add(labelonline);
        panelGridSetting.add(boxonline);
        panelGridSetting.add(labelpassword);
        panelGridSetting.add(textpassword);
        panelCenter.add(panelGridSetting);
        return panelCenter;
    }

    private JPanel getDownPanel() {
        JPanel panelDown = new JPanel();
        panelDown.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelDown.setPreferredSize(new Dimension(0, 70));

        JPanel panelbutton = new JPanel();
        panelbutton.setBackground(Color.white);
        panelbutton.setLayout(new FlowLayout(FlowLayout.RIGHT, 50, 0));
        panelbutton.setPreferredSize(new Dimension(630, 50));

        ImageIcon icon_clear = new ImageIcon("src/resources/icon/clear.png");
        ImageIcon icon_clear_enable = new ImageIcon("src/resources/icon/clearEnable.png");
        ImageIcon icon_clear_disable = new ImageIcon("src/resources/icon/clearDisable.png");

        ImageIcon icon_start = new ImageIcon("src/resources/icon/start.png");
        ImageIcon icon_start_enable = new ImageIcon("src/resources/icon/startEnable.png");
        ImageIcon icon_start_disable = new ImageIcon("src/resources/icon/startDisable.png");


        buttonclear = new MyIconButton(icon_clear, icon_clear_enable, icon_clear_disable, "clear");
        buttonadd = new MyIconButton(icon_start, icon_start_enable, icon_start_disable, "add");
        panelbutton.add(buttonclear);
        panelbutton.add(buttonadd);

        info = new JLabel("输入添加内容");
        Font font = new Font("微软雅黑", 0, 12);
        panelDown.setFont(font);

        panelDown.add(panelbutton);
        panelDown.add(info);

        return panelDown;
    }

    private void addListener() {
        buttonclear.addActionListener(e -> {
            textid.setText("");
            textname.setText("");
            textrange.setText("");
            textpassword.setText("");
            boxonline.setSelected(false);
            boxadmin.setSelected(false);

            info.setText("已清空");
        });

        buttonadd.addActionListener(e -> {
            String id = textid.getText();
            String range = textrange.getText();
            String name = textname.getText();
            String password = new String(textpassword.getPassword());
            Boolean admin = boxadmin.isSelected();
            Boolean online = boxonline.isSelected();

            if (id.equals("")) {
                info.setText("ID不允许为空");
                JOptionPane.showMessageDialog(this, "ID不允许为空");
                return;
            }
            if (range.equals("")) {
                info.setText("range不允许为空");
                JOptionPane.showMessageDialog(this, "range不允许为空");

                return;
            }
            if (name.equals("")) {
                info.setText("name不允许为空");
                JOptionPane.showMessageDialog(this, "name不允许为空");
                return;
            }
            if (password.equals("")) {
                info.setText("password不允许为空");
                JOptionPane.showMessageDialog(this, "password不允许为空");
                return;
            }

            UserInfo user = new UserInfo();
            user.setUserid(id);
            user.setUsername(name);
            user.setUserrange(range);
            user.setUseradmin(admin);
            user.setUseronline(online);

            UserInfoDao.addOneUser(user, password);

            info.setText("已成功添加一个用户记录!");

            UserInfoPanel.settingPanelMain.removeAll();
            UserInfoPanel.settingPanelMain.add(new SettingPanelShowall());
            UserInfoPanel.settingPanelMain.updateUI();
        });
    }

    public static void setadmin() {
        buttonadd.setEnabled(false);
    }

}
