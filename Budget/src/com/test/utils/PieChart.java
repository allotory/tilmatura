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
import org.jfree.data.general.DefaultPieDataset;

import com.test.db.SqliteDB;

public class PieChart {
	//生成显示图表的面板
	public static JPanel createDemoPie() {
		JFreeChart jFreeChart = createChart(createDataset());
		return new ChartPanel(jFreeChart);
	}

	//生成图表主对象JFreeChart
	public static JFreeChart createChart(DefaultPieDataset dpd) {
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
		JFreeChart chart = ChartFactory.createPieChart(
				"", 						//标题
				dpd, 				//数据集
				true, 						//是否显示Legend
				true, 						//是否显示提示
				false 						//否存在URL
				);
		//设置背景颜色
//		CategoryPlot plot = chart.getCategoryPlot();
//		plot.setBackgroundPaint(ChartColor.WHITE);
//		//网格线色设置  
//		plot.setRangeGridlinePaint(ChartColor.GRAY); 
		
		return chart;
	}

	//生成数据
	public static DefaultPieDataset createDataset() {
		//数据库操作
	    SqliteDB sdb = null;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    PreparedStatement pstmt2 = null;
	    ResultSet rs = null;
	    ResultSet rs2 = null;
		
	    DefaultPieDataset dpd = new DefaultPieDataset(); //建立一个默认的饼图
		
		//数据库
		sdb = new SqliteDB();
		conn = sdb.getConn();
		try {
			//select scheAmount, scheDate from sche where scheType='收入' order by scheDate;
			pstmt = conn.prepareStatement("select sum(scheAmount) as sum_amount from sche where scheType='收入'");
			rs = sdb.execQuery(pstmt);
			while(rs.next()) {
				String amount = rs.getString("sum_amount");
				dpd.setValue("收入", Integer.parseInt(amount));
			}
			pstmt2 = conn.prepareStatement("select sum(scheAmount) as sum_amount from sche where scheType='支出'");
			rs2 = sdb.execQuery(pstmt2);
			while(rs2.next()) {
				String amount = rs2.getString("sum_amount");
				dpd.setValue("支出", Integer.parseInt(amount));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		sdb.closeDB();
		
		return dpd;
	}
}
