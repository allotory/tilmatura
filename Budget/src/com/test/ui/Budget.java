package com.test.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

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
    
    //主窗口Panel
    private JPanel mainPanel = null;
    
    //左侧导航Panel
    private JPanel westPanel = null;

    //中心Panel
    private JPanel centerPanel = null;
    //设置中心卡片布局
  	private CardLayout card = null;
    
	//首页card panel
    private JPanel indexPanel = null;
	//新增收支card Panel
    private JPanel newSchePanel = null;
	//收支明细card Panel
    private JPanel scheDetailPanel = null;
	//收支统计card Panel
    private JPanel scheStatPanel = null;
	//添加类别card Panel
	private JPanel newTypePanel = null;
	//图表card Panel
	private JPanel graphPanel = null;
    
	//获取屏幕高度宽度
	private ScreenSizeUtils screenSizeUtils = null;
	
	//基础设置
	public void init() {
		this.setTitle("个人收支管理工具");
		this.setLayout(null);
		this.setScreen();
		mainPanel = new JPanel(new BorderLayout());
		//设置中心内容区
		this.setContent();
		//设置侧边栏
		westPanel = new BudgetSideBar().setSideBar(centerPanel, card);
  		mainPanel.add(BorderLayout.WEST, westPanel);
		//设置菜单栏
		menuBar = new BudgetMenu().setMenu(centerPanel, card);
		this.setJMenuBar(menuBar);
		//固定大小
		this.setResizable(false);
		this.setBounds((screenWidth - windowWidth)/2, 
				(screenHeight - windowHeight)/2, windowWidth, windowHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(mainPanel);
	}
	
	//获取屏幕高度宽度
	public void setScreen() {
		screenSizeUtils = new ScreenSizeUtils();
		screenWidth = screenSizeUtils.getScreenWidth();
		screenHeight = screenSizeUtils.getScreenHeight();
	}
	
	//设置中心内容
	public void setContent() {
		centerPanel = new JPanel();
		
		//设置中心卡片布局
		card = new CardLayout();
		centerPanel.setLayout(card);
		
		//设置首页
		indexPanel = new IndexCard().setIndex();
		centerPanel.add("index", indexPanel);
		//设置新增开支
		newSchePanel = new NewScheCard().setNewSche();
		centerPanel.add("newSchedule", newSchePanel);
		//设置收支明细
		scheDetailPanel = new ScheDetailsCard().scheDetails();
		centerPanel.add("scheDetail", scheDetailPanel);
		//设置收支统计
		scheStatPanel = new ScheStatCard().inexpStat();
		centerPanel.add("scheStat", scheStatPanel);
		//设置添加类别
		newTypePanel = new NewTypeCard().setNewType();
		centerPanel.add("newType", newTypePanel);
		//设置图表
		graphPanel = new GraphCard().getGraph("收支图表", "iegraph");
		centerPanel.add("scheGraph", graphPanel);
		
		//显示首页
		card.show(centerPanel, "index");
		
		mainPanel.add(BorderLayout.CENTER, centerPanel);
	}
}
