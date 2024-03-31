package br.com.luhf.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection connection;

    private ConnectionFactory(Connection connection) {

    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = initConnection();
        } else if (connection.isClosed()) {
            connection = initConnection();
        }
        return connection;
    }

    private static Connection initConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:15432/mod29", "luiz@gmail.com", "postgres");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
