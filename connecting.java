import java.sql.*;

public class connecting {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Students";
        String username = "root";
        String pass = "Kabir@4847";
        String query = "Select * from student_info;";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded succesfully!");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, username, pass);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String field = rs.getString("field");
                System.out.println("-------------------------------");
                System.out.println("ID : " + id);
                System.out.println("Name : " + name);
                System.out.println("Field : " + field);
                System.out.println();
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
