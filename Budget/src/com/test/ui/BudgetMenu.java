package com.test.ui;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//������˵���
public class BudgetMenu {
	//�˵���
    private JMenuBar menuBar = null;
    
    //�ļ��˵�
    private JMenu fileMenu = null;
    //�ļ��˵� - ��ҳ
    private JMenuItem indexMItem = null;
    //�ļ��˵� - �½���֧
    private JMenuItem newMItem = null;
    //�ļ��˵� - ������
    private JMenuItem addTypeMItem = null;
    //�ļ��˵� - �˳�
    private JMenuItem exitMItem = null;
    
    //��֧��ϸ�˵�
    private JMenu scheduleMenu = null;
    //�ļ��˵� - ��֧��ϸ
    private JMenuItem scheduleMItem = null;
    //��֧��ϸ�˵� - ��֧ͳ��
    private JMenuItem scheStatMItem = null;
    //��֧��ϸ�˵� - ��֧ͼ��
    private JMenuItem graphMItem = null;
    
    //֧�������˵�
    private JMenu expensesMenu = null;
    //֧�������˵� - �նη���
    private JMenuItem edayMItem = null;
    //֧�������˵� - �¶ȷ���
    private JMenuItem emonthMItem = null;
    //֧�������˵� - ��ȷ���
    private JMenuItem eyearMItem = null;   
    
    //��������˵�
    private JMenu incomeMenu = null;
    //��������˵� - �նη���
    private JMenuItem idayMItem = null;
    //��������˵� - �¶ȷ���
    private JMenuItem imonthMItem = null;
    //��������˵� - ��ȷ���
    private JMenuItem iyearMItem = null;
    
    //�����˵�
    private JMenu helpMenu = null;
    //�����˵� - ����
    private JMenuItem aboutMItem = null;
    
    //���ò˵�
  	public JMenuBar setMenu(JPanel centerPanel, CardLayout card) {
  		menuBar = new JMenuBar();
  		
  		//�ļ��˵�
  		fileMenu = new JMenu("�ļ�");
  		indexMItem = new JMenuItem("��ҳ");
  		newMItem = new JMenuItem("������֧");
  		addTypeMItem = new JMenuItem("������");
  		exitMItem = new JMenuItem("�˳�");
  		fileMenu.add(indexMItem);
  		fileMenu.add(newMItem);
  		fileMenu.add(addTypeMItem);
  		fileMenu.add(exitMItem);
  		indexMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//��ʾ��ҳ
  				card.show(centerPanel, "index");
  			}
  		});
  		newMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//��ʾ������֧
  				card.show(centerPanel, "newSchedule");
  			}
  		});
  		addTypeMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//��ʾ������
  				card.show(centerPanel, "newType");
  			}
  		});
  		exitMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				System.exit(0);
  			}
  		});
  		
  		//��֧��ϸ�˵�
  		scheduleMenu = new JMenu("��֧��ϸ");
  		scheduleMItem = new JMenuItem("��֧��ϸ");
  		scheStatMItem = new JMenuItem("��֧ͳ��");
  		graphMItem = new JMenuItem("��֧ͼ��");
  		scheduleMenu.add(scheduleMItem);
  		scheduleMenu.add(scheStatMItem);
  		scheduleMenu.add(graphMItem);
  		scheduleMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//��ʾ��֧��ϸ
  				card.show(centerPanel, "scheDetail");
  			}
  		});
  		scheStatMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//��ʾ��֧ͳ��
  				card.show(centerPanel, "scheStat");
  			}
  		});
  		graphMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//��ʾ��֧ͼ��
  				card.show(centerPanel, "scheGraph");
  			}
  		});
  		
  		//֧�������˵�
  		expensesMenu = new JMenu("֧������");
  		edayMItem = new JMenuItem("�նη���");
  		emonthMItem = new JMenuItem("�¶ȷ���");
  		eyearMItem = new JMenuItem("��ȷ���");
  		expensesMenu.add(edayMItem);
  		expensesMenu.add(emonthMItem);
  		expensesMenu.add(eyearMItem);
  		edayMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//��ʾ֧���ն�ͼ��
  				card.show(centerPanel, "edayGraph");
  			}
  		});
  		emonthMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//��ʾ֧���¶�ͼ��
  				card.show(centerPanel, "emonthGraph");
  			}
  		});
  		eyearMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//��ʾ֧�����ͼ��
  				card.show(centerPanel, "eyearGraph");
  			}
  		});
  		
  		//��������˵�
  		incomeMenu = new JMenu("֧������");
  		idayMItem = new JMenuItem("�նη���");
  		imonthMItem = new JMenuItem("�¶ȷ���");
  		iyearMItem = new JMenuItem("��ȷ���");
  		incomeMenu.add(idayMItem);
  		incomeMenu.add(imonthMItem);
  		incomeMenu.add(iyearMItem);
  		idayMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//��ʾ�����ն�ͼ��
  				card.show(centerPanel, "idayGraph");
  			}
  		});
  		imonthMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//��ʾ�����¶�ͼ��
  				card.show(centerPanel, "imonthGraph");
  			}
  		});
  		iyearMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				//��ʾ�������ͼ��
  				card.show(centerPanel, "iyearGraph");
  			}
  		});
  		
  		//�����˵�
  		helpMenu = new JMenu("����");
  		aboutMItem = new JMenuItem("����");
  		helpMenu.add(aboutMItem);
  		aboutMItem.addMouseListener(new MouseAdapter() {
  			@Override
  			public void mousePressed(MouseEvent e) {
  				JOptionPane.showMessageDialog(null, "û�а�����");
  			}
  		});
  		
  		menuBar.add(fileMenu);
  		menuBar.add(scheduleMenu);
  		menuBar.add(expensesMenu);
  		menuBar.add(incomeMenu);
  		menuBar.add(helpMenu);
  		
  		return menuBar;
  	}
}
