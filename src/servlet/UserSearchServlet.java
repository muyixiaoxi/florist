package servlet;

import model.Manager;
import service.FlowerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/user_search")
public class UserSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取req域中flowerName
        String flowerName= req.getParameter("flowerName");



            try {
                //       判断flowerName是否为空
                if(flowerName.trim().equals("")||flowerName==null){
                    resp.sendRedirect("/goods_detail");
                    return;
                }else{
                    req.setAttribute("goods" , FlowerService.getSearchFlower(flowerName));
                    req.getRequestDispatcher("/goods_detail.jsp").forward(req,resp);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
