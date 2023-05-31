package service;

import dao.ManagerDao;
import model.Manager;

import java.sql.SQLException;

public class ManagerService {
    public static Manager login(String name,String password) throws SQLException {
        Manager manager=ManagerDao.selectManagernamePassword(name,password);

        return manager;
    }
}
