package web.servlet;

import domain.MyCourse;
import org.apache.commons.beanutils.BeanUtils;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/UpdateStu_inf")
public class UpdateStu_inf extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String is_sign = req.getParameter("is_sign");
        String stuID = req.getParameter("stuID");
        String ID = req.getParameter("id");
        String courseID = req.getParameter("courseID");
        UserServiceImpl userService = new UserServiceImpl();
        userService.updateStusign_inf(ID, is_sign, stuID);
        req.getRequestDispatcher("/StuSign_inf?id=" + ID + "&currentPage=1&rows=9").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
