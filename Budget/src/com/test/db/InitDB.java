package com.test.db;

import java.sql.Connection;
import java.sql.Statement;

//初始化数据库
public class InitDB {
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		SqliteDB sdb = new SqliteDB();
		
		conn = sdb.getConn();
		stmt = conn.createStatement();
		stmt.executeUpdate("drop table if exists sche;");
		stmt.executeUpdate("create table sche (id integer primary key,scheType text,scheCategory integer,scheDate text,scheAmount real,scheDescription text);");
		stmt.executeUpdate("drop table if exists category;");
		stmt.executeUpdate("create table category (id integer primary key,cateName text,scheType text);");
		
		sdb.closeDB();
	}
}
