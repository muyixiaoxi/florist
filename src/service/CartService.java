package service;

import dao.CartDao;
import model.Flower;
import model.User;
import utils.PriceUtil;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartService {


    //    增加
    public static void addGoods(User user, Flower flower) throws SQLException {
//        购物车中存在，数量加一
        if(CartDao.isFlowerExist(user.getId(),flower.getId())){
            CartDao.updateFlowerCount(user.getId(),flower.getId(),
                    CartDao.getFlowerCount(user.getId(),flower.getId())+1);
            return;
        }

        CartDao.addFlower(user.getId(), flower.getId());
    }

//    删除
    public static void deletGoods(User user,Flower flower) throws SQLException {
//        删除相应对象
        CartDao.deleteFLower(user.getId(),flower.getId());
    }
//    减一
    public static void cutGoods(User user,Flower flower) throws SQLException {
        int count =CartDao.getFlowerCount(user.getId(),flower.getId());
        if(count>1){
            CartDao.updateFlowerCount(user.getId(),flower.getId(),count-1);
        }
    }
//    总价
    public static double priceGoods(Map<Flower,Integer> cart){
        double price=0;
        for (Flower f:cart.keySet()
             ) {
            price = PriceUtil.add(price,Double.parseDouble(f.getPrice())*cart.get(f));
        }
        return price;
    }

//    购物车初始化
    public static Map<Flower,Integer> getUserCart(User user) throws SQLException {
//        创建map对象
        Map<Flower,Integer>cart=new HashMap<Flower,Integer>();
//        获取flower对象
        List<Flower> flowers= CartDao.getUserFlowers(user.getId());

        for (Flower f:flowers
             ) {
            cart.put(f,CartDao.getFlowerCount(user.getId(),f.getId()));
        }

        return cart;
    }
}
