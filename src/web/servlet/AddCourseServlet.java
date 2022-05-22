package web.servlet;

import domain.MyCourse;
import domain.MyCourse_inf;
import domain.MyTeacher;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
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

@WebServlet("/AddCourseServlet")
public class AddCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String, String[]> map = req.getParameterMap();
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        MyTeacher myTeacher = new MyTeacher();
        myTeacher = (MyTeacher) user;
        String id = ((MyTeacher) user).getId();
        MyCourse myCourse = new MyCourse();

        try {
            BeanUtils.populate(myCourse, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        myCourse.setTeaID(myTeacher.getId());
        UserService service = new UserServiceImpl();
        service.addCourse(myCourse);

        resp.sendRedirect(req.getContextPath() + "/FindUserByPageServlet");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
