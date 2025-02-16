import java.sql.*;

public class deleting {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/students";
        String username = "root";
        String pass = "Kabir@4847";
        String query = "DELETE FROM student_info WHERE id = 12345;";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded !");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, username, pass);
            System.out.println("Connection built!");

            Statement stmt = con.createStatement();
            int rowsAffected = stmt.executeUpdate(query);

            if (rowsAffected > 0) {
                System.out.println("Deleted succesfully! & " + rowsAffected + " rows affected");
            } else {
                System.out.println("Deletion failed!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
