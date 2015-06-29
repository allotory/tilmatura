package com.test.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class NewTypeCard {
	//添加类别Panel
	private JPanel newTypePanel = null;
	//添加类别 title panel
	private JPanel newTypeTPanel = null;
	private TitledBorder newTypeTBorder = null;
	//添加类别 - 名称
	private JLabel typeName = null;
	private JTextField typeNameField = null;
	//添加类别 - 所属类型
    private JComboBox<String> typeCbox = null;
    //添加按钮
    private JButton addBtn = null;
    
    //管理类别 panel
    private JPanel manageTypePanel = null;
    private TitledBorder mgeTypeTBorder = null;
    //管理类别 table
    private JTable manageTypeTable = null;
	
	public JPanel setNewType() {
		//添加类别Panel
		newTypePanel = new JPanel(new BorderLayout());
		
		//添加类别 头部panel
		newTypeTPanel = new JPanel(new FlowLayout());
		newTypeTBorder = new TitledBorder("添加类别");
		newTypeTPanel.setBorder(newTypeTBorder);
		//类别名称
		typeName = new JLabel("类别名称：");
		typeNameField = new JTextField(20);
		//类型
		typeCbox = new JComboBox<String>();
		typeCbox.addItem("收入");
		typeCbox.addItem("支出");
		//按钮
		addBtn = new JButton("添加");
		
		//管理类别 panel
		manageTypePanel = new JPanel(new BorderLayout());
		mgeTypeTBorder = new TitledBorder("管理类别");
		manageTypePanel.setBorder(mgeTypeTBorder);
		
		//定义二维数组作为表格数据  
	    Object[][] tableData = {  
	        new Object[]{"李清照" , 29 ,29 },  
	        new Object[]{"苏格拉底", 29 , 56},  
	        new Object[]{"李白", 29 , 35 },  
	        new Object[]{"弄玉", 29 , 18},  
	        new Object[]{"虎头", 29 , 2 }  
	    };  
	    //定义一维数据作为列标题  
	    Object[] columnTitle = {"类别名称" , "类型" , "管理"};  
		//管理类别表格
	    manageTypeTable = new JTable(tableData, columnTitle);
		
		newTypeTPanel.add(typeName);
		newTypeTPanel.add(typeNameField);
		newTypeTPanel.add(typeCbox);
		newTypeTPanel.add(addBtn);

	    manageTypePanel.add(BorderLayout.CENTER, new JScrollPane(manageTypeTable));
		
		newTypePanel.add(BorderLayout.NORTH, newTypeTPanel);
		newTypePanel.add(BorderLayout.CENTER, manageTypePanel);
		
		return newTypePanel;
	}
}
