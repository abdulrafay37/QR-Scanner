# University Hostel Canteen Khata Management System

## Project Overview

The **University Hostel Canteen Khata Management System** is a Java-based console application designed to manage hostel students' canteen credit accounts (Khata System). The system allows canteen vendors to add bills to a student's account, send payment reminders, and enables students to view their outstanding balance, transaction history, and notifications.

---

## Features

### Vendor Panel

* Scan student QR code (Student ID).
* Add canteen bills to a student's khata.
* Automatically generate transaction references.
* Send payment reminder notifications to students.

### Student Panel

* View current khata balance.
* Check transaction history.
* Receive and view payment notifications.
* Access personal account information.

---

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* ArrayList Collection Framework
* Scanner Class
* Date Class

---

## Classes Used

### 1. Transaction Class

Stores transaction details:

* Transaction ID
* Amount
* Date and Time

#### Methods

* Constructor
* toString()

---

### 2. Student Class

Stores student information and account details.

#### Attributes

* Student ID (QR Code Data)
* Name
* Room Number
* Khata Balance
* Notifications
* Transaction History

#### Methods

* addToKhata()
* addNotification()
* displayStudentDashboard()
* Getter Methods

---

### 3. CanteenKhataSystem Class

Main system controller.

#### Responsibilities

* Maintain student database.
* Handle Vendor Panel operations.
* Handle Student Panel operations.
* Search students by Student ID.

#### Methods

* main()
* vendorMenu()
* studentMenu()
* findStudent()

---

## System Workflow

### Vendor Side

1. Vendor opens Vendor Panel.
2. Scans student's QR Code (Student ID).
3. Adds bill amount.
4. System updates student's khata.
5. Transaction is recorded automatically.

### Payment Reminder

1. Vendor selects notification option.
2. Student receives payment reminder.
3. Notification appears on student's dashboard.

### Student Side

1. Student enters Student ID.
2. Dashboard displays:

   * Personal Information
   * Outstanding Balance
   * Notifications
   * Transaction History

---

## Sample Student Records

| Student ID | Name             | Room              |
| ---------- | ---------------- | ----------------- |
| SP26-025   | Abdul Rafay      | Hostel 1, Room A5 |
| SP26-063   | Syed Hassan Shah | Hostel 2, Room D1 |

---

## Sample Output

### Main Menu

```text
=== UNIVERSITY HOSTEL CANTEEN SYSTEM ===
1. Vendor Panel (Dukaan Daar)
2. Student Panel
3. Exit
```

### Add Bill

```text
Scan QR (Enter Student ID): SP26-025
Enter Item Bill Amount (Rs.): 500

Success! Rs. 500 added to Abdul Rafay's khata.
```

### Student Dashboard

```text
--- STUDENT DASHBOARD (Abdul Rafay) ---
Room No: Hostel 1, Room A5
Current Payable Khata: Rs. 500

Notifications:
No new payment reminders.

Your Khata History:
[Date] Ref: TXN1234 -> Rs. 500
```

---

## Future Enhancements

* Real QR Code Scanner Integration
* File Handling for Permanent Data Storage
* GUI using Java Swing or JavaFX
* Admin Panel
* Monthly Billing Reports
* Online Payment Integration
* Hostel Management Module
* Database Integration (MySQL)

---

## Learning Concepts Covered

This project demonstrates:

* Classes and Objects
* Encapsulation
* ArrayLists
* Loops
* Conditional Statements
* Methods
* Date Handling
* Console-Based User Interface
* Basic Software Design

---

## Author

**Abdul Rafay**

First Semester Student
COMSATS University Islamabad, Sahiwal Campus

---

## License

This project is developed for educational and learning purposes.
