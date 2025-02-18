# Hotel Reservation System

## Overview
The **Hotel Reservation System** is a simple Java-based console application that allows users to manage hotel room reservations. It connects to a MySQL database using JDBC and provides functionalities such as reserving a room, viewing reservations, retrieving room numbers, updating reservations, and deleting reservations.

## Features
- **Reserve a Room**: Allows guests to book a room by providing their details.
- **View Reservations**: Displays all existing reservations.
- **Get Room Number**: Fetches the room number based on reservation ID and guest name.
- **Update Reservation**: Modifies reservation details such as guest name, room number, and contact number.
- **Delete Reservation**: Removes a reservation based on its ID.
- **Exit System**: Gracefully exits the application.

## Technologies Used
- **Java** (Core Java, JDBC)
- **MySQL** (Database Management)
- **JDBC Driver** (MySQL Connector)

## Database Schema
The system interacts with a MySQL database with a table named `reservations`. Below is the sample table structure:
```sql
CREATE TABLE reservations (
    reservation_id INT AUTO_INCREMENT PRIMARY KEY,
    guest_name VARCHAR(100) NOT NULL,
    room_no INT NOT NULL,
    contact_number VARCHAR(15) NOT NULL,
    reservation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## Setup Instructions
### Prerequisites
- Install **Java JDK** (version 8 or later)
- Install **MySQL Server**
- Download the **MySQL JDBC Driver**

### Configuration
1. Clone this repository:
   ```sh
   git clone https://github.com/yourusername/Hotel-Reservation-System.git
   ```
2. Open the project in an IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code).
3. Update the database connection details in the `hotel_reservation.java` file:
   ```java
   private static final String url = "jdbc:mysql://localhost:3306/hotel_db";
   private static final String username = "root";
   private static final String pass = "yourpassword";
   ```
4. Ensure that the MySQL database and `reservations` table exist.
5. Compile and run the Java program:
   ```sh
   javac hotel_reservation.java
   java Hotel_Reservation_system.hotel_reservation
   ```

## Usage
Upon running the program, a menu will be displayed:
```
HOTEL MANAGEMENT SYSTEM
1. Reserve a room
2. View Reservations
3. Get Room number
4. Update Reservations
5. Delete Reservations
0. Exit
Choose an option:
```
- Enter the corresponding number to perform an operation.
- Follow the prompts to enter required details.
- The system will execute the operation and provide feedback.

## Future Improvements
- Implement **Prepared Statements** to prevent SQL Injection.
- Add **GUI Interface** for better user experience.
- Implement **Authentication System** for staff and guests.

## Contributing
Feel free to fork this repository, create feature branches, and submit pull requests.


