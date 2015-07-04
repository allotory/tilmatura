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

	//收支明细card Panel
    private JPanel scheDetailPanel = null;
	//收支统计card Panel
    private JPanel scheStatPanel = null;
	//图表card Panel
	private JPanel graphPanel = null;
	//图表 expenses card Panel
	private JPanel egraphPanel = null;
	//图表 income card Panel
	private JPanel igraphPanel = null;
    
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
  				//设置收支明细
  				scheDetailPanel = new ScheDetailsCard().scheDetails();
  				centerPanel.add("scheDetail", scheDetailPanel);
  				//显示收支明细
  				card.show(centerPanel, "scheDetail");
  			}
  		});
  		scheStatBtn.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//设置收支统计
  				scheStatPanel = new ScheStatCard().inexpStat();
  				centerPanel.add("scheStat", scheStatPanel);
  				//显示收支统计
  				card.show(centerPanel, "scheStat");
  			}
  		});
  		graphBtn.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//设置收支图表
  				graphPanel = new GraphCard().getGraph("收支图表", "iegraph");
  				centerPanel.add("scheGraph", graphPanel);
  				//显示收支图表
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
  		edayBtn.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//设置支出日段分析图表
  				egraphPanel = new ExpensesGraphCard().getGraph("支出日段分析", "edaygraph");
  				centerPanel.add("edayGraph", egraphPanel);
  				//显示支出日段图表
  				card.show(centerPanel, "edayGraph");
  			}
  		});
  		emonthBtn.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//设置支出月度分析图表
  				egraphPanel = new ExpensesGraphCard().getGraph("支出月度分析", "emonthgraph");
  				centerPanel.add("emonthGraph", egraphPanel);
  				//显示支出月度图表
  				card.show(centerPanel, "emonthGraph");
  			}
  		});
  		eyearBtn.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//设置支出年度分析图表
  				egraphPanel = new ExpensesGraphCard().getGraph("支出年段分析", "eyeargraph");
  				centerPanel.add("eyearGraph", egraphPanel);
  				//显示支出年度图表
  				card.show(centerPanel, "eyearGraph");
  			}
  		});
  		
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
  		idayBtn.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//设置收入日段分析图表
  				igraphPanel = new IncomeGraphCard().getGraph("收入日段分析", "idaygraph");
  				centerPanel.add("idayGraph", igraphPanel);
  				//显示收入日度图表
  				card.show(centerPanel, "idayGraph");
  			}
  		});
  		imonthBtn.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//设置收入月度分析图表
  				igraphPanel = new IncomeGraphCard().getGraph("收入月度分析", "imonthgraph");
  				centerPanel.add("imonthGraph", igraphPanel);
  				//显示收入月度图表
  				card.show(centerPanel, "imonthGraph");
  			}
  		});
  		iyearBtn.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//设置收入年度分析图表
  				igraphPanel = new IncomeGraphCard().getGraph("收入年段分析", "iyeargraph");
  				centerPanel.add("iyearGraph", igraphPanel);
  				//显示收入年度图表
  				card.show(centerPanel, "iyearGraph");
  			}
  		});
  		
  		inAnalysisPanel.add(idayBtn);
  		inAnalysisPanel.add(imonthBtn);
  		inAnalysisPanel.add(iyearBtn);
  		
  		westPanel.add(schedulePanel);
  		westPanel.add(expAnalysisPanel);
  		westPanel.add(inAnalysisPanel);
  		
  		return westPanel;
  	}
}
