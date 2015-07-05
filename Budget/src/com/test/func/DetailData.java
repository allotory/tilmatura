package com.test.func;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.db.SqliteDB;

public class DetailData {

    //数据库操作
    SqliteDB sdb = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    String data = "";
    
    public String getDetailData(String sql) {
    	//数据库
		sdb = new SqliteDB();
		conn = sdb.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = sdb.execQuery(pstmt);
			while(rs.next()) {
				data = rs.getString("sum_amount");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    	return data;
    }
    
}
