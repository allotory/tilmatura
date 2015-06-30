package com.test.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

//ͼ�����
public class GraphCard {

	//ͼ��Panel
	private JPanel graphPanel = null;
	private TitledBorder graphTBorder = null;
	//Panel����
	private String tbMsg = "";
	
	//ͼ�� title panel
	private JPanel graphTPanel = null;
	//��֧��ϸ - ��ʼ����
    private JLabel startDateLabel = null;
    private JTextField startDate = null;
    //��֧��ϸ - ��������
    private JLabel endDateLabel = null;
    private JTextField endDate = null;
    //��֧��ϸ - ��ѯ
    private JButton queryBtn = null;
    
    //ͼ��center panel
    private JPanel graphCPanel = null;
	
	public JPanel getGraph(String title, String flag) {
		//ͼ�����
		tbMsg = title;
		
		//ͼ��Panel
		graphPanel = new JPanel(new BorderLayout());
		graphTBorder = new TitledBorder(tbMsg);
		graphPanel.setBorder(graphTBorder);
		
		if(flag.equals("iegraph")) {
			//��֧ͼ��
			
			//ͼ��title panel
			graphTPanel = new JPanel(new FlowLayout());
			//��ʼ����
			startDateLabel = new JLabel("��ʼ���ڣ�");
			startDate = new JTextField(20);
			//��������
			endDateLabel = new JLabel("�������ڣ�");
			endDate = new JTextField(20);
			//��ѯ��ť
			queryBtn = new JButton("��ѯ");
			
			graphTPanel.add(startDateLabel);
			graphTPanel.add(startDate);
			graphTPanel.add(endDateLabel);
			graphTPanel.add(endDate);
			graphTPanel.add(queryBtn);
			
			//ͼ��
			graphCPanel = new JPanel();
			graphCPanel.setBackground(Color.GREEN);
			
		}
		
		graphPanel.add(BorderLayout.NORTH, graphTPanel);
		graphPanel.add(BorderLayout.CENTER, graphCPanel);
		
		return graphPanel;
	}
	
}
