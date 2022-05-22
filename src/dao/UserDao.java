package dao;

import domain.*;

import java.util.List;

/**
 * 用户操作的Dao
 */
public interface UserDao {
    List<MySignCount_inf> findSign_count();

    List<MyStu_inf> findStu_inf();

    List<MyCourse_inf> findAll();

    MyStudent findUserByUsernameAndPassword_stu(String userid, String password);

    MyTeacher findUserByUsernameAndPassword_tea(String userid, String password);

    MyTeacher findMyTeacherPwd(String userid, String changePwd);

    MyStudent findMyStudentPwd(String userid, String changePwd);

    void addCourse(MyCourse myCourse);

    void deleteCourse(int parseInt);

    void updateCourse(MyCourse course, int parseInt);

    int findAll_course(String id);

    List<MyCourse_inf> findBypage(int start, int rows, String id);

    List<MySign_inf> findBypage_signinf(int start, int rows, String id);

    int findAll_signinf(String id);

    void deleteSign_inf(int parseInt);

    List<MySign_inf> findBypage_signinfSame(int start, int rows, int courseID, String id);

    int findAll_signinfSame(String id, int courseID);

    int findAll_stuSign(int id);

    List<MyStuSign_inf> findBypage_stusign_inf(int start, int rows, int id);

    void updateStusign_inf(int id, String is_sign, String StuID);

    List<MyStuSign_count> findStuSign_count(int courseID);

    int insertSignin(int courseID, String datetime);

    List<MyStuSign_inf> findstuID_courseID(int courseID);

    void insertSign_stuinf(MyStuSign_inf myStuSign_inf);

    void insert_photopath(String photo_path, int signiNum);

    int findAll_Stu_course(String stuID);

    List<MyStu_Course> findBypage_stuCourse(int start, int rows, String stuID);

    int findAll_stu_courseSign(String stuID, int courseId);

    List<MyStuCourseSign> findBypage_StuCoursesign(int start, int rows, String stuID, int courseId);

    public void deleteCourseSign(int courseID);
}
