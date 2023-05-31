package servlet;

import dao.FlowerDao;
import dao.UserDao;
import service.FlowerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/manager_action")
public class ManagerActionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取请求域对象
        int id = Integer.parseInt(req.getParameter("id"));
        //                设置请求域
        try {
            req.setAttribute("flower", FlowerDao.getFlowerById(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
//                转发
        req.getRequestDispatcher("update_flower.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
