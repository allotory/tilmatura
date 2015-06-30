package com.test.ui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class BudgetSideBar {
    //左侧导航Panel
    private JPanel westPanel = null;
    
    //左侧导航 - 收支明细Panel
    private JPanel schedulePanel = null;
    //左侧导航 - 收支明细title border
    private TitledBorder scheduleTBorder = null;
    //左侧导航 - 收支明细按钮
    private JButton scheduleBtn = null;
    //左侧导航 - 收支统计按钮
    private JButton scheStatBtn = null;
    //左侧导航 - 收支图表按钮
    private JButton graphBtn = null;
    
    //左侧导航 - 支出分析Panel
    private JPanel expAnalysisPanel = null;
    //左侧导航 - 支出分析title border
    private TitledBorder expAnaylysisTBorder = null;
    //左侧导航 - 日段分析
    private JButton edayBtn = null;
    //左侧导航 - 月度分析
    private JButton emonthBtn = null;
    //左侧导航 - 年度分析
    private JButton eyearBtn = null;
    
    //左侧导航 - 收入分析Panel
    private JPanel inAnalysisPanel = null;
    //左侧导航 - 收入分析title border
    private TitledBorder inAnalysisTBorder = null;
    //左侧导航 - 日段分析
    private JButton idayBtn = null;
    //左侧导航 - 月度分析
    private JButton imonthBtn = null;
    //左侧导航 - 年度分析
    private JButton iyearBtn = null;
    
    //设置左侧导航
  	public JPanel setSideBar(JPanel centerPanel, CardLayout card) {
  		westPanel = new JPanel(new GridLayout(3, 1));
  		westPanel.setPreferredSize(new Dimension(130, 0));
  		
  		//收支明细
  		schedulePanel = new JPanel(new GridLayout(3, 1));
  		scheduleTBorder = new TitledBorder("收支明细");
  		schedulePanel.setBorder(scheduleTBorder);
  		scheduleBtn = new JButton("收支明细");
  		scheStatBtn = new JButton("收支统计");
  		graphBtn = new JButton("收支图表");
  		scheduleBtn.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//显示收支明细
  				card.show(centerPanel, "scheDetail");
  			}
  		});
  		scheStatBtn.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//显示收支明细
  				card.show(centerPanel, "scheStat");
  			}
  		});
  		graphBtn.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//显示收支明细
  				card.show(centerPanel, "scheGraph");
  			}
  		});
  		
  		schedulePanel.add(scheduleBtn);
  		schedulePanel.add(scheStatBtn);
  		schedulePanel.add(graphBtn);
  		
  		//支出分析
  		expAnalysisPanel = new JPanel(new GridLayout(3, 1));
  		expAnaylysisTBorder = new TitledBorder("支出分析");
  		expAnalysisPanel.setBorder(expAnaylysisTBorder);
  		edayBtn = new JButton("日段分析");
  		emonthBtn = new JButton("月度分析");
  		eyearBtn = new JButton("年度分析");
  		
  		expAnalysisPanel.add(edayBtn);
  		expAnalysisPanel.add(emonthBtn);
  		expAnalysisPanel.add(eyearBtn);
  		
  		//收入分析
  		inAnalysisPanel = new JPanel(new GridLayout(3, 1));
  		inAnalysisTBorder = new TitledBorder("收入分析");
  		inAnalysisPanel.setBorder(inAnalysisTBorder);
  		idayBtn = new JButton("日段分析");
  		imonthBtn = new JButton("月度分析");
  		iyearBtn = new JButton("年度分析");
  		
  		inAnalysisPanel.add(idayBtn);
  		inAnalysisPanel.add(imonthBtn);
  		inAnalysisPanel.add(iyearBtn);
  		
  		westPanel.add(schedulePanel);
  		westPanel.add(expAnalysisPanel);
  		westPanel.add(inAnalysisPanel);
  		
  		return westPanel;
  	}
}
