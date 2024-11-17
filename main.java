import java.util.ArrayList;
import java.util.Scanner;

// Faculty class to hold the details of each faculty member
class Faculty {
    private int id;
    private String name;
    private String department;
    private String designation;

    // Constructor
    public Faculty(int id, String name, String department, String designation) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.designation = designation;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    // Method to display faculty details
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Designation: " + designation);
    }
}

public class FacultyManagement {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Faculty> facultyList = new ArrayList<>();

    // Method to add a new faculty
    public static void addFaculty() {
        System.out.print("Enter Faculty ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Designation: ");
        String designation = scanner.nextLine();

        Faculty faculty = new Faculty(id, name, department, designation);
        facultyList.add(faculty);
        System.out.println("Faculty added successfully!");
    }

    // Method to view all faculty records
    public static void viewAllFaculties() {
        if (facultyList.isEmpty()) {
            System.out.println("No faculty records available.");
        } else {
            System.out.println("Faculty Details:");
            for (Faculty faculty : facultyList) {
                faculty.display();
            }
        }
    }

    // Method to search for a faculty by ID
    public static void searchFaculty() {
        System.out.print("Enter Faculty ID to search: ");
        int id = scanner.nextInt();
        boolean found = false;
        for (Faculty faculty : facultyList) {
            if (faculty.getId() == id) {
                faculty.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Faculty not found with ID: " + id);
        }
    }

    // Method to update faculty details
    public static void updateFaculty() {
        System.out.print("Enter Faculty ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        boolean found = false;
        for (Faculty faculty : facultyList) {
            if (faculty.getId() == id) {
                System.out.print("Enter New Name: ");
                faculty.setName(scanner.nextLine());
                System.out.print("Enter New Department: ");
                faculty.setDepartment(scanner.nextLine());
                System.out.print("Enter New Designation: ");
                faculty.setDesignation(scanner.nextLine());
                System.out.println("Faculty details updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Faculty not found with ID: " + id);
        }
    }

    // Method to delete a faculty record
    public static void deleteFaculty() {
        System.out.print("Enter Faculty ID to delete: ");
        int id = scanner.nextInt();
        boolean found = false;
        for (int i = 0; i < facultyList.size(); i++) {
            if (facultyList.get(i).getId() == id) {
                facultyList.remove(i);
                System.out.println("Faculty deleted successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Faculty not found with ID: " + id);
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Faculty Management System ---");
            System.out.println("1. Add Faculty");
            System.out.println("2. View All Faculties");
            System.out.println("3. Search Faculty by ID");
            System.out.println("4. Update Faculty Details");
            System.out.println("5. Delete Faculty");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addFaculty();
                    break;
                case 2:
                    viewAllFaculties();
                    break;
                case 3:
                    searchFaculty();
                    break;
                case 4:
                    updateFaculty();
                    break;
                case 5:
                    deleteFaculty();
                    break;
                case 6:
                    System.out.println("Exiting the application...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
