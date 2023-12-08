import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection myConn = null;
        PreparedStatement myStamt = null;
        ResultSet myRes = null;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "1234");
            System.out.println("Contectado!");

            String sql = ("INSERT INTO employees (id, first_name, last_name) VALUES (?, ?, ?)");
            myStamt = myConn.prepareStatement(sql);
            myStamt.setString(1, "2");
            myStamt.setString(2, "Luis");
            myStamt.setString(3, "Levratto");

            int rowsAffrected = myStamt.executeUpdate();

            if (rowsAffrected > 0) {
                System.out.println("Se ha creado un nuevo empleado");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Algo salio mal");
        }
    }
}