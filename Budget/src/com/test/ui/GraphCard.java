package com.test.ui;

import java.awt.BorderLayout;
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

import com.test.utils.BarChart;
import com.test.utils.JudgeDate;

//ͼ�����
public class GraphCard {

	//ͼ��Panel
	private JPanel graphPanel = null;
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
		graphPanel = new JPanel(new BorderLayout());
		graphTBorder = new TitledBorder(tbMsg);
		graphPanel.setBorder(graphTBorder);
		
		if(flag.equals("iegraph")) {
			//��֧ͼ��
			
			//ͼ��title panel
			graphTPanel = new JPanel(new FlowLayout());
			//��ʼ����
			startDateLabel = new JLabel("��ʼ���ڣ�");
			startDate = new JTextField(10);
			//��������
			endDateLabel = new JLabel("�������ڣ�");
			endDate = new JTextField(10);
			//��ѯ��ť
			queryBtn = new JButton("��ѯ");
			queryBtn.addMouseListener(new MouseAdapter() {
	  			@Override
	  			public void mousePressed(MouseEvent e) {
	  				new Thread( ()->{
	  					if(JudgeDate.judge(startDate.getText()) && JudgeDate.judge(endDate.getText())) {
	  	  					//ˢ��ͼ��
		  	  				SwingUtilities.invokeLater(()->{
		  	  					graphCPanel = BarChart.createQueryBar(startDate.getText(), endDate.getText());
		  	  					graphPanel.repaint();
		  					});
	  					}else {
	  						JOptionPane.showMessageDialog(null, "�Բ����������ڸ�ʽ������󣡣�������yyyy-MM-dd��");
	  					}
	  				}).start();
	  			}
	  		});
			
			graphTPanel.add(startDateLabel);
			graphTPanel.add(startDate);
			graphTPanel.add(endDateLabel);
			graphTPanel.add(endDate);
			graphTPanel.add(queryBtn);
			
			//ͼ��
			graphCPanel = BarChart.createDemoBar();
		}
		
		graphPanel.add(BorderLayout.NORTH, graphTPanel);
		graphPanel.add(BorderLayout.CENTER, graphCPanel);
		
		return graphPanel;
	}
	
}
