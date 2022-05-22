package web.servlet;

import domain.*;
import org.apache.commons.beanutils.BeanUtils;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/Sign_infServlet")
public class Sign_infServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPage = req.getParameter("currentPage");
        String rows = req.getParameter("rows");


        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "9";
        }
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        MyTeacher myTeacher = new MyTeacher();
        myTeacher = (MyTeacher) user;
        String id = ((MyTeacher) user).getId();
        UserServiceImpl userService = new UserServiceImpl();
        MyPageBean<MySign_inf> pb = userService.findUserByPage_signinf(currentPage, rows, id);

        req.setAttribute("pb", pb);

        req.getRequestDispatcher("/main.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
