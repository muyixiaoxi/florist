package servlet;

import dao.CartDao;
import dao.UserDao;
import model.User;
import service.CartService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserLoginServlet", urlPatterns = "/user_login")
public class UserLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        判断用户是否已经登录
        HttpSession session = req.getSession();
        //        接受请求 接受参数 username password
        String username = req.getParameter("username");
        String password = req.getParameter("password");


//        调用业务层 login =>user
        User user = UserService.login(username, password);
        if (user == null) {
//            失败给出响应
            req.setAttribute("msg", "用户名或者密码错误，请重新登录");
            req.getRequestDispatcher("/user_login.jsp").forward(req, resp);
        } else {
//            成功给出响应
//            将账号密码存在会话中
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/goods_detail").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
