package com.test.ui;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class NewScheCard {
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
    
    public JPanel setNewSche() {
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
		
		return newSchePanel;
	}
}
