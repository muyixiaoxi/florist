package dao;

import model.Flower;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBUtil;

import java.sql.SQLException;
import java.util.List;

public class FlowerDao {

//    获取全部花
    public static List<Flower> getAll() throws SQLException {
//        拿到执行者对象
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
//        sql
        String sql = "select * from flowers";
//        执行
        return r.query(sql,new BeanListHandler<Flower>(Flower.class));

   }

//   通过id查询花
    public static Flower getFlowerById(int id) throws SQLException {
//        拿到执行者对象
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
//        sql
        String sql = "select * from flowers where id=?  ";
//        执行
        return r.query(sql,new BeanHandler<Flower>(Flower.class),id);
    }

//    模糊查询
    public static List<Flower> getSearchFlower(String name) throws SQLException {
//        拿到执行者对象
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
//        sql
        String sql = "select * from flowers where name like ?";
//        执行
        return r.query(sql,new BeanListHandler<Flower>(Flower.class),"%"+name+"%");
    }

//    删除花
    public static void deleteFlower(int id) throws SQLException {
//        拿到执行者对象
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
//        sql
        String sql = "delete from flowers where id=?";
//        执行
        r.update(sql,id);
    }


//    修改flower 信息
    public static void updateFlower(Flower flower) throws SQLException {
//        拿到执行者对象
        QueryRunner r =new QueryRunner(DBUtil.getDataSource());
//        sql
        String sql = null;
        if(flower.getPath()!=null){
            sql = "update flowers set price=?,kind=?,path=? where id=?";
            //        执行
            r.update(sql,flower.getPrice(),flower.getKind(),flower.getPath(),flower.getId());
        }else{
            sql = "update flowers set price=?,kind=? where id=?";
            //        执行
            r.update(sql,flower.getPrice(),flower.getKind(),flower.getId());
        }

    }

//    新建花朵
    public static void addFlower(Flower flower) throws SQLException {
//        拿到执行者对象
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
//        sql
        String sql = "insert into flowers (name,price,kind,path) values(?,?,?,?)";
        r.update(sql,flower.getName(),flower.getPrice(),flower.getKind(),flower.getPath());
    }
}
