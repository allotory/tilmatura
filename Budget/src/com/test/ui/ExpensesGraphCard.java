package com.test.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ExpensesGraphCard {

	//ͼ��Panel
	private JPanel egraphPanel = null;
	private TitledBorder graphTBorder = null;
	//Panel����
	private String tbMsg = "";
	
	//ͼ�� title panel
	private JPanel graphTPanel = null;
	//ͼ�� - ��ʼ����
    private JLabel startDateLabel = null;
    private JTextField startDate = null;
    //ͼ�� - ��������
    private JLabel endDateLabel = null;
    private JTextField endDate = null;
    //ͼ��- ���
    private JLabel scheTypeLabel = null;
    private JComboBox<String> scheTypeCbox = null;
    //ͼ�� - ��ѯ
    private JButton queryBtn = null;
    
    //ͼ��center panel
    private JPanel graphCPanel = null;
	
	public JPanel getGraph(String title, String flag) {
		//ͼ�����
		tbMsg = title;
		
		//ͼ��Panel
		egraphPanel = new JPanel(new BorderLayout());
		graphTBorder = new TitledBorder(tbMsg);
		egraphPanel.setBorder(graphTBorder);

		//ͼ��title panel
		graphTPanel = new JPanel(new FlowLayout());
		
		if(flag.equals("edaygraph")) {
			//֧���նη���

			//��ʼ����
			startDateLabel = new JLabel("��ʼ���ڣ�");
			startDate = new JTextField(20);
			startDate.setText("2015-01-01");
			//��������
			endDateLabel = new JLabel("�������ڣ�");
			endDate = new JTextField(20);
			endDate.setText("2015-12-31");
		}else if(flag.equals("emonthgraph")) {
			//֧���¶ȷ���

			//��ʼ����
			startDateLabel = new JLabel("��ʼ���ڣ�");
			startDate = new JTextField(20);
			startDate.setText("2015-01");
			//��������
			endDateLabel = new JLabel("�������ڣ�");
			endDate = new JTextField(20);
			endDate.setText("2015-12");
		}else if(flag.equals("eyeargraph")) {
			//֧����ȷ���

			//��ʼ����
			startDateLabel = new JLabel("��ʼ���ڣ�");
			startDate = new JTextField(20);
			startDate.setText("2014");
			//��������
			endDateLabel = new JLabel("�������ڣ�");
			endDate = new JTextField(20);
			endDate.setText("2015");
		}
		
		//���
		scheTypeLabel = new JLabel("���");
		scheTypeCbox = new JComboBox<String>();
		scheTypeCbox.addItem("ȫ��");
		scheTypeCbox.addItem("��");
		scheTypeCbox.addItem("ʳ");
		scheTypeCbox.addItem("ס");
		scheTypeCbox.addItem("��");
		//��ѯ��ť
		queryBtn = new JButton("��ѯ");
		
		graphTPanel.add(startDateLabel);
		graphTPanel.add(startDate);
		graphTPanel.add(endDateLabel);
		graphTPanel.add(endDate);
		graphTPanel.add(scheTypeLabel);
		graphTPanel.add(scheTypeCbox);
		graphTPanel.add(queryBtn);

		if(flag.equals("edaygraph")) {
			//֧���նη���

			//ͼ��
			graphCPanel = new JPanel();
			graphCPanel.setBackground(Color.ORANGE);
		}else if(flag.equals("emonthgraph")) {
			//֧���¶ȷ���

			//ͼ��
			graphCPanel = new JPanel();
			graphCPanel.setBackground(Color.PINK);
		}else if(flag.equals("eyeargraph")) {
			//֧����ȷ���

			//ͼ��
			graphCPanel = new JPanel();
			graphCPanel.setBackground(Color.YELLOW);
		}
		
		egraphPanel.add(BorderLayout.NORTH, graphTPanel);
		egraphPanel.add(BorderLayout.CENTER, graphCPanel);
		
		return egraphPanel;
	}
}
