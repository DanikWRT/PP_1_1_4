package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
//        userService.saveUser("Name1", "lastName1", (byte) 20);
//        userService.removeUserById(1);
//        List<User> users = userService.getAllUsers();
//        for (User list: users) {
//            System.out.println(list);
//        }
//        userService.cleanUsersTable();
//        userService.dropUsersTable();

     }
}
