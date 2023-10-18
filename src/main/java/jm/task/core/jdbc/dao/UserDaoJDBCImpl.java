package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String queryCreateUsersTable = "CREATE TABLE users("
                + "ID INT(5) NOT NULL AUTO_INCREMENT,"
                + "name VARCHAR(20) NOT NULL, "
                + "lastname VARCHAR(20) NOT NULL, "
                + "age INT(3) NOT NULL, " + "PRIMARY KEY (ID) "
                + ")";
        try (Statement statement = Util.getConnection().createStatement();) {
            statement.execute(queryCreateUsersTable);
        } catch (SQLSyntaxErrorException e) {
            System.err.println("Таблица уже существует");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private void updateTable(String sql, String msg) {
        try (Statement statement = Util.getConnection().createStatement()) {
            int res = statement.executeUpdate(sql);
            if (res > 0) {
                System.out.println(msg);
            }
        } catch (SQLSyntaxErrorException  e) {
            System.out.println("Ошибка создания/удаления таблицы");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void dropUsersTable() {
        String query = "DROP TABLE 'users'";
        updateTable(query, "Таблица удалена");
    }

    public void saveUser(String name, String lastName, byte age) {
        String query = String.format(
                "Insert into users(name,lastname,age) VALUES ('%s','%s','%d')"
                , name, lastName, age);
        updateTable(query, String.format("Пользователь с именем %s успешно добавлен", name));
    }

    public void removeUserById(long id) {
        String query = String.format("DELETE FROM users WHERE id = %s", id);
        updateTable(query, String.format("Пользователь, с id %d удалён \n", id));
    }

    public List<User> getAllUsers() {

        return null;
    }

    public void cleanUsersTable() {

    }
}
