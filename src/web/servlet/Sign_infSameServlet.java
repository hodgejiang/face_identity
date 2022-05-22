package web.servlet;

import domain.MyPageBean;
import domain.MySign_inf;
import domain.MyTeacher;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Sign_infSameServlet")
public class Sign_infSameServlet extends HttpServlet {
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
        MyTeacher myTeacher = new MyTeacher();
        myTeacher = (MyTeacher) user;
        String id = ((MyTeacher) user).getId();
        UserServiceImpl userService = new UserServiceImpl();
        MyPageBean<MySign_inf> pb = userService.findUserByPage_signinfSame(currentPage, rows, id_course, id);

        req.setAttribute("pb", pb);
        req.setAttribute("courseID_", id_course);
        req.getRequestDispatcher("/tab_coursesign.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
