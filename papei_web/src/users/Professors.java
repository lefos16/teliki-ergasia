package users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import courses.Courses;
import courses.Grades;

public class Professors extends Users {

    private String email;
    private int prof_id;
    private List<Courses> courses = new ArrayList<>();

    public int getProf_id() {
        return prof_id;
    }

    public void setProf_id(int prof_id) {
        this.prof_id = prof_id;
    }

    public Professors(){
        super();

    }

    public Professors(String username,String password, String name, String surmane,String department,String email){
        super(username,password,name, surmane,department);
        this.email=email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public static Professors login (String username,String password){
        Professors prof = new Professors();
        try{
            Class.forName("org.postgresql.Driver");

            Connection con=DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/papei","postgres","7S/$?u18zY");
            PreparedStatement ps =con.prepareStatement("select * from professors where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();

            if(rs.next()){
                prof.setName(rs.getString("name"));
                prof.setDepartment(rs.getString("department"));
                prof.setSurname(rs.getString("surname"));
                prof.setUsername(rs.getString("username"));
                prof.setProf_id(rs.getInt("prof_id"));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return prof;
    }

    public static ArrayList<Courses> getcourses(int prof_id){
        List<Courses> cr = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver");

            Connection con=DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/papei","postgres","7S/$?u18zY");
            PreparedStatement ps =con.prepareStatement("select courses.name , courses.course_id \n" +
                    "from prof_course \n" +
                    "JOIN courses ON  prof_course.course_id = courses.course_id \n" +
                    "where prof_course.\"prof_id\"=? ");
            ps.setInt(1, prof_id);

            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                Courses course = new Courses();
                course.setName(rs.getString("name"));
                course.setCourse_id(rs.getInt("course_id"));
                cr.add(course);
            }


        }catch(Exception e)
        {
            e.printStackTrace();
        }


        return (ArrayList<Courses>) cr;
    }
    public static ArrayList<Grades> viewgrade(int course_id){
        List<Grades> grd = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver");

            Connection con=DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/papei","postgres","7S/$?u18zY");
            PreparedStatement ps =con.prepareStatement("SElECT grades.\"registrationNumber\" , grades.\"grade\"\n" +
                    "FROM grades\n" +
                    "WHERE course_id=?");
            ps.setInt(1, course_id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Grades gr = new Grades();
                gr.setRegNum(rs.getInt("registrationNumber"));
                gr.setGrade(rs.getInt("grade"));
                grd.add(gr);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return (ArrayList<Grades>) grd;
    }
    public static boolean addgrade(int registrationNumber, int course_id, int grade){
        boolean suc = false ;
        try{
            Class.forName("org.postgresql.Driver");

            Connection con=DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/papei","postgres","7S/$?u18zY");
            PreparedStatement ps =con.prepareStatement("INSERT INTO public.grades(\n" +
                    "\t\"registrationNumber\", course_id, grade)\n" +
                    "\tVALUES (?, ?, ?);");
            ps.setInt(1, registrationNumber);
            ps.setInt(2, course_id);
            ps.setInt(3, grade);
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
