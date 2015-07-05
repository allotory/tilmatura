package com.test.func;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

//��ȡ�������
public class TableData {

	ResultSet rs = null;
	DefaultTableModel tableModel = null;
	
	public TableData(ResultSet rs) {
		this.rs = rs;
	}
	
	//��������
	public DefaultTableModel getTableData() {
		
		Vector<Vector<Object>> tableData = new Vector<Vector<Object>>();
		
		try {
			while(rs.next()) {
				Vector<Object> v = new Vector<Object>();
				v.add(rs.getInt("id"));
				v.add(rs.getString("cateName"));
				v.add(rs.getString("scheType"));
				v.add("ɾ��");
				
				tableData.add(v);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	    //����һά������Ϊ�б���  
		Vector<String> columnTitle = new Vector<String>();
		columnTitle.add("���");
		columnTitle.add("�������");
		columnTitle.add("����");
		columnTitle.add("����");
		
		tableModel = new DefaultTableModel(tableData, columnTitle);
		
		return tableModel;
	}

	//��֧��ϸ��Ϣ
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
		
	    //����һά������Ϊ�б���  
		Vector<String> columnTitle = new Vector<String>();
		columnTitle.add("���");
		columnTitle.add("����");
		columnTitle.add("�������");
		columnTitle.add("����");
		columnTitle.add("���");
		columnTitle.add("����");
		
		tableModel = new DefaultTableModel(tableData, columnTitle);
		
		return tableModel;
	}

	//��֧ͳ��
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
		
	    //����һά������Ϊ�б���  
		Vector<String> columnTitle = new Vector<String>();
		columnTitle.add("�������");
		columnTitle.add("����");
		columnTitle.add("���");
		
		tableModel = new DefaultTableModel(tableData, columnTitle);
		
		return tableModel;
	}
}
