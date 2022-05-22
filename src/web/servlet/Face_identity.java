package web.servlet;

import com.baidu.aip.face.AipFace;
import dao.impl.UserDaoImpl;
import domain.MyFace_Identity;
import domain.MyStuSign_inf;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Face_identity")
public class Face_identity extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseID = req.getParameter("courseID");
        String photo_id = req.getParameter("photo_ID");
        String signiNum = req.getParameter("signiNum");
        int i = Integer.parseInt(signiNum);
        UserServiceImpl userService = new UserServiceImpl();
        AipFace client = userService.client;
        List<MyFace_Identity> list = userService.faceIdentity(client, photo_id);
        UserDaoImpl userDao = new UserDaoImpl();
        int i1 = Integer.parseInt(courseID);
        List<MyStuSign_inf> myStuSign_infs = userDao.findstuID_courseID(i1);
        for (MyStuSign_inf myStuSign_inf : myStuSign_infs) {
            myStuSign_inf.setIs_sign("未到");
            myStuSign_inf.setSigniNum(i);
            myStuSign_inf.setCourseID(i1);
            myStuSign_inf.setFaceGrades(0);
        }
        for (MyStuSign_inf myStuSign_inf : myStuSign_infs) {
            for (MyFace_Identity myFace_identity : list) {
                if (myFace_identity.getStudentID().equals(myStuSign_inf.getStudentID())) {
                    myStuSign_inf.setIs_sign("已到");
                    myStuSign_inf.setFaceGrades(myFace_identity.getFaceGrades());
                }
            }
        }
        userService.insertSign_stuinf(myStuSign_infs);
        userService.insertPhoto_path(photo_id, i);

        req.getRequestDispatcher("/StuSign_inf?id=" + signiNum + "&courseID=" + courseID).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
