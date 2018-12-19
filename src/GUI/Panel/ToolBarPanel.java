package GUI.Panel;

import GUI.AppMainWindow;
import GUI.MyIconButton;

import javax.swing.*;
import java.awt.*;

public class ToolBarPanel extends JPanel {
    private static MyIconButton buttoneleinfo;
    private static MyIconButton buttoneleruninfo;
    private static MyIconButton buttonuserinfo;
    private static MyIconButton buttonuserlogin;

    public ToolBarPanel() {
        initialize();
        addButtion();
        addListener();
    }

    private void initialize() {
        Dimension preferredSize = new Dimension(48, 636);
        this.setPreferredSize(preferredSize);
        this.setMaximumSize(preferredSize);
        this.setMinimumSize(preferredSize);
        this.setBackground(new Color(37, 174, 96));
        this.setLayout(new GridLayout(2, 1));
    }

    private void addButtion() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(37, 174, 96));
        panel.setLayout(new FlowLayout(-2, -2, -4));

        ImageIcon eleinfoicon = new ImageIcon("src/resources/icon/eleinfo.png");
        ImageIcon eleinfoiconenable = new ImageIcon("src/resources/icon/eleinfoEnable.png");

        ImageIcon eleruninfoicon = new ImageIcon("src/resources/icon/eleruninfo.png");
        ImageIcon eleruninfoiconenable = new ImageIcon("src/resources/icon/eleruninfoEnable.png");

        ImageIcon userinfoicon = new ImageIcon("src/resources/icon/userinfo.png");
        ImageIcon userinfoiconenable = new ImageIcon("src/resources/icon/userinfoEnable.png");

        ImageIcon loginicon = new ImageIcon("src/resources/icon/login.png");
        ImageIcon loginiconenable = new ImageIcon("src/resources/icon/loginEnable.png");


        buttoneleinfo = new MyIconButton(eleinfoicon, eleinfoiconenable, eleinfoicon, "电梯信息");
        buttoneleruninfo = new MyIconButton(eleruninfoicon, eleruninfoiconenable, eleruninfoicon, "电梯运行信息");
        buttonuserinfo = new MyIconButton(userinfoicon, userinfoiconenable, userinfoicon, "用户信息");
        buttonuserlogin = new MyIconButton(loginicon, loginiconenable, loginicon, "登录");

        panel.add(buttoneleinfo);
        panel.add(buttoneleruninfo);
        panel.add(buttonuserinfo);
        panel.add(buttonuserlogin);

        this.add(panel);
    }

    private void addListener() {
        buttoneleinfo.addActionListener(e -> {
            AppMainWindow.mainPanelCenter.removeAll();
            AppMainWindow.mainPanelCenter.add(AppMainWindow.eleinfopanel, BorderLayout.CENTER);
            AppMainWindow.mainPanelCenter.updateUI();

            System.out.println("to EleInfo");
        });
        buttoneleruninfo.addActionListener(e -> {
            AppMainWindow.mainPanelCenter.removeAll();
            AppMainWindow.mainPanelCenter.add(AppMainWindow.eleruninfopanel, BorderLayout.CENTER);
            AppMainWindow.mainPanelCenter.updateUI();

            System.out.println("to EleRunInfo");
        });
        buttonuserinfo.addActionListener(e -> {
            AppMainWindow.mainPanelCenter.removeAll();
            AppMainWindow.mainPanelCenter.add(AppMainWindow.userinfopanel, BorderLayout.CENTER);
            AppMainWindow.mainPanelCenter.updateUI();

            System.out.println("to UserInfo");
        });
        buttonuserlogin.addActionListener(e -> {
            AppMainWindow.mainPanelCenter.removeAll();
            AppMainWindow.mainPanelCenter.add(AppMainWindow.userloginpanel, BorderLayout.CENTER);
            AppMainWindow.mainPanelCenter.updateUI();

            System.out.println("to UserLogin");
        });

    }

    public static void setLogin(boolean islogin) {
        buttoneleinfo.setEnabled(islogin);
        buttoneleruninfo.setEnabled(islogin);
        buttonuserinfo.setEnabled(islogin);
    }

}
