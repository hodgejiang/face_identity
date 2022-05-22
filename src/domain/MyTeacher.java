package domain;

public class MyTeacher {
    private String Id;
    private String Name;
    private String Pwd;

    public MyTeacher() {

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String pwd) {
        Pwd = pwd;
    }


    @Override
    public String toString() {
        return "MyTeacher{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Pwd='" + Pwd + '\'' +
                '}';
    }
}
