package servlets;

import com.google.gson.Gson;
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

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

            response.setContentType("application/json");
            System.out.println("hey there");
        try (PrintWriter out = response.getWriter()) {
            try {
                EngineManager engineManager = ServletUtils.getEngineManager(request.getServletContext());
                engineManager.getUsersManager().register(request.getParameter("username"), request.getParameter("password"));
                Gson gson = new Gson();
                out.println(gson.toJson("hey"));
            } catch(FailedToConnectToDataBaseException ex){
                response.setStatus(400);
                System.out.println(ex.getMessage());
                out.println("error: " + ex.getMessage());
            }catch(Exception e) {
                // fail register case
                response.setStatus(400);
                out.println("error: " + e.getMessage());
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
