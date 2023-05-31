package servlet;

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

@WebServlet(name = "CartServlet",urlPatterns = "/goods_cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        从session域中取出 cart 对象
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");

//        用户为空，重定向到登录页面
        if(user == null){
            resp.sendRedirect("user_login.jsp");
            return;
        }

        try {
            session.setAttribute("cart", CartService.getUserCart(user));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Map<Flower,Integer> cart = (HashMap<Flower,Integer>) session.getAttribute("cart");

//        判断购物车是否为空
        if(cart.isEmpty()){
//
//            为空，重定向到蛋糕展示列表
            resp.sendRedirect("goods_detail.jsp");
        }else{
//            不为空，转发到goods_cart.jsp
            req.getRequestDispatcher("goods_cart.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
