package com.test.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.test.func.DetailData;
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
		
//		select date('now', 'start of day');
//		
//		sqlite> select date('now', 'start of day', '-7 day', 'weekday 1');
//		sqlite> select date('now', 'start of day', '+0 day', 'weekday 1');
//		
//		sqlite> select * from sche where scheDate >= date('now', 'start of month') and s
//				cheDate <= date('now', 'start of month', '+1 month', '-1 day');
//		
//		sqlite> select date('now', 'start of year');
//		sqlite> select date('now', 'start of year', '+1 year', '-1 day');
		//����ͳ����ϸ��Ϣ
		//����
		iweekLabel = new JLabel("�������룺0");
		eweekLabel = new JLabel("����֧����0");
		weekSurplusLabel = new JLabel("����ӯ�ࣺ0");
		DetailData dd = new DetailData();
		//��������
		String wa = dd.getDetailData("select sum(scheAmount) AS sum_amount from sche where scheDate >= date('now', 'start of day', '-7 day', 'weekday 1') and scheDate <= date('now', 'start of day', '+0 day', 'weekday 1') and scheType='����';");
		int week_in = 0;
		if(!(wa.equals("") || wa == null)) {
			week_in = Integer.parseInt(wa);
		}
		//����֧��
		String wb = dd.getDetailData("select sum(scheAmount) AS sum_amount from sche where scheDate >= date('now', 'start of day', '-7 day', 'weekday 1') and scheDate <= date('now', 'start of day', '+0 day', 'weekday 1') and scheType='֧��';");
		int week_exp = 0;
		if(!(wb.equals("") || wb == null)) {
			week_exp = Integer.parseInt(wb);
		}
		iweekLabel.setText("�������룺" + week_in);
		eweekLabel.setText("����֧����" + week_exp);
		weekSurplusLabel.setText("����ӯ�ࣺ" + (week_in - week_exp));
		
		//����
		imonthLabel = new JLabel("�������룺0");
		emonthLabel = new JLabel("����֧����0");
		monthSurplusLabel = new JLabel("����ӯ�ࣺ0");
		//����
		String ma = dd.getDetailData("select sum(scheAmount) AS sum_amount from sche where scheDate >= date('now', 'start of month') and scheDate <= date('now', 'start of month', '+1 month', '-1 day') and scheType='����';");
		int month_in = 0;
		if(!(ma.equals("") || ma == null)) {
			month_in = Integer.parseInt(ma);
		}
		//֧��
		String mb = dd.getDetailData("select sum(scheAmount) AS sum_amount from sche where scheDate >= date('now', 'start of month') and scheDate <= date('now', 'start of month', '+1 month', '-1 day') and scheType='֧��';");
		int month_exp = 0;
		if(!(mb.equals("") || mb == null)) {
			month_exp = Integer.parseInt(mb);
		}
		imonthLabel.setText("�������룺" + month_in);
		emonthLabel.setText("����֧����" + month_exp);
		monthSurplusLabel.setText("����ӯ�ࣺ" + (month_in - month_exp));
		
		//����
		iyearLabel = new JLabel("�������룺0");
		eyearLabel = new JLabel("����֧����0");
		yearSurplusLabel = new JLabel("����ӯ�ࣺ0");
		//����
		String ya = dd.getDetailData("select sum(scheAmount) AS sum_amount from sche where scheDate >= date('now', 'start of year') and scheDate <= date('now', 'start of year', '+1 year', '-1 day') and scheType='����';");
		int year_in = 0;
		if(!(ya.equals("") || ya == null)) {
			year_in = Integer.parseInt(ya);
		}
		//֧��
		String yb = dd.getDetailData("select sum(scheAmount) AS sum_amount from sche where scheDate >= date('now', 'start of year') and scheDate <= date('now', 'start of year', '+1 year', '-1 day') and scheType='֧��';");
		int year_exp = 0;
		if(!(yb.equals("") || yb == null)) {
			year_exp = Integer.parseInt(yb);
		}
		iyearLabel.setText("�������룺" + year_in);
		eyearLabel.setText("����֧����" + year_exp);
		yearSurplusLabel.setText("����ӯ�ࣺ" + (year_in - year_exp));
		
		//ȫ��
		iallLabel = new JLabel("�����룺0");
		eallLabel = new JLabel("��֧����0");
		allSurplusLabel = new JLabel("��ӯ�ࣺ0");
		//����
		String aa = dd.getDetailData("select sum(scheAmount) AS sum_amount from sche where scheType='����';");
		int all_in = 0;
		if(!(aa.equals("") || aa == null)) {
			all_in = Integer.parseInt(aa);
		}
		//֧��
		String ab = dd.getDetailData("select sum(scheAmount) AS sum_amount from sche where scheType='֧��';");
		int all_exp = 0;
		if(!(ab.equals("") || ab == null)) {
			all_exp = Integer.parseInt(ab);
		}
		iallLabel.setText("�����룺" + all_in);
		eallLabel.setText("��֧����" + all_exp);
		allSurplusLabel.setText("��ӯ�ࣺ" + (all_in - all_exp));
		
		//�����
		dataStatPanel.add(iweekLabel);
		dataStatPanel.add(eweekLabel);
		dataStatPanel.add(weekSurplusLabel);
		//�����
		dataStatPanel.add(imonthLabel);
		dataStatPanel.add(emonthLabel);
		dataStatPanel.add(monthSurplusLabel);
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
