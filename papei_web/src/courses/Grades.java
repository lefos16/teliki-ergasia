package courses;

import users.Students;

import java.util.HashMap;
import java.util.Map;

public class Grades {
    private String courseName;
    private int regNum;
    private int grade;

    public Grades(){

    }

    public int getRegNum() {
        return regNum;
    }

    public void setRegNum(int regNum) {
        this.regNum = regNum;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getCourseName() {
        return courseName;

    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
