package domain;

import java.util.Date;

public class MySignin {
    private long signiNum;
    private Date signinTime;
    private String sininPer;
    private int CourseID;
    private String sign_pic;


    public MySignin() {

    }

    public long getSigniNum() {
        return signiNum;
    }

    public void setSigniNum(long signiNum) {
        this.signiNum = signiNum;
    }

    public Date getSigninTime() {
        return signinTime;
    }

    public void setSigninTime(Date signinTime) {
        this.signinTime = signinTime;
    }

    public String getSininPer() {
        return sininPer;
    }

    public void setSininPer(String sininPer) {
        this.sininPer = sininPer;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }

    public String getSign_pic() {
        return sign_pic;
    }

    public void setSign_pic(String sign_pic) {
        this.sign_pic = sign_pic;
    }
}
