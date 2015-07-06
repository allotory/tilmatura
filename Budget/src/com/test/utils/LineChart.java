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
	
	//������ʾͼ������
	public static JPanel createDemoLine(String type) {
		JFreeChart jFreeChart = createChart(createDataset(type));
		return new ChartPanel(jFreeChart);
	}
	public static JPanel createQueryLine(String startDate, String endDate, String type) {
		JFreeChart jFreeChart = createChart(createQueryDataset(startDate, endDate, type));
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
		plot = chart.getCategoryPlot();
		plot.setBackgroundPaint(ChartColor.WHITE);
		//������ɫ����  
		plot.setRangeGridlinePaint(ChartColor.GRAY); 
		
		return chart;
	}

	//Ĭ������
	public static DefaultCategoryDataset createDataset(String type) {
		//���ݿ����
	    SqliteDB sdb = null;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
		
		DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
		//���ݿ�
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
					linedataset.addValue(Integer.parseInt(amount), "���", sdate);
				}
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		sdb.closeDB();

		return linedataset;
	}
	
	//��������
	public static DefaultCategoryDataset createQueryDataset(String startDate, String endDate, String type) {
		//���ݿ����
	    SqliteDB sdb = null;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
		
		DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
		//���ݿ�
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
					linedataset.addValue(Integer.parseInt(amount), "���", sdate);
				}
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		sdb.closeDB();
		//ˢ��
		refresh(linedataset);
		return linedataset;
	}
	
	public static void refresh(DefaultCategoryDataset dataset) {
		plot.setDataset(dataset); 
	}
}
