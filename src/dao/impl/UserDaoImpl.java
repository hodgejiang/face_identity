package dao.impl;


import com.mysql.jdbc.Statement;
import dao.UserDao;
import domain.*;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import util.JDBC_Utils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBC_Utils.getDataSource());

    @Override
    public List<MySignCount_inf> findSign_count() {

        String sql = "select\n" +
                "  `signin`.`CourseID` AS `courseID`,\n" +
                "  count(`signin`.`CourseID`) AS `coursecount`\n" +
                "from `signin`\n" +
                "group by `signin`.`CourseID`\n";
        List<MySignCount_inf> mySignCount_infs = template.query(sql, new BeanPropertyRowMapper<MySignCount_inf>(MySignCount_inf.class));


        return mySignCount_infs;
    }

    @Override
    public List<MyStu_inf> findStu_inf() {

        String sql = "SELECT\n" +
                "  `student`.`ID`         AS `stuId`,\n" +
                "  `student`.`Name`       AS `stuName`,\n" +
                "  `student`.`stuCollege` AS `stuCollege`,\n" +
                "  `student`.`PicID`      AS `stuPic`,\n" +
                "  `student`.`StuPhone`   AS `StuPhone`,\n" +
                "  `class`.`ClassName`    AS `className`\n" +
                "FROM `student`\n" +
                "   LEFT JOIN `class`\n" +
                "     ON `student`.`ClassID` = `class`.`ClassID`\n" +
                "\n";
        List<MyStu_inf> myStu_infs = template.query(sql, new BeanPropertyRowMapper<MyStu_inf>(MyStu_inf.class));

        return myStu_infs;
    }

    @Override
    public List<MyCourse_inf> findAll() {
        //使用JDBC操作数据库
        String sql = "select\n" +
                "`course`.`CourseID`   AS `courseID`,\n" +
                "  `course`.`CourseName` AS `courseName`,\n" +
                "  `teacher`.`Name`      AS `teaName`,\n" +
                "  `course`.`className`  AS `className`,\n" +
                "  `course`.`Term`       AS `term`,\n" +
                "  `course`.`ClassNum`   AS `classNum`,\n" +
                "  `course`.`courseTime` AS `courseTime`\n" +
                "from `course`\n" +
                "   left join `teacher`\n" +
                "     on `course`.`TeaID` = `teacher`.`ID`\n";
        List<MyCourse_inf> course_inf = template.query(sql, new BeanPropertyRowMapper<MyCourse_inf>(MyCourse_inf.class));

        return course_inf;
    }

    @Override
    public MyStudent findUserByUsernameAndPassword_stu(String userid, String password) {
        try {
            String sql = "select * from student where ID = ? and Pwd = ?";
            MyStudent user = template.queryForObject(sql, new BeanPropertyRowMapper<MyStudent>(MyStudent.class), userid, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public MyTeacher findUserByUsernameAndPassword_tea(String userid, String password) {
        try {
            String sql = "select * from teacher where ID = ? and Pwd = ?";
            MyTeacher user = template.queryForObject(sql, new BeanPropertyRowMapper<MyTeacher>(MyTeacher.class), userid, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public MyTeacher findMyTeacherPwd(String userid, String changePwd) {
        try {
            String sql = "update teacher set Pwd = ? where ID = ?";
            template.update(sql, changePwd, userid);

            MyTeacher myTeacher = new MyTeacher();
            return myTeacher;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public MyStudent findMyStudentPwd(String userid, String changePwd) {
        try {
            String sql = "update student set Pwd = ? where ID = ?";
            template.update(sql, changePwd, userid);

            MyStudent myStudent = new MyStudent();
            return myStudent;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void addCourse(MyCourse myCourse) {
        String sql = "insert into course values(null,?,?,?,?,?,?)";
        template.update(sql, myCourse.getCourseName(), myCourse.getTeaID(), myCourse.getClassName(), myCourse.getTerm(), myCourse.getClassNum(), myCourse.getCourseTime());

    }

    @Override
    public void deleteCourse(int courseID) {
        String sql = "delete from course where CourseID = ?";
        template.update(sql, courseID);

    }

    @Override
    public void deleteCourseSign(int courseID) {
        String sql_ = "delete from sign_stuinf where courseID = ?";
        template.update(sql_, courseID);

    }

    @Override
    public void updateCourse(MyCourse myCourse, int id) {

        String sql = "update course set CourseName = ?, courseTime = ?,classNum = ?, className = ?,Term = ? where CourseID = ?";
        template.update(sql, myCourse.getCourseName(), myCourse.getCourseTime(), myCourse.getClassNum(), myCourse.getClassName(), myCourse.getTerm(), id);
    }

    @Override
    public int findAll_course(String id) {
        String sql = "select count(*) from course where TeaID = ?";

        return template.queryForObject(sql, Integer.class, id);
    }

    @Override
    public List<MyCourse_inf> findBypage(int start, int rows, String id) {
        String sql = "SELECT\n" +
                "  `course`.`CourseID`   AS `courseID`,\n" +
                "  `course`.`CourseName` AS `courseName`,\n" +
                "  `teacher`.`Name`      AS `teaName`,\n" +
                "  `course`.`className`  AS `className`,\n" +
                "  `course`.`Term`       AS `term`,\n" +
                "  `course`.`ClassNum`   AS `classNum`,\n" +
                "  `course`.`courseTime` AS `courseTime`\n" +
                "FROM `course`\n" +
                "   LEFT JOIN `teacher`\n" +
                "     ON `course`.`TeaID` = `teacher`.`ID` where TeaID = ? LIMIT ?,?\n";

        return template.query(sql, new BeanPropertyRowMapper<MyCourse_inf>(MyCourse_inf.class), id, start, rows);
    }

    @Override
    public List<MySign_inf> findBypage_signinf(int start, int rows, String id) {
        String sql = "SELECT\n" +

                "`signin`.`CourseID` AS `courseID`,\n " +
                "  `signin`.`signiNum`   AS `signID`,\n" +
                "  `course`.`CourseName` AS `courseName`,\n" +
                "  `course`.`className`  AS `className`,\n" +
                "  `signin`.`signinTime` AS `signinTime`,\n" +
                "  `course`.`ClassNum`   AS `classNum`,\n" +
                "  `signin`.`sign_pic`   AS `sign_pic`\n" +
                "FROM `signin`\n" +
                "   LEFT JOIN `course`  \n" +
                "     ON `signin`.`CourseID` = `course`.`CourseID` where TeaID = ? order by signID desc  limit ?,?";

        return template.query(sql, new BeanPropertyRowMapper<MySign_inf>(MySign_inf.class), id, start, rows);
    }

    @Override
    public int findAll_signinf(String id) {
        String sql = "\n" +
                "SELECT COUNT(*) FROM\n" +
                "(SELECT \n" +
                "`signin`.`CourseID` AS `courseID`,\n " +
                "  `signin`.`signiNum`   AS `signID`,\n" +
                "  `course`.`CourseName` AS `courseName`,\n" +
                "  `course`.`className`  AS `className`,\n" +
                "  `signin`.`signinTime` AS `signinTime`,\n" +
                "  `course`.`ClassNum`   AS `classNum`,\n" +
                "  `signin`.`sign_pic`   AS `sign_pic`\n" +
                "FROM `signin`\n" +
                "   LEFT JOIN `course`\n" +
                "     ON `signin`.`CourseID` = `course`.`CourseID`\n" +
                "WHERE `course`.`TeaID` = ? \n" +
                "ORDER BY `signID` DESC\n" +
                ")AS total\n";

        return template.queryForObject(sql, Integer.class, id);
    }

    @Override
    public void deleteSign_inf(int id) {
        String sql = "delete from signin where signiNum = ?";
        template.update(sql, id);
    }

    @Override
    public List<MySign_inf> findBypage_signinfSame(int start, int rows, int courseID, String teaid) {
        String sql = "\n" +
                "SELECT\n" +
                "`signin`.`CourseID` AS `courseID`,\n " +
                " `signin`.`signiNum`   AS `signID`,\n" +
                "  `course`.`CourseName` AS `courseName`,\n" +
                "  `course`.`className`  AS `className`,\n" +
                "  `signin`.`signinTime` AS `signinTime`,\n" +
                "  `course`.`ClassNum`   AS `classNum`,\n" +
                "  `signin`.`sign_pic`   AS `sign_pic`\n" +
                "FROM `signin`\n" +
                "   LEFT JOIN `course`\n" +
                "     ON `signin`.`CourseID` = `course`.`CourseID` \n" +
                "     WHERE `course`.`TeaID` = ? AND `signin`.`CourseID` =?\n order by signID desc  limit ?,?";

        return template.query(sql, new BeanPropertyRowMapper<MySign_inf>(MySign_inf.class), teaid, courseID, start, rows);
    }

    @Override
    public int findAll_signinfSame(String id, int courseID) {
        String sql = "\n" +
                "SELECT COUNT(*) FROM\n" +
                "(SELECT \n" +
                "  `signin`.`signiNum`   AS `signID`,\n" +
                "  `course`.`CourseName` AS `courseName`,\n" +
                "  `course`.`className`  AS `className`,\n" +
                "  `signin`.`signinTime` AS `signinTime`,\n" +
                "  `course`.`ClassNum`   AS `classNum`,\n" +
                "  `signin`.`sign_pic`   AS `sign_pic`\n" +
                "FROM `signin`\n" +
                "   LEFT JOIN `course`\n" +
                "     ON `signin`.`CourseID` = `course`.`CourseID`\n" +
                "WHERE `course`.`TeaID` = ? and `signin`.`CourseID`= ? \n" +
                "ORDER BY `signID` DESC\n" +
                ")AS total\n";
        return template.queryForObject(sql, Integer.class, id, courseID);
    }

    @Override
    public int findAll_stuSign(int id) {
        String sql = "SELECT COUNT(*) FROM\n" +
                "(SELECT sign_stuinf.`studentID`,student.`Name`,course.`className`,course.`Term`,course.`CourseID`,course.`CourseName`,sign_stuinf.`is_sign`\n" +
                "FROM sign_stuinf \n" +
                "LEFT JOIN course \n" +
                "ON sign_stuinf.`courseID`=course.`CourseID` \n" +
                "LEFT JOIN student\n" +
                "ON sign_stuinf.`studentID`=student.`ID` WHERE sign_stuinf.`signiNum`=?) AS total";

        return template.queryForObject(sql, Integer.class, id);
    }

    @Override
    public List<MyStuSign_inf> findBypage_stusign_inf(int start, int rows, int id) {
        String sql = " select\n" +
                "`sign_stuinf`.`faceGrades` AS `faceGrades`," +
                "`sign_stuinf`.`signiNum` AS  `signiNum`,\n   " +
                "`sign_stuinf`.`sign_infID` AS  `sign_infID`,\n" +
                "  `sign_stuinf`.`studentID` AS `studentID`,\n" +
                "  `student`.`Name`          AS `Name`,\n" +
                "  `course`.`className`      AS `className`,\n" +
                "  `course`.`Term`           AS `Term`,\n" +
                "  `course`.`CourseID`       AS `courseID`,\n" +
                "  `course`.`CourseName`     AS `CourseName`,\n" +
                "  `sign_stuinf`.`is_sign`   AS `is_sign`\n" +
                "from `sign_stuinf`\n" +
                "    left join `course`\n" +
                "      on `sign_stuinf`.`courseID` = `course`.`CourseID`\n" +
                "   left join `student`\n" +
                "     on `sign_stuinf`.`studentID` = `student`.`ID`\n" +
                "WHERE  sign_stuinf.`signiNum` = ? limit ?,?";


        return template.query(sql, new BeanPropertyRowMapper<MyStuSign_inf>(MyStuSign_inf.class), id, start, rows);
    }

    @Override
    public void updateStusign_inf(int id, String is_sign, String stuID) {
        if (is_sign.equals("已到")) {
            String sql = "update sign_stuinf set is_sign = '未到' where signiNum = ? and studentID = ?";
            template.update(sql, id, stuID);

        }
        if (is_sign.equals("未到")) {
            String sql = "update sign_stuinf set is_sign = '已到' where signiNum = ? and studentID = ?";
            template.update(sql, id, stuID);

        }

    }

    @Override
    public List<MyStuSign_count> findStuSign_count(int courseID) {
        String sql = "SELECT sign_stuinf.`studentID` AS studentID,COUNT(signiNum) AS signiNum\n" +
                "FROM sign_stuinf WHERE sign_stuinf.`courseID`= ? and sign_stuinf.`is_sign`='已到'\n" +
                "GROUP BY sign_stuinf.`studentID`";

        List<MyStuSign_count> mySignCount_infs = template.query(sql, new BeanPropertyRowMapper<MyStuSign_count>(MyStuSign_count.class), courseID);
        return mySignCount_infs;
    }

    @Override
    public int insertSignin(int courseID, String datetime) {
        String sql = "INSERT INTO signin (signiNum,signinTime,CourseID) VALUES (NULL,?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        int temp = template.update(new PreparedStatementCreator() {

            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                ps.setString(1, datetime);
                ps.setInt(2, courseID);


                return ps;

            }

        }, keyHolder);

        int id = 0;
        if (temp > 0) {

            id = keyHolder.getKey().intValue();

        }
        return id;
    }

    @Override
    public List<MyStuSign_inf> findstuID_courseID(int courseID) {
        String sql = "SELECT StuID AS studentID, courseID AS courseID\n" +
                "FROM c_s\n" +
                "WHERE CourseID =?";

        List<MyStuSign_inf> MyStuSign_inf = template.query(sql, new BeanPropertyRowMapper<MyStuSign_inf>(MyStuSign_inf.class), courseID);

        return MyStuSign_inf;
    }

    @Override
    public void insertSign_stuinf(MyStuSign_inf myStuSign_inf) {

        String sql = "INSERT INTO sign_stuinf (courseID,is_sign,studentID,signiNum,faceGrades) VALUES (?,?,?,?,?)";

        template.update(sql, myStuSign_inf.getCourseID(), myStuSign_inf.getIs_sign(), myStuSign_inf.getStudentID(), myStuSign_inf.getSigniNum(), myStuSign_inf.getFaceGrades());

    }

    @Override
    public void insert_photopath(String photo_path, int signiNum) {
        String sql = "update signin set sign_pic = ? where signiNum = ? ";
        template.update(sql, photo_path, signiNum);
    }

    @Override
    public int findAll_Stu_course(String stuID) {
        String sql = "SELECT COUNT(*) FROM (SELECT  c_s.`StuID` AS stuID,course.`CourseID` AS courseID,course.`CourseName` AS courseName,teacher.`Name` AS teaName,course.`className` AS className,course.`Term` AS term ,course.`ClassNum` AS classNum,course.`courseTime` AS courseTime\n" +
                "FROM course\n" +
                "LEFT JOIN c_s\n" +
                "ON c_s.`CourseID` = course.`CourseID`\n" +
                "LEFT JOIN teacher\n" +
                "ON teacher.`ID` = course.`TeaID`\n" +
                "WHERE Stuid = ?) AS total";

        return template.queryForObject(sql, Integer.class, stuID);


    }

    @Override
    public List<MyStu_Course> findBypage_stuCourse(int start, int rows, String stuID) {
        String sql = "SELECT  c_s.`StuID` AS stuID,course.`CourseID` AS courseID,course.`CourseName` AS courseName,teacher.`Name` AS teaName,course.`className` AS className,course.`Term` AS term ,course.`ClassNum` AS classNum,course.`courseTime` AS courseTime\n" +
                "FROM course\n" +
                "LEFT JOIN c_s\n" +
                "ON c_s.`CourseID` = course.`CourseID`\n" +
                "LEFT JOIN teacher\n" +
                "ON teacher.`ID` = course.`TeaID`\n" +
                "WHERE Stuid = ? limit ?,?";

        List<MyStu_Course> query = template.query(sql, new BeanPropertyRowMapper<MyStu_Course>(MyStu_Course.class), stuID, start, rows);
        return query;
    }

    @Override
    public int findAll_stu_courseSign(String stuID, int courseId) {

        String sql = "SELECT COUNT(*) FROM (SELECT signin.`signinTime`,sign_stuinf.`faceGrades`,sign_stuinf.`is_sign`,sign_stuinf.`studentID`,sign_stuinf.`courseID`\n" +
                "FROM signin\n" +
                "LEFT JOIN sign_stuinf\n" +
                "ON sign_stuinf.`signiNum` = signin.`signiNum`\n" +
                "WHERE studentID = ? AND sign_stuinf.`courseID`= ? ) AS total";

        return template.queryForObject(sql, Integer.class, stuID, courseId);

    }

    @Override
    public List<MyStuCourseSign> findBypage_StuCoursesign(int start, int rows, String stuID, int courseId) {
        String sql = "SELECT signin.`signinTime`,sign_stuinf.`faceGrades`,sign_stuinf.`is_sign`,sign_stuinf.`studentID`,sign_stuinf.`courseID`\n" +
                "FROM signin\n" +
                "LEFT JOIN sign_stuinf\n" +
                "ON sign_stuinf.`signiNum` = signin.`signiNum`\n" +
                "WHERE studentID = ? AND sign_stuinf.`courseID`=? limit ?,?";

        List<MyStuCourseSign> query = template.query(sql, new BeanPropertyRowMapper<MyStuCourseSign>(MyStuCourseSign.class), stuID, courseId, start, rows);
        return query;

    }


}
