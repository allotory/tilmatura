package com.test.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import com.test.utils.JudgeDate;
import com.test.utils.LineChart;

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
			startDate = new JTextField(10);
			startDate.setText("2015-01-01");
			//��������
			endDateLabel = new JLabel("�������ڣ�");
			endDate = new JTextField(10);
			endDate.setText("2015-12-31");
			
			//��ѯ��ť
			queryBtn = new JButton("��ѯ");
			queryBtn.addMouseListener(new MouseAdapter() {
	  			@Override
	  			public void mousePressed(MouseEvent e) {
	  				new Thread( ()->{
	  					if(JudgeDate.judge("yyyy-MM-dd", startDate.getText()) && JudgeDate.judge("yyyy-MM-dd", endDate.getText())) {
	  	  					//ˢ��ͼ��
		  	  				SwingUtilities.invokeLater(()->{
		  	  					graphCPanel = LineChart.createQueryLine(startDate.getText(), endDate.getText(), "֧��");
		  					});
	  					}else {
	  						JOptionPane.showMessageDialog(null, "�Բ����������ڸ�ʽ������󣡣�������yyyy-MM-dd��");
	  					}
	  				}).start();
	  			}
	  		});
		}else if(flag.equals("emonthgraph")) {
			//֧���¶ȷ���

			//��ʼ����
			startDateLabel = new JLabel("��ʼ���ڣ�");
			startDate = new JTextField(10);
			startDate.setText("2015-01");
			//��������
			endDateLabel = new JLabel("�������ڣ�");
			endDate = new JTextField(10);
			endDate.setText("2015-12");
			//��ѯ��ť
			queryBtn = new JButton("��ѯ");
			queryBtn.addMouseListener(new MouseAdapter() {
	  			@Override
	  			public void mousePressed(MouseEvent e) {
	  				new Thread( ()->{
	  					if(JudgeDate.judge("yyyy-MM", startDate.getText()) && JudgeDate.judge("yyyy-MM", endDate.getText())) {
	  	  					//ˢ��ͼ��
		  	  				SwingUtilities.invokeLater(()->{
		  	  					graphCPanel = LineChart.createQueryLine(startDate.getText(), endDate.getText(), "֧��");
		  					});
	  					}else {
	  						JOptionPane.showMessageDialog(null, "�Բ����������ڸ�ʽ������󣡣�������yyyy-MM��");
	  					}
	  				}).start();
	  			}
	  		});
		}else if(flag.equals("eyeargraph")) {
			//֧����ȷ���

			//��ʼ����
			startDateLabel = new JLabel("��ʼ���ڣ�");
			startDate = new JTextField(10);
			startDate.setText("2014");
			//��������
			endDateLabel = new JLabel("�������ڣ�");
			endDate = new JTextField(10);
			endDate.setText("2015");
			//��ѯ��ť
			queryBtn = new JButton("��ѯ");
			queryBtn.addMouseListener(new MouseAdapter() {
	  			@Override
	  			public void mousePressed(MouseEvent e) {
	  				new Thread( ()->{
	  					if(JudgeDate.judge("yyyy", startDate.getText()) && JudgeDate.judge("yyyy", endDate.getText())) {
	  	  					//ˢ��ͼ��
		  	  				SwingUtilities.invokeLater(()->{
		  	  					graphCPanel = LineChart.createQueryLine(startDate.getText(), endDate.getText(), "֧��");
		  					});
	  					}else {
	  						JOptionPane.showMessageDialog(null, "�Բ����������ڸ�ʽ������󣡣�������yyyy��");
	  					}
	  				}).start();
	  			}
	  		});
		}
		
		
		
		graphTPanel.add(startDateLabel);
		graphTPanel.add(startDate);
		graphTPanel.add(endDateLabel);
		graphTPanel.add(endDate);
		graphTPanel.add(queryBtn);

		if(flag.equals("edaygraph")) {
			//֧���նη���

			//ͼ��
			graphCPanel = LineChart.createDemoLine("֧��");
			graphCPanel.setBackground(Color.ORANGE);
		}else if(flag.equals("emonthgraph")) {
			//֧���¶ȷ���

			//ͼ��
			graphCPanel = LineChart.createDemoLine("֧��");
			graphCPanel.setBackground(Color.PINK);
		}else if(flag.equals("eyeargraph")) {
			//֧����ȷ���

			//ͼ��
			graphCPanel = LineChart.createDemoLine("֧��");
			graphCPanel.setBackground(Color.YELLOW);
		}
		
		egraphPanel.add(BorderLayout.NORTH, graphTPanel);
		egraphPanel.add(BorderLayout.CENTER, graphCPanel);
		
		return egraphPanel;
	}
}
