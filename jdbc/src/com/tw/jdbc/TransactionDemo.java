package com.tw.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {
    public static void main(String[] args) {
        String sql1 = "insert into emp values (213, 'Jack', 2300)";
        String sql2 = "update emp set salary=5000 where empid=101";
        String sql3 = "delete from emp where eid=103";

        Connection conn = null; // grab connection
        try {
            conn.setAutoCommit(false);

            Statement stmt = conn.createStatement();
            stmt.addBatch(sql1);
            stmt.addBatch(sql2);
            stmt.addBatch(sql3);

            stmt.executeBatch();
            conn.commit();
        }catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
