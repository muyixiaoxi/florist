package dao;

import model.Manager;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DBUtil;

import java.sql.SQLException;

public class ManagerDao {


//    用户名 密码 查询
    public static Manager selectManagernamePassword(String name,String password) throws SQLException {
//        拿到执行者对象
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
//        sql
        String sql = "select * from manager where name = ? and password = ?";
//        执行sql
        return r.query(sql,new BeanHandler<Manager>(Manager.class),name,password);
    }
}
