package com.test.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.test.db.SqliteDB;

public class NewScheCard {
	//������֧ Panel
    private JPanel newSchePanel = null;
    //������֧ - title border
    private TitledBorder newScheTBorder = null;
    //������֧ - ����
    private JLabel scheType = null;
    private JRadioButton incomeRbtn = null;
    private JRadioButton expRbtn = null;
    private ButtonGroup btnGroup = null;
    //������֧ - ���
    private JLabel scheCategory = null;
    private JComboBox<String> categoryCbox = null;
    //������֧ - ����
    private JLabel scheDateLabel = null;
    private JTextField scheDate = null;
    //������֧ - ���
    private JLabel scheNumLabel = null;
    private JTextField scheNum = null;
    //������֧ - ��ע
    private JLabel scheNoteLabel = null;
    private JTextField scheNote = null;
    //������֧ - �ύ
    private JButton addScheBtn = null;
    
    //���ݿ����
    private SqliteDB sdb = null;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private PreparedStatement pstmt2 = null;
    private ResultSet rs = null;
    
    public JPanel setNewSche() {
    	
    	//���ݿ�
    	sdb = new SqliteDB();
		conn = sdb.getConn();
		String sql1 = "insert into sche(scheType, scheCategory, scheDate, "
				+ "scheAmount, scheDescription) values (?, ?, ?, ?, ?);";
		String sql2 = "select * from category;";
		
		try {
			pstmt = conn.prepareStatement(sql1);
			pstmt2 = conn.prepareStatement(sql2);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    	
		//������֧
		newSchePanel = new JPanel();
		newSchePanel.setLayout(null);
		newScheTBorder = new TitledBorder("������֧");
		newSchePanel.setBorder(newScheTBorder);
		
		//��֧����
		scheType = new JLabel("���ͣ�");
		incomeRbtn = new JRadioButton("����");
		incomeRbtn.setSelected(true);
		expRbtn = new JRadioButton("֧��");
		btnGroup = new ButtonGroup();
		btnGroup.add(incomeRbtn);
		btnGroup.add(expRbtn);
		scheType.setBounds(50, 25, 40, 50);
		incomeRbtn.setBounds(90, 25, 80, 50);
		expRbtn.setBounds(170, 25, 80, 50);
		
		//��֧����
		scheCategory = new JLabel("���");
		categoryCbox = new JComboBox<String>();
		//��ѯ����
		try {
			pstmt2 = conn.prepareStatement(sql2);
			rs = sdb.execQuery(pstmt2);
			while(rs.next()) {
				categoryCbox.addItem(rs.getString("cateName"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		scheCategory.setBounds(50, 60, 40, 50);
		categoryCbox.setBounds(100, 75, 120, 20);
		
		//��֧����
		scheDateLabel = new JLabel("���ڣ�");
		scheDate = new JTextField(60);
		scheDateLabel.setBounds(50, 98, 40, 50);
		scheDate.setBounds(100, 110, 120, 25);
		
		//��֧���
		scheNumLabel = new JLabel("��");
		scheNum = new JTextField(60);
		scheNumLabel.setBounds(50, 138, 40, 50);
		scheNum.setBounds(100, 150, 120, 25);
		
		//��֧��ע
		scheNoteLabel = new JLabel("��ע��");
		scheNote = new JTextField(60);
		scheNoteLabel.setBounds(50, 178, 40, 50);
		scheNote.setBounds(100, 190, 120, 25);
		
		//�ύ
		addScheBtn = new JButton("�ύ");
		addScheBtn.setBounds(100, 230, 60, 30);
		addScheBtn.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				
  				new Thread( ()->{
  					try {
	  					if(incomeRbtn.isSelected()) {
	  						pstmt.setString(1, incomeRbtn.getText());
	  	  				}else if(expRbtn.isSelected()) {
	  	  					pstmt.setString(1, expRbtn.getText());
	  	  				}
  						pstmt.setString(2, categoryCbox.getSelectedItem().toString());
  						pstmt.setString(3, scheDate.getText());
  						pstmt.setString(4, scheNum.getText());
  						pstmt.setString(5, scheNote.getText());
  						
  						int r = sdb.execOther(pstmt);
  						if(r != -1) {
  							JOptionPane.showMessageDialog(null, "��ӳɹ���");
  						}else{
  							JOptionPane.showMessageDialog(null, "���ʧ�ܡ�");
  						}
  						
  					} catch (SQLException e1) {
  						e1.printStackTrace();
  					}
  				}).start();
  			}
  		});
		
		//�����֧����
		newSchePanel.add(scheType);
		newSchePanel.add(incomeRbtn);
		newSchePanel.add(expRbtn);
		//�����֧����
		newSchePanel.add(scheCategory);
		newSchePanel.add(categoryCbox);
		//�����֧����
		newSchePanel.add(scheDateLabel);
		newSchePanel.add(scheDate);
		//�����֧���
		newSchePanel.add(scheNumLabel);
		newSchePanel.add(scheNum);
		//�����֧��ע
		newSchePanel.add(scheNoteLabel);
		newSchePanel.add(scheNote);
		//����ύ��ť
		newSchePanel.add(addScheBtn);
		
		return newSchePanel;
	}
}
