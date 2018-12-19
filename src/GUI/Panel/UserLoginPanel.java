package GUI.Panel;

import Dao.EleRunInfoDao;
import Dao.UserInfoDao;
import Dao.UserLoginInfoDao;
import GUI.AppMainWindow;
import GUI.MyIconButton;
import GUI.Panel.EleInfoPanelPackage.SettingPanelAddone;
import GUI.Panel.EleInfoPanelPackage.SettingPanelDeleteone;
import GUI.Panel.UserInfoPanelPackage.SettingPanelUpdateone;

import javax.swing.*;
import java.awt.*;

public class UserLoginPanel extends JPanel {
    public static MyIconButton buttonlogin;
    public static MyIconButton buttonclear;

    public static JLabel labeluserid;
    public static JLabel labelpassword;

    public static JTextField textuserid;
    public static JPasswordField textpasswprd;

    public static JLabel bottominfo;

    public static boolean isadmin = false;

    /**
     * 构造
     */
    public UserLoginPanel() {
        super(true);
        initialize();
        addComponent();
        addListener();
    }


    /**
     * 初始化
     */
    private void initialize() {
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
    }

    /**
     * 添加组件
     */
    private void addComponent() {
        this.add(getUpPanel(), BorderLayout.NORTH);
        this.add(getCenterPanel(), BorderLayout.CENTER);
        this.add(getDownPanel(), BorderLayout.SOUTH);
    }

    /**
     * 上部面板
     *
     * @return
     */
    private JPanel getUpPanel() {
        JPanel panelUp = new JPanel();
        panelUp.setBackground(Color.WHITE);
        panelUp.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 5));

        JLabel labelTitle = new JLabel("登录");

        Font font = new Font("微软雅黑", 0, 27);

        labelTitle.setFont(font);
        labelTitle.setForeground(new Color(37, 174, 96));
        panelUp.add(labelTitle);

        return panelUp;
    }

    /**
     * 中部面板
     *
     * @return
     */
    private JPanel getCenterPanel() {
        JPanel panelcenter = new JPanel();
        panelcenter.setBackground(Color.white);
        panelcenter.setLayout(new GridLayout(2, 1));

        //设置grid
        JPanel panelGridSetting = new JPanel();
        panelGridSetting.setBackground(Color.white);
        panelGridSetting.setLayout(new FlowLayout(0, 25, 18));

        //new对象
        ImageIcon icon_clear = new ImageIcon("src/resources/icon/clear.png");
        ImageIcon icon_clear_enable = new ImageIcon("src/resources/icon/clearEnable.png");
        ImageIcon icon_clear_disable = new ImageIcon("src/resources/icon/clearDisable.png");

        ImageIcon icon_login = new ImageIcon("src/resources/icon/loginb.png");
        ImageIcon icon_login_enable = new ImageIcon("src/resources/icon/loginbEnable.png");
        ImageIcon icon_login_disable = new ImageIcon("src/resources/icon/loginbDisable.png");


        buttonlogin = new MyIconButton(icon_login, icon_login_enable, icon_login_disable, "Login");
        buttonclear = new MyIconButton(icon_clear, icon_clear_enable, icon_clear_disable, "Clear");
        labeluserid = new JLabel("UserID");
        labelpassword = new JLabel("PassWord");
        textuserid = new JTextField();
        textpasswprd = new JPasswordField();

        //设置尺寸
        Dimension SIZE = new Dimension(120, 30);
        labeluserid.setPreferredSize(SIZE);
        labelpassword.setPreferredSize(SIZE);

        SIZE = new Dimension(550, 24);
        textpasswprd.setPreferredSize(SIZE);
        textuserid.setPreferredSize(SIZE);

        // 字体
        Font font = new Font("微软雅黑", 0, 13);
        labeluserid.setFont(font);
        labelpassword.setFont(font);
        textpasswprd.setFont(font);
        textuserid.setFont(font);

        //add
        panelGridSetting.add(labeluserid);
        panelGridSetting.add(textuserid);
        panelGridSetting.add(labelpassword);
        panelGridSetting.add(textpasswprd);
        panelGridSetting.add(buttonlogin);
        panelGridSetting.add(buttonclear);

        panelcenter.add(panelGridSetting);
        return panelcenter;
    }

    /**
     * 底部面板
     *
     * @return
     */
    private JPanel getDownPanel() {
        JPanel paneldown = new JPanel();
        paneldown.setBackground(Color.white);
        paneldown.setLayout(new FlowLayout(2, 25, 15));
        bottominfo = new JLabel("欢迎进入电梯管理系统，请输入用户名与密码");
        paneldown.add(bottominfo);
        return paneldown;
    }

    private void addListener() {
        buttonlogin.addActionListener(e -> {
            String userid = textuserid.getText();
            String password = new String(textpasswprd.getPassword());

            if (userid.equals("")) {
                JOptionPane.showMessageDialog(this, "用户名不允许为空！");
                bottominfo.setText("用户名不允许为空");
                return;
            }

            String token = UserLoginInfoDao.findpwdbyid(userid);
            if (!token.equals(password)) {
                JOptionPane.showMessageDialog(this, "密码不正确！");
                bottominfo.setText("密码不正确");
                textpasswprd.setText("");
                return;
            }

            isadmin = UserInfoDao.isadmin(userid);
            System.out.println(isadmin);

            ToolBarPanel.setLogin(true);

            if (!isadmin) {
                SettingPanelAddone.setadmin();
                SettingPanelDeleteone.setadmin();
                GUI.Panel.UserInfoPanelPackage.SettingPanelAddone.setadmin();
                GUI.Panel.UserInfoPanelPackage.SettingPanelDeleteone.setadmin();
                SettingPanelUpdateone.setadmin();
            }


            bottominfo.setText("正在初始化中.....");
            EleRunInfoDao.initruntime();
            bottominfo.setText("初始化完成，进入系统......");

            AppMainWindow.mainPanelCenter.removeAll();
            AppMainWindow.mainPanelCenter.add(AppMainWindow.eleinfopanel, BorderLayout.CENTER);
            AppMainWindow.mainPanelCenter.updateUI();

            System.out.println("to EleInfo");
        });

        buttonclear.addActionListener(e -> {
            textuserid.setText("");
            textpasswprd.setText("");
            bottominfo.setText("已清空");
        });
    }
}
