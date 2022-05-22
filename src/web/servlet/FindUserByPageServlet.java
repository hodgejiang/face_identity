package web.servlet;

import domain.MyCourse_inf;
import domain.MyPageBean;
import domain.MyTeacher;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/FindUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {

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
        MyPageBean<MyCourse_inf> pb = userService.findUserByPage(currentPage, rows, id);

        req.setAttribute("pb", pb);

        req.getRequestDispatcher("/tab_c.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
