package com.test.ui;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//主界面菜单栏
public class BudgetMenu {
	//菜单栏
    private JMenuBar menuBar = null;
    
    //文件菜单
    private JMenu fileMenu = null;
    //文件菜单 - 首页
    private JMenuItem indexMItem = null;
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
    
    //设置菜单
  	public JMenuBar setMenu(JPanel centerPanel, CardLayout card) {
  		menuBar = new JMenuBar();
  		
  		//文件菜单
  		fileMenu = new JMenu("文件");
  		indexMItem = new JMenuItem("首页");
  		newMItem = new JMenuItem("新增收支");
  		addTypeMItem = new JMenuItem("添加类别");
  		exitMItem = new JMenuItem("退出");
  		fileMenu.add(indexMItem);
  		fileMenu.add(newMItem);
  		fileMenu.add(addTypeMItem);
  		fileMenu.add(exitMItem);
  		indexMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//显示首页
  				card.show(centerPanel, "index");
  			}
  		});
  		newMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//显示新增开支
  				card.show(centerPanel, "newSchedule");
  			}
  		});
  		addTypeMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//显示添加类别
  				card.show(centerPanel, "newType");
  			}
  		});
  		exitMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				System.exit(0);
  			}
  		});
  		
  		//收支明细菜单
  		scheduleMenu = new JMenu("收支明细");
  		scheduleMItem = new JMenuItem("收支明细");
  		scheStatMItem = new JMenuItem("收支统计");
  		graphMItem = new JMenuItem("收支图表");
  		scheduleMenu.add(scheduleMItem);
  		scheduleMenu.add(scheStatMItem);
  		scheduleMenu.add(graphMItem);
  		scheduleMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//显示收支明细
  				card.show(centerPanel, "scheDetail");
  			}
  		});
  		scheStatMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//显示收支统计
  				card.show(centerPanel, "scheStat");
  			}
  		});
  		graphMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//显示收支图表
  				card.show(centerPanel, "scheGraph");
  			}
  		});
  		
  		//支出分析菜单
  		expensesMenu = new JMenu("支出分析");
  		edayMItem = new JMenuItem("日段分析");
  		emonthMItem = new JMenuItem("月度分析");
  		eyearMItem = new JMenuItem("年度分析");
  		expensesMenu.add(edayMItem);
  		expensesMenu.add(emonthMItem);
  		expensesMenu.add(eyearMItem);
  		edayMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//显示支出日段图表
  				card.show(centerPanel, "edayGraph");
  			}
  		});
  		emonthMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//显示支出月度图表
  				card.show(centerPanel, "emonthGraph");
  			}
  		});
  		eyearMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//显示支出年度图表
  				card.show(centerPanel, "eyearGraph");
  			}
  		});
  		
  		//收入分析菜单
  		incomeMenu = new JMenu("支出分析");
  		idayMItem = new JMenuItem("日段分析");
  		imonthMItem = new JMenuItem("月度分析");
  		iyearMItem = new JMenuItem("年度分析");
  		incomeMenu.add(idayMItem);
  		incomeMenu.add(imonthMItem);
  		incomeMenu.add(iyearMItem);
  		idayMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//显示收入日度图表
  				card.show(centerPanel, "idayGraph");
  			}
  		});
  		imonthMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//显示收入月度图表
  				card.show(centerPanel, "imonthGraph");
  			}
  		});
  		iyearMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//显示收入年度图表
  				card.show(centerPanel, "iyearGraph");
  			}
  		});
  		
  		//帮助菜单
  		helpMenu = new JMenu("帮助");
  		aboutMItem = new JMenuItem("关于");
  		helpMenu.add(aboutMItem);
  		aboutMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				JOptionPane.showMessageDialog(null, "没有帮助～");
  			}
  		});
  		
  		menuBar.add(fileMenu);
  		menuBar.add(scheduleMenu);
  		menuBar.add(expensesMenu);
  		menuBar.add(incomeMenu);
  		menuBar.add(helpMenu);
  		
  		return menuBar;
  	}
}
