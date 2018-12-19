package GUI.Panel;

import GUI.AppMainWindow;
import GUI.Panel.EleRunInfoPanelPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EleRunInfoPanel extends JPanel {
    //RunInfo跳转
    public static JPanel settingpanelshowall;
    public static JPanel settingpanelshowerrormsg;
    public static JPanel settingpanelrunningtime;

    public static JPanel settingPanelMain;

    //子菜单按钮选项
    public static JPanel panelshowall;
    public static JPanel panelshowerrormsg;
    public static JPanel panelrunningtime;

    //子菜单标签
    public static JLabel labelshowall;
    public static JLabel labelshowerrormsg;
    public static JLabel labelrunningtime;

    /**
     * 构造
     */
    public EleRunInfoPanel() {
        initialize();
        addComponent();
        addListener();
    }

    /**
     * 初始化
     */
    private void initialize() {
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());
        settingpanelshowall = new SettingPanelShowall();
        settingpanelshowerrormsg = new SettingpanelShowErrmsg();
        settingpanelrunningtime = new SettingPanelRunningTime();
    }

    private void addComponent() {
        this.add(getUpPanel(), BorderLayout.NORTH);
        this.add(getCenterPanel(), BorderLayout.CENTER);
    }

    private JPanel getUpPanel() {
        JPanel panelUp = new JPanel();
        panelUp.setBackground(Color.white);
        panelUp.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 5));

        JLabel labeltitle = new JLabel("电梯运行状况");

        Font font = new Font("微软雅黑", 0, 27);
        labeltitle.setFont(font);
        labeltitle.setForeground(new Color(37, 174, 96));
        panelUp.add(labeltitle);

        return panelUp;
    }

    private JPanel getCenterPanel() {
        //面板
        JPanel panelCenter = new JPanel();
        panelCenter.setBackground(Color.white);
        panelCenter.setLayout(new BorderLayout());

        //二级菜单panel
        JPanel panellist = new JPanel();
        Dimension SIZE = new Dimension(200, 636);
        panellist.setPreferredSize(SIZE);
        panellist.setBackground(new Color(62, 62, 62));
        panellist.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        //new子选项
        panelshowall = new JPanel();
        panelshowall.setBackground(new Color(69, 186, 121));
        panelshowall.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 13));
        SIZE = new Dimension(200, 48);
        panelshowall.setPreferredSize(SIZE);

        panelshowerrormsg = new JPanel();
        panelshowerrormsg.setBackground(new Color(37, 174, 96));
        panelshowerrormsg.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 13));
        SIZE = new Dimension(200, 48);
        panelshowerrormsg.setPreferredSize(SIZE);

        panelrunningtime = new JPanel();
        panelrunningtime.setBackground(new Color(37, 174, 96));
        panelrunningtime.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 13));
        SIZE = new Dimension(200, 48);
        panelrunningtime.setPreferredSize(SIZE);

        //Label添加标签
        labelshowall = new JLabel("显示所有运行信息");
        labelshowerrormsg = new JLabel("查询错误运行信息");
        labelrunningtime = new JLabel("查看运行时间过长电梯");
        //设置字体
        Font font = new Font("微软雅黑", 0, 15);
        labelshowall.setFont(font);
        labelshowerrormsg.setFont(font);
        labelrunningtime.setFont(font);
        //设置背景透明
        labelshowall.setForeground(Color.white);
        labelshowerrormsg.setForeground(Color.white);
        labelrunningtime.setForeground(Color.white);
        //标签显示文字
        panelshowall.add(labelshowall);
        panelshowerrormsg.add(labelshowerrormsg);
        panelrunningtime.add(labelrunningtime);

        //添加菜单
        panellist.add(panelshowall);
        panellist.add(panelshowerrormsg);
        panellist.add(panelrunningtime);

        //设置panel
        settingPanelMain = new JPanel();
        settingPanelMain.setBackground(Color.white);
        settingPanelMain.setLayout(new BorderLayout());
        settingPanelMain.add(settingpanelshowall, BorderLayout.CENTER);

        panelCenter.add(panellist, BorderLayout.WEST);
        panelCenter.add(settingPanelMain, BorderLayout.CENTER);

        return panelCenter;
    }

    private void addListener() {
        panelshowall.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelshowall.setBackground(new Color(37, 174, 96));
                panelshowerrormsg.setBackground(new Color(37, 174, 96));
                panelrunningtime.setBackground(new Color(37, 174, 96));

                panelshowall.setBackground(new Color(69, 186, 121));

                EleRunInfoPanel.settingPanelMain.removeAll();
                EleRunInfoPanel.settingPanelMain.add(settingpanelshowall, BorderLayout.CENTER);
                AppMainWindow.mainPanelCenter.updateUI();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        panelshowerrormsg.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelshowall.setBackground(new Color(37, 174, 96));
                panelshowerrormsg.setBackground(new Color(37, 174, 96));
                panelrunningtime.setBackground(new Color(37, 174, 96));

                panelshowerrormsg.setBackground(new Color(69, 186, 121));

                EleRunInfoPanel.settingPanelMain.removeAll();
                EleRunInfoPanel.settingPanelMain.add(settingpanelshowerrormsg, BorderLayout.CENTER);
                AppMainWindow.mainPanelCenter.updateUI();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        panelrunningtime.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelshowall.setBackground(new Color(37, 174, 96));
                panelshowerrormsg.setBackground(new Color(37, 174, 96));
                panelrunningtime.setBackground(new Color(37, 174, 96));

                panelrunningtime.setBackground(new Color(69, 186, 121));

                EleRunInfoPanel.settingPanelMain.removeAll();
                EleRunInfoPanel.settingPanelMain.add(settingpanelrunningtime, BorderLayout.CENTER);
                AppMainWindow.mainPanelCenter.updateUI();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
