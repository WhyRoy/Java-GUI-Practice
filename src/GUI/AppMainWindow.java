/**
 * Project File Encoding = GBK
 * Project File Encoding = GBK
 */

package GUI;

import GUI.Panel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AppMainWindow {
    private JFrame frame;

    private static JPanel mainPanel;
    public static JPanel mainPanelCenter;

    public static EleInfoPanel eleinfopanel;
    public static EleRunInfoPanel eleruninfopanel;
    public static UserInfoPanel userinfopanel;
    public static UserLoginPanel userloginpanel;

    public static void main(String[] args) {

        AppMainWindow window = new AppMainWindow();
        window.frame.setVisible(true);

    }

    /**
     * 构造，创建APP
     */
    public AppMainWindow() {
        initialize();
    }

    /**
     * 初始化frame内容
     */
    private void initialize() {
        System.out.println("AppStart");

        //去掉所有自带的效果
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        //初始化窗口
        frame = new JFrame();
        frame.setBounds(240, 100, 885, 636);
        frame.setTitle("电梯管理系统");
        frame.setBackground(Color.white);

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.white);
        mainPanel.setLayout(new BorderLayout());

        ToolBarPanel toolbar = new ToolBarPanel();
        ToolBarPanel.setLogin(false);
        eleinfopanel = new EleInfoPanel();
        eleruninfopanel = new EleRunInfoPanel();
        userinfopanel = new UserInfoPanel();
        userloginpanel = new UserLoginPanel();

        mainPanel.add(toolbar, BorderLayout.WEST);

        mainPanelCenter = new JPanel(true);
        mainPanelCenter.setLayout(new BorderLayout());
        mainPanelCenter.add(userloginpanel, BorderLayout.CENTER);

        mainPanel.add(mainPanelCenter, BorderLayout.CENTER);
        frame.add(mainPanel);

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

}
