# Volunteering Management System

A robust, console-based Java application designed to manage community service events, track volunteers, and handle task assignments. This project demonstrates clean **Object-Oriented Programming (OOP)** principles and persistent data storage using **JDBC and MySQL**.

---

## 🚀 Features

* **Volunteer Management:** Create and track volunteer profiles including contact info and experience levels.
* **Event Coordination:** Organize events with specific dates and locations.
* **Diverse Task Types:** Create specific tasks for events, categorized into:
    * **Food Tasks:** Catering and distribution.
    * **Education Tasks:** Teaching and workshops.
    * **Logistics Tasks:** Setup and transport.
* **Smart Assignment:** Assign specific volunteers to tasks within an event.
* **Data Persistence:** All data is saved in a MySQL database via JDBC.
* **Interactive UI:** A user-friendly console-based menu for real-time interaction.

---

## 🧠 OOP Concepts Demonstrated

### Encapsulation
Domain classes like `Volunteer`, `Event`, and `Task` use private fields and public accessors to protect the internal state and ensure data integrity.

### Inheritance & Polymorphism
The system utilizes a specialized class hierarchy for tasks. The abstract base class `Task` is extended by:
* `FoodTask`
* `EducationTask`
* `LogisticsTask`

---

## 🛠️ Technologies Used

* **Language:** Java (JDK 8+)
* **Database:** MySQL
* **Driver:** JDBC (Java Database Connectivity)
* **Input:** Console I/O (Scanner)

---

## 🗄️ Database Schema

The system uses four interconnected tables to maintain data integrity:



1.  **VOLUNTEERS:** `volunteerID` (PK), `name`, `email`, `energyLevel`, `experienceLevel`.
2.  **EVENTS:** `eventID` (PK), `name`, `eventDate`, `location`.
3.  **TASKS:** `taskID` (PK), `eventID` (FK), `taskType`, `requiredVolunteers`, `durationHours`.
4.  **ASSIGNMENTS:** `assignmentID` (PK), `volunteerID` (FK), `taskID` (FK), `hoursContributed`.

---

## ▶️ How to Run

### 1. Prerequisites
* Java JDK 8 or higher installed.
* MySQL Server running locally.
* Add the **MySQL Connector/J** JAR to your project's classpath.

### 2. Configure Database
Update the credentials in `MyJDBC.java` to match your local setup:
```java
private static final String URL = "jdbc:mysql://127.0.0.1:3306/VOLUNTEERAPP";
private static final String USERNAME = "root";
private static final String PASS = "your_password";
```

### 3. Run the Application
Run the `Main` class. On startup:
* The database and tables are automatically created (if not already present).
* A console menu appears.

---

### 📋 Sample Menu
```text
=== Volunteer Management System ===
1. Create Volunteer
2. Create Event
3. Add Task to Event
4. Assign Volunteer to Task
0. Exit
```

### 🎯 Project Goal
This project was built to:

* **Practice clean OOP design**: Utilizing inheritance, encapsulation, and polymorphism.
* **Learn JDBC database integration**: Connecting a Java application to a MySQL backend.
* **Demonstrate realistic application architecture**: Implementing a structured approach to data handling.
* **Serve as a CV / portfolio project**: Showcasing backend development skills to potential employers.

---

### 📌 Possible Extensions
* [ ] **List / Search**: Add functionality to filter and find specific volunteers and events.
* [ ] **Update and Delete**: Implement full CRUD operations for database records.
* [ ] **Transaction Handling**: Ensure data integrity using SQL transactions.
* [ ] **Energy Tracking**: Track volunteer fatigue/energy levels during assignments.
* [ ] **Export Data**: Add functionality to save system data to JSON files.
* [ ] **GUI Version**: Develop a visual interface using JavaFX or Swing.

---

### 👤 Author
**Karim Sakr** *Computer Engineering Student* at Lebanese American University - Byblos, Lebanon.
