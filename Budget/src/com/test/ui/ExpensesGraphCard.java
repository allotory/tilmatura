package com.test.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import com.test.utils.JudgeDate;
import com.test.utils.LineChart;

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
			startDate = new JTextField(10);
			startDate.setText("2015-01-01");
			//结束日期
			endDateLabel = new JLabel("结束日期：");
			endDate = new JTextField(10);
			endDate.setText("2015-12-31");
			
			//查询按钮
			queryBtn = new JButton("查询");
			queryBtn.addMouseListener(new MouseAdapter() {
	  			@Override
	  			public void mousePressed(MouseEvent e) {
	  				new Thread( ()->{
	  					if(JudgeDate.judge("yyyy-MM-dd", startDate.getText()) && JudgeDate.judge("yyyy-MM-dd", endDate.getText())) {
	  	  					//刷新图表
		  	  				SwingUtilities.invokeLater(()->{
		  	  					graphCPanel = LineChart.createQueryLine(startDate.getText(), endDate.getText(), "支出");
		  					});
	  					}else {
	  						JOptionPane.showMessageDialog(null, "对不起，您的日期格式输入错误！（范例：yyyy-MM-dd）");
	  					}
	  				}).start();
	  			}
	  		});
		}else if(flag.equals("emonthgraph")) {
			//支出月度分析

			//起始日期
			startDateLabel = new JLabel("起始日期：");
			startDate = new JTextField(10);
			startDate.setText("2015-01");
			//结束日期
			endDateLabel = new JLabel("结束日期：");
			endDate = new JTextField(10);
			endDate.setText("2015-12");
			//查询按钮
			queryBtn = new JButton("查询");
			queryBtn.addMouseListener(new MouseAdapter() {
	  			@Override
	  			public void mousePressed(MouseEvent e) {
	  				new Thread( ()->{
	  					if(JudgeDate.judge("yyyy-MM", startDate.getText()) && JudgeDate.judge("yyyy-MM", endDate.getText())) {
	  	  					//刷新图表
		  	  				SwingUtilities.invokeLater(()->{
		  	  					graphCPanel = LineChart.createQueryLine(startDate.getText(), endDate.getText(), "支出");
		  					});
	  					}else {
	  						JOptionPane.showMessageDialog(null, "对不起，您的日期格式输入错误！（范例：yyyy-MM）");
	  					}
	  				}).start();
	  			}
	  		});
		}else if(flag.equals("eyeargraph")) {
			//支出年度分析

			//起始日期
			startDateLabel = new JLabel("起始日期：");
			startDate = new JTextField(10);
			startDate.setText("2014");
			//结束日期
			endDateLabel = new JLabel("结束日期：");
			endDate = new JTextField(10);
			endDate.setText("2015");
			//查询按钮
			queryBtn = new JButton("查询");
			queryBtn.addMouseListener(new MouseAdapter() {
	  			@Override
	  			public void mousePressed(MouseEvent e) {
	  				new Thread( ()->{
	  					if(JudgeDate.judge("yyyy", startDate.getText()) && JudgeDate.judge("yyyy", endDate.getText())) {
	  	  					//刷新图表
		  	  				SwingUtilities.invokeLater(()->{
		  	  					graphCPanel = LineChart.createQueryLine(startDate.getText(), endDate.getText(), "支出");
		  					});
	  					}else {
	  						JOptionPane.showMessageDialog(null, "对不起，您的日期格式输入错误！（范例：yyyy）");
	  					}
	  				}).start();
	  			}
	  		});
		}
		
		
		
		graphTPanel.add(startDateLabel);
		graphTPanel.add(startDate);
		graphTPanel.add(endDateLabel);
		graphTPanel.add(endDate);
		graphTPanel.add(queryBtn);

		if(flag.equals("edaygraph")) {
			//支出日段分析

			//图表
			graphCPanel = LineChart.createDemoLine("支出");
			graphCPanel.setBackground(Color.ORANGE);
		}else if(flag.equals("emonthgraph")) {
			//支出月度分析

			//图表
			graphCPanel = LineChart.createDemoLine("支出");
			graphCPanel.setBackground(Color.PINK);
		}else if(flag.equals("eyeargraph")) {
			//支出年度分析

			//图表
			graphCPanel = LineChart.createDemoLine("支出");
			graphCPanel.setBackground(Color.YELLOW);
		}
		
		egraphPanel.add(BorderLayout.NORTH, graphTPanel);
		egraphPanel.add(BorderLayout.CENTER, graphCPanel);
		
		return egraphPanel;
	}
}
