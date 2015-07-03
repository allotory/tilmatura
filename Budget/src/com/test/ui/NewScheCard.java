package com.test.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.test.db.SqliteDB;

public class NewScheCard {
	//新增收支 Panel
    private JPanel newSchePanel = null;
    //新增收支 - title border
    private TitledBorder newScheTBorder = null;
    //新增收支 - 类型
    private JLabel scheType = null;
    private JRadioButton incomeRbtn = null;
    private JRadioButton expRbtn = null;
    private ButtonGroup btnGroup = null;
    //新增收支 - 类别
    private JLabel scheCategory = null;
    private JComboBox<String> categoryCbox = null;
    //新增收支 - 日期
    private JLabel scheDateLabel = null;
    private JTextField scheDate = null;
    //新增收支 - 金额
    private JLabel scheNumLabel = null;
    private JTextField scheNum = null;
    //新增收支 - 备注
    private JLabel scheNoteLabel = null;
    private JTextField scheNote = null;
    //新增收支 - 提交
    private JButton addScheBtn = null;
    
    //数据库操作
    private SqliteDB sdb = null;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private PreparedStatement pstmt2 = null;
    private ResultSet rs = null;
    
    public JPanel setNewSche() {
    	
    	//数据库
    	sdb = new SqliteDB();
		conn = sdb.getConn();
		String sql1 = "insert into sche(scheType, scheCategory, scheDate, "
				+ "scheAmount, scheDescription) values (?, ?, ?, ?, ?);";
		String sql2 = "select * from category;";
		
		try {
			pstmt = conn.prepareStatement(sql1);
			pstmt2 = conn.prepareStatement(sql2);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    	
		//新增收支
		newSchePanel = new JPanel();
		newSchePanel.setLayout(null);
		newScheTBorder = new TitledBorder("新增收支");
		newSchePanel.setBorder(newScheTBorder);
		
		//收支类型
		scheType = new JLabel("类型：");
		incomeRbtn = new JRadioButton("收入");
		incomeRbtn.setSelected(true);
		expRbtn = new JRadioButton("支出");
		btnGroup = new ButtonGroup();
		btnGroup.add(incomeRbtn);
		btnGroup.add(expRbtn);
		scheType.setBounds(50, 25, 40, 50);
		incomeRbtn.setBounds(90, 25, 80, 50);
		expRbtn.setBounds(170, 25, 80, 50);
		
		//收支分类
		scheCategory = new JLabel("类别：");
		categoryCbox = new JComboBox<String>();
		//查询分类
		try {
			pstmt2 = conn.prepareStatement(sql2);
			rs = sdb.execQuery(pstmt2);
			while(rs.next()) {
				categoryCbox.addItem(rs.getString("cateName"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		scheCategory.setBounds(50, 60, 40, 50);
		categoryCbox.setBounds(100, 75, 120, 20);
		
		//收支日期
		scheDateLabel = new JLabel("日期：");
		scheDate = new JTextField(60);
		scheDateLabel.setBounds(50, 98, 40, 50);
		scheDate.setBounds(100, 110, 120, 25);
		
		//收支金额
		scheNumLabel = new JLabel("金额：");
		scheNum = new JTextField(60);
		scheNumLabel.setBounds(50, 138, 40, 50);
		scheNum.setBounds(100, 150, 120, 25);
		
		//收支备注
		scheNoteLabel = new JLabel("备注：");
		scheNote = new JTextField(60);
		scheNoteLabel.setBounds(50, 178, 40, 50);
		scheNote.setBounds(100, 190, 120, 25);
		
		//提交
		addScheBtn = new JButton("提交");
		addScheBtn.setBounds(100, 230, 60, 30);
		addScheBtn.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				
  				new Thread( ()->{
  					try {
	  					if(incomeRbtn.isSelected()) {
	  						pstmt.setString(1, incomeRbtn.getText());
	  	  				}else if(expRbtn.isSelected()) {
	  	  					pstmt.setString(1, expRbtn.getText());
	  	  				}
  						pstmt.setString(2, categoryCbox.getSelectedItem().toString());
  						pstmt.setString(3, scheDate.getText());
  						pstmt.setString(4, scheNum.getText());
  						pstmt.setString(5, scheNote.getText());
  						
  						int r = sdb.execOther(pstmt);
  						if(r != -1) {
  							JOptionPane.showMessageDialog(null, "添加成功～");
  						}else{
  							JOptionPane.showMessageDialog(null, "添加失败～");
  						}
  						
  					} catch (SQLException e1) {
  						e1.printStackTrace();
  					}
  				}).start();
  			}
  		});
		
		//添加收支类型
		newSchePanel.add(scheType);
		newSchePanel.add(incomeRbtn);
		newSchePanel.add(expRbtn);
		//添加收支分类
		newSchePanel.add(scheCategory);
		newSchePanel.add(categoryCbox);
		//添加收支日期
		newSchePanel.add(scheDateLabel);
		newSchePanel.add(scheDate);
		//添加收支金额
		newSchePanel.add(scheNumLabel);
		newSchePanel.add(scheNum);
		//添加收支备注
		newSchePanel.add(scheNoteLabel);
		newSchePanel.add(scheNote);
		//添加提交按钮
		newSchePanel.add(addScheBtn);
		
		return newSchePanel;
	}
}
