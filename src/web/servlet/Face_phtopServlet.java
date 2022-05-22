package web.servlet;

import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Face_photoServlet")
public class Face_phtopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SmartUpload su = new SmartUpload();
        String courseID = req.getParameter("courseID");
        String photo_path = "";
        su.initialize(getServletConfig(), req, resp);
        int j = 0;
        try {
            su.upload();//获取要上传的文件
            su.setAllowedFilesList("jpg,png,gif,jpeg");
            String path = getServletContext().getRealPath("/sign_photo");
            UserServiceImpl userService = new UserServiceImpl();
            j = userService.insertSign_inf(courseID);
            Files files = su.getFiles();
            com.jspsmart.upload.File file1;
            for (int i = 0; i < files.getCount(); i++) {
                file1 = files.getFile(i);
                String fileExt = file1.getFileExt();//图片后缀名
                file1.saveAs(path + "/" + j + "." + fileExt);
                photo_path = path + "/" + j + "." + fileExt;
            }
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/Face_identity?photo_ID=" + photo_path + "&signiNum=" + j).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
