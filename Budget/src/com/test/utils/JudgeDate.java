package com.test.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//�ж����ڸ�ʽ
public class JudgeDate {

	public static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	public static boolean judge(String s) {
		try {
			Date date = (Date) formatter.parse(s);
			return s.equals(formatter.format(date));
		} catch (Exception e) {
			return false;
		}
	}
}
