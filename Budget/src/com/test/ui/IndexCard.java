package com.test.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.test.utils.LineChart;

public class IndexCard {
	//��ҳcard panel
    private JPanel indexPanel = null;
    //��ҳ����ͳ��Panel
    private JPanel dataStatPanel = null;
    //��ҳ����ͳ��title border
    private TitledBorder dataStatTBorder = null;
    
    //��ҳ����ͳ�� - ��������/֧��/ӯ��
    private JLabel iweekLabel = null;
    private JLabel eweekLabel = null;
    private JLabel weekSurplusLabel = null;
    //��ҳ����ͳ�� - ��������/֧��/ӯ��
    private JLabel imonthLabel = null;
    private JLabel emonthLabel = null;
    private JLabel monthSurplusLabel = null;
    //��ҳ����ͳ�� - ����������/֧��/ӯ��
    private JLabel iquarterLabel = null;
    private JLabel equarterLabel = null;
    private JLabel quarterSurplusLabel = null;
    //��ҳ����ͳ�� - ��������/֧��/ӯ��
    private JLabel iyearLabel = null;
    private JLabel eyearLabel = null;
    private JLabel yearSurplusLabel = null;
    //��ҳ����ͳ�� - ȫ������/֧��/ӯ��
    private JLabel iallLabel = null;
    private JLabel eallLabel = null;
    private JLabel allSurplusLabel = null;
    
    //��ҳ����ͼ��Panel
    private JPanel dataGraphPanel = null;
    //��ҳ����ͼ��title border
    private TitledBorder dataGraphTBorder = null;
    
    public JPanel setIndex() {
		//��ҳ��ƬPanel
		indexPanel = new JPanel(new BorderLayout());
		indexPanel.setBackground(Color.PINK);
		
		//����ͳ��
		dataStatPanel = new JPanel(new GridLayout(5, 3));
		dataStatTBorder = new TitledBorder("����ͳ��");
		dataStatPanel.setBorder(dataStatTBorder);
		
		//����ͳ����ϸ��Ϣ
		//����
		iweekLabel = new JLabel("�������룺0");
		eweekLabel = new JLabel("����֧����0");
		weekSurplusLabel = new JLabel("����ӯ�ࣺ0");
		//����
		imonthLabel = new JLabel("�������룺0");
		emonthLabel = new JLabel("����֧����0");
		monthSurplusLabel = new JLabel("����ӯ�ࣺ0");
		//������
		iquarterLabel = new JLabel("���������룺0");
		equarterLabel = new JLabel("������֧����0");
		quarterSurplusLabel = new JLabel("������ӯ�ࣺ0");
		//����
		iyearLabel = new JLabel("�������룺0");
		eyearLabel = new JLabel("����֧����0");
		yearSurplusLabel = new JLabel("����ӯ�ࣺ0");
		//ȫ��
		iallLabel = new JLabel("�����룺0");
		eallLabel = new JLabel("��֧����0");
		allSurplusLabel = new JLabel("��ӯ�ࣺ0");
		
		//�����
		dataStatPanel.add(iweekLabel);
		dataStatPanel.add(eweekLabel);
		dataStatPanel.add(weekSurplusLabel);
		//�����
		dataStatPanel.add(imonthLabel);
		dataStatPanel.add(emonthLabel);
		dataStatPanel.add(monthSurplusLabel);
		//��Ӽ���
		dataStatPanel.add(iquarterLabel);
		dataStatPanel.add(equarterLabel);
		dataStatPanel.add(quarterSurplusLabel);
		//������
		dataStatPanel.add(iyearLabel);
		dataStatPanel.add(eyearLabel);
		dataStatPanel.add(yearSurplusLabel);
		//���ȫ��
		dataStatPanel.add(iallLabel);
		dataStatPanel.add(eallLabel);
		dataStatPanel.add(allSurplusLabel);
		
		//��������ͼ��
		dataGraphPanel = LineChart.createDemoLine();
		dataGraphTBorder = new TitledBorder("����ͼ��");
		dataGraphPanel.setBorder(dataGraphTBorder);
		
		indexPanel.add(BorderLayout.NORTH, dataStatPanel);
		indexPanel.add(BorderLayout.CENTER, dataGraphPanel);
		
		return indexPanel;
	}
}
