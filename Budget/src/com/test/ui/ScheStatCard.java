package com.test.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.test.db.SqliteDB;
import com.test.func.TableData;

public class ScheStatCard {
	//收支统计Panel
    private JPanel scheStatPanel = null;
    private TitledBorder scheStatTBorder = null;
    //收支统计 - 标题Panel
    private JPanel scheStatTitlePanel = null;
    //收支统计 - 起始日期
    private JLabel startStatDateLabel = null;
    private JTextField startStatDate = null;
    //收支统计 - 结束日期
    private JLabel endStatDateLabel = null;
    private JTextField endStatDate = null;
    //收支统计 - 查询
    private JButton queryStatBtn = null;
    //收支统计 - 表格
    private JTable scheStatTable = null;
    
    //数据库操作
    SqliteDB sdb = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt2 = null;
    ResultSet rs = null;

    //表格数据
    TableData td = null;
	DefaultTableModel tableModel = null;
    
    public JPanel inexpStat() {
		//收支统计
		scheStatPanel = new JPanel(new BorderLayout());
		scheStatTBorder = new TitledBorder("收支统计");
		scheStatPanel.setBorder(scheStatTBorder);
		
		//收支统计 - 头部Panel
		scheStatTitlePanel = new JPanel(new FlowLayout());
		//收支统计 - 起始日期
		startStatDateLabel = new JLabel("起始日期");
		startStatDate = new JTextField(20);
		//收支统计 - 结束日期
		endStatDateLabel = new JLabel("结束日期");
		endStatDate = new JTextField(20);
		//收支统计 - 查询
		queryStatBtn = new JButton("查询");
		
		scheStatTitlePanel.add(startStatDateLabel);
		scheStatTitlePanel.add(startStatDate);
		scheStatTitlePanel.add(endStatDateLabel);
		scheStatTitlePanel.add(endStatDate);
		scheStatTitlePanel.add(queryStatBtn);
		
		//数据库
		sdb = new SqliteDB();
		conn = sdb.getConn();
		String sql2 = "select scheCategory, scheType, sum(scheAmount) as sum_amount from sche group by scheCategory;";
		try {
			pstmt2 = conn.prepareStatement(sql2);
			rs = sdb.execQuery(pstmt2);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		td = new TableData(rs);
		tableModel = td.getStatTableData();
		sdb.closeDB();
		//收支明细表格
		scheStatTable = new JTable(tableModel);
		
		scheStatPanel.add(BorderLayout.NORTH, scheStatTitlePanel);
		scheStatPanel.add(BorderLayout.CENTER, new JScrollPane(scheStatTable));
		
		return scheStatPanel;
	}
}
