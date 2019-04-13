package users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Students extends Users {

    private int registrationNumber;
    private int semester;



   public Students(int registrationNumber){
       super();
       this.registrationNumber = registrationNumber;
   }

   public Students(String username, String password, String name, String surmane, String department, int registrationNumber,int semester){
       super(username,password,name,surmane,department);

       this.registrationNumber = registrationNumber;
       this.semester = semester;
   }

    public Students() {
        super();
    }


    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getRegistrationNumber() {

        return registrationNumber;
    }

    public static Students login (String username,String password){
      Students std = new Students();
        try{
            Class.forName("org.postgresql.Driver");

            Connection con=DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/papei","postgres","7S/$?u18zY");
            PreparedStatement ps =con.prepareStatement("select * from students where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();

            if(rs.next()){
                std = new Students(rs.getInt("registrationNumber"));
                std.setName(rs.getString("name"));
                std.setDepartment(rs.getString("department"));
                std.setSurname(rs.getString("surname"));
                std.setUsername(rs.getString("username"));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return std;

    }

    public static ArrayList<String> Seegrades(int registrationNumber){
       List<String> str = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver");

            Connection con=DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/papei","postgres","7S/$?u18zY");
            PreparedStatement ps =con.prepareStatement("Select courses.name , grades.grade \n" +
                    "From grades \n" +
                    "Join courses ON grades.course_id = courses.course_id\n" +
                    "Where grades.\"registrationNumber\" = ?");
            ps.setInt(1, registrationNumber);

            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                str.add(rs.getString("name"));
                int i = rs.getInt("grade");
                str.add(Integer.toString(i));
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return (ArrayList<String>) str;
    }
    public static ArrayList<Double> Semestergrades(int registrationNumber){
       List<Double> grd = new ArrayList<>();
        double[] count = new double[8];
        double[] sum = new double[8];
        for (int i = 0; i<8; i++){
            count[i]=0;
            sum[i]=0;
        }
        try{
            Class.forName("org.postgresql.Driver");

            Connection con=DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/papei","postgres","7S/$?u18zY");
            PreparedStatement ps =con.prepareStatement("Select courses.semester, grades.grade\n" +
                    "From grades\n" +
                    "Join courses ON grades.course_id = courses.course_id\n" +
                    "Where grades.\"registrationNumber\" = ?");
            ps.setInt(1, registrationNumber);
            
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                double sem = (rs.getInt("semester"));
                double gr = rs.getInt("grade");
                switch ((int) sem){
                    case 1:
                        count[0]++;
                        sum[0]+=gr;
                        break;
                        case 2:
                        count[1]++;
                        sum[1]+=gr;
                        break;
                        case 3:
                        count[2]++;
                        sum[2]+=gr;
                        break;
                        case 4:
                        count[3]++;
                        sum[3]+=gr;
                        break;
                        case 5:
                        count[4]++;
                        sum[4]+=gr;
                        break;
                        case 6:
                        count[5]++;
                        sum[5]+=gr;
                        break;
                        case 7:
                        count[6]++;
                        sum[6]+=gr;
                        break;
                        case 8:
                        count[7]++;
                        sum[7]+=gr;
                        break;
                }
            }
            NumberFormat nf = new DecimalFormat("#0.##");
            for (int i=0 ; i<8 ; i++){
                if (count[i] !=0) {
                    double k = sum[i] / count[i];
                    grd.add(Double.valueOf(nf.format(k)));
                }else{
                    grd.add(0.0);
                }
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
       return (ArrayList<Double>) grd;
    }
    public static ArrayList<Double> grdavarage(int registrationNumber){
       List<Double> avg = new ArrayList<>();
       Double sum= new Double(0.0);
       Double counter=new Double(0.0);
        try{
            Class.forName("org.postgresql.Driver");

            Connection con=DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/papei","postgres","7S/$?u18zY");
            PreparedStatement ps =con.prepareStatement("Select  grades.grade\n" +
                    "From grades\n" +
                    "Where grades.\"registrationNumber\" = ?");
            ps.setInt(1, registrationNumber);

            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                counter++;
                sum+=rs.getInt("grade");
            }
            if (counter!=0) {
                Double k = sum / counter;
                NumberFormat nf = new DecimalFormat("#0.##");
                avg.add(Double.valueOf(nf.format(k)));
                avg.add(counter);
            }else{
                avg.add(0.0);
                avg.add(0.0);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

       return (ArrayList<Double>) avg;

    }
}
