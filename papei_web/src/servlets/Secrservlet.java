package servlets;

import courses.Courses;
import users.Secretaries;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "Secrservlet", urlPatterns={"/Secr"})
public class Secrservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (request.getParameter("button1") != null) {
            ArrayList<Courses> courses= Secretaries.reviewCourses();
            request.setAttribute("list",courses);
            RequestDispatcher rs = request.getRequestDispatcher("coursesreview.jsp");
            rs.forward(request, response);
        } else if (request.getParameter("button2") != null) {
            ArrayList<String> str = Secretaries.profCourses();
            request.setAttribute("list1",str);
            RequestDispatcher rs = request.getRequestDispatcher("profcourse.jsp");
            rs.forward(request, response);
      } else if (request.getParameter("button3") != null) {
            String pro_id = request.getParameter("prof_id");
            String course_id = request.getParameter("course_id");
            int proid;
            int courseid;
            boolean success = false;
            try{
                proid = Integer.parseInt(pro_id);
             courseid = Integer.parseInt(course_id);
             success = Secretaries.assignprof(proid,courseid);
                if (success != false){
                    out.println("Your request was successful");

                }else{
                    out.println("Something went wrong try again");

                }
        }catch (NumberFormatException e){
                out.println("Expected integer value");

            }

       }else if (request.getParameter("button4") != null){


            request.getSession().invalidate();
            RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
            rs.forward(request, response);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
