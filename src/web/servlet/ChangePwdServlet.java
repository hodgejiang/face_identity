package web.servlet;

import domain.MyStudent;
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

@WebServlet("/ChangePwdServlet")
public class ChangePwdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String changePwd = req.getParameter("changePwd");
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        if (user instanceof MyTeacher) {
            UserService service = new UserServiceImpl();

            MyTeacher user_t = service.findUser_t((MyTeacher) user, changePwd);
            if (user_t != null) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
        } else {
            UserService service = new UserServiceImpl();
            MyStudent user_s = service.findUser_s((MyStudent) user, changePwd);
            if (user_s != null) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
