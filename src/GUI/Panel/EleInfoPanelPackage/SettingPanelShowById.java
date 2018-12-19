package GUI.Panel.EleInfoPanelPackage;

import Dao.EleInfoDao;
import GUI.MyIconButton;
import GUI.MyTabel;
import tables.EleInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class SettingPanelShowById extends JPanel {

    JLabel labelid;
    JLabel labelrange;
    JTextField textid;
    JTextField textrange;
    MyIconButton buttonid;
    MyIconButton buttonrange;
    MyIconButton buttonall;
    MyIconButton buttonclear;

    JLabel info;


    DefaultTableModel model;
    public static MyTabel table;
    private static Object[][] tableDatas;
    JScrollPane panelScroll;

    public SettingPanelShowById() {
        initialize();
        tableDatas = new Object[1][6];
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
        panelGridSetting.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 30));

        //初始化组件
        labelid = new JLabel("输入电梯id编号");
        labelrange = new JLabel("输入电梯区域");

        textid = new JTextField();
        textrange = new JTextField();

        ImageIcon icon_id = new ImageIcon("src/resources/icon/findbyid.png");
        ImageIcon icon_id_enable = new ImageIcon("src/resources/icon/findbyidEnable.png");
        ImageIcon icon_id_disable = new ImageIcon("src/resources/icon/findbyidDisable.png");

        ImageIcon icon_range = new ImageIcon("src/resources/icon/findbyrange.png");
        ImageIcon icon_range_enable = new ImageIcon("src/resources/icon/findbyrangeEnable.png");
        ImageIcon icon_range_disable = new ImageIcon("src/resources/icon/findbyrangeDisable.png");

        ImageIcon icon_clear = new ImageIcon("src/resources/icon/clear.png");
        ImageIcon icon_clear_enable = new ImageIcon("src/resources/icon/clearEnable.png");
        ImageIcon icon_clear_disable = new ImageIcon("src/resources/icon/clearDisable.png");

        ImageIcon icon_all = new ImageIcon("src/resources/icon/findbyboth.png");
        ImageIcon icon_all_enable = new ImageIcon("src/resources/icon/findbybothEnable.png");
        ImageIcon icon_all_disable = new ImageIcon("src/resources/icon/findbybothDisable.png");

        buttonid = new MyIconButton(icon_id, icon_id_enable, icon_id_disable, "id");
        buttonrange = new MyIconButton(icon_range, icon_range_enable, icon_range_disable, "range");
        buttonall = new MyIconButton(icon_all, icon_all_enable, icon_all_disable, "all");
        buttonclear = new MyIconButton(icon_clear, icon_clear_enable, icon_clear_disable, "clear");

        // 字体
        Font font = new Font("微软雅黑", 0, 13);
        labelid.setFont(font);
        labelrange.setFont(font);
        textid.setFont(font);
        textrange.setFont(font);

        // 大小
        Dimension SIZE = new Dimension(100, 30);
        labelid.setPreferredSize(SIZE);
        labelrange.setPreferredSize(SIZE);

        SIZE = new Dimension(250, 24);
        textid.setPreferredSize(SIZE);
        textrange.setPreferredSize(SIZE);

        panelGridSetting.add(labelid);
        panelGridSetting.add(textid);
        panelGridSetting.add(buttonid);
        panelGridSetting.add(labelrange);
        panelGridSetting.add(textrange);
        panelGridSetting.add(buttonrange);
        panelGridSetting.add(buttonclear);
        panelGridSetting.add(buttonall);


        //表格设置
        model = new DefaultTableModel(tableDatas, new String[]{"编号", "电梯型号", "电梯创建日期", "区域", "电梯地址", "最近维修"});
        table = new MyTabel(model);
        table.Beautiful(false);


        //设置滚动条
        panelScroll = new JScrollPane(table) {
            public Dimension getPreferredSize() {
                return new Dimension(300, 60);
            }
        };
        panelScroll.setBackground(Color.white);


        panelCenter.add(panelGridSetting);
        panelCenter.add(panelScroll);

        return panelCenter;
    }


    private JPanel getDownPanel() {
        JPanel panelDown = new JPanel();
        info = new JLabel("输入查询内容");

        Font font = new Font("微软雅黑", 0, 12);
        panelDown.setFont(font);
        panelDown.add(info);

        return panelDown;
    }


    private void addListener() {
        buttonclear.addActionListener(e -> {
            textrange.setText("");
            textid.setText("");

            tableDatas = new Object[0][6];
            model = new DefaultTableModel(tableDatas, new String[]{"编号", "电梯型号", "电梯创建日期", "区域", "电梯地址", "最近维修"});
            table.setModel(model);
            table.Beautiful(false);

            info.setText("已清空");
        });


        buttonid.addActionListener(e -> {
            if (textid.getText().equals("")) {
                info.setText("id不允许为空");
                JOptionPane.showMessageDialog(this, "id不允许为空");
                return;
            }
            inittableDateByid(textid.getText());
            model = new DefaultTableModel(tableDatas, new String[]{"编号", "电梯型号", "电梯创建日期", "区域", "电梯地址", "最近维修"});
            table.setModel(model);
            table.Beautiful(false);
            info.setText("已更新");
        });

        buttonrange.addActionListener(e -> {
            if (textrange.getText().equals("")) {
                info.setText("Range不允许为空");
                JOptionPane.showMessageDialog(this, "Range不允许为空");

                return;
            }
            inittableDateByrange(textrange.getText());
            model = new DefaultTableModel(tableDatas, new String[]{"编号", "电梯型号", "电梯创建日期", "区域", "电梯地址", "最近维修"});
            table.setModel(model);
            table.Beautiful(false);
            info.setText("已更新");
        });

        buttonall.addActionListener(e -> {
            if (textrange.getText().equals("") || textid.getText().equals("")) {
                info.setText("Range和Id都不允许为空");
                JOptionPane.showMessageDialog(this, "Range和Id都不允许为空");
                return;
            }
            inittableDateByrangeAndId(textid.getText(), textrange.getText());
            model = new DefaultTableModel(tableDatas, new String[]{"编号", "电梯型号", "电梯创建日期", "区域", "电梯地址", "最近维修"});
            table.setModel(model);
            table.Beautiful(false);
            info.setText("已更新");
        });
    }


    private static void inittableDateByrange(String elerange) {
        List<EleInfo> list = EleInfoDao.findbyelerange(elerange);
        Object[][] result = new Object[list.size()][6];

        int i = 0;
        for (EleInfo ele : list) {
            result[i][0] = ele.getEleid();
            result[i][1] = ele.getEletype();
            result[i][2] = ele.getElecreatedate();
            result[i][3] = ele.getElerange();
            result[i][4] = ele.getEleaddress();
            result[i][5] = ele.getElelastmtdate();
            i++;
        }
        tableDatas = result;
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

    private static void inittableDateByrangeAndId(String eleid, String elerange) {
        List<EleInfo> list = EleInfoDao.findbyrangeandid(eleid, elerange);
        Object[][] result = new Object[list.size()][6];

        int i = 0;
        for (EleInfo ele : list) {
            result[i][0] = ele.getEleid();
            result[i][1] = ele.getEletype();
            result[i][2] = ele.getElecreatedate();
            result[i][3] = ele.getElerange();
            result[i][4] = ele.getEleaddress();
            result[i][5] = ele.getElelastmtdate();
            i++;
        }
        tableDatas = result;
    }


}
