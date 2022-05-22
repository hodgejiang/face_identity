package service;

import com.baidu.aip.face.AipFace;
import domain.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     *
     * @return
     */
    public void addCourse(MyCourse myCourse);

    public List<MySignCount_inf> findSign_count();

    public List<MyStu_inf> findStu_inf();

    public List<MyCourse_inf> findAll();

    public MyTeacher login_tea(MyTeacher user);

    public MyStudent login_stu(MyStudent user);

    public MyTeacher findUser_t(MyTeacher myTeacher, String pwd);

    public MyStudent findUser_s(MyStudent myStudent, String pwd);

    public void deleteCourse(String id);

    public void updateCourse(MyCourse myCourse, String id);

    MyPageBean<MyCourse_inf> findUserByPage(String currentPage, String rows, String id);

    MyPageBean<MyStu_Course> findStu_CoursePage(String currentPage, String rows, String stuID);

    MyPageBean<MySign_inf> findUserByPage_signinf(String currentPage, String rows, String id);

    MyPageBean<MyStuCourseSign> findStuCourseSign(String currentPage, String rows, String stuID, String courseID);

    void deleteSign_inf(String id);

    MyPageBean<MySign_inf> findUserByPage_signinfSame(String currentPage, String rows, String courseID, String id);

    MyPageBean<MyStuSign_inf> findUserByPage_stusign_inf(String currentPage, String rows, String id, String courseID);

    void updateStusign_inf(String id, String is_sign, String stuI);

    int insertSign_inf(String courseID);

    void insertSign_stuinf(List<MyStuSign_inf> list);

    void insertPhoto_path(String photo_path, int signiNum);

    public List<MyFace_Identity> faceIdentity(AipFace client, String facePhotoPath);


}
