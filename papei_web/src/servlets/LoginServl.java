package servlets;

import courses.Courses;
import users.Professors;
import users.Secretaries;
import users.Students;
import users.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LoginServl", urlPatterns={"/log"})
public class LoginServl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String usertype = request.getParameter("usertype");

        if ("Secretaries".equals(usertype)){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Secretaries scr = Secretaries.login(username,password);
        request.setAttribute("name", scr.getName());
        request.setAttribute("surname", scr.getSurname());
        request.setAttribute("department", scr.getDepartment());
        request.setAttribute("username", scr.getUsername());
        if(scr.getName()!=null)
        {
            RequestDispatcher rs = request.getRequestDispatcher("Welcome.jsp");
            rs.forward(request, response);
        }
        else
        {
            out.println("Username or Password incorrect");
            RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
            rs.include(request, response);
        }
        }
        if("Professors".equals(usertype)){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Professors prof = Professors.login(username,password);
            request.setAttribute("name", prof.getName());
            request.setAttribute("surname", prof.getSurname());
            request.setAttribute("department", prof.getDepartment());
            request.setAttribute("username", prof.getUsername());
            request.getSession().setAttribute("prof_id",prof.getProf_id());
            int ii = (int) request.getSession().getAttribute("prof_id");
            List<Courses> cr = Professors.getcourses(ii);
            request.setAttribute("list",cr);
            if(prof.getName()!=null)
            {
                RequestDispatcher rs = request.getRequestDispatcher("WelcomeP.jsp");
                rs.forward(request, response);
            }
            else
            {
                out.println("Username or Password incorrect");
                RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
                rs.include(request, response);
            }
        }
        if("Student".equals(usertype)){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Students std = Students.login(username,password);

            if(std.getName()!=null)
            {
                request.setAttribute("name", std.getName());
                request.setAttribute("surname", std.getSurname());
                request.setAttribute("department", std.getDepartment());
                request.setAttribute("username", std.getUsername());

                request.getSession().setAttribute("registrationNumber", std.getRegistrationNumber());
                RequestDispatcher rs = request.getRequestDispatcher("WelcomeS.jsp");
                rs.forward(request, response);
            }
            else
            {
                out.println("Username or Password incorrect");
                RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
                rs.include(request, response);
            }
        }
        out.close();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
