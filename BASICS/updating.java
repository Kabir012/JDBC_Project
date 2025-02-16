package BASICS;

import java.sql.*;

public class updating {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/students";
        String username = "root";
        String pass = "Kabir@4847";
        String query = "UPDATE student_info SET field = 'Engineering' WHERE id = 15385;";
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
                System.out.println("Updated succesfully! & " + rowsAffected + " rows affected");
            } else {
                System.out.println("Updation failed!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
