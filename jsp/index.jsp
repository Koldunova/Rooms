<%@page import="by.koldunova.entity.Room"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.JasperException"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Rooms</title>
    </head>
    <body>
        <h1>ROOMS</h1>
        <h1>Your ip: <%=request.getAttribute("ip")%> Your country: <%=request.getAttribute("country")%></h1>

        <table border="1">
            <th>
                <td><h3>Name</h3></td>
                <td><h3>Country</h3></td>
                <td><h3>Link</h3></td>
            </th>
            <%
                ArrayList<Room> rooms = (ArrayList<Room>) request.getAttribute("rooms");

                for (int i = 0; i < rooms.size(); i++){
                    out.println("<tr><td>");
                    out.println(rooms.get(i).getNumRoom());
                    out.println("</td><td>" );
                    out.println(rooms.get(i).getName());
                    out.println("</td><td>" );
                    out.println(rooms.get(i).getCountry());
                    out.println("</td><td>" );
                    out.println("Link");
                    out.println("</td></tr>");
                }
            %>
        </table>
    </body>
</html>