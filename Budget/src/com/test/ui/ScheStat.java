package com.test.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ScheStat {
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
		
		//�����ά������Ϊ�������  
	    Object[][] tableData = {  
	        new Object[]{"������" , 29 ,29 , "Ů"},  
	        new Object[]{"�ո�����", 29 , 56 , "��"},  
	        new Object[]{"���", 29 , 35 , "��"},  
	        new Object[]{"Ū��", 29 , 18 , "Ů"},  
	        new Object[]{"��ͷ", 29 , 2 , "��"}  
	    };  
	    //����һά������Ϊ�б���  
	    Object[] columnTitle = {"�������" , "����" , "֧��", "����"};  
		//��֧��ϸ���
		scheStatTable = new JTable(tableData, columnTitle);
		
		scheStatPanel.add(BorderLayout.NORTH, scheStatTitlePanel);
		scheStatPanel.add(BorderLayout.CENTER, new JScrollPane(scheStatTable));
		
		return scheStatPanel;
	}
}
