package servlets;

import engine.exceptions.FailedToConnectToDataBaseException;
import engine.managers.EngineManager;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            try {
                EngineManager engineManager = ServletUtils.getEngineManager(request.getServletContext());
                engineManager.getUsersManager().login(request.getParameter("username"), request.getParameter("password"));
            } catch(FailedToConnectToDataBaseException ex){
                response.setStatus(400);
                System.out.println(ex.getMessage());
                out.println("error: " + ex.getMessage());
            }catch(Exception e) {
                response.setStatus(400);
                out.println("error: " + e.getMessage());
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}