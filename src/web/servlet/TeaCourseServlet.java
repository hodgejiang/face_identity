package web.servlet;

import domain.MyCourse_inf;
import domain.MySignCount_inf;
import domain.MyTeacher;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/TeaCourseServlet")
public class TeaCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        UserService service = new UserServiceImpl();
        List<MyCourse_inf> course_inf = service.findAll();
        List<MySignCount_inf> signCount_infs = service.findSign_count();
        List<MyCourse_inf> myCourse_infs = new ArrayList<>();
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        MyTeacher myTeacher = new MyTeacher();
        myTeacher = (MyTeacher) user;
        for (MyCourse_inf myCourse_inf : course_inf) {
            if (myTeacher.getName().equals(myCourse_inf.getTeaName())) {
                myCourse_infs.add(myCourse_inf);
            }
        }

        for (MySignCount_inf signCount_inf : signCount_infs) {
            for (MyCourse_inf myCourse_inf : myCourse_infs) {
                if (signCount_inf.getCourseID() == myCourse_inf.getCourseID()) {
                    myCourse_inf.setCourseCount(signCount_inf.getCoursecount());
                }
            }
        }
        request.setAttribute("course_infs", myCourse_infs);


        response.sendRedirect(request.getContextPath() + "/tab_c.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
