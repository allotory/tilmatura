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

public class ScheDetails {
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
    
    public JPanel scheDetails() {
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
		scheTypeCbox.addItem("��");
		scheTypeCbox.addItem("ʳ");
		scheTypeCbox.addItem("ס");
		scheTypeCbox.addItem("��");
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
		
		//�����ά������Ϊ�������  
	    Object[][] tableData = {  
	        new Object[]{"������" , 29 ,29 , "Ů"},  
	        new Object[]{"�ո�����", 29 , 56 , "��"},  
	        new Object[]{"���", 29 , 35 , "��"},  
	        new Object[]{"Ū��", 29 , 18 , "Ů"},  
	        new Object[]{"��ͷ", 29 , 2 , "��"}  
	    };  
	    //����һά������Ϊ�б���  
	    Object[] columnTitle = {"����" , "����" , "֧��", "�ϼ�"};  
		//��֧��ϸ���
		scheTable = new JTable(tableData, columnTitle);
		
		scheDetailPanel.add(BorderLayout.NORTH, scheDeTitlePanel);
		scheDetailPanel.add(BorderLayout.CENTER, new JScrollPane(scheTable));
		
		return scheDetailPanel;
	}
}
