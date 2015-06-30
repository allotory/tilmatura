package com.test.ui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class BudgetSideBar {
    //��ർ��Panel
    private JPanel westPanel = null;
    
    //��ർ�� - ��֧��ϸPanel
    private JPanel schedulePanel = null;
    //��ർ�� - ��֧��ϸtitle border
    private TitledBorder scheduleTBorder = null;
    //��ർ�� - ��֧��ϸ��ť
    private JButton scheduleBtn = null;
    //��ർ�� - ��֧ͳ�ư�ť
    private JButton scheStatBtn = null;
    //��ർ�� - ��֧ͼ��ť
    private JButton graphBtn = null;
    
    //��ർ�� - ֧������Panel
    private JPanel expAnalysisPanel = null;
    //��ർ�� - ֧������title border
    private TitledBorder expAnaylysisTBorder = null;
    //��ർ�� - �նη���
    private JButton edayBtn = null;
    //��ർ�� - �¶ȷ���
    private JButton emonthBtn = null;
    //��ർ�� - ��ȷ���
    private JButton eyearBtn = null;
    
    //��ർ�� - �������Panel
    private JPanel inAnalysisPanel = null;
    //��ർ�� - �������title border
    private TitledBorder inAnalysisTBorder = null;
    //��ർ�� - �նη���
    private JButton idayBtn = null;
    //��ർ�� - �¶ȷ���
    private JButton imonthBtn = null;
    //��ർ�� - ��ȷ���
    private JButton iyearBtn = null;
    
    //������ർ��
  	public JPanel setSideBar(JPanel centerPanel, CardLayout card) {
  		westPanel = new JPanel(new GridLayout(3, 1));
  		westPanel.setPreferredSize(new Dimension(130, 0));
  		
  		//��֧��ϸ
  		schedulePanel = new JPanel(new GridLayout(3, 1));
  		scheduleTBorder = new TitledBorder("��֧��ϸ");
  		schedulePanel.setBorder(scheduleTBorder);
  		scheduleBtn = new JButton("��֧��ϸ");
  		scheStatBtn = new JButton("��֧ͳ��");
  		graphBtn = new JButton("��֧ͼ��");
  		scheduleBtn.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//��ʾ��֧��ϸ
  				card.show(centerPanel, "scheDetail");
  			}
  		});
  		scheStatBtn.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//��ʾ��֧��ϸ
  				card.show(centerPanel, "scheStat");
  			}
  		});
  		graphBtn.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//��ʾ��֧��ϸ
  				card.show(centerPanel, "scheGraph");
  			}
  		});
  		
  		schedulePanel.add(scheduleBtn);
  		schedulePanel.add(scheStatBtn);
  		schedulePanel.add(graphBtn);
  		
  		//֧������
  		expAnalysisPanel = new JPanel(new GridLayout(3, 1));
  		expAnaylysisTBorder = new TitledBorder("֧������");
  		expAnalysisPanel.setBorder(expAnaylysisTBorder);
  		edayBtn = new JButton("�նη���");
  		emonthBtn = new JButton("�¶ȷ���");
  		eyearBtn = new JButton("��ȷ���");
  		
  		expAnalysisPanel.add(edayBtn);
  		expAnalysisPanel.add(emonthBtn);
  		expAnalysisPanel.add(eyearBtn);
  		
  		//�������
  		inAnalysisPanel = new JPanel(new GridLayout(3, 1));
  		inAnalysisTBorder = new TitledBorder("�������");
  		inAnalysisPanel.setBorder(inAnalysisTBorder);
  		idayBtn = new JButton("�նη���");
  		imonthBtn = new JButton("�¶ȷ���");
  		iyearBtn = new JButton("��ȷ���");
  		
  		inAnalysisPanel.add(idayBtn);
  		inAnalysisPanel.add(imonthBtn);
  		inAnalysisPanel.add(iyearBtn);
  		
  		westPanel.add(schedulePanel);
  		westPanel.add(expAnalysisPanel);
  		westPanel.add(inAnalysisPanel);
  		
  		return westPanel;
  	}
}
