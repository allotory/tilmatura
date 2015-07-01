package com.test.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.test.utils.LineChart;

public class IndexCard {
	//首页card panel
    private JPanel indexPanel = null;
    //首页数据统计Panel
    private JPanel dataStatPanel = null;
    //首页数据统计title border
    private TitledBorder dataStatTBorder = null;
    
    //首页数据统计 - 本周收入/支出/盈余
    private JLabel iweekLabel = null;
    private JLabel eweekLabel = null;
    private JLabel weekSurplusLabel = null;
    //首页数据统计 - 本月收入/支出/盈余
    private JLabel imonthLabel = null;
    private JLabel emonthLabel = null;
    private JLabel monthSurplusLabel = null;
    //首页数据统计 - 本季度收入/支出/盈余
    private JLabel iquarterLabel = null;
    private JLabel equarterLabel = null;
    private JLabel quarterSurplusLabel = null;
    //首页数据统计 - 本年收入/支出/盈余
    private JLabel iyearLabel = null;
    private JLabel eyearLabel = null;
    private JLabel yearSurplusLabel = null;
    //首页数据统计 - 全部收入/支出/盈余
    private JLabel iallLabel = null;
    private JLabel eallLabel = null;
    private JLabel allSurplusLabel = null;
    
    //首页数据图表Panel
    private JPanel dataGraphPanel = null;
    //首页数据图表title border
    private TitledBorder dataGraphTBorder = null;
    
    public JPanel setIndex() {
		//首页卡片Panel
		indexPanel = new JPanel(new BorderLayout());
		indexPanel.setBackground(Color.PINK);
		
		//数据统计
		dataStatPanel = new JPanel(new GridLayout(5, 3));
		dataStatTBorder = new TitledBorder("数据统计");
		dataStatPanel.setBorder(dataStatTBorder);
		
		//数据统计详细信息
		//本周
		iweekLabel = new JLabel("本周收入：0");
		eweekLabel = new JLabel("本周支出：0");
		weekSurplusLabel = new JLabel("本周盈余：0");
		//本月
		imonthLabel = new JLabel("本月收入：0");
		emonthLabel = new JLabel("本月支出：0");
		monthSurplusLabel = new JLabel("本月盈余：0");
		//本季度
		iquarterLabel = new JLabel("本季度收入：0");
		equarterLabel = new JLabel("本季度支出：0");
		quarterSurplusLabel = new JLabel("本季度盈余：0");
		//本年
		iyearLabel = new JLabel("本年收入：0");
		eyearLabel = new JLabel("本年支出：0");
		yearSurplusLabel = new JLabel("本年盈余：0");
		//全部
		iallLabel = new JLabel("总收入：0");
		eallLabel = new JLabel("总支出：0");
		allSurplusLabel = new JLabel("总盈余：0");
		
		//添加周
		dataStatPanel.add(iweekLabel);
		dataStatPanel.add(eweekLabel);
		dataStatPanel.add(weekSurplusLabel);
		//添加月
		dataStatPanel.add(imonthLabel);
		dataStatPanel.add(emonthLabel);
		dataStatPanel.add(monthSurplusLabel);
		//添加季度
		dataStatPanel.add(iquarterLabel);
		dataStatPanel.add(equarterLabel);
		dataStatPanel.add(quarterSurplusLabel);
		//添加年度
		dataStatPanel.add(iyearLabel);
		dataStatPanel.add(eyearLabel);
		dataStatPanel.add(yearSurplusLabel);
		//添加全部
		dataStatPanel.add(iallLabel);
		dataStatPanel.add(eallLabel);
		dataStatPanel.add(allSurplusLabel);
		
		//设置数据图表
		dataGraphPanel = LineChart.createDemoLine();
		dataGraphTBorder = new TitledBorder("数据图表");
		dataGraphPanel.setBorder(dataGraphTBorder);
		
		indexPanel.add(BorderLayout.NORTH, dataStatPanel);
		indexPanel.add(BorderLayout.CENTER, dataGraphPanel);
		
		return indexPanel;
	}
}
