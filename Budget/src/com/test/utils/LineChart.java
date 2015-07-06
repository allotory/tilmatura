package com.test.utils;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.test.db.SqliteDB;

public class LineChart {

	public static CategoryPlot plot = null;
	
	//生成显示图表的面板
	public static JPanel createDemoLine(String type) {
		JFreeChart jFreeChart = createChart(createDataset(type));
		return new ChartPanel(jFreeChart);
	}
	public static JPanel createQueryLine(String startDate, String endDate, String type) {
		JFreeChart jFreeChart = createChart(createQueryDataset(startDate, endDate, type));
		return new ChartPanel(jFreeChart);
	}

	//生成图表主对象JFreeChart
	public static JFreeChart createChart(DefaultCategoryDataset linedataset) {
		//创建主题样式
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		//设置标题字体
		standardChartTheme.setExtraLargeFont(new Font("Microsoft Yahei Font", Font.BOLD, 20));
		// 设置图例的字体
		standardChartTheme.setRegularFont(new Font("Microsoft Yahei Font", Font.PLAIN, 15));
		//设置轴向的字体
		standardChartTheme.setLargeFont(new Font("Microsoft Yahei Font", Font.PLAIN, 15));
		//应用主题样式
		ChartFactory.setChartTheme(standardChartTheme);

		//定义图表对象
		JFreeChart chart = ChartFactory.createLineChart(
				"", 						//标题
				"时间", 						//目录轴的显示标签--横轴
				"金额(元)", 					//数值轴的显示标签--纵轴  
				linedataset, 				//数据集
				PlotOrientation.VERTICAL, 	//图标方向
				true, 						//是否显示Legend
				true, 						//是否显示提示
				false 						//否存在URL
				);
		//设置背景颜色
		plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(ChartColor.WHITE);
		//网格线色设置  
		plot.setRangeGridlinePaint(ChartColor.GRAY); 
		
		return chart;
	}

	//默认数据
	public static DefaultCategoryDataset createDataset(String type) {
		//数据库操作
	    SqliteDB sdb = null;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
		
		DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
		//数据库
		sdb = new SqliteDB();
		conn = sdb.getConn();
		try {
			pstmt = conn.prepareStatement("select * from sche order by scheDate;");
			rs = sdb.execQuery(pstmt);
			while(rs.next()) {
				String sdate = rs.getString("scheDate");
				String amount = rs.getString("scheAmount");
				String stype = rs.getString("scheType");
				if(stype.equals(type)) {
					linedataset.addValue(Integer.parseInt(amount), "金额", sdate);
				}
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		sdb.closeDB();

		return linedataset;
	}
	
	//生成数据
	public static DefaultCategoryDataset createQueryDataset(String startDate, String endDate, String type) {
		//数据库操作
	    SqliteDB sdb = null;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
		
		DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
		//数据库
		sdb = new SqliteDB();
		conn = sdb.getConn();
		try {
			pstmt = conn.prepareStatement("select * from sche where scheDate>=? and scheDate<=? order by scheDate;");
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			rs = sdb.execQuery(pstmt);
			while(rs.next()) {
				String sdate = rs.getString("scheDate");
				String amount = rs.getString("scheAmount");
				String stype = rs.getString("scheType");
				if(stype.equals(type)) {
					linedataset.addValue(Integer.parseInt(amount), "金额", sdate);
				}
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		sdb.closeDB();
		//刷新
		refresh(linedataset);
		return linedataset;
	}
	
	public static void refresh(DefaultCategoryDataset dataset) {
		plot.setDataset(dataset); 
	}
}
