package servlet;

import model.Flower;
import org.apache.commons.beanutils.BeanUtils;
import service.FlowerService;
import service.ManagerService;
import utils.UploadUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/add_flower")
@MultipartConfig
public class ManagerAddFlowerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Part part = req.getPart("photo");
//        获取文件名
        String path = UploadUtils.upload(part,req,resp);//调用工具类中的方法
        if(path==""){
            return;
        }

        Flower flower = new Flower();

        try {
            BeanUtils.copyProperties(flower,req.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        flower.setPath(path);

//        添加
        FlowerService.addFlower(flower);
        req.setAttribute("msg","添加成功");
        req.getRequestDispatcher("add_flower.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
