package dao;

import model.Flower;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DBUtil;

import javax.management.Query;
import java.nio.channels.FileLock;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class CartDao {

    //    获取与用户匹配的  flower_id flower_count 集合
    public static List<Integer> getFlowerId(int user_id) throws SQLException {
//        拿到执行者对象
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
//        sql
        String sql = "select flower_id from cart where user_id= ?";
//        通过用户的id获取cart 中的 flower id
        return (List<Integer>) r.query(sql, new ColumnListHandler(),user_id);
    }

//    获取匹配用户的flower_count
    public static int getFlowerCount(int user_id,int flower_id) throws SQLException {
//        拿到执行者对象
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
//       sql
        String sql = "select flower_count from cart where user_id = ? and flower_id=?";
//        返回 flower_count;
        return (int) r.query(sql,new ScalarHandler(),user_id,flower_id);
    }

//    新建
    public static void addFlower(int user_id,int flower_id) throws SQLException {
//        拿到执行者对象
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
//        sql
        String sql = "insert into cart (user_id,flower_id,flower_count) values(?,?,?)";
//        执行
        r.update(sql,user_id,flower_id,1);
    }

//    修改数量
    public static void updateFlowerCount(int user_id , int flower_id, int flower_count) throws SQLException {
//        拿到执行者对象
        QueryRunner r =new QueryRunner(DBUtil.getDataSource());
//        sql
        String sql = "update cart set flower_count= ? where user_id=? and flower_id=?";
//        执行
        r.update(sql,flower_count,user_id,flower_id);
    }

//    删除flower
    public  static void deleteFLower(int user_id , int flower_id) throws SQLException {
//        拿到执行者对象
        QueryRunner r = new QueryRunner((DBUtil.getDataSource()));
//        sql
        String sql = "delete from cart where user_id=? and flower_id=?";
//        执行
        r.update(sql,user_id,flower_id);
    }

//    获取用户的所有flower
    public static List<Flower> getUserFlowers(int user_id) throws SQLException {
//        拿到执行者对象
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
//        sqlf
        String sql = "select id,name,price,kind,path from flowers,cart where id=flower_id and user_id=?";
//        执行
        return r.query(sql,new BeanListHandler<Flower>(Flower.class),user_id);
    }

//    判断flower是否存在
    public static boolean isFlowerExist(int user_id,int flower_id) throws SQLException {
//        拿到执行者对象
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
//        sql
        String sql = "select * from cart where user_id = ? and flower_id = ?";
//        执行
        Flower flower = r.query(sql,new BeanHandler<Flower>(Flower.class),user_id,flower_id);
        if (flower==null){
            return false;
        }else{
            return true;
        }
    }
}
