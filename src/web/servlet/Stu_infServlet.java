package web.servlet;

import domain.MyCourse_inf;
import domain.MyStu_inf;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/Stu_infServlet")
public class Stu_infServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String stuId = req.getParameter("stuId");
        UserService service = new UserServiceImpl();
        List<MyStu_inf> findStu_inf = service.findStu_inf();

        for (MyStu_inf myStu_inf : findStu_inf) {
            if (myStu_inf.getStuId().equals(stuId)) {
                req.setAttribute("findStu_infs", myStu_inf);
                break;
            }
        }


        req.getRequestDispatcher("/Sp1.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
