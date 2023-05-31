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
import java.util.Map;

@WebServlet("/CartCutServlet")
public class CartCutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        从session域中获取cart对象
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Map<Flower,Integer> cart = (Map<Flower, Integer>) session.getAttribute("cart");

//        获取传入id
        int id = Integer.parseInt(req.getParameter("id"));
        Flower flower = null;
//        通过id查看是否存在该商品
        try {
            flower = FlowerDao.getFlowerById(id);
            if(flower!=null){
                CartService.cutGoods(user,flower);
            }
//            重定向到cart页面
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
