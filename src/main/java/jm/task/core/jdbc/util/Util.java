package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/kata_114";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection connection;
        try {
            Driver driver = new FabricM

        } catch (SQLException e) {
            System.err.println("Не удалось загрузить класс драйвера");
        }
    }
}
