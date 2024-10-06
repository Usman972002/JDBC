package JDBC;

import java.sql.*;

public class DemoJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//       Step 2 & 3 : Load & Register Driver --> This is Optional
        Class.forName("org.postgresql.Driver");

//        Step 4 : Create Connection
        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "Usman@123";
        Connection connection = DriverManager.getConnection(url, uname, pass);

        System.out.println("Connection Established");

//       Step 5 : Create Statement
        Statement statement = connection.createStatement();
//        Step 6 : Execute Statement
        String query1 = "select name from marks where sid = 1";
//        ResultSet resultSet = statement.executeQuery(query1);
//        This Will Print If the recordset has Data or not
//        System.out.println(resultSet.next());
//        This prints the exact data
//        System.out.println(resultSet.getString("name"));

//       Fetching all the Data
        String query2 = "select * from marks";
        ResultSet resultSet = statement.executeQuery(query2);
        while(resultSet.next()){
            System.out.print(resultSet.getInt(1) + " -");
            System.out.print(resultSet.getString(2) + " -");
            System.out.print(resultSet.getInt(3));
            System.out.println();
        }


//        Step 7 : Close Connection
        connection.close();
        System.out.println("Connection Closed");
    }
}
