package service;

import dao.FlowerDao;
import model.Flower;

import java.sql.SQLException;
import java.util.List;

public class FlowerService {

//    加载页面时，获取全部商品列表展示
    public static List<Flower> getGoodsList(){
        List <Flower> list = null;
        try {
            list= FlowerDao.getAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    //    查询业务
    public static List<Flower> getSearchFlower(String name) throws SQLException {
        return FlowerDao.getSearchFlower(name);
    }

//    删除业务
    public static void deleteFlower(int id){
        try {
//            id存在
            if(FlowerDao.getFlowerById(id)!=null){
//                删除
                FlowerDao.deleteFlower(id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

//    修改花
    public static void updateFlower(Flower flower){

        try {
//                更新
            FlowerDao.updateFlower(flower);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

//    添加
    public static void addFlower(Flower flower){
        try {
            FlowerDao.addFlower(flower);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
