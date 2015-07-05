package com.test.func;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

//获取表格数据
public class TableData {

	ResultSet rs = null;
	DefaultTableModel tableModel = null;
	
	public TableData(ResultSet rs) {
		this.rs = rs;
	}
	
	//类型数据
	public DefaultTableModel getTableData() {
		
		Vector<Vector<Object>> tableData = new Vector<Vector<Object>>();
		
		try {
			while(rs.next()) {
				Vector<Object> v = new Vector<Object>();
				v.add(rs.getInt("id"));
				v.add(rs.getString("cateName"));
				v.add(rs.getString("scheType"));
				v.add("删除");
				
				tableData.add(v);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	    //定义一维数据作为列标题  
		Vector<String> columnTitle = new Vector<String>();
		columnTitle.add("编号");
		columnTitle.add("类别名称");
		columnTitle.add("类型");
		columnTitle.add("管理");
		
		tableModel = new DefaultTableModel(tableData, columnTitle);
		
		return tableModel;
	}

	//收支详细信息
	public DefaultTableModel getScheTableData() {
		
		Vector<Vector<Object>> tableData = new Vector<Vector<Object>>();
		
		try {
			while(rs.next()) {
				Vector<Object> v = new Vector<Object>();
				v.add(rs.getInt("id"));
				v.add(rs.getString("scheType"));
				v.add(rs.getString("scheCategory"));
				v.add(rs.getString("scheDate"));
				v.add(rs.getString("scheAmount"));
				v.add(rs.getString("scheDescription"));
				
				tableData.add(v);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	    //定义一维数据作为列标题  
		Vector<String> columnTitle = new Vector<String>();
		columnTitle.add("编号");
		columnTitle.add("类型");
		columnTitle.add("类别名称");
		columnTitle.add("日期");
		columnTitle.add("金额");
		columnTitle.add("描述");
		
		tableModel = new DefaultTableModel(tableData, columnTitle);
		
		return tableModel;
	}

	//收支统计
	public DefaultTableModel getStatTableData() {
		
		Vector<Vector<Object>> tableData = new Vector<Vector<Object>>();
		
		try {
			while(rs.next()) {
				Vector<Object> v = new Vector<Object>();
				v.add(rs.getString("scheCategory"));
				v.add(rs.getString("scheType"));
				v.add(rs.getString("sum_amount"));
				
				tableData.add(v);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	    //定义一维数据作为列标题  
		Vector<String> columnTitle = new Vector<String>();
		columnTitle.add("类别名称");
		columnTitle.add("类型");
		columnTitle.add("金额");
		
		tableModel = new DefaultTableModel(tableData, columnTitle);
		
		return tableModel;
	}
}
