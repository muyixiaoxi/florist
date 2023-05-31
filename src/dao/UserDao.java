package dao;

import model.Flower;
import model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBUtil;

import java.sql.*;
import java.util.List;

public class UserDao {
    
//    add方法
    public static void addUser(User user) throws SQLException {
//        拿到执行者对象
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
//        sql
        String sql="insert into user(username,password,name,phone,address) values(?,?,?,?,?)";
//        执行
        r.update(sql,user.getUsername(),user.getPassword(),user.getName(),user.getPhone(),user.getAddress());
    }

//    判断username是否存在
    public static boolean isUsernameExist(String username) throws SQLException {
//        拿到执行者对象
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
//        sql
        String sql = "select * from user where username = ?";
//        执行
        User user = r.query(sql,new BeanHandler<User>(User.class),username);

        if(user == null){
            return false;
        }else{
            return true;
        }
    }

//    username password 查询
    public static User selectUsernamePassword(String username,String password) throws SQLException {
//        拿到执行者对象
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
//        sql
        String sql = "select * from user where username = ? and password = ?";
//        执行sql
        return r.query(sql,new BeanHandler<User>(User.class),username,password);
    }

//    获取全部用户
    public static List<User> getAllUser() throws SQLException {
//        拿到执行者对象
        QueryRunner r =new QueryRunner(DBUtil.getDataSource());
//        sql
        String sql = "select * from user";
//        执行sql
        return r.query(sql,new BeanListHandler<User>(User.class));
    }

//    删除用户
    public static void deleteUser(int id) throws SQLException {
//        拿到执行者对象
        QueryRunner r =new QueryRunner(DBUtil.getDataSource());
//        sql
        String sql = "delete from user where id = ?";
//        执行sql
        r.update(sql,id);
    }

    //    修改用户信息
    public static void updateUser(User user) throws SQLException {
//        拿到执行者对象
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
//        sql
        String sql = "update user set password=?,name=?,phone=?,address=? where username=?";
        r.update(sql,user.getPassword(),user.getName(),user.getPhone(),user.getAddress(),user.getUsername());
    }

//    通过id查询用户
    public static User getUserById(int id) throws SQLException {
//        拿到执行者对象
        QueryRunner r =new QueryRunner(DBUtil.getDataSource());
//        sql
        String sql = "select * from user where id =?";
//        执行
        return r.query(sql,new BeanHandler<User>(User.class),id);
    }
}
