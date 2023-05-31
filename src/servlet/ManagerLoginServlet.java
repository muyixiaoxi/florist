package servlet;

import model.Manager;
import service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/manager_login")
public class ManagerLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //        接受请求 接受参数 username password
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        Manager manager = null;
        try {
           manager = ManagerService.login(name, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (manager == null) {
//            失败给出响应
            req.setAttribute("msg", "用户名或者密码错误，请重新登录");
            req.getRequestDispatcher("/user_login.jsp").forward(req, resp);
        } else {
//            成功给出响应
//            将manager ,存在会话中
            req.getSession().setAttribute("manager", manager);
            req.getRequestDispatcher("/manager_detail").forward(req, resp);
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
