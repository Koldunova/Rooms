package by.koldunova;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        PrintWriter pw = resp.getWriter();
;
        pw.println("<H1> Your ip:" + ip + " Your country: " + country + "</H1>");

        try {
            ArrayList<Room> rooms = DbReader.readRooms();

            for (Room room : rooms) {
                pw.println("<H1> " + room.toString() + "</H1>");
            }
        } catch (SQLException e) {
            pw.println("<H1> SQLException "+e.getMessage()+" </H1>");
        } catch (ClassNotFoundException e) {
            pw.println("<H3> ClassNotFoundException "+e.getMessage()+" </H3>");
        }

        pw.println("<H1> Hi! </H1>");
    }

}