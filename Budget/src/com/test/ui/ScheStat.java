package com.test.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ScheStat {
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
		
		//定义二维数组作为表格数据  
	    Object[][] tableData = {  
	        new Object[]{"李清照" , 29 ,29 , "女"},  
	        new Object[]{"苏格拉底", 29 , 56 , "男"},  
	        new Object[]{"李白", 29 , 35 , "男"},  
	        new Object[]{"弄玉", 29 , 18 , "女"},  
	        new Object[]{"虎头", 29 , 2 , "男"}  
	    };  
	    //定义一维数据作为列标题  
	    Object[] columnTitle = {"类别名称" , "类型" , "支出", "收入"};  
		//收支明细表格
		scheStatTable = new JTable(tableData, columnTitle);
		
		scheStatPanel.add(BorderLayout.NORTH, scheStatTitlePanel);
		scheStatPanel.add(BorderLayout.CENTER, new JScrollPane(scheStatTable));
		
		return scheStatPanel;
	}
}
