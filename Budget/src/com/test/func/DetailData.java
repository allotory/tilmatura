package com.test.func;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.db.SqliteDB;

public class DetailData {

    //���ݿ����
    SqliteDB sdb = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    String data = "";
    
    public String getDetailData(String sql) {
    	//���ݿ�
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
