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
	
	//生成显示图表的面板
	public static JPanel createDemoBar() {
		JFreeChart jFreeChart = createChart(createDataset());
		return new ChartPanel(jFreeChart);
	}
	//生成新查询图表的面板
	public static JPanel createQueryBar(String startDate, String endDate) {
		JFreeChart jFreeChart = createChart(createQueryDataset(startDate, endDate));
		return new ChartPanel(jFreeChart);
	}

	//生成图表主对象JFreeChart
	public static JFreeChart createChart(DefaultCategoryDataset bardataset) {
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
		JFreeChart chart = ChartFactory.createBarChart(
				"", 						//标题
				"分类", 						//目录轴的显示标签--横轴
				"金额(元)", 					//数值轴的显示标签--纵轴  
				bardataset, 				//数据集
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
		//宽度
		// 使用自定义的渲染器 
        CustomRenderer renderer = new CustomRenderer(); 
		// 设置柱子宽度 
		renderer.setMaximumBarWidth(0.05); 
		// 设置柱子高度 
		renderer.setMinimumBarLength(0.2); 
		// 设置柱子边框颜色 
		renderer.setBaseOutlinePaint(Color.BLACK); 
		// 设置柱子边框可见 
		renderer.setDrawBarOutline(true); 
		// 设置每个地区所包含的平行柱的之间距离 
		renderer.setItemMargin(0.5); 
		chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF); 
		// 显示每个柱的数值，并修改该数值的字体属性 
		renderer.setIncludeBaseInRange(true); 
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); 
		renderer.setBaseItemLabelsVisible(true); 
		plot.setRenderer(renderer); 
		// 设置柱的透明度 
		plot.setForegroundAlpha(1.0f); 
		// 背景色 透明度 
		plot.setBackgroundAlpha(0.5f); 
		
		return chart;
	}

	//生成默认数据
	public static DefaultCategoryDataset createDataset() {
		//数据库操作
	    SqliteDB sdb = null;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
		
		DefaultCategoryDataset bardataset = new DefaultCategoryDataset();
		//纵坐标名称
		String series = "金额";
		//数据库
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

	//生成查询数据
	public static DefaultCategoryDataset createQueryDataset(String startDate, String endDate) {
		//数据库操作
	    SqliteDB sdb = null;
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
		
		DefaultCategoryDataset bardataset = new DefaultCategoryDataset();
		//纵坐标名称
		String series = "金额";
		//数据库
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
		
		//刷新
		refresh(bardataset);
		
		return bardataset;
	}
	
	public static void refresh(DefaultCategoryDataset dataset) {
		plot.setDataset(dataset); 
	}
}

//自定义柱状图渲染器
class CustomRenderer extends org.jfree.chart.renderer.category.BarRenderer { 
	   
	private static final long serialVersionUID = 1L;
	
	private Paint[] colors; 
    //初始化柱子颜色 
    private String[] colorValues = { "#AFD8F8", "#F6BD0F", "#8BBA00", "#FF8E46", "#008E8E", "#D64646" }; 
   
    public CustomRenderer() { 
        colors = new Paint[colorValues.length]; 
        for (int i = 0; i < colorValues.length; i++) { 
            colors[i] = Color.decode(colorValues[i]); 
        } 
    } 
   
    //每根柱子以初始化的颜色不断轮循 
    public Paint getItemPaint(int i, int j) { 
        return colors[j % colors.length]; 
    } 
}