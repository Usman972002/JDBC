import java.sql.*;
public class CRUD {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "Usman@123";
        Connection con = DriverManager.getConnection(url,uname,pass);
        System.out.println("Connection Established");
        Statement st = con.createStatement();
//        Create
//        String query = "insert into marks values(5,'BeYou',100)";
//        boolean status= st.execute(query);
//        System.out.println(status);

//       Update
//        String query = "update marks set name='BeyoU' where sid = 5";
//        st.execute(query);

//        Delete
//        String query = "delete from marks where sid = 5";
//        st.execute(query);

//        Prepared Statements
        int sid = 5;
        String name = "BeYou";
        int marks = 100;
        String query = "insert into marks values(?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,sid);
        ps.setString(2,name);
        ps.setInt(3,marks);
        ps.execute();

        con.close();
        System.out.println("Connection Closed");
    }
}
