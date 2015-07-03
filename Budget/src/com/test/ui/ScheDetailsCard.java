package com.test.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.test.db.SqliteDB;
import com.test.func.TableData;

public class ScheDetailsCard {
	//收支明细 Panel
    private JPanel scheDetailPanel = null;
    //收支明细 title border
    private TitledBorder scheDetailTBorder = null;
    //收支明细 - 标题Panel
    private JPanel scheDeTitlePanel = null;
    //收支明细 - 起始日期
    private JLabel startDateLabel = null;
    private JTextField startDate = null;
    //收支明细 - 结束日期
    private JLabel endDateLabel = null;
    private JTextField endDate = null;
    //收支明细 - 类别
    private JLabel scheTypeLabel = null;
    private JComboBox<String> scheTypeCbox = null;
    //收支明细 - 查询
    private JButton queryBtn = null;
    //收支明细 - 表格
    private JTable scheTable = null;

    //数据库操作
    private SqliteDB sdb = null;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private PreparedStatement pstmt2 = null;
    private ResultSet rs = null;
    private ResultSet rs2 = null;
    
    //表格数据
    TableData td = null;
	DefaultTableModel tableModel = null;
    
    public JPanel scheDetails() {
    	
    	//数据库
    	sdb = new SqliteDB();
		conn = sdb.getConn();
		String sql1 = "select * from sche;";
		String sql2 = "select * from category;";
    	
		//收支明细
		scheDetailPanel = new JPanel(new BorderLayout());
		scheDetailTBorder = new TitledBorder("收支明细");
		scheDetailPanel.setBorder(scheDetailTBorder);

		//标题Panel
		scheDeTitlePanel = new JPanel(new FlowLayout());
		//起始日期
		startDateLabel = new JLabel("起始日期：");
		startDate = new JTextField(20);
		//结束日期
		endDateLabel = new JLabel("结束日期：");
		endDate = new JTextField(20);
		//类别
		scheTypeLabel = new JLabel("类别：");
		scheTypeCbox = new JComboBox<String>();
		//查询分类
		try {
			pstmt2 = conn.prepareStatement(sql2);
			rs2 = sdb.execQuery(pstmt2);
			scheTypeCbox.addItem("全部分类");
			while(rs2.next()) {
				scheTypeCbox.addItem(rs2.getString("cateName"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		//查询按钮
		queryBtn = new JButton("查询");

		//添加起始如期
		scheDeTitlePanel.add(startDateLabel);
		scheDeTitlePanel.add(startDate);
		//添加结束如期
		scheDeTitlePanel.add(endDateLabel);
		scheDeTitlePanel.add(endDate);
		//添加类别
		scheDeTitlePanel.add(scheTypeLabel);
		scheDeTitlePanel.add(scheTypeCbox);
		//添加查询按钮
		scheDeTitlePanel.add(queryBtn);
		
		//定义表格数据模型
		try {
			pstmt = conn.prepareStatement(sql1);
			rs = sdb.execQuery(pstmt);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		td = new TableData(rs);
		tableModel = td.getScheTableData();
		
		//收支明细表格
		scheTable = new JTable(tableModel);
		
		scheDetailPanel.add(BorderLayout.NORTH, scheDeTitlePanel);
		scheDetailPanel.add(BorderLayout.CENTER, new JScrollPane(scheTable));
		
		return scheDetailPanel;
	}
}
