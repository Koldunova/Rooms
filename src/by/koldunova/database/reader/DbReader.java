package by.koldunova.database.reader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import by.koldunova.database.MyConnection;
import by.koldunova.entity.Room;

public final class DbReader {
    public static ArrayList<Room> readRooms() throws SQLException, ClassNotFoundException {
        Connection connection = MyConnection.getConnDB();

        final String sql = "SELECT * FROM rooms.room;";
        final Statement statement = connection.createStatement();
        final ResultSet resultSet = statement.executeQuery(sql);

        ArrayList<Room> rooms = new ArrayList<Room>(50);
        Room room;
        while (resultSet.next()) {
            int num = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String country = resultSet.getString(3);
            boolean lamp = resultSet.getBoolean(4);

            room = new Room(num, name, country, lamp);

            rooms.add(room);
        }
        return rooms;
    }
}
