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
	//������Panel
	private JPanel newTypePanel = null;
	//������ title panel
	private JPanel newTypeTPanel = null;
	private TitledBorder newTypeTBorder = null;
	//������ - ����
	private JLabel typeName = null;
	private JTextField typeNameField = null;
	//������ - ��������
    private JComboBox<String> typeCbox = null;
    //��Ӱ�ť
    private JButton addBtn = null;
    
    //������� panel
    private JPanel manageTypePanel = null;
    private TitledBorder mgeTypeTBorder = null;
    //������� table
    private JTable manageTypeTable = null;
	
	public JPanel setNewType() {
		//������Panel
		newTypePanel = new JPanel(new BorderLayout());
		
		//������ ͷ��panel
		newTypeTPanel = new JPanel(new FlowLayout());
		newTypeTBorder = new TitledBorder("������");
		newTypeTPanel.setBorder(newTypeTBorder);
		//�������
		typeName = new JLabel("������ƣ�");
		typeNameField = new JTextField(20);
		//����
		typeCbox = new JComboBox<String>();
		typeCbox.addItem("����");
		typeCbox.addItem("֧��");
		//��ť
		addBtn = new JButton("���");
		
		//������� panel
		manageTypePanel = new JPanel(new BorderLayout());
		mgeTypeTBorder = new TitledBorder("�������");
		manageTypePanel.setBorder(mgeTypeTBorder);
		
		//�����ά������Ϊ�������  
	    Object[][] tableData = {  
	        new Object[]{"������" , 29 ,29 },  
	        new Object[]{"�ո�����", 29 , 56},  
	        new Object[]{"���", 29 , 35 },  
	        new Object[]{"Ū��", 29 , 18},  
	        new Object[]{"��ͷ", 29 , 2 }  
	    };  
	    //����һά������Ϊ�б���  
	    Object[] columnTitle = {"�������" , "����" , "����"};  
		//���������
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
