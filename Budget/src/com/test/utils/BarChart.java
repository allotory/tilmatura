package com.test.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.RenderingHints;
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
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.test.db.SqliteDB;

public class BarChart {
	
	public static CategoryPlot plot = null;
	
	//������ʾͼ������
	public static JPanel createDemoBar() {
		JFreeChart jFreeChart = createChart(createDataset());
		return new ChartPanel(jFreeChart);
	}
	//�����²�ѯͼ������
	public static JPanel createQueryBar(String startDate, String endDate) {
		JFreeChart jFreeChart = createChart(createQueryDataset(startDate, endDate));
		return new ChartPanel(jFreeChart);
	}

	//����ͼ��������JFreeChart
	public static JFreeChart createChart(DefaultCategoryDataset bardataset) {
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
		JFreeChart chart = ChartFactory.createBarChart(
				"", 						//����
				"����", 						//Ŀ¼�����ʾ��ǩ--����
				"���(Ԫ)", 					//��ֵ�����ʾ��ǩ--����  
				bardataset, 				//���ݼ�
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
		//���
		// ʹ���Զ������Ⱦ�� 
        CustomRenderer renderer = new CustomRenderer(); 
		// �������ӿ�� 
		renderer.setMaximumBarWidth(0.05); 
		// �������Ӹ߶� 
		renderer.setMinimumBarLength(0.2); 
		// �������ӱ߿���ɫ 
		renderer.setBaseOutlinePaint(Color.BLACK); 
		// �������ӱ߿�ɼ� 
		renderer.setDrawBarOutline(true); 
		// ����ÿ��������������ƽ������֮����� 
		renderer.setItemMargin(0.5); 
		chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF); 
		// ��ʾÿ��������ֵ�����޸ĸ���ֵ���������� 
		renderer.setIncludeBaseInRange(true); 
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); 
		renderer.setBaseItemLabelsVisible(true); 
		plot.setRenderer(renderer); 
		// ��������͸���� 
		plot.setForegroundAlpha(1.0f); 
		// ����ɫ ͸���� 
		plot.setBackgroundAlpha(0.5f); 
		
		return chart;
	}

	//����Ĭ������
	public static DefaultCategoryDataset createDataset() {
		//���ݿ����
	    SqliteDB sdb = null;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
		
		DefaultCategoryDataset bardataset = new DefaultCategoryDataset();
		//����������
		String series = "���";
		//���ݿ�
		sdb = new SqliteDB();
		conn = sdb.getConn();
		try {
			pstmt = conn.prepareStatement("select scheCategory, sum(scheAmount) as sum_amount from sche group by scheCategory;");
			rs = sdb.execQuery(pstmt);
			while(rs.next()) {
				String cate = rs.getString("scheCategory");
				String amount = rs.getString("sum_amount");
				bardataset.setValue(Integer.parseInt(amount), series, cate);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		sdb.closeDB();
		
		return bardataset;
	}

	//���ɲ�ѯ����
	public static DefaultCategoryDataset createQueryDataset(String startDate, String endDate) {
		//���ݿ����
	    SqliteDB sdb = null;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
		
		DefaultCategoryDataset bardataset = new DefaultCategoryDataset();
		//����������
		String series = "���";
		//���ݿ�
		sdb = new SqliteDB();
		conn = sdb.getConn();
		try {
			pstmt = conn.prepareStatement("select scheCategory, sum(scheAmount) as sum_amount from sche where scheDate>=? and scheDate<=? group by scheCategory;");
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			rs = sdb.execQuery(pstmt);
			while(rs.next()) {
				String cate = rs.getString("scheCategory");
				String amount = rs.getString("sum_amount");
				bardataset.setValue(Integer.parseInt(amount), series, cate);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		sdb.closeDB();
		
		//ˢ��
		refresh(bardataset);
		
		return bardataset;
	}
	
	public static void refresh(DefaultCategoryDataset dataset) {
		plot.setDataset(dataset); 
	}
}

//�Զ�����״ͼ��Ⱦ��
class CustomRenderer extends org.jfree.chart.renderer.category.BarRenderer { 
	   
	private static final long serialVersionUID = 1L;
	
	private Paint[] colors; 
    //��ʼ��������ɫ 
    private String[] colorValues = { "#AFD8F8", "#F6BD0F", "#8BBA00", "#FF8E46", "#008E8E", "#D64646" }; 
   
    public CustomRenderer() { 
        colors = new Paint[colorValues.length]; 
        for (int i = 0; i < colorValues.length; i++) { 
            colors[i] = Color.decode(colorValues[i]); 
        } 
    } 
   
    //ÿ�������Գ�ʼ������ɫ������ѭ 
    public Paint getItemPaint(int i, int j) { 
        return colors[j % colors.length]; 
    } 
}