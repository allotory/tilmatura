package com.test.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.test.db.SqliteDB;
import com.test.func.TableData;

public class ScheStatCard {
	//��֧ͳ��Panel
    private JPanel scheStatPanel = null;
    private TitledBorder scheStatTBorder = null;
    //��֧ͳ�� - ����Panel
    private JPanel scheStatTitlePanel = null;
    //��֧ͳ�� - ��ʼ����
    private JLabel startStatDateLabel = null;
    private JTextField startStatDate = null;
    //��֧ͳ�� - ��������
    private JLabel endStatDateLabel = null;
    private JTextField endStatDate = null;
    //��֧ͳ�� - ��ѯ
    private JButton queryStatBtn = null;
    //��֧ͳ�� - ���
    private JTable scheStatTable = null;
    
    //���ݿ����
    SqliteDB sdb = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt2 = null;
    ResultSet rs = null;

    //�������
    TableData td = null;
	DefaultTableModel tableModel = null;
    
    public JPanel inexpStat() {
		//��֧ͳ��
		scheStatPanel = new JPanel(new BorderLayout());
		scheStatTBorder = new TitledBorder("��֧ͳ��");
		scheStatPanel.setBorder(scheStatTBorder);
		
		//��֧ͳ�� - ͷ��Panel
		scheStatTitlePanel = new JPanel(new FlowLayout());
		//��֧ͳ�� - ��ʼ����
		startStatDateLabel = new JLabel("��ʼ����");
		startStatDate = new JTextField(20);
		//��֧ͳ�� - ��������
		endStatDateLabel = new JLabel("��������");
		endStatDate = new JTextField(20);
		//��֧ͳ�� - ��ѯ
		queryStatBtn = new JButton("��ѯ");
		
		scheStatTitlePanel.add(startStatDateLabel);
		scheStatTitlePanel.add(startStatDate);
		scheStatTitlePanel.add(endStatDateLabel);
		scheStatTitlePanel.add(endStatDate);
		scheStatTitlePanel.add(queryStatBtn);
		
		//���ݿ�
		sdb = new SqliteDB();
		conn = sdb.getConn();
		String sql2 = "select scheCategory, scheType, sum(scheAmount) as sum_amount from sche group by scheCategory;";
		try {
			pstmt2 = conn.prepareStatement(sql2);
			rs = sdb.execQuery(pstmt2);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		td = new TableData(rs);
		tableModel = td.getStatTableData();
		sdb.closeDB();
		//��֧��ϸ���
		scheStatTable = new JTable(tableModel);
		
		scheStatPanel.add(BorderLayout.NORTH, scheStatTitlePanel);
		scheStatPanel.add(BorderLayout.CENTER, new JScrollPane(scheStatTable));
		
		return scheStatPanel;
	}
}
