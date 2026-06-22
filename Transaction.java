import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
class Transaction {
    private String transactionId;
    private double amount;
    private Date dateTime;

    public Transaction(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.dateTime = new Date();
    }

    @Override
    public String toString() {
        return "[" + dateTime + "] Ref: " + transactionId + " -> Rs. " + amount;
    }
}
class Student {
    private String studentId; // Yeh QR Code ka data hoga
    private String name;
    private String roomNumber;
    private double khataBalance;
    private ArrayList<String> notifications;
    private ArrayList<Transaction> personalHistory;

    public Student(String studentId, String name, String roomNumber) {
        this.studentId = studentId;
        this.name = name;
        this.roomNumber = roomNumber;
        this.khataBalance = 0.0;
        this.notifications = new ArrayList<>();
        this.personalHistory = new ArrayList<>();
    }

    // Getters and Setters
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public double getKhataBalance() { return khataBalance; }
    
    public void addToKhata(double amount, String transId) {
        this.khataBalance += amount;
        this.personalHistory.add(new Transaction(transId, amount));
    }

    public void addNotification(String msg) {
        this.notifications.add(msg);
    }

    // Student Dashboard
    public void displayStudentDashboard() {
        System.out.println("\n---  STUDENT DASHBOARD (" + name + ") ---");
        System.out.println("Room No: " + roomNumber);
        System.out.println("Current Payable Khata: Rs. " + khataBalance);
        
        System.out.println("\n Notifications:");
        if (notifications.isEmpty()) {
            System.out.println("   No new payment reminders.");
        } else {
            for (String notif : notifications) {
                System.out.println("   -> " + notif);
            }
        }

        System.out.println("\n Your Khata History:");
        if (personalHistory.isEmpty()) {
            System.out.println("   No transactions yet.");
        } else {
            for (Transaction t : personalHistory) {
                System.out.println("   " + t);
            }
        }
        System.out.println("---------------");
    }
}

class CanteenKhataSystem {
    private static ArrayList<Student> studentDatabase = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Dummy Data add kar rahe hain system me
        studentDatabase.add(new Student("SP26-025", "Abdul Rafay", "Hostel 1, Room A5"));
        studentDatabase.add(new Student("SP26-063", "Syed Hassan Shah", "Hostel 2, Room D1"));

        while (true) {
            System.out.println("\n===  UNIVERSITY HOSTEL CANTEEN SYSTEM ===");
            System.out.println("1. Vendor Panel (Dukaan Daar)");
            System.out.println("2. Student Panel");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int mainChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (mainChoice == 1) {
                vendorMenu();
            } else if (mainChoice == 2) {
                studentMenu();
            } else if (mainChoice == 3) {
                System.out.println("System shutting down. Khata saved successfully!");
                break;
            } else {
                System.out.println("Invalid option! Dubara try karen.");
            }
        }
    }

    // --- VENDOR PANEL LOGIC ---
    private static void vendorMenu() {
        System.out.println("\n---  VENDOR PANEL ---");
        System.out.println("1. Scan QR Code & Add Bill (Khata)");
        System.out.println("2. Send Payment Notification (Demand Money)");
        System.out.print("Choose option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Scan QR (Enter Student ID): ");
        String scanId = scanner.nextLine();
        
        Student student = findStudent(scanId);
        if (student == null) {
            System.out.println(" Student not found in database!");
            return;
        }

        if (choice == 1) {
            System.out.print("Enter Item Bill Amount (Rs.): ");
            double amount = scanner.nextDouble();
        
            // Generate temporary transaction reference
            String transId = "TXN" + System.currentTimeMillis() % 10000;
            student.addToKhata(amount, transId);
            
            System.out.println(" Success! Rs. " + amount + " added to " + student.getName() + "'s khata.");
        } 
        else if (choice == 2) {
            // Button Press Simulation to send notification
            String reminderMsg = "Canteen Bill Alert! Your current outstanding balance is Rs. " 
                                 + student.getKhataBalance() + ". Please clear your dues.";
            student.addNotification(reminderMsg);
            System.out.println(" Notification sent successfully to " + student.getName() + ".");
        }
    }

    //  STUDENT PANEL LOGIC 
    private static void studentMenu() {
        System.out.print("\nEnter your Student ID (To view your account): ");
        String studentId = scanner.nextLine();
        
        Student student = findStudent(studentId);
        if (student != null) {
            student.displayStudentDashboard();
        } else {
            System.out.println(" Account not found!");
        }
    }

    // Helper method to search student from arraylist 
    private static Student findStudent(String id) {
        for (Student s : studentDatabase) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }
}