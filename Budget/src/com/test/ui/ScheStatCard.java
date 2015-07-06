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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.test.db.SqliteDB;
import com.test.func.TableData;
import com.test.utils.JudgeDate;

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
    ResultSet rs2 = null;
    String sql1 = "select scheCategory, scheType, sum(scheAmount) as sum_amount from sche where scheDate>=? and scheDate<=? group by scheCategory;";
    String sql2 = "select scheCategory, scheType, sum(scheAmount) as sum_amount from sche group by scheCategory;";

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
		queryStatBtn.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				new Thread( ()->{
  					if(JudgeDate.judge("yyyy-MM-dd", startStatDate.getText()) && JudgeDate.judge("yyyy-MM-dd", endStatDate.getText())) {
  						//���ݿ�
  	  					sdb = new SqliteDB();
  	  					conn = sdb.getConn();
  	  					try {
  	  						pstmt = conn.prepareStatement(sql1);
  	  						pstmt.setString(1, startStatDate.getText());
  	  						pstmt.setString(2, endStatDate.getText());
  	  						rs = sdb.execQuery(pstmt);
  	  					} catch (SQLException e1) {
  	  						e1.printStackTrace();
  	  					}

  	  					td = new TableData(rs);
  	  					tableModel = td.getStatTableData();
  	  					
  	  					//ˢ�±�
	  	  				SwingUtilities.invokeLater(()->{
	  	  					scheStatTable.setModel(tableModel);
	  	  					scheStatTable.validate();
	  	  					scheStatTable.updateUI();
	  					});
  	  					
  	  					//�ر����ݿ�����
  	  					sdb.closeDB();
  					}else {
  						JOptionPane.showMessageDialog(null, "�Բ����������ڸ�ʽ������󣡣�������yyyy-MM-dd��");
  					}
  				}).start();
  			}
  		});
		
		scheStatTitlePanel.add(startStatDateLabel);
		scheStatTitlePanel.add(startStatDate);
		scheStatTitlePanel.add(endStatDateLabel);
		scheStatTitlePanel.add(endStatDate);
		scheStatTitlePanel.add(queryStatBtn);
		
		//���ݿ�
		sdb = new SqliteDB();
		conn = sdb.getConn();
		
		try {
			pstmt2 = conn.prepareStatement(sql2);
			rs2 = sdb.execQuery(pstmt2);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		td = new TableData(rs2);
		tableModel = td.getStatTableData();
		sdb.closeDB();
		//��֧��ϸ���
		scheStatTable = new JTable(tableModel);
		
		scheStatPanel.add(BorderLayout.NORTH, scheStatTitlePanel);
		scheStatPanel.add(BorderLayout.CENTER, new JScrollPane(scheStatTable));
		
		return scheStatPanel;
	}
}
