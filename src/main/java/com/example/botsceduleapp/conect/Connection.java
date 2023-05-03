package com.example.botsceduleapp.conect;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    public static java.sql.Connection db = connect();
    public static java.sql.Connection db_users = connect_user();

    private static java.sql.Connection connect() {
        try {
            java.sql.Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Lessons", "postgres", "123456");
            return connection;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    private static java.sql.Connection connect_user() {
        try {
            java.sql.Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tg_users", "postgres", "123456");
            return connection;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
