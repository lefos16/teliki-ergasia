package courses;
import users.Professors;

public class Courses {
    private int course_id;
    private String department;
    private String name;
    private int semester;
    private String profUsername;

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public Courses(){

    }

    public Courses(String department,String name,int semester, Professors prof){
        this.department = department;
        this.name = name;
        this.semester=semester;
        this.profUsername = prof.getUsername();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getProfUsername() {
        return profUsername;
    }

    public void setProfUsername(String profUsername) {
        this.profUsername = profUsername;
    }
}
