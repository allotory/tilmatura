package com.test.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ExpensesGraphCard {

	//图表Panel
	private JPanel egraphPanel = null;
	private TitledBorder graphTBorder = null;
	//Panel标题
	private String tbMsg = "";
	
	//图表 title panel
	private JPanel graphTPanel = null;
	//图表 - 起始日期
    private JLabel startDateLabel = null;
    private JTextField startDate = null;
    //图表 - 结束日期
    private JLabel endDateLabel = null;
    private JTextField endDate = null;
    //图表- 类别
    private JLabel scheTypeLabel = null;
    private JComboBox<String> scheTypeCbox = null;
    //图表 - 查询
    private JButton queryBtn = null;
    
    //图表center panel
    private JPanel graphCPanel = null;
	
	public JPanel getGraph(String title, String flag) {
		//图标标题
		tbMsg = title;
		
		//图标Panel
		egraphPanel = new JPanel(new BorderLayout());
		graphTBorder = new TitledBorder(tbMsg);
		egraphPanel.setBorder(graphTBorder);

		//图表title panel
		graphTPanel = new JPanel(new FlowLayout());
		
		if(flag.equals("edaygraph")) {
			//支出日段分析

			//起始日期
			startDateLabel = new JLabel("起始日期：");
			startDate = new JTextField(20);
			startDate.setText("2015-01-01");
			//结束日期
			endDateLabel = new JLabel("结束日期：");
			endDate = new JTextField(20);
			endDate.setText("2015-12-31");
		}else if(flag.equals("emonthgraph")) {
			//支出月度分析

			//起始日期
			startDateLabel = new JLabel("起始日期：");
			startDate = new JTextField(20);
			startDate.setText("2015-01");
			//结束日期
			endDateLabel = new JLabel("结束日期：");
			endDate = new JTextField(20);
			endDate.setText("2015-12");
		}else if(flag.equals("eyeargraph")) {
			//支出年度分析

			//起始日期
			startDateLabel = new JLabel("起始日期：");
			startDate = new JTextField(20);
			startDate.setText("2014");
			//结束日期
			endDateLabel = new JLabel("结束日期：");
			endDate = new JTextField(20);
			endDate.setText("2015");
		}
		
		//类别
		scheTypeLabel = new JLabel("类别：");
		scheTypeCbox = new JComboBox<String>();
		scheTypeCbox.addItem("全部");
		scheTypeCbox.addItem("衣");
		scheTypeCbox.addItem("食");
		scheTypeCbox.addItem("住");
		scheTypeCbox.addItem("行");
		//查询按钮
		queryBtn = new JButton("查询");
		
		graphTPanel.add(startDateLabel);
		graphTPanel.add(startDate);
		graphTPanel.add(endDateLabel);
		graphTPanel.add(endDate);
		graphTPanel.add(scheTypeLabel);
		graphTPanel.add(scheTypeCbox);
		graphTPanel.add(queryBtn);

		if(flag.equals("edaygraph")) {
			//支出日段分析

			//图表
			graphCPanel = new JPanel();
			graphCPanel.setBackground(Color.ORANGE);
		}else if(flag.equals("emonthgraph")) {
			//支出月度分析

			//图表
			graphCPanel = new JPanel();
			graphCPanel.setBackground(Color.PINK);
		}else if(flag.equals("eyeargraph")) {
			//支出年度分析

			//图表
			graphCPanel = new JPanel();
			graphCPanel.setBackground(Color.YELLOW);
		}
		
		egraphPanel.add(BorderLayout.NORTH, graphTPanel);
		egraphPanel.add(BorderLayout.CENTER, graphCPanel);
		
		return egraphPanel;
	}
}
