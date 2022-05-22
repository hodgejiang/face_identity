package service.impl;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.util.Base64Util;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.*;
import domain.MyStudent;
import org.json.JSONArray;
import org.json.JSONObject;
import service.UserService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserServiceImpl implements UserService {

    public static final String APP_ID = "25339482";
    public static final String API_KEY = "3niHe7Gvgy7VqnTwqDXTBfms";
    public static final String SECRET_KEY = "lkGMqfROGhLhtBd1tPG17Y628xQd8g8n";
    public AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

    private UserDao dao = new UserDaoImpl();

    public UserServiceImpl() {
        super();
    }

    @Override
    public void addCourse(MyCourse myCourse) {
        dao.addCourse(myCourse);
    }

    @Override
    public List<MySignCount_inf> findSign_count() {
        return dao.findSign_count();
    }

    @Override
    public List<MyStu_inf> findStu_inf() {
        return dao.findStu_inf();
    }

    @Override
    public List<MyCourse_inf> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }

    @Override
    public MyStudent login_stu(MyStudent student_user) {
        return dao.findUserByUsernameAndPassword_stu(student_user.getId(), student_user.getPwd());
    }

    @Override
    public MyTeacher login_tea(MyTeacher teacher_user) {
        return dao.findUserByUsernameAndPassword_tea(teacher_user.getId(), teacher_user.getPwd());
    }

    @Override
    public MyTeacher findUser_t(MyTeacher myTeacher, String pwd) {
        return dao.findMyTeacherPwd(myTeacher.getId(), pwd);
    }

    @Override
    public MyStudent findUser_s(MyStudent myStudent, String pwd) {
        return dao.findMyStudentPwd(myStudent.getId(), pwd);
    }

    @Override
    public void deleteCourse(String id) {
        dao.deleteCourse(Integer.parseInt(id));
        dao.deleteCourseSign(Integer.parseInt(id));
    }

    @Override
    public void updateCourse(MyCourse myCourse, String id) {
        dao.updateCourse(myCourse, Integer.parseInt(id));
    }

    @Override
    public MyPageBean<MyCourse_inf> findUserByPage(String _currentPage, String _rows, String id) {

        MyPageBean<MyCourse_inf> pb = new MyPageBean<MyCourse_inf>();
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        int totalCount = dao.findAll_course(id);
        pb.setTotalCount(totalCount);
        int start = (currentPage - 1) * rows;
        List<MyCourse_inf> list = dao.findBypage(start, rows, id);
        List<MySignCount_inf> sign_count = dao.findSign_count();
        for (MySignCount_inf mySignCount_inf : sign_count) {
            for (MyCourse_inf myCourse_inf : list) {
                if (myCourse_inf.getCourseID() == mySignCount_inf.getCourseID()) {
                    myCourse_inf.setCourseCount(mySignCount_inf.getCoursecount());
                }
            }
        }

        pb.setList(list);

        int totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public MyPageBean<MyStu_Course> findStu_CoursePage(String _currentPage, String _rows, String stuID) {

        MyPageBean<MyStu_Course> pb = new MyPageBean<MyStu_Course>();
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        int totalCount = dao.findAll_Stu_course(stuID);
        pb.setTotalCount(totalCount);
        int start = (currentPage - 1) * rows;
        List<MyStu_Course> list = dao.findBypage_stuCourse(start, rows, stuID);
        pb.setList(list);

        int totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public MyPageBean<MySign_inf> findUserByPage_signinf(String _currentPage, String _rows, String id) {
        MyPageBean<MySign_inf> pb = new MyPageBean<MySign_inf>();
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        int totalCount = dao.findAll_signinf(id);
        pb.setTotalCount(totalCount);
        int start = (currentPage - 1) * rows;
        List<MySign_inf> list = dao.findBypage_signinf(start, rows, id);
        pb.setList(list);

        int totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public MyPageBean<MyStuCourseSign> findStuCourseSign(String _currentPage, String _rows, String stuID, String courseID) {
        MyPageBean<MyStuCourseSign> pb = new MyPageBean<MyStuCourseSign>();
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        int courseId = Integer.parseInt(courseID);
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        int totalCount = dao.findAll_stu_courseSign(stuID, courseId);
        pb.setTotalCount(totalCount);
        int start = (currentPage - 1) * rows;
        List<MyStuCourseSign> list = dao.findBypage_StuCoursesign(start, rows, stuID, courseId);
        pb.setList(list);

        int totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public void deleteSign_inf(String id) {
        dao.deleteSign_inf(Integer.parseInt(id));
    }


    @Override
    public MyPageBean<MySign_inf> findUserByPage_signinfSame(String _currentPage, String _rows, String courseID, String id) {
        MyPageBean<MySign_inf> pb = new MyPageBean<MySign_inf>();
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        int courseId = Integer.parseInt(courseID);
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        int totalCount = dao.findAll_signinfSame(id, courseId);
        pb.setTotalCount(totalCount);
        int start = (currentPage - 1) * rows;
        List<MySign_inf> list = dao.findBypage_signinfSame(start, rows, courseId, id);
        pb.setList(list);

        int totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public MyPageBean<MyStuSign_inf> findUserByPage_stusign_inf(String _currentPage, String _rows, String id, String courseID) {
        MyPageBean<MyStuSign_inf> pb = new MyPageBean<MyStuSign_inf>();
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        int ID = Integer.parseInt(id);
        int courseId = Integer.parseInt(courseID);
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        int totalCount = dao.findAll_stuSign(ID);
        pb.setTotalCount(totalCount);
        int start = (currentPage - 1) * rows;
        List<MyStuSign_inf> list = dao.findBypage_stusign_inf(start, rows, ID);
        List<MyStuSign_count> stuSign_count = dao.findStuSign_count(courseId);
        for (MyStuSign_count myStuSign_count : stuSign_count) {
            for (MyStuSign_inf myStuSign_inf : list) {
                if (myStuSign_count.getStudentID().equals(myStuSign_inf.getStudentID())) {
                    myStuSign_inf.setSignCount(myStuSign_count.getSigniNum());
                }
            }
        }

        pb.setList(list);

        int totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public void updateStusign_inf(String id, String is_sign, String stuID) {
        int i = Integer.parseInt(id);
        dao.updateStusign_inf(i, is_sign, stuID);
    }

    @Override
    public int insertSign_inf(String courseID) {

        java.util.Date d = new java.util.Date();
        int i1 = Integer.parseInt(courseID);
        java.text.SimpleDateFormat dformat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = dformat.format(d);
        int i = dao.insertSignin(i1, datetime);//签到序号
        return i;
    }

    @Override
    public void insertSign_stuinf(List<MyStuSign_inf> list) {
        for (MyStuSign_inf myStuSign_inf : list) {
            dao.insertSign_stuinf(myStuSign_inf);
        }
    }

    @Override
    public void insertPhoto_path(String photo_path, int signiNum) {
        dao.insert_photopath(photo_path, signiNum);
    }

    @Override
    public List<MyFace_Identity> faceIdentity(AipFace client, String facePhotoPath) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("max_face_num", "10");
        options.put("match_threshold", "70");
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        options.put("max_user_num", "10");

        String path = facePhotoPath;
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String image = Base64Util.encode(bytes);
        String imageType = "BASE64";
        String groupIdList = "student_face";

        // 人脸搜索 M:N 识别

        JSONObject res = client.multiSearch(image, imageType, groupIdList, options);
        List<MyFace_Identity> list = new ArrayList<>();


        if (res.get("result") instanceof JSONObject) {
            JSONObject jsonObject = res.getJSONObject("result");
            JSONArray face_list = jsonObject.getJSONArray("face_list");
            for (Object o : face_list) {
                JSONObject user = (JSONObject) o;
                JSONArray jsonArray = user.getJSONArray("user_list");
                if (jsonArray.length() > 0) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(0);
                    double score = jsonObject1.getDouble("score");
                    int faceGrades = (int) score;
                    String studentID = jsonObject1.getString("user_id");
                    MyFace_Identity myFace_identity = new MyFace_Identity();
                    myFace_identity.setFaceGrades(faceGrades);
                    myFace_identity.setStudentID(studentID);
                    list.add(myFace_identity);
                }
            }


        }


        return list;
    }

}
