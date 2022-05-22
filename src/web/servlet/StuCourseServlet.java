package web.servlet;

import domain.MyPageBean;
import domain.MyStu_Course;
import domain.MyStudent;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/StuCourseServlet")
public class StuCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id_course = req.getParameter("id");
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
        MyStudent student = (MyStudent) user;
        String id = student.getId();
        UserServiceImpl userService = new UserServiceImpl();
        MyPageBean<MyStu_Course> pb = userService.findStu_CoursePage(currentPage, rows, id);

        req.setAttribute("pb", pb);

        req.getRequestDispatcher("/tab_stuCourse.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
