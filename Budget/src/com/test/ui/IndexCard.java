package com.test.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.test.func.DetailData;
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
		
//		select date('now', 'start of day');
//		
//		sqlite> select date('now', 'start of day', '-7 day', 'weekday 1');
//		sqlite> select date('now', 'start of day', '+0 day', 'weekday 1');
//		
//		sqlite> select * from sche where scheDate >= date('now', 'start of month') and s
//				cheDate <= date('now', 'start of month', '+1 month', '-1 day');
//		
//		sqlite> select date('now', 'start of year');
//		sqlite> select date('now', 'start of year', '+1 year', '-1 day');
		//数据统计详细信息
		//本周
		iweekLabel = new JLabel("本周收入：0");
		eweekLabel = new JLabel("本周支出：0");
		weekSurplusLabel = new JLabel("本周盈余：0");
		DetailData dd = new DetailData();
		//本周收入
		String wa = dd.getDetailData("select sum(scheAmount) AS sum_amount from sche where scheDate >= date('now', 'start of day', '-7 day', 'weekday 1') and scheDate <= date('now', 'start of day', '+0 day', 'weekday 1') and scheType='收入';");
		int week_in = 0;
		if(!(wa.equals("") || wa == null)) {
			week_in = Integer.parseInt(wa);
		}
		//本周支出
		String wb = dd.getDetailData("select sum(scheAmount) AS sum_amount from sche where scheDate >= date('now', 'start of day', '-7 day', 'weekday 1') and scheDate <= date('now', 'start of day', '+0 day', 'weekday 1') and scheType='支出';");
		int week_exp = 0;
		if(!(wb.equals("") || wb == null)) {
			week_exp = Integer.parseInt(wb);
		}
		iweekLabel.setText("本周收入：" + week_in);
		eweekLabel.setText("本周支出：" + week_exp);
		weekSurplusLabel.setText("本周盈余：" + (week_in - week_exp));
		
		//本月
		imonthLabel = new JLabel("本月收入：0");
		emonthLabel = new JLabel("本月支出：0");
		monthSurplusLabel = new JLabel("本月盈余：0");
		//收入
		String ma = dd.getDetailData("select sum(scheAmount) AS sum_amount from sche where scheDate >= date('now', 'start of month') and scheDate <= date('now', 'start of month', '+1 month', '-1 day') and scheType='收入';");
		int month_in = 0;
		if(!(ma.equals("") || ma == null)) {
			month_in = Integer.parseInt(ma);
		}
		//支出
		String mb = dd.getDetailData("select sum(scheAmount) AS sum_amount from sche where scheDate >= date('now', 'start of month') and scheDate <= date('now', 'start of month', '+1 month', '-1 day') and scheType='支出';");
		int month_exp = 0;
		if(!(mb.equals("") || mb == null)) {
			month_exp = Integer.parseInt(mb);
		}
		imonthLabel.setText("本月收入：" + month_in);
		emonthLabel.setText("本月支出：" + month_exp);
		monthSurplusLabel.setText("本月盈余：" + (month_in - month_exp));
		
		//本年
		iyearLabel = new JLabel("本年收入：0");
		eyearLabel = new JLabel("本年支出：0");
		yearSurplusLabel = new JLabel("本年盈余：0");
		//收入
		String ya = dd.getDetailData("select sum(scheAmount) AS sum_amount from sche where scheDate >= date('now', 'start of year') and scheDate <= date('now', 'start of year', '+1 year', '-1 day') and scheType='收入';");
		int year_in = 0;
		if(!(ya.equals("") || ya == null)) {
			year_in = Integer.parseInt(ya);
		}
		//支出
		String yb = dd.getDetailData("select sum(scheAmount) AS sum_amount from sche where scheDate >= date('now', 'start of year') and scheDate <= date('now', 'start of year', '+1 year', '-1 day') and scheType='支出';");
		int year_exp = 0;
		if(!(yb.equals("") || yb == null)) {
			year_exp = Integer.parseInt(yb);
		}
		iyearLabel.setText("本年收入：" + year_in);
		eyearLabel.setText("本年支出：" + year_exp);
		yearSurplusLabel.setText("本年盈余：" + (year_in - year_exp));
		
		//全部
		iallLabel = new JLabel("总收入：0");
		eallLabel = new JLabel("总支出：0");
		allSurplusLabel = new JLabel("总盈余：0");
		//收入
		String aa = dd.getDetailData("select sum(scheAmount) AS sum_amount from sche where scheType='收入';");
		int all_in = 0;
		if(!(aa.equals("") || aa == null)) {
			all_in = Integer.parseInt(aa);
		}
		//支出
		String ab = dd.getDetailData("select sum(scheAmount) AS sum_amount from sche where scheType='支出';");
		int all_exp = 0;
		if(!(ab.equals("") || ab == null)) {
			all_exp = Integer.parseInt(ab);
		}
		iallLabel.setText("总收入：" + all_in);
		eallLabel.setText("总支出：" + all_exp);
		allSurplusLabel.setText("总盈余：" + (all_in - all_exp));
		
		//添加周
		dataStatPanel.add(iweekLabel);
		dataStatPanel.add(eweekLabel);
		dataStatPanel.add(weekSurplusLabel);
		//添加月
		dataStatPanel.add(imonthLabel);
		dataStatPanel.add(emonthLabel);
		dataStatPanel.add(monthSurplusLabel);
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
