package web.servlet;

import domain.MyPageBean;
import domain.MyStuCourseSign;
import domain.MyStudent;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/StuCourseSign")
public class StuCourseSign extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id_course = req.getParameter("id");
        String currentPage = req.getParameter("currentPage");
        String rows = req.getParameter("rows");
        req.setAttribute("temp_id", id_course);

        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "9";
        }
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        MyStudent student = (MyStudent) user;
        String stuid = student.getId();
        UserServiceImpl userService = new UserServiceImpl();
        MyPageBean<MyStuCourseSign> pb = userService.findStuCourseSign(currentPage, rows, stuid, id_course);
        req.setAttribute("pb", pb);

        req.getRequestDispatcher("/tab_stuCourseSign.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
