package GUI.Panel.EleInfoPanelPackage;

import Dao.EleInfoDao;
import GUI.AppMainWindow;
import GUI.MyIconButton;
import GUI.MyTabel;
import tables.EleInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class SettingPanelUpdateone extends JPanel {

    JLabel labelid;
    JTextField textid;
    MyIconButton buttonid;

    JLabel labeldate;
    JTextField textdate;
    MyIconButton buttonupdateset;

    DefaultTableModel model;
    public static MyTabel table;
    private static Object[][] tableDatas;
    JScrollPane panelScroll;

    MyIconButton buttonupdatenow;
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
        panelCenter.setLayout(new GridLayout(2, 1));

        //设置Grid
        JPanel panelGridSetting = new JPanel();
        panelGridSetting.setBackground(Color.white);
        panelGridSetting.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 20));

        //初始化组件
        labelid = new JLabel("输入id编号");
        labeldate = new JLabel("输入设置时间");

        textid = new JTextField();
        textdate = new JTextField();


        ImageIcon icon_id = new ImageIcon("src/resources/icon/findbyid.png");
        ImageIcon icon_id_enable = new ImageIcon("src/resources/icon/findbyidEnable.png");
        ImageIcon icon_id_disable = new ImageIcon("src/resources/icon/findbyidDisable.png");

        ImageIcon icon_now = new ImageIcon("src/resources/icon/now.png");
        ImageIcon icon_now_enable = new ImageIcon("src/resources/icon/nowEnable.png");
        ImageIcon icon_now_disable = new ImageIcon("src/resources/icon/nowDisable.png");

        ImageIcon icon_start = new ImageIcon("src/resources/icon/start.png");
        ImageIcon icon_start_enable = new ImageIcon("src/resources/icon/startEnable.png");
        ImageIcon icon_start_disable = new ImageIcon("src/resources/icon/startDisable.png");

        buttonid = new MyIconButton(icon_id, icon_id_enable, icon_id_disable, "id");
        buttonupdatenow = new MyIconButton(icon_now, icon_now_enable, icon_now_disable, "设置id");
        buttonupdateset = new MyIconButton(icon_start, icon_start_enable, icon_start_disable, "设置为当前日期");

        // 字体
        Font font = new Font("微软雅黑", 0, 13);
        labelid.setFont(font);
        textid.setFont(font);

        labeldate.setFont(font);
        textdate.setFont(font);

        // 大小
        labelid.setPreferredSize(new Dimension(100, 30));
        labeldate.setPreferredSize(new Dimension(100, 30));
        textid.setPreferredSize(new Dimension(250, 24));
        textdate.setPreferredSize(new Dimension(250, 24));

        panelGridSetting.add(labelid);
        panelGridSetting.add(textid);
        panelGridSetting.add(buttonid);
        panelGridSetting.add(labeldate);
        panelGridSetting.add(textdate);
        panelGridSetting.add(buttonupdatenow);
        panelGridSetting.add(buttonupdateset);


        model = new DefaultTableModel(tableDatas, new String[]{"编号", "电梯型号", "电梯创建日期", "区域", "电梯地址", "最近维修"});
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
        info = new JLabel("输入添加内容");
        Font font = new Font("微软雅黑", 0, 12);
        panelDown.setFont(font);
        panelDown.add(info);

        return panelDown;
    }

    private void addListener() {
        buttonid.addActionListener(e -> {
            String id = textid.getText();
            if (id.equals("")) {
                info.setText("id不允许为空");
                JOptionPane.showMessageDialog(this, "id不允许为空");
                return;
            }
            inittableDateByid(id);
            model = new DefaultTableModel(tableDatas, new String[]{"编号", "电梯型号", "电梯创建日期", "区域", "电梯地址", "最近维修"});
            table.setModel(model);
            table.Beautiful(false);
            info.setText("已更新");
        });

        buttonupdatenow.addActionListener(e -> {
            Date currentDate = new Date(System.currentTimeMillis());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String now = df.format(currentDate);
            textdate.setText(now);
            info.setText("已读取当前时间");
            JOptionPane.showMessageDialog(this, "已读取当前时间");
        });

        buttonupdateset.addActionListener(e -> {
            String id = textid.getText();
            if (id.equals("")) {
                info.setText("id不允许为空");
                JOptionPane.showMessageDialog(this, "id不允许为空");
                return;
            }
            Date date = Date.valueOf(textdate.getText());
            EleInfoDao.updateMtdate(date, id);
            info.setText("更新成功");
            buttonid.doClick();
        });
    }

    private static void inittableDateByid(String id) {
        EleInfo list = EleInfoDao.findbyeleid(id);
        Object[][] result = new Object[1][6];
        result[0][0] = list.getEleid();
        result[0][1] = list.getEletype();
        result[0][2] = list.getElecreatedate();
        result[0][3] = list.getElerange();
        result[0][4] = list.getEleaddress();
        result[0][5] = list.getElelastmtdate();
        tableDatas = result;
    }

}
