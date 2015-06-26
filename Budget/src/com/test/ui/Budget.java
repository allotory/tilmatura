package com.test.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.test.utils.ScreenSizeUtils;

//������֧������
@SuppressWarnings("serial")
public class Budget extends JFrame{
	
	//���ڵĿ�Ⱥʹ��ڵĸ߶�
	private int windowWidth = 800;
	private int windowHeight = 600;	
	
	//��Ļ�Ŀ�Ⱥ���Ļ�ĸ߶�
	private int screenWidth = 0;
	private int screenHeight = 0;
	
	//�˵���
    private JMenuBar menuBar = null;
    
    //�ļ��˵�
    private JMenu fileMenu = null;
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
    
    //������Panel
    private JPanel mainPanel = null;

	//��ȡ��Ļ�߶ȿ��
	private ScreenSizeUtils screenSizeUtils = null;
	
	//��������
	public void init() {
		this.setTitle("������֧������");
		this.setLayout(null);
		this.setScreen();
		this.setMenu();
		this.setBounds((screenWidth - windowWidth)/2, 
				(screenHeight - windowHeight)/2, windowWidth, windowHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel(new BorderLayout());
		this.setContentPane(mainPanel);
	}
	
	//��ȡ��Ļ�߶ȿ��
	public void setScreen() {
		screenSizeUtils = new ScreenSizeUtils();
		screenWidth = screenSizeUtils.getScreenWidth();
		screenHeight = screenSizeUtils.getScreenHeight();
	}
	
	//���ò˵�
	public void setMenu() {
		menuBar = new JMenuBar();
		//�ļ��˵�
		fileMenu = new JMenu("�ļ�");
		newMItem = new JMenuItem("������֧");
		addTypeMItem = new JMenuItem("������");
		exitMItem = new JMenuItem("�˳�");
		fileMenu.add(fileMenu);
		fileMenu.add(newMItem);
		fileMenu.add(addTypeMItem);
		fileMenu.add(exitMItem);
		//��֧��ϸ�˵�
		scheduleMenu = new JMenu("��֧��ϸ");
		scheduleMItem = new JMenuItem("��֧��ϸ");
		scheStatMItem = new JMenuItem("��֧ͳ��");
		graphMItem = new JMenuItem("��֧ͼ��");
		scheduleMenu.add(scheduleMItem);
		scheduleMenu.add(scheStatMItem);
		scheduleMenu.add(graphMItem);
		//֧�������˵�
		expensesMenu = new JMenu("֧������");
		edayMItem = new JMenuItem("�նη���");
		emonthMItem = new JMenuItem("�¶ȷ���");
		eyearMItem = new JMenuItem("��ȷ���");
		expensesMenu.add(edayMItem);
		expensesMenu.add(emonthMItem);
		expensesMenu.add(eyearMItem);
		//��������˵�
		incomeMenu = new JMenu("֧������");
		idayMItem = new JMenuItem("�նη���");
		imonthMItem = new JMenuItem("�¶ȷ���");
		iyearMItem = new JMenuItem("��ȷ���");
		incomeMenu.add(idayMItem);
		incomeMenu.add(imonthMItem);
		incomeMenu.add(iyearMItem);
		//�����˵�
		helpMenu = new JMenu("����");
		aboutMItem = new JMenuItem("����");
		helpMenu.add(aboutMItem);
		
		menuBar.add(fileMenu);
		menuBar.add(scheduleMenu);
		menuBar.add(expensesMenu);
		menuBar.add(incomeMenu);
		menuBar.add(helpMenu);
		
		this.setJMenuBar(menuBar);
	}
}
