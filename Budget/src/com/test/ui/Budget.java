package com.test.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

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
    
    //����Panel
    private JPanel centerPanel = null;
    //����Panel - title border
    private TitledBorder centerTBorder = null;
    //�������Ŀ�Ƭ����
  	private CardLayout card = null;
    
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
    
    //������֧ Panel
    private JPanel newSchePanel = null;
    
	//��ȡ��Ļ�߶ȿ��
	private ScreenSizeUtils screenSizeUtils = null;
	
	//��������
	public void init() {
		this.setTitle("������֧������");
		this.setLayout(null);
		this.setScreen();
		this.setMenu();
		this.setResizable(false);
		this.setBounds((screenWidth - windowWidth)/2, 
				(screenHeight - windowHeight)/2, windowWidth, windowHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel(new BorderLayout());
		this.setSideBar();
		this.setContent();
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
		newMItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//��ʾ������֧
				card.show(centerPanel, "newSchedule");
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
	
	//������ർ��
	public void setSideBar() {
		westPanel = new JPanel(new GridLayout(3, 1));
		westPanel.setPreferredSize(new Dimension(130, 0));
		
		//��֧��ϸ
		schedulePanel = new JPanel(new GridLayout(3, 1));
		scheduleTBorder = new TitledBorder("��֧��ϸ");
		schedulePanel.setBorder(scheduleTBorder);
		scheduleBtn = new JButton("��֧��ϸ");
		scheStatBtn = new JButton("��֧ͳ��");
		graphBtn = new JButton("��֧ͼ��");
		
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
		
		mainPanel.add(BorderLayout.WEST, westPanel);
	}
	
	//������������
	public void setContent() {
		centerPanel = new JPanel();
		centerTBorder = new TitledBorder("");
		centerPanel.setBorder(centerTBorder);
		
		//�������Ŀ�Ƭ����
		card = new CardLayout();
		centerPanel.setLayout(card);
		
		//������ҳ
		this.setIndex();
		//����������֧
		this.setNewSche();
		
		//��ʾ��ҳ
		card.show(centerPanel, "index");
		
		mainPanel.add(BorderLayout.CENTER, centerPanel);
	}
	
	public void setIndex() {
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
		dataGraphPanel = new JPanel();
		dataGraphTBorder = new TitledBorder("����ͼ��");
		dataGraphPanel.setBorder(dataGraphTBorder);
		
		indexPanel.add(BorderLayout.NORTH, dataStatPanel);
		indexPanel.add(BorderLayout.CENTER, dataGraphPanel);
		
		//��ӵ���Ƭ
		centerPanel.add("index", indexPanel);
	}
	
	public void setNewSche() {
		//������֧
		newSchePanel = new JPanel();
		
		//��ӵ���Ƭ
		centerPanel.add("newSchedule", newSchePanel);
	}
}
