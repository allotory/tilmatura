package com.test.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
    //������֧ - title border
    private TitledBorder newScheTBorder = null;
    //������֧ - ����
    private JLabel scheType = null;
    private JRadioButton incomeRbtn = null;
    private JRadioButton expRbtn = null;
    //������֧ - ���
    private JLabel scheCategory = null;
    private JComboBox<String> categoryCbox = null;
    //������֧ - ����
    private JLabel scheDateLabel = null;
    private JTextField scheDate = null;
    //������֧ - ���
    private JLabel scheNumLabel = null;
    private JTextField scheNum = null;
    //������֧ - ��ע
    private JLabel scheNoteLabel = null;
    private JTextField scheNote = null;
    //������֧ - �ύ
    private JButton addScheBtn = null;
    
    //��֧��ϸ Panel
    private JPanel scheDetailPanel = null;
    //��֧��ϸ title border
    private TitledBorder scheDetailTBorder = null;
    //��֧��ϸ - ����Panel
    private JPanel scheDeTitlePanel = null;
    //��֧��ϸ - ��ʼ����
    private JLabel startDateLabel = null;
    private JTextField startDate = null;
    //��֧��ϸ - ��������
    private JLabel endDateLabel = null;
    private JTextField endDate = null;
    //��֧��ϸ - ���
    private JLabel scheTypeLabel = null;
    private JComboBox<String> scheTypeCbox = null;
    //��֧��ϸ - ��ѯ
    private JButton queryBtn = null;
    //��֧��ϸ - ���
    private JTable scheTable = null;
    
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
		scheduleBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//��ʾ��֧��ϸ
				card.show(centerPanel, "scheDetail");
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
		
		mainPanel.add(BorderLayout.WEST, westPanel);
	}
	
	//������������
	public void setContent() {
		centerPanel = new JPanel();
		
		//�������Ŀ�Ƭ����
		card = new CardLayout();
		centerPanel.setLayout(card);
		
		//������ҳ
		this.setIndex();
		//����������֧
		this.setNewSche();
		//������֧��ϸ
		this.scheDetails();
		
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
		newSchePanel.setLayout(null);
		newScheTBorder = new TitledBorder("������֧");
		newSchePanel.setBorder(newScheTBorder);
		
		//��֧����
		scheType = new JLabel("���ͣ�");
		incomeRbtn = new JRadioButton("����");
		incomeRbtn.setSelected(true);
		expRbtn = new JRadioButton("֧��");
		scheType.setBounds(50, 25, 40, 50);
		incomeRbtn.setBounds(90, 25, 80, 50);
		expRbtn.setBounds(170, 25, 80, 50);
		
		//��֧����
		scheCategory = new JLabel("���");
		categoryCbox = new JComboBox<String>();
		categoryCbox.addItem("��");
		categoryCbox.addItem("ʳ");
		categoryCbox.addItem("ס");
		categoryCbox.addItem("��");
		scheCategory.setBounds(50, 60, 40, 50);
		categoryCbox.setBounds(100, 75, 120, 20);
		
		//��֧����
		scheDateLabel = new JLabel("���ڣ�");
		scheDate = new JTextField(60);
		scheDateLabel.setBounds(50, 98, 40, 50);
		scheDate.setBounds(100, 110, 120, 25);
		
		//��֧���
		scheNumLabel = new JLabel("��");
		scheNum = new JTextField(60);
		scheNumLabel.setBounds(50, 138, 40, 50);
		scheNum.setBounds(100, 150, 120, 25);
		
		//��֧��ע
		scheNoteLabel = new JLabel("��ע��");
		scheNote = new JTextField(60);
		scheNoteLabel.setBounds(50, 178, 40, 50);
		scheNote.setBounds(100, 190, 120, 25);
		
		//�ύ
		addScheBtn = new JButton("�ύ");
		addScheBtn.setBounds(100, 230, 60, 30);
		
		//�����֧����
		newSchePanel.add(scheType);
		newSchePanel.add(incomeRbtn);
		newSchePanel.add(expRbtn);
		//�����֧����
		newSchePanel.add(scheCategory);
		newSchePanel.add(categoryCbox);
		//�����֧����
		newSchePanel.add(scheDateLabel);
		newSchePanel.add(scheDate);
		//�����֧���
		newSchePanel.add(scheNumLabel);
		newSchePanel.add(scheNum);
		//�����֧��ע
		newSchePanel.add(scheNoteLabel);
		newSchePanel.add(scheNote);
		//����ύ��ť
		newSchePanel.add(addScheBtn);
		
		//��ӵ���Ƭ
		centerPanel.add("newSchedule", newSchePanel);
	}
	
	public void scheDetails() {
		scheDetailPanel = new JPanel(new BorderLayout());
		scheDetailTBorder = new TitledBorder("��֧��ϸ");
		scheDetailPanel.setBorder(scheDetailTBorder);

		//����Panel
		scheDeTitlePanel = new JPanel(new FlowLayout());
		//��ʼ����
		startDateLabel = new JLabel("��ʼ���ڣ�");
		startDate = new JTextField(10);
		//��������
		endDateLabel = new JLabel("�������ڣ�");
		endDate = new JTextField(10);
		//���
		scheTypeLabel = new JLabel("���");
		scheTypeCbox = new JComboBox<String>();
		scheTypeCbox.addItem("��");
		scheTypeCbox.addItem("ʳ");
		scheTypeCbox.addItem("ס");
		scheTypeCbox.addItem("��");
		//��ѯ��ť
		queryBtn = new JButton("��ѯ");

		//�����ʼ����
		scheDeTitlePanel.add(startDateLabel);
		scheDeTitlePanel.add(startDate);
		//��ӽ�������
		scheDeTitlePanel.add(endDateLabel);
		scheDeTitlePanel.add(endDate);
		//������
		scheDeTitlePanel.add(scheTypeLabel);
		scheDeTitlePanel.add(scheTypeCbox);
		//��Ӳ�ѯ��ť
		scheDeTitlePanel.add(queryBtn);
		
		//�����ά������Ϊ�������  
	    Object[][] tableData = {  
	        new Object[]{"������" , 29 ,29 , "Ů"},  
	        new Object[]{"�ո�����", 29 , 56 , "��"},  
	        new Object[]{"���", 29 , 35 , "��"},  
	        new Object[]{"Ū��", 29 , 18 , "Ů"},  
	        new Object[]{"��ͷ", 29 , 2 , "��"}  
	    };  
	    //����һά������Ϊ�б���  
	    Object[] columnTitle = {"����" , "����" , "֧��", "�ϼ�"};  
		//��֧��ϸ���
		scheTable = new JTable(tableData, columnTitle);
		
		scheDetailPanel.add(BorderLayout.NORTH, scheDeTitlePanel);
		scheDetailPanel.add(BorderLayout.CENTER, new JScrollPane(scheTable));
		
		//��ӵ���Ƭ
		centerPanel.add("scheDetail", scheDetailPanel);
	}
}
