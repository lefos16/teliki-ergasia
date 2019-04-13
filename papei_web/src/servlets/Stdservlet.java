package servlets;

import users.Students;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Stdservlet", urlPatterns={"/Std"})
public class Stdservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ii = (int) request.getSession().getAttribute("registrationNumber");


        if (request.getParameter("button1") != null){
            ArrayList<String> str1 = Students.Seegrades(ii);
            request.setAttribute("list",str1);
            RequestDispatcher rs = request.getRequestDispatcher("gradesreview.jsp");
            rs.forward(request, response);
        } else if(request.getParameter("button2") != null){
            ArrayList<Double> grd = Students.Semestergrades(ii);
            request.setAttribute("list",grd);
            RequestDispatcher rs = request.getRequestDispatcher("semgrades.jsp");
            rs.forward(request, response);


        } else if(request.getParameter("button3") != null){
            ArrayList<Double> avg = Students.grdavarage(ii);
            request.setAttribute("avg",avg.get(0));
            int num = avg.get(1).intValue();
            request.setAttribute("pass", num);
            RequestDispatcher rs = request.getRequestDispatcher("avggrades.jsp");
            rs.forward(request, response);


        } else if (request.getParameter("button4") != null){


            request.getSession().invalidate();
            RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
            rs.forward(request, response);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
