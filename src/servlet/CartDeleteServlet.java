package servlet;

import dao.FlowerDao;
import model.Flower;
import model.User;
import service.CartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/CartDeleteServlet")
public class CartDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        从session域中取出 cart对象
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Map<Flower,Integer> cart = (HashMap<Flower,Integer>) session.getAttribute("cart");

//        从req域中获取 flower
        Flower flower = null;

//        通过id查看是否有该商品
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            flower = FlowerDao.getFlowerById(id);
            if(flower != null){
//                如果不为空，调用函数
                CartService.deletGoods(user,flower);
            }
//            重定向到购物车页面
            resp.sendRedirect("goods_cart");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
