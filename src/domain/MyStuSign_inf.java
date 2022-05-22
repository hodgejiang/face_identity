package domain;

public class MyStuSign_inf {

    private String studentID;
    private String Name;
    private String className;
    private String Term;
    private int courseID;
    private String CourseName;
    private String is_sign;
    private String signCount = "0";
    private int sign_infID;
    private int signiNum;
    private int faceGrades;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public int getSign_infID() {
        return sign_infID;
    }

    public void setSign_infID(int sign_infID) {
        this.sign_infID = sign_infID;
    }

    public int getSigniNum() {
        return signiNum;
    }

    public void setSigniNum(int signiNum) {
        this.signiNum = signiNum;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String term) {
        Term = term;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getIs_sign() {
        return is_sign;
    }

    public void setIs_sign(String is_sign) {
        this.is_sign = is_sign;
    }

    public String getSignCount() {
        return signCount;
    }

    public void setSignCount(String signCount) {
        this.signCount = signCount;
    }

    public int getFaceGrades() {
        return faceGrades;
    }

    public void setFaceGrades(int faceGrades) {
        this.faceGrades = faceGrades;
    }
}
