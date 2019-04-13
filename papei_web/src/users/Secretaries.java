package users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import courses.*;

public class Secretaries extends Users {

    private String phoneNum;

    public Secretaries(){

        super();
    }
    public Secretaries(String username,String password, String name, String surmane,String department,String phoneNum){
        super(username,password,name,surmane,department);
        this.phoneNum = phoneNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public static void assignProf(String course, String prof) {

    }

    public static ArrayList<String> profCourses(){
        List<String> str = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver");

            Connection con=DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/papei","postgres","7S/$?u18zY");
            PreparedStatement ps =con.prepareStatement("SELECT courses.name as cname, courses.department, professors.name, professors.surname\n" +
                    "FROM prof_course\n" +
                    "JOIN professors ON prof_course.prof_id = professors.prof_id\n" +
                    "JOIN courses ON prof_course.course_id = courses.course_id ");

            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                str.add(rs.getString("cname"));
                str.add(rs.getString("department"));
                str.add(rs.getString("name"));
                str.add(rs.getString("surname"));

            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return (ArrayList<String>) str;
    }

    public static ArrayList<Courses> reviewCourses(){
        List<Courses> courses = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver");

            Connection con=DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/papei","postgres","7S/$?u18zY");
            PreparedStatement ps =con.prepareStatement("select * from courses ");

                ResultSet rs =ps.executeQuery();
                while(rs.next()){
                Courses cours = new Courses();
                cours.setDepartment(rs.getString("department"));
                cours.setName(rs.getString("name"));
                cours.setSemester(rs.getInt("semester"));
                courses.add(cours);
                }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return (ArrayList<Courses>) courses;

    }

    public static Secretaries login(String username,String password){

        Secretaries scr = new Secretaries();
        try{
            Class.forName("org.postgresql.Driver");

            Connection con=DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/papei","postgres","7S/$?u18zY");
            PreparedStatement ps =con.prepareStatement("select * from secretaries where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();

            if(rs.next()){
                scr.setName(rs.getString("name"));
                scr.setPhoneNum(rs.getString("phoneNum"));
                scr.setDepartment(rs.getString("department"));
                scr.setSurname(rs.getString("surname"));
                scr.setUsername(rs.getString("username"));
        }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return scr;
    }

    public static boolean assignprof(int porf_id,int course_id){
        boolean suc = false ;
        try{
            Class.forName("org.postgresql.Driver");

            Connection con=DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/papei","postgres","7S/$?u18zY");
            PreparedStatement ps =con.prepareStatement("INSERT INTO public.prof_course(\n" +
                    "\tprof_id, course_id)\n" +
                    "\tVALUES (?, ?);");
            ps.setInt(1, porf_id);
            ps.setInt(2, course_id);
            int k = ps.executeUpdate();
            if(k>0){
                suc = true;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return suc;
    }

}
