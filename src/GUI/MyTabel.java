package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MyTabel extends JTable {

    public MyTabel(DefaultTableModel obj) {
        super(obj);
    }

    public void Beautiful(boolean bool) {
        Font font = new Font("微软雅黑", 0, 12);
        this.setFont(font);

        //表头
        this.getTableHeader().setFont(font);
        this.getTableHeader().setBackground(new Color(37, 174, 96));
        this.setRowHeight(30);
        this.setGridColor(new Color(229, 229, 229));
        this.setSelectionBackground(new Color(37, 174, 96));

        //设置列宽
        if (bool) {
            this.getColumnModel().getColumn(0).setPreferredWidth(60);
            this.getColumnModel().getColumn(0).setMaxWidth(60);
        } else {
            this.getColumnModel().getColumn(0).setPreferredWidth(40);
            this.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        if (bool) {
            this.getColumnModel().getColumn(1).setPreferredWidth(400);
            this.getColumnModel().getColumn(1).setMaxWidth(400);
        } else {
            this.getColumnModel().getColumn(1).setPreferredWidth(80);
            this.getColumnModel().getColumn(1).setMaxWidth(80);
        }
        if (bool) {
            this.getColumnModel().getColumn(2).setPreferredWidth(360);
            this.getColumnModel().getColumn(2).setMaxWidth(360);
        } else {
            this.getColumnModel().getColumn(2).setPreferredWidth(90);
            this.getColumnModel().getColumn(2).setMaxWidth(90);
        }

        if (bool) {
            this.getColumnModel().getColumn(3).setPreferredWidth(450);
            this.getColumnModel().getColumn(3).setMaxWidth(500);
        } else {
            this.getColumnModel().getColumn(3).setPreferredWidth(50);
            this.getColumnModel().getColumn(3).setMaxWidth(50);
        }
        this.getColumnModel().getColumn(4).setPreferredWidth(225);
        this.getColumnModel().getColumn(4).setMaxWidth(250);


        //居中显示
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        this.setDefaultRenderer(Object.class, r);
        this.getTableHeader().setDefaultRenderer(r);

    }

}
