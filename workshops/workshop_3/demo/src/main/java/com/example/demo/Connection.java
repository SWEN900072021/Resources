package com.example.demo;

import java.sql.*;

public class Connection {
        private static final String url = "jdbc:postgresql://localhost:5433/postgres";
        private static final String user = "postgres";
        private static final String password = "";
        /**
         * Connect to the PostgreSQL database
         * @return a Connection object
         */
        public static Boolean connect(String username, String userPassword) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?;";
            PreparedStatement findStatement = null;
            ResultSet rs = null;
            java.sql.Connection conn = null;
            try {
                DriverManager.registerDriver(new org.postgresql.Driver());
                conn = DriverManager.getConnection(url, user, password);

                findStatement = conn.prepareStatement(sql);
                findStatement.setString(1, username);
                findStatement.setString(2, userPassword);
                findStatement.execute();

                rs = findStatement.getResultSet();
                return rs.next();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    assert rs != null;
                    rs.close();
                    findStatement.close();
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            return false;
        }
}
