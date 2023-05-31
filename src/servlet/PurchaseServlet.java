package servlet;

import dao.FlowerDao;
import model.Flower;
import model.User;      
import service.CartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "PurchaseServlet",urlPatterns = "/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1、用户未登录，跳转登录页面
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
//            跳转
            req.setAttribute("msg", "请登录");
            req.getRequestDispatcher("/user_login.jsp").forward(req, resp);
        } else {
            Flower flower = null;
//            通过id查看是否有该商品
            int id = Integer.parseInt(req.getParameter("id"));
//            没有，则重定向到商品展示列表
            try {
                flower = FlowerDao.getFlowerById(id);
                if(flower == null){
                    resp.sendRedirect("goods_detail.jsp");
                    return;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

//            有，加入购物车
//            从session域中获取购物车
            HttpSession session = req.getSession();
//            购物车 就是一个Map集合
//            key:flower    value: count
            Map<Flower,Integer> cart=(Map) session.getAttribute("cart");
//            cart是否存在
//            不存在，创建购物车
            if(cart == null){
                cart = new HashMap<Flower,Integer>();
//                存在session域中
                session.setAttribute("cart",cart);
            }
//            无论存在与否，都要往购物车中，添加商品
            try {
                CartService.addGoods(user,flower);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Cookie cookie = new Cookie("JSESSIONID",session.getId());
//            将session对应的ID持久化30分钟，目的和session域中存储的对象持久的时间一致
            cookie.setMaxAge(60*30);
            cookie.setPath("/");
            resp.addCookie(cookie);

//            重定向到购物车页面中
            resp.sendRedirect("goods_cart");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
