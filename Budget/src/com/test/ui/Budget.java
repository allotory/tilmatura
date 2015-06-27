package com.test.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.test.utils.ScreenSizeUtils;

//个人收支管理工具
@SuppressWarnings("serial")
public class Budget extends JFrame{
	
	//窗口的宽度和窗口的高度
	private int windowWidth = 800;
	private int windowHeight = 600;	
	
	//屏幕的宽度和屏幕的高度
	private int screenWidth = 0;
	private int screenHeight = 0;
	
	//菜单栏
    private JMenuBar menuBar = null;
    
    //文件菜单
    private JMenu fileMenu = null;
    //文件菜单 - 新建收支
    private JMenuItem newMItem = null;
    //文件菜单 - 添加类别
    private JMenuItem addTypeMItem = null;
    //文件菜单 - 退出
    private JMenuItem exitMItem = null;
    
    //收支明细菜单
    private JMenu scheduleMenu = null;
    //文件菜单 - 收支明细
    private JMenuItem scheduleMItem = null;
    //收支明细菜单 - 收支统计
    private JMenuItem scheStatMItem = null;
    //收支明细菜单 - 收支图表
    private JMenuItem graphMItem = null;
    
    //支出分析菜单
    private JMenu expensesMenu = null;
    //支出分析菜单 - 日段分析
    private JMenuItem edayMItem = null;
    //支出分析菜单 - 月度分析
    private JMenuItem emonthMItem = null;
    //支出分析菜单 - 年度分析
    private JMenuItem eyearMItem = null;   
    
    //收入分析菜单
    private JMenu incomeMenu = null;
    //收入分析菜单 - 日段分析
    private JMenuItem idayMItem = null;
    //收入分析菜单 - 月度分析
    private JMenuItem imonthMItem = null;
    //收入分析菜单 - 年度分析
    private JMenuItem iyearMItem = null;
    
    //帮助菜单
    private JMenu helpMenu = null;
    //帮助菜单 - 关于
    private JMenuItem aboutMItem = null;
    
    //主窗口Panel
    private JPanel mainPanel = null;

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
    
    //中心Panel
    private JPanel centerPanel = null;
    //中心Panel - title border
    private TitledBorder centerTBorder = null;

	//获取屏幕高度宽度
	private ScreenSizeUtils screenSizeUtils = null;
	
	//基础设置
	public void init() {
		this.setTitle("个人收支管理工具");
		this.setLayout(null);
		this.setScreen();
		this.setMenu();
		this.setBounds((screenWidth - windowWidth)/2, 
				(screenHeight - windowHeight)/2, windowWidth, windowHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel(new BorderLayout());
		this.setSideBar();
		this.setContent();
		this.setContentPane(mainPanel);
	}
	
	//获取屏幕高度宽度
	public void setScreen() {
		screenSizeUtils = new ScreenSizeUtils();
		screenWidth = screenSizeUtils.getScreenWidth();
		screenHeight = screenSizeUtils.getScreenHeight();
	}
	
	//设置菜单
	public void setMenu() {
		menuBar = new JMenuBar();
		//文件菜单
		fileMenu = new JMenu("文件");
		newMItem = new JMenuItem("新增收支");
		addTypeMItem = new JMenuItem("添加类别");
		exitMItem = new JMenuItem("退出");
		fileMenu.add(fileMenu);
		fileMenu.add(newMItem);
		fileMenu.add(addTypeMItem);
		fileMenu.add(exitMItem);
		//收支明细菜单
		scheduleMenu = new JMenu("收支明细");
		scheduleMItem = new JMenuItem("收支明细");
		scheStatMItem = new JMenuItem("收支统计");
		graphMItem = new JMenuItem("收支图表");
		scheduleMenu.add(scheduleMItem);
		scheduleMenu.add(scheStatMItem);
		scheduleMenu.add(graphMItem);
		//支出分析菜单
		expensesMenu = new JMenu("支出分析");
		edayMItem = new JMenuItem("日段分析");
		emonthMItem = new JMenuItem("月度分析");
		eyearMItem = new JMenuItem("年度分析");
		expensesMenu.add(edayMItem);
		expensesMenu.add(emonthMItem);
		expensesMenu.add(eyearMItem);
		//收入分析菜单
		incomeMenu = new JMenu("支出分析");
		idayMItem = new JMenuItem("日段分析");
		imonthMItem = new JMenuItem("月度分析");
		iyearMItem = new JMenuItem("年度分析");
		incomeMenu.add(idayMItem);
		incomeMenu.add(imonthMItem);
		incomeMenu.add(iyearMItem);
		//帮助菜单
		helpMenu = new JMenu("帮助");
		aboutMItem = new JMenuItem("关于");
		helpMenu.add(aboutMItem);
		
		menuBar.add(fileMenu);
		menuBar.add(scheduleMenu);
		menuBar.add(expensesMenu);
		menuBar.add(incomeMenu);
		menuBar.add(helpMenu);
		
		this.setJMenuBar(menuBar);
	}
	
	//设置左侧导航
	public void setSideBar() {
		westPanel = new JPanel(new GridLayout(3, 1));
		westPanel.setPreferredSize(new Dimension(130, 0));
		
		//收支明细
		schedulePanel = new JPanel(new GridLayout(3, 1));
		scheduleTBorder = new TitledBorder("收支明细");
		schedulePanel.setBorder(scheduleTBorder);
		scheduleBtn = new JButton("收支明细");
		scheStatBtn = new JButton("收支统计");
		graphBtn = new JButton("收支图表");
		
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
		
		mainPanel.add(BorderLayout.WEST, westPanel);
	}
	
	//设置中心内容
	public void setContent() {
		centerPanel = new JPanel();
		centerTBorder = new TitledBorder("首页");
		centerPanel.setBorder(centerTBorder);
		mainPanel.add(BorderLayout.CENTER, centerPanel);
	}
}
