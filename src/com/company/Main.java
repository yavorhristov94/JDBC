package com.company;

import oracle.sql.ORAData;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.sql.*;

import static com.company.DBType.ORADB;

public class Main {

    public static void main(String[] args) throws SQLException {
	// write your code here

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try{
            conn = DBUtil.getConnection(ORADB);
            String sql = "Select * From dba_users where Rownum < ?";

            preparedStatement= conn.prepareStatement
                    (sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            preparedStatement.setDouble(1, 10);

            rs = preparedStatement.executeQuery();

            while(rs.next()){System.out.println(rs.getString("username"));}

        }catch (SQLException e){}


/*
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
        */
/*
        try(
                Connection conn = DBUtil.getConnection(DBType.ORADB);
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("Select username, password from dba_users");
        ){

            rs.absolute(7);
            System.out.println(rs.getString("username"));
            System.out.println(rs.getString("password"));

            rs.moveToInsertRow();
            rs.updateString("username", "dick");
            rs.updateString("password", "dick");
            rs.insertRow();

            System.out.println("Updating name");
            rs.updateString("username", "HRDept");
            System.out.println("Updating name");
            rs.updateRow();

            System.out.println("Record updated succesfully");
            System.out.println(rs.getString("username"));
            System.out.println(rs.getString("password"));
        }
        //test
*/
    }
}
