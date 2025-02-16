import java.sql.*;

public class inserting {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/students";
        String username = "root";
        String pass = "Kabir@4847";
        String query = "INSERT INTO student_info (id,name) VALUES (12345,'Aakarshn');";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers Loaded!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, username, pass);
            System.out.println("Connection established!!");
            Statement stmt = con.createStatement();
            int rowsAffected = stmt.executeUpdate(query);

            if (rowsAffected > 0) {
                System.out.println("Insertion succesfull! & " + rowsAffected + " rows affected");
            } else {
                System.out.println("Insertion failed");
            }

            stmt.close();
            con.close();
            System.out.println("Connection closed !");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
