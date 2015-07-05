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
	//������ʾͼ������
	public static JPanel createDemoLine() {
		JFreeChart jFreeChart = createChart(createDataset());
		return new ChartPanel(jFreeChart);
	}

	//����ͼ��������JFreeChart
	public static JFreeChart createChart(DefaultCategoryDataset linedataset) {
		//����������ʽ
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		//���ñ�������
		standardChartTheme.setExtraLargeFont(new Font("Microsoft Yahei Font", Font.BOLD, 20));
		// ����ͼ��������
		standardChartTheme.setRegularFont(new Font("Microsoft Yahei Font", Font.PLAIN, 15));
		//�������������
		standardChartTheme.setLargeFont(new Font("Microsoft Yahei Font", Font.PLAIN, 15));
		//Ӧ��������ʽ
		ChartFactory.setChartTheme(standardChartTheme);

		//����ͼ�����
		JFreeChart chart = ChartFactory.createLineChart(
				"", 						//����
				"ʱ��", 						//Ŀ¼�����ʾ��ǩ--����
				"���(Ԫ)", 					//��ֵ�����ʾ��ǩ--����  
				linedataset, 				//���ݼ�
				PlotOrientation.VERTICAL, 	//ͼ�귽��
				true, 						//�Ƿ���ʾLegend
				true, 						//�Ƿ���ʾ��ʾ
				false 						//�����URL
				);
		//���ñ�����ɫ
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(ChartColor.WHITE);
		//������ɫ����  
		plot.setRangeGridlinePaint(ChartColor.GRAY); 
		
		return chart;
	}

	//��������
	public static DefaultCategoryDataset createDataset() {
		
		DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
		// ����������
		String series1 = "����";
		String series2 = "֧��";
		// ��������(������)
		String type1 = "1��";
		String type2 = "2��";
		String type3 = "3��";
		
		linedataset.addValue(0.0, series1, type1);
		linedataset.addValue(4.2, series1, type2);
		linedataset.addValue(3.9, series1, type3);
		linedataset.addValue(1.0, series2, type1);
		linedataset.addValue(5.2, series2, type2);
		linedataset.addValue(7.9, series2, type3);
		return linedataset;
	}
}
