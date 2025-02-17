package Hotel_Reservation_system;

import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class hotel_reservation {

    private static final String url = "jdbc:mysql://localhost:3306/hotel_db";

    private static final String username = "root";

    private static final String pass = "Kabir@4847";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, username, pass);

            while (true) {
                System.out.println();
                System.out.println("HOTEL MANAGEMENT SYSTEM ");
                Scanner sc = new Scanner(System.in);
                System.out.println("1. Reserve a room");
                System.out.println("2. View Reservations");
                System.out.println("3. Get Reservations");
                System.out.println("4. Update Reservations");
                System.out.println("5. Delete Reservations");
                System.out.println("0. Exit");
                System.out.println("Choose an option: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        reserveRoom(con, sc);
                        break;
                    case 2:
                        viewReservations(con, sc);
                        break;
                    case 3:
                        getReservations(con, sc);
                        break;
                    case 4:
                        updateReservation(con, sc);
                        break;
                    case 5:
                        deleteReservation(con, sc);
                        break;
                    case 0:
                        exit();
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice, Try Again!");
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void reserveRoom(Connection con, Scanner sc) {
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter room number: ");
        int roomNo = sc.nextInt();
        System.out.println("Enter your contact number: ");
        String contactNo = sc.nextLine();

        String query = "INSERT INTO reservations (guest_name,room_no,contact_number)" +
                "VALUES (' " + name + "'," + roomNo + " ,' " + contactNo + " ')";

        try {
            Statement stmt = con.createStatement();
            int rowsAffected = stmt.executeUpdate(query);
            if (rowsAffected > 0) {
                System.out.println("Reservation Successful!");
            } else {
                System.out.println("Reservation Failed!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewReservations(Connection con){
        String query = "SELECT reservation_id , guest_name, room_no, contact_number , reservation_date FROM reservations";
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                int reservation_id = rs.getInt("reservation_id");
                String guest_name = rs.getString("guest_name");
                int room_no = rs.getInt("guest_name");
                String reservation_date = rs.getTimestamp("reservation_date").toString();

                System.out.println();
                System.out.println("-------------------------------------");
                System.out.println("ID: " + reservation_id);
                System.out.println();
            }

        }

    }
}
