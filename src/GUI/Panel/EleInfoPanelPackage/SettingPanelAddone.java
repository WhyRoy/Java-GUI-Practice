package GUI.Panel.EleInfoPanelPackage;

import Dao.EleInfoDao;
import GUI.MyIconButton;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;

import GUI.Panel.EleInfoPanel;
import System.InputCheck;
import tables.EleInfo;

public class SettingPanelAddone extends JPanel {
    JLabel labelid;
    JLabel labeltype;
    JLabel labelcreatedate;
    JLabel labelrange;
    JLabel labeladdress;
    JLabel labelmtdate;

    JLabel info;

    JTextField textid;
    JTextField texttype;
    JTextField textcreatedate;
    JTextField textrange;
    JTextField textaddress;
    JTextField textmtdate;

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
        labeltype = new JLabel("型号");
        labelcreatedate = new JLabel("创建日期");
        labeladdress = new JLabel("地址");
        labelrange = new JLabel("区域");
        labelmtdate = new JLabel("最近维修日期");

        textid = new JTextField();
        texttype = new JTextField();
        textcreatedate = new JTextField();
        textaddress = new JTextField();
        textrange = new JTextField();
        textmtdate = new JTextField();

        // 字体
        Font font = new Font("微软雅黑", 0, 13);
        labelid.setFont(font);
        labeltype.setFont(font);
        labelcreatedate.setFont(font);
        labeladdress.setFont(font);
        labelrange.setFont(font);
        labelmtdate.setFont(font);
        textid.setFont(font);
        texttype.setFont(font);
        textcreatedate.setFont(font);
        textaddress.setFont(font);
        textrange.setFont(font);
        textmtdate.setFont(font);

        // 大小
        Dimension SIZE = new Dimension(78, 30);
        labelid.setPreferredSize(SIZE);
        labeltype.setPreferredSize(SIZE);
        labelcreatedate.setPreferredSize(SIZE);
        labeladdress.setPreferredSize(SIZE);
        labelrange.setPreferredSize(SIZE);
        labelmtdate.setPreferredSize(SIZE);

        SIZE = new Dimension(400, 24);
        textid.setPreferredSize(SIZE);
        texttype.setPreferredSize(SIZE);
        textcreatedate.setPreferredSize(SIZE);
        textaddress.setPreferredSize(SIZE);
        textrange.setPreferredSize(SIZE);
        textmtdate.setPreferredSize(SIZE);

        panelGridSetting.add(labelid);
        panelGridSetting.add(textid);
        panelGridSetting.add(labeltype);
        panelGridSetting.add(texttype);
        panelGridSetting.add(labelcreatedate);
        panelGridSetting.add(textcreatedate);
        panelGridSetting.add(labeladdress);
        panelGridSetting.add(textaddress);
        panelGridSetting.add(labelrange);
        panelGridSetting.add(textrange);
        panelGridSetting.add(labelmtdate);
        panelGridSetting.add(textmtdate);

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
            texttype.setText("");
            textcreatedate.setText("");
            textaddress.setText("");
            textrange.setText("");
            textmtdate.setText("");
            info.setText("已清空");
        });

        buttonadd.addActionListener(e -> {
            String id = textid.getText();
            String type = texttype.getText();
            String createdate = textcreatedate.getText();
            String address = textaddress.getText();
            String range = textrange.getText();
            String mtdate = textmtdate.getText();

            if (id.equals("")) {
                info.setText("id不为空");
                JOptionPane.showMessageDialog(this, "id不为空！");
                return;
            }
            if (type.equals("")) {
                info.setText("type不为空");
                JOptionPane.showMessageDialog(this, "type不为空！");
                return;
            }
            if (createdate.equals("")) {
                info.setText("createdate不为空");
                JOptionPane.showMessageDialog(this, "createdate不为空！");
                return;
            }
            if (address.equals("")) {
                info.setText("address不为空");
                JOptionPane.showMessageDialog(this, "address不为空！");
                return;
            }
            if (range.equals("")) {
                info.setText("range不为空");
                JOptionPane.showMessageDialog(this, "range不为空！");
                return;
            }
            if (mtdate.equals("")) {
                info.setText("mtdate不为空");
                JOptionPane.showMessageDialog(this, "mtdate不为空！");
                return;
            }
            if (!InputCheck.datecheck(createdate)) {
                info.setText("创建日期不合法(yyyy-mm-dd)");
                JOptionPane.showMessageDialog(this, "创建日期不合法(yyyy-mm-dd)！");
                return;
            }
            if (!InputCheck.datecheck(mtdate)) {
                info.setText("最近维修日期不合法(yyyy-mm-dd)");
                JOptionPane.showMessageDialog(this, "最近维修日期不合法(yyyy-mm-dd)");

                return;
            }

            EleInfo ele = new EleInfo();
            ele.setEleid(id);
            ele.setEletype(type);
            ele.setElecreatedate(Date.valueOf(createdate));
            ele.setElerange(range);
            ele.setEleaddress(address);
            ele.setElelastmtdate(Date.valueOf(mtdate));
            EleInfoDao.addOneEle(ele);

            info.setText("已成功添加一个电梯记录!");

            EleInfoPanel.settingPanelMain.removeAll();
            EleInfoPanel.settingPanelMain.add(new SettingPanelShowall());
            EleInfoPanel.settingPanelMain.updateUI();

        });
    }

    public static void setadmin() {
        buttonadd.setEnabled(false);
    }
}
