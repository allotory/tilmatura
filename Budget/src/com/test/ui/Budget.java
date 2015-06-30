package com.test.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
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
    
    //������Panel
    private JPanel mainPanel = null;
    
    //��ർ��Panel
    private JPanel westPanel = null;

    //����Panel
    private JPanel centerPanel = null;
    //�������Ŀ�Ƭ����
  	private CardLayout card = null;
    
	//��ҳcard panel
    private JPanel indexPanel = null;
	//������֧card Panel
    private JPanel newSchePanel = null;
	//��֧��ϸcard Panel
    private JPanel scheDetailPanel = null;
	//��֧ͳ��card Panel
    private JPanel scheStatPanel = null;
	//������card Panel
	private JPanel newTypePanel = null;
	//ͼ��card Panel
	private JPanel graphPanel = null;
	//ͼ�� expenses card Panel
	private JPanel egraphPanel = null;
	//ͼ�� income card Panel
	private JPanel igraphPanel = null;
    
	//��ȡ��Ļ�߶ȿ��
	private ScreenSizeUtils screenSizeUtils = null;
	
	//��������
	public void init() {
		this.setTitle("������֧������");
		this.setLayout(null);
		this.setScreen();
		mainPanel = new JPanel(new BorderLayout());
		//��������������
		this.setContent();
		//���ò����
		westPanel = new BudgetSideBar().setSideBar(centerPanel, card);
  		mainPanel.add(BorderLayout.WEST, westPanel);
		//���ò˵���
		menuBar = new BudgetMenu().setMenu(centerPanel, card);
		this.setJMenuBar(menuBar);
		//�̶���С
		this.setResizable(false);
		this.setBounds((screenWidth - windowWidth)/2, 
				(screenHeight - windowHeight)/2, windowWidth, windowHeight);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(mainPanel);
	}
	
	//��ȡ��Ļ�߶ȿ��
	public void setScreen() {
		screenSizeUtils = new ScreenSizeUtils();
		screenWidth = screenSizeUtils.getScreenWidth();
		screenHeight = screenSizeUtils.getScreenHeight();
	}
	
	//������������
	public void setContent() {
		centerPanel = new JPanel();
		
		//�������Ŀ�Ƭ����
		card = new CardLayout();
		centerPanel.setLayout(card);
		
		//������ҳ
		indexPanel = new IndexCard().setIndex();
		centerPanel.add("index", indexPanel);
		//����������֧
		newSchePanel = new NewScheCard().setNewSche();
		centerPanel.add("newSchedule", newSchePanel);
		//������֧��ϸ
		scheDetailPanel = new ScheDetailsCard().scheDetails();
		centerPanel.add("scheDetail", scheDetailPanel);
		//������֧ͳ��
		scheStatPanel = new ScheStatCard().inexpStat();
		centerPanel.add("scheStat", scheStatPanel);
		//����������
		newTypePanel = new NewTypeCard().setNewType();
		centerPanel.add("newType", newTypePanel);
		//������֧ͼ��
		graphPanel = new GraphCard().getGraph("��֧ͼ��", "iegraph");
		centerPanel.add("scheGraph", graphPanel);
		//����֧���նη���ͼ��
		egraphPanel = new ExpensesGraphCard().getGraph("֧���նη���", "edaygraph");
		centerPanel.add("edayGraph", egraphPanel);
		//����֧���¶ȷ���ͼ��
		egraphPanel = new ExpensesGraphCard().getGraph("֧���¶ȷ���", "emonthgraph");
		centerPanel.add("emonthGraph", egraphPanel);
		//����֧����ȷ���ͼ��
		egraphPanel = new ExpensesGraphCard().getGraph("֧����η���", "eyeargraph");
		centerPanel.add("eyearGraph", egraphPanel);
		//���������նη���ͼ��
		igraphPanel = new IncomeGraphCard().getGraph("�����նη���", "idaygraph");
		centerPanel.add("idayGraph", igraphPanel);
		//���������¶ȷ���ͼ��
		igraphPanel = new IncomeGraphCard().getGraph("�����¶ȷ���", "imonthgraph");
		centerPanel.add("imonthGraph", igraphPanel);
		//����������ȷ���ͼ��
		igraphPanel = new IncomeGraphCard().getGraph("������η���", "iyeargraph");
		centerPanel.add("iyearGraph", igraphPanel);
		
		//��ʾ��ҳ
		card.show(centerPanel, "index");
		
		mainPanel.add(BorderLayout.CENTER, centerPanel);
	}
}
