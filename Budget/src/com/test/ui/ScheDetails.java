package com.test.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ScheDetails {
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
    
    public JPanel scheDetails() {
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
		scheTypeCbox.addItem("衣");
		scheTypeCbox.addItem("食");
		scheTypeCbox.addItem("住");
		scheTypeCbox.addItem("行");
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
		
		//定义二维数组作为表格数据  
	    Object[][] tableData = {  
	        new Object[]{"李清照" , 29 ,29 , "女"},  
	        new Object[]{"苏格拉底", 29 , 56 , "男"},  
	        new Object[]{"李白", 29 , 35 , "男"},  
	        new Object[]{"弄玉", 29 , 18 , "女"},  
	        new Object[]{"虎头", 29 , 2 , "男"}  
	    };  
	    //定义一维数据作为列标题  
	    Object[] columnTitle = {"日期" , "收入" , "支出", "合计"};  
		//收支明细表格
		scheTable = new JTable(tableData, columnTitle);
		
		scheDetailPanel.add(BorderLayout.NORTH, scheDeTitlePanel);
		scheDetailPanel.add(BorderLayout.CENTER, new JScrollPane(scheTable));
		
		return scheDetailPanel;
	}
}
