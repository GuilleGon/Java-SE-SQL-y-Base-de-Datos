import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection myConn = null;
        Statement myStamt = null;
        ResultSet myRes = null;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "1234");
            System.out.println("Contectado!");

            myStamt = myConn.createStatement();

            int rowsAffrected = myStamt.executeUpdate("UPDATE employees " + "set first_name = 'Jose Luis'" + "WHERE id = '2'");
            myRes = myStamt.executeQuery("SELECT * FROM employees order by first_name");

            while (myRes.next()) {
                System.out.println(myRes.getString("first_name")+ " " + myRes.getString("last_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Algo salio mal");
        }
    }
}