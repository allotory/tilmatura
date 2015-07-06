package com.test.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//�ж����ڸ�ʽ
public class JudgeDate {


	public static boolean judge(String match, String s) {
		try {
			DateFormat formatter = new SimpleDateFormat(match);
			Date date = (Date) formatter.parse(s);
			return s.equals(formatter.format(date));
		} catch (Exception e) {
			return false;
		}
	}
}
