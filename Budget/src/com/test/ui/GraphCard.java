package com.test.ui;

import java.awt.BorderLayout;
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

import com.test.utils.BarChart;
import com.test.utils.JudgeDate;

//图表分析
public class GraphCard {

	//图表Panel
	private JPanel graphPanel = null;
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
		graphPanel = new JPanel(new BorderLayout());
		graphTBorder = new TitledBorder(tbMsg);
		graphPanel.setBorder(graphTBorder);
		
		if(flag.equals("iegraph")) {
			//收支图表
			
			//图表title panel
			graphTPanel = new JPanel(new FlowLayout());
			//起始日期
			startDateLabel = new JLabel("起始日期：");
			startDate = new JTextField(10);
			//结束日期
			endDateLabel = new JLabel("结束日期：");
			endDate = new JTextField(10);
			//查询按钮
			queryBtn = new JButton("查询");
			queryBtn.addMouseListener(new MouseAdapter() {
	  			@Override
	  			public void mousePressed(MouseEvent e) {
	  				new Thread( ()->{
	  					if(JudgeDate.judge(startDate.getText()) && JudgeDate.judge(endDate.getText())) {
	  	  					//刷新图表
		  	  				SwingUtilities.invokeLater(()->{
		  	  					graphCPanel = BarChart.createQueryBar(startDate.getText(), endDate.getText());
		  	  					graphPanel.repaint();
		  					});
	  					}else {
	  						JOptionPane.showMessageDialog(null, "对不起，您的日期格式输入错误！（范例：yyyy-MM-dd）");
	  					}
	  				}).start();
	  			}
	  		});
			
			graphTPanel.add(startDateLabel);
			graphTPanel.add(startDate);
			graphTPanel.add(endDateLabel);
			graphTPanel.add(endDate);
			graphTPanel.add(queryBtn);
			
			//图表
			graphCPanel = BarChart.createDemoBar();
		}
		
		graphPanel.add(BorderLayout.NORTH, graphTPanel);
		graphPanel.add(BorderLayout.CENTER, graphCPanel);
		
		return graphPanel;
	}
	
}
