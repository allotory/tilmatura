package com.test.utils;

import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart {
	//生成显示图表的面板
	public static JPanel createDemoLine() {
		JFreeChart jFreeChart = createChart(createDataset());
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
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(ChartColor.WHITE);
		//网格线色设置  
		plot.setRangeGridlinePaint(ChartColor.GRAY); 
		
		return chart;
	}

	//生成数据
	public static DefaultCategoryDataset createDataset() {
		
		DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
		// 各曲线名称
		String series1 = "收入";
		String series2 = "支出";
		// 横轴名称(列名称)
		String type1 = "1月";
		String type2 = "2月";
		String type3 = "3月";
		
		linedataset.addValue(0.0, series1, type1);
		linedataset.addValue(4.2, series1, type2);
		linedataset.addValue(3.9, series1, type3);
		linedataset.addValue(1.0, series2, type1);
		linedataset.addValue(5.2, series2, type2);
		linedataset.addValue(7.9, series2, type3);
		return linedataset;
	}
}
