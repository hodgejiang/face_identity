package domain;

public class MyStuCourseSign {
    private String signinTime;
    private String faceGrades;
    private String is_sign;
    private String studentID;
    private String courseID;

    public String getSigninTime() {
        return signinTime;
    }

    public void setSigninTime(String signinTime) {
        this.signinTime = signinTime;
    }

    public String getFaceGrades() {
        return faceGrades;
    }

    public void setFaceGrades(String faceGrades) {
        this.faceGrades = faceGrades;
    }

    public String getIs_sign() {
        return is_sign;
    }

    public void setIs_sign(String is_sign) {
        this.is_sign = is_sign;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
}
