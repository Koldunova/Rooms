package by.koldunova;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.koldunova.database.reader.DbReader;
import by.koldunova.entity.MyIp;
import by.koldunova.entity.Room;

public class MainServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        MyIp ipUserInf = new MyIp(req);

        String ip = ipUserInf.getIp();
        String country = ipUserInf.getCountry();

        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/index.jsp");

        req.setAttribute("ip", ip);
        req.setAttribute("country", country);

        try {
            req.setAttribute("rooms", DbReader.readRooms());
        } catch (SQLException e) {
            // pw.println("<H1> SQLException "+e.getMessage()+" </H1>");
        } catch (ClassNotFoundException e) {
            // pw.println("<H3> ClassNotFoundException "+e.getMessage()+" </H3>");
        }

        dispatcher.forward(req, resp);

    }

}