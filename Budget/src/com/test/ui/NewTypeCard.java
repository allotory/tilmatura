package com.test.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class NewTypeCard {
	//添加类别Panel
	private JPanel newTypePanel = null;
	//添加类别 title panel
	private JPanel newTypeTPanel = null;
	private TitledBorder newTypeTBorder = null;
	//添加类别 - 名称
	private JLabel typeName = null;
	private JTextField typeNameField = null;
	//添加类别 - 所属类型
    private JComboBox<String> typeCbox = null;
    //添加按钮
    private JButton addBtn = null;
    
    //管理类别 panel
    private JPanel manageTypePanel = null;
    private TitledBorder mgeTypeTBorder = null;
    //管理类别 table
    private JTable manageTypeTable = null;
	
    //数据库操作
    SqliteDB sdb = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt2 = null;
    ResultSet rs = null;
    
    //表格数据
    TableData td = null;
	DefaultTableModel tableModel = null;
    
	public JPanel setNewType() {
		//数据库
		sdb = new SqliteDB();
		conn = sdb.getConn();
		String sql1 = "insert into category(cateName, scheType) values (?, ?);";
		String sql2 = "select * from category;";
		try {
			pstmt = conn.prepareStatement(sql1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		//添加类别Panel
		newTypePanel = new JPanel(new BorderLayout());
		
		//添加类别 头部panel
		newTypeTPanel = new JPanel(new FlowLayout());
		newTypeTBorder = new TitledBorder("添加类别");
		newTypeTPanel.setBorder(newTypeTBorder);
		//类别名称
		typeName = new JLabel("类别名称：");
		typeNameField = new JTextField(20);
		//类型
		typeCbox = new JComboBox<String>();
		typeCbox.addItem("收入");
		typeCbox.addItem("支出");
		//按钮
		addBtn = new JButton("添加");
		addBtn.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				new Thread( ()->{
  					try {
  						pstmt.setString(1, typeNameField.getText());
  						pstmt.setString(2, typeCbox.getSelectedItem().toString());
  						int r = sdb.execOther(pstmt);
  						if(r != -1) {
  							System.out.println("添加类别成功！");
  						}else{
  							System.out.println("添加类别失败！");
  						}
  					} catch (SQLException e1) {
  						e1.printStackTrace();
  					}
  					
  					try {
  						pstmt2 = conn.prepareStatement(sql2);
  						rs = sdb.execQuery(pstmt2);
  					} catch (SQLException e1) {
  						e1.printStackTrace();
  					}

  					td = new TableData(rs);
  					tableModel = td.getTableData();
  					
  					manageTypeTable.setModel(tableModel);
  					manageTypeTable.validate();
  					manageTypeTable.updateUI();
  				}).start();
  			}
  		});
		
		//管理类别 panel
		manageTypePanel = new JPanel(new BorderLayout());
		mgeTypeTBorder = new TitledBorder("管理类别");
		manageTypePanel.setBorder(mgeTypeTBorder);
		
		//定义表格数据模型
		try {
			pstmt2 = conn.prepareStatement(sql2);
			rs = sdb.execQuery(pstmt2);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		td = new TableData(rs);
		tableModel = td.getTableData();
		
		//管理类别表格
	    manageTypeTable = new JTable(tableModel);
		
		newTypeTPanel.add(typeName);
		newTypeTPanel.add(typeNameField);
		newTypeTPanel.add(typeCbox);
		newTypeTPanel.add(addBtn);

	    manageTypePanel.add(BorderLayout.CENTER, new JScrollPane(manageTypeTable));
		
		newTypePanel.add(BorderLayout.NORTH, newTypeTPanel);
		newTypePanel.add(BorderLayout.CENTER, manageTypePanel);
		
		return newTypePanel;
	}
}
