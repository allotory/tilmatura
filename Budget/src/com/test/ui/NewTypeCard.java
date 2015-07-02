package com.test.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.test.db.SqliteDB;
import com.test.func.TableData;

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
	
    //���ݿ����
    SqliteDB sdb = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt2 = null;
    ResultSet rs = null;
    
    //�������
    TableData td = null;
	DefaultTableModel tableModel = null;
    
	public JPanel setNewType() {
		//���ݿ�
		sdb = new SqliteDB();
		conn = sdb.getConn();
		String sql1 = "insert into category(cateName, scheType) values (?, ?);";
		String sql2 = "select * from category;";
		try {
			pstmt = conn.prepareStatement(sql1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
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
		addBtn.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				new Thread( ()->{
  					try {
  						pstmt.setString(1, typeNameField.getText());
  						pstmt.setString(2, typeCbox.getSelectedItem().toString());
  						int r = sdb.execOther(pstmt);
  						if(r != -1) {
  							System.out.println("������ɹ���");
  						}else{
  							System.out.println("������ʧ�ܣ�");
  						}
  					} catch (SQLException e1) {
  						e1.printStackTrace();
  					}
  					
  					try {
  						pstmt2 = conn.prepareStatement(sql2);
  						rs = sdb.execQuery(pstmt2);
  					} catch (SQLException e1) {
  						e1.printStackTrace();
  					}

  					td = new TableData(rs);
  					tableModel = td.getTableData();
  					
  					manageTypeTable.setModel(tableModel);
  					manageTypeTable.validate();
  					manageTypeTable.updateUI();
  				}).start();
  			}
  		});
		
		//������� panel
		manageTypePanel = new JPanel(new BorderLayout());
		mgeTypeTBorder = new TitledBorder("�������");
		manageTypePanel.setBorder(mgeTypeTBorder);
		
		//����������ģ��
		try {
			pstmt2 = conn.prepareStatement(sql2);
			rs = sdb.execQuery(pstmt2);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		td = new TableData(rs);
		tableModel = td.getTableData();
		
		//���������
	    manageTypeTable = new JTable(tableModel);
		
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
