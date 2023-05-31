package service;

import dao.FlowerDao;
import dao.UserDao;
import model.Flower;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    //    注册功能
    public boolean register(User user) {

        try {
//            用户是否注册
            if (UserDao.isUsernameExist(user.getUsername())) {
                return false;
            } else {
                UserDao.addUser(user);
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    //    登录业务
    public static User login(String username, String password) {

        User user = null;
        try {
            user = UserDao.selectUsernamePassword(username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    //    获取全部用户
    public static List getAllUser() {
        try {
            return UserDao.getAllUser();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    //    注销用户
    public static void deleteUser(int id) {
        try {

            UserDao.deleteUser(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //    修改用户信息 业务
    public static void updateUser(User user) {
        try {

            UserDao.updateUser(user);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
