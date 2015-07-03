package com.test.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

public class ScheDetailsCard {
	//��֧��ϸ Panel
    private JPanel scheDetailPanel = null;
    //��֧��ϸ title border
    private TitledBorder scheDetailTBorder = null;
    //��֧��ϸ - ����Panel
    private JPanel scheDeTitlePanel = null;
    //��֧��ϸ - ��ʼ����
    private JLabel startDateLabel = null;
    private JTextField startDate = null;
    //��֧��ϸ - ��������
    private JLabel endDateLabel = null;
    private JTextField endDate = null;
    //��֧��ϸ - ���
    private JLabel scheTypeLabel = null;
    private JComboBox<String> scheTypeCbox = null;
    //��֧��ϸ - ��ѯ
    private JButton queryBtn = null;
    //��֧��ϸ - ���
    private JTable scheTable = null;

    //���ݿ����
    private SqliteDB sdb = null;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private PreparedStatement pstmt2 = null;
    private ResultSet rs = null;
    private ResultSet rs2 = null;
    
    //�������
    TableData td = null;
	DefaultTableModel tableModel = null;
    
    public JPanel scheDetails() {
    	
    	//���ݿ�
    	sdb = new SqliteDB();
		conn = sdb.getConn();
		String sql1 = "select * from sche;";
		String sql2 = "select * from category;";
    	
		//��֧��ϸ
		scheDetailPanel = new JPanel(new BorderLayout());
		scheDetailTBorder = new TitledBorder("��֧��ϸ");
		scheDetailPanel.setBorder(scheDetailTBorder);

		//����Panel
		scheDeTitlePanel = new JPanel(new FlowLayout());
		//��ʼ����
		startDateLabel = new JLabel("��ʼ���ڣ�");
		startDate = new JTextField(20);
		//��������
		endDateLabel = new JLabel("�������ڣ�");
		endDate = new JTextField(20);
		//���
		scheTypeLabel = new JLabel("���");
		scheTypeCbox = new JComboBox<String>();
		//��ѯ����
		try {
			pstmt2 = conn.prepareStatement(sql2);
			rs2 = sdb.execQuery(pstmt2);
			scheTypeCbox.addItem("ȫ������");
			while(rs2.next()) {
				scheTypeCbox.addItem(rs2.getString("cateName"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		//��ѯ��ť
		queryBtn = new JButton("��ѯ");

		//�����ʼ����
		scheDeTitlePanel.add(startDateLabel);
		scheDeTitlePanel.add(startDate);
		//��ӽ�������
		scheDeTitlePanel.add(endDateLabel);
		scheDeTitlePanel.add(endDate);
		//������
		scheDeTitlePanel.add(scheTypeLabel);
		scheDeTitlePanel.add(scheTypeCbox);
		//��Ӳ�ѯ��ť
		scheDeTitlePanel.add(queryBtn);
		
		//����������ģ��
		try {
			pstmt = conn.prepareStatement(sql1);
			rs = sdb.execQuery(pstmt);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		td = new TableData(rs);
		tableModel = td.getScheTableData();
		
		//��֧��ϸ���
		scheTable = new JTable(tableModel);
		
		scheDetailPanel.add(BorderLayout.NORTH, scheDeTitlePanel);
		scheDetailPanel.add(BorderLayout.CENTER, new JScrollPane(scheTable));
		
		return scheDetailPanel;
	}
}
