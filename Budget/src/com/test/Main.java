package com.test;

import javax.swing.UIManager;

//import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.test.ui.Budget;

public class Main {
	public static void main(String[] args) {
		//ʹ��beautyeye LNF
//		try{
//			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
//			//BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
//	        BeautyEyeLNFHelper.launchBeautyEyeLNF();
//	        UIManager.put("RootPane.setupButtonVisible", false);
//	    }catch(Exception e){
//	    	e.printStackTrace();
//	    }
		
		//ʹ��ϵͳĬ��LNF
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		Budget budget = new Budget();
		budget.init();
		budget.setVisible(true);
	}
}
