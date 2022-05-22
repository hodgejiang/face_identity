package web.servlet;

import domain.MyStudent;
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

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //2.获取数据
        //2.1获取用户填写验证码
        String verifycode = request.getParameter("verifycode");

        //3.验证码校验
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证码一次性
        if (!checkcode_server.equalsIgnoreCase(verifycode)) {
            //验证码不正确
            //提示信息
            request.setAttribute("login_msg", "验证码错误！");
            //跳转登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);

            return;
        }


        String is_id = request.getParameter("RadioGroup1");
        if ("0".equals(is_id)) {
            Map<String, String[]> map = request.getParameterMap();

            MyTeacher user = new MyTeacher();
            try {
                BeanUtils.populate(user, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }


            //5.调用Service查询
            UserService service = new UserServiceImpl();
            MyTeacher loginUser = service.login_tea(user);
            //6.判断是否登录成功
            if (loginUser != null) {
                //登录成功
                //将用户存入session
                session.setAttribute("user", loginUser);
                //跳转页面
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else {
                //登录失败
                //提示信息
                request.setAttribute("login_msg", "用户名或密码错误！");
                //跳转登录页面
                request.getRequestDispatcher("/login.jsp").forward(request, response);

            }

        }

        if ("1".equals(is_id)) {
            Map<String, String[]> map = request.getParameterMap();

            MyStudent user = new MyStudent();
            try {
                BeanUtils.populate(user, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }


            //5.调用Service查询
            UserService service = new UserServiceImpl();
            MyStudent loginUser = service.login_stu(user);
            //6.判断是否登录成功
            if (loginUser != null) {
                //登录成功
                //将用户存入session
                session.setAttribute("user", loginUser);
                //跳转页面
                response.sendRedirect(request.getContextPath() + "/Sindex.jsp");
            } else {
                //登录失败
                //提示信息
                request.setAttribute("login_msg", "用户名或密码错误！");
                //跳转登录页面
                request.getRequestDispatcher("/login.jsp").forward(request, response);

            }

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
