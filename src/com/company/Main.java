package com.company;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
	// write your code here

        try(
        Connection conn = DBUtil.getConnection(DBType.ORADB);
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery("Select * From dba_users Where Rownum <= 10");
        ){

            rs.beforeFirst();
            System.out.println("First 10 Rows : ");
            while(rs.next()){
                System.out.println( rs.getString("username"));
            }
        }
        //test

    }
}
