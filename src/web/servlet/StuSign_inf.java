package web.servlet;

import domain.MyPageBean;
import domain.MySign_inf;
import domain.MyStuSign_inf;
import domain.MyTeacher;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/StuSign_inf")
public class StuSign_inf extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id_sign = req.getParameter("id");
        String currentPage = req.getParameter("currentPage");
        String rows = req.getParameter("rows");
        String courseID = req.getParameter("courseID");


        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "9";
        }

        UserServiceImpl userService = new UserServiceImpl();
        MyPageBean<MyStuSign_inf> pb = userService.findUserByPage_stusign_inf(currentPage, rows, id_sign, courseID);

        req.setAttribute("pb", pb);

        req.getRequestDispatcher("/tab_stusign.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
