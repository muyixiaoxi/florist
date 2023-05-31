package servlet;

import model.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "UserRegisterServlet",urlPatterns = "/user_register")
public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        拿到前台数据 封装
        User user = new User();

        try {
            BeanUtils.copyProperties(user,req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        UserService uService = new UserService();
//        调用业务层 判断
        if(uService.register(user)){
            req.setAttribute("msg","注册成功，请登录");
            req.getRequestDispatcher("user_login.jsp").forward(req,resp);
        }else{
            req.setAttribute("msg","用户名存在");
            req.getRequestDispatcher("user_register.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
