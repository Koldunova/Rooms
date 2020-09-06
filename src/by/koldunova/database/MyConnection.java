package by.koldunova.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class MyConnection {
    private static MyConnection myConnection;
    private static Connection connDB;

    private MyConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connDB = DriverManager.getConnection("jdbc:mysql://localhost/rooms?serverTimezone=Europe/Moscow&useSSL=false    ", "roomuser", "8975367");
    }

    public static MyConnection getMyConnection() throws SQLException, ClassNotFoundException {
        if (myConnection==null) {
            synchronized (MyConnection.class) {
                if(myConnection == null) {
                    myConnection= new MyConnection();
                }
            }
        }
        return myConnection;
    }
    
    public static Connection getConnDB() throws SQLException, ClassNotFoundException {
        getMyConnection();
        return connDB;
    }
}
