package domain;

public class MyStu_inf {
    private String stuId;
    private String stuName;
    private String stuCollege;
    private String stuPic;
    private String StuPhone;
    private String className;

    public MyStu_inf() {

    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuCollege() {
        return stuCollege;
    }

    public void setStuCollege(String stuCollege) {
        this.stuCollege = stuCollege;
    }

    public String getStuPic() {
        return stuPic;
    }

    public void setStuPic(String stuPic) {
        this.stuPic = stuPic;
    }

    public String getStuPhone() {
        return StuPhone;
    }

    public void setStuPhone(String stuPhone) {
        StuPhone = stuPhone;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "MyStu_inf{" +
                "stuId='" + stuId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuCollege='" + stuCollege + '\'' +
                ", stuPic='" + stuPic + '\'' +
                ", StuPhone='" + StuPhone + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
