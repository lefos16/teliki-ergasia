package servlets;

import courses.Courses;
import courses.Grades;
import users.Professors;
import users.Secretaries;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Profservlet", urlPatterns={"/Prof"})
public class Profservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if(request.getParameter("button1")!= null){
         String kk =  request.getParameter("course");
            int course_id = Integer.parseInt(kk);
            List<Grades> grd = Professors.viewgrade(course_id);
            request.setAttribute("list",grd);
            RequestDispatcher rs = request.getRequestDispatcher("profgrade.jsp");
            rs.forward(request, response);
        }else if(request.getParameter("button2") != null){
            String std_id = request.getParameter("regNum");
            String grd = request.getParameter("grade");
            String kk =  request.getParameter("course1");
            int course_id = Integer.parseInt(kk);
            boolean success = false;
            int regNum;
            int grade;
            try{
                regNum = Integer.parseInt(std_id);
                grade = Integer.parseInt(grd);
                success = Professors.addgrade(regNum,course_id,grade);
                if (success != false){
                    out.println("Your request was successful");

                }else{
                    out.println("Something went wrong try again");

                }
            }catch (NumberFormatException e){
                out.println("Expected integer value");

            }

        }else if (request.getParameter("button3") != null){


            request.getSession().invalidate();
            RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
            rs.forward(request, response);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
