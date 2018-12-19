package GUI.Panel;

import GUI.AppMainWindow;
import GUI.Panel.EleInfoPanelPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EleInfoPanel extends JPanel {
    //主界面跳转
    public static JPanel settingpanelshowall;
    public static JPanel settingpanelshowbyid;
    public static JPanel settingpaneladdone;
    public static JPanel settingpaneldeleteone;
    public static JPanel settingpanelupdateone;

    public static JPanel settingPanelMain;

    //子菜单按钮选项
    public static JPanel panelshowall;
    public static JPanel panelshowbyid;
    public static JPanel paneladdone;
    public static JPanel paneldeleteone;
    public static JPanel panelupdateone;

    //子菜单标签
    public static JLabel labelshowall;
    public static JLabel labelshowbyid;
    public static JLabel labeladdone;
    public static JLabel labeldeleteone;
    public static JLabel labelupdateone;

    /**
     * 构造
     */
    public EleInfoPanel() {
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
        settingpanelshowbyid = new SettingPanelShowById();
        settingpaneladdone = new SettingPanelAddone();
        settingpaneldeleteone = new SettingPanelDeleteone();
        settingpanelupdateone = new SettingPanelUpdateone();
    }

    private void addComponent() {
        this.add(getUpPanel(), BorderLayout.NORTH);
        this.add(getCenterPanel(), BorderLayout.CENTER);
    }

    private JPanel getUpPanel() {
        JPanel panelUp = new JPanel();
        panelUp.setBackground(Color.white);
        panelUp.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 5));

        JLabel labeltitle = new JLabel("电梯信息操作");

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
        paneladdone = new JPanel();
        paneladdone.setBackground(new Color(37, 174, 96));
        paneladdone.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 13));
        SIZE = new Dimension(200, 48);
        paneladdone.setPreferredSize(SIZE);

        panelshowbyid = new JPanel();
        panelshowbyid.setBackground(new Color(37, 174, 96));
        panelshowbyid.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 13));
        SIZE = new Dimension(200, 48);
        panelshowbyid.setPreferredSize(SIZE);

        panelshowall = new JPanel();
        panelshowall.setBackground(new Color(69, 186, 121));
        panelshowall.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 13));
        SIZE = new Dimension(200, 48);
        panelshowall.setPreferredSize(SIZE);

        paneldeleteone = new JPanel();
        paneldeleteone.setBackground(new Color(37, 174, 96));
        paneldeleteone.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 13));
        SIZE = new Dimension(200, 48);
        paneldeleteone.setPreferredSize(SIZE);

        panelupdateone = new JPanel();
        panelupdateone.setBackground(new Color(37, 174, 96));
        panelupdateone.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 13));
        SIZE = new Dimension(200, 48);
        panelupdateone.setPreferredSize(SIZE);


        //Label添加标签
        labelshowall = new JLabel("显示所有信息");
        labelshowbyid = new JLabel("查询电梯");
        labeladdone = new JLabel("添加电梯");
        labeldeleteone = new JLabel("删除电梯");
        labelupdateone = new JLabel("更新电梯信息");
        //设置字体
        Font font = new Font("微软雅黑", 0, 15);
        labelshowall.setFont(font);
        labelshowbyid.setFont(font);
        labeladdone.setFont(font);
        labeldeleteone.setFont(font);
        labelupdateone.setFont(font);
        //设置背景透明
        labelshowall.setForeground(Color.white);
        labelshowbyid.setForeground(Color.white);
        labeladdone.setForeground(Color.white);
        labeldeleteone.setForeground(Color.white);
        labelupdateone.setForeground(Color.white);

        //标签显示文字
        panelshowall.add(labelshowall);
        panelshowbyid.add(labelshowbyid);
        paneladdone.add(labeladdone);
        paneldeleteone.add(labeldeleteone);
        panelupdateone.add(labelupdateone);

        //添加菜单
        panellist.add(panelshowall);
        panellist.add(panelshowbyid);
        panellist.add(paneladdone);
        panellist.add(paneldeleteone);
        panellist.add(panelupdateone);

        //设置panel
        settingPanelMain = new JPanel();
        settingPanelMain.setBackground(Color.white);
        settingPanelMain.setLayout(new BorderLayout());
        settingPanelMain.add(settingpanelshowall, BorderLayout.CENTER);

        panelCenter.add(panellist, BorderLayout.WEST);
        panelCenter.add(settingPanelMain, BorderLayout.CENTER);

        return panelCenter;
    }

    /**
     * 添加事件监听
     */
    private void addListener() {
        panelshowall.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelshowall.setBackground(new Color(37, 174, 96));
                panelshowbyid.setBackground(new Color(37, 174, 96));
                paneladdone.setBackground(new Color(37, 174, 96));
                paneldeleteone.setBackground(new Color(37, 174, 96));
                panelupdateone.setBackground(new Color(37, 174, 96));

                panelshowall.setBackground(new Color(69, 186, 121));

                EleInfoPanel.settingPanelMain.removeAll();
                EleInfoPanel.settingPanelMain.add(settingpanelshowall, BorderLayout.CENTER);
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

        panelshowbyid.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelshowall.setBackground(new Color(37, 174, 96));
                panelshowbyid.setBackground(new Color(37, 174, 96));
                paneladdone.setBackground(new Color(37, 174, 96));
                paneldeleteone.setBackground(new Color(37, 174, 96));
                panelupdateone.setBackground(new Color(37, 174, 96));

                panelshowbyid.setBackground(new Color(69, 186, 121));

                EleInfoPanel.settingPanelMain.removeAll();
                EleInfoPanel.settingPanelMain.add(settingpanelshowbyid, BorderLayout.CENTER);

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

        paneladdone.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelshowall.setBackground(new Color(37, 174, 96));
                panelshowbyid.setBackground(new Color(37, 174, 96));
                paneladdone.setBackground(new Color(37, 174, 96));
                paneldeleteone.setBackground(new Color(37, 174, 96));
                panelupdateone.setBackground(new Color(37, 174, 96));

                paneladdone.setBackground(new Color(69, 186, 121));

                EleInfoPanel.settingPanelMain.removeAll();
                EleInfoPanel.settingPanelMain.add(settingpaneladdone, BorderLayout.CENTER);

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

        paneldeleteone.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelshowall.setBackground(new Color(37, 174, 96));
                panelshowbyid.setBackground(new Color(37, 174, 96));
                paneladdone.setBackground(new Color(37, 174, 96));
                paneldeleteone.setBackground(new Color(37, 174, 96));
                panelupdateone.setBackground(new Color(37, 174, 96));

                paneldeleteone.setBackground(new Color(69, 186, 121));

                EleInfoPanel.settingPanelMain.removeAll();
                EleInfoPanel.settingPanelMain.add(settingpaneldeleteone, BorderLayout.CENTER);

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

        panelupdateone.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panelshowall.setBackground(new Color(37, 174, 96));
                panelshowbyid.setBackground(new Color(37, 174, 96));
                paneladdone.setBackground(new Color(37, 174, 96));
                paneldeleteone.setBackground(new Color(37, 174, 96));
                panelupdateone.setBackground(new Color(37, 174, 96));

                panelupdateone.setBackground(new Color(69, 186, 121));

                EleInfoPanel.settingPanelMain.removeAll();
                EleInfoPanel.settingPanelMain.add(settingpanelupdateone, BorderLayout.CENTER);

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
