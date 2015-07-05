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
	//������ʾͼ������
	public static JPanel createDemoPie() {
		JFreeChart jFreeChart = createChart(createDataset());
		return new ChartPanel(jFreeChart);
	}

	//����ͼ��������JFreeChart
	public static JFreeChart createChart(DefaultPieDataset dpd) {
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
		JFreeChart chart = ChartFactory.createPieChart(
				"", 						//����
				dpd, 				//���ݼ�
				true, 						//�Ƿ���ʾLegend
				true, 						//�Ƿ���ʾ��ʾ
				false 						//�����URL
				);
		//���ñ�����ɫ
//		CategoryPlot plot = chart.getCategoryPlot();
//		plot.setBackgroundPaint(ChartColor.WHITE);
//		//������ɫ����  
//		plot.setRangeGridlinePaint(ChartColor.GRAY); 
		
		return chart;
	}

	//��������
	public static DefaultPieDataset createDataset() {
		//���ݿ����
	    SqliteDB sdb = null;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    PreparedStatement pstmt2 = null;
	    ResultSet rs = null;
	    ResultSet rs2 = null;
		
	    DefaultPieDataset dpd = new DefaultPieDataset(); //����һ��Ĭ�ϵı�ͼ
		
		//���ݿ�
		sdb = new SqliteDB();
		conn = sdb.getConn();
		try {
			//select scheAmount, scheDate from sche where scheType='����' order by scheDate;
			pstmt = conn.prepareStatement("select sum(scheAmount) as sum_amount from sche where scheType='����'");
			rs = sdb.execQuery(pstmt);
			while(rs.next()) {
				String amount = rs.getString("sum_amount");
				dpd.setValue("����", Integer.parseInt(amount));
			}
			pstmt2 = conn.prepareStatement("select sum(scheAmount) as sum_amount from sche where scheType='֧��'");
			rs2 = sdb.execQuery(pstmt2);
			while(rs2.next()) {
				String amount = rs2.getString("sum_amount");
				dpd.setValue("֧��", Integer.parseInt(amount));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		sdb.closeDB();
		
		return dpd;
	}
}
