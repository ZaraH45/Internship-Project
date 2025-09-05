import java.util.Scanner;

class Student 
{
    int id;
    String name;

    Student(int Id, String Name) 
    {
        id = Id;
        name = Name;
    }
}

public class StudentManagementSystem 
{
    static Student[] students = new Student[100]; 
    static int count = 0; 
    static Scanner sc = new Scanner(System.in);

    static void addStudent() 
    {
        if (count >= 100)

        {
            System.out.println("Sorry cannot add more students.");
            return;
        }
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        students[count] = new Student(id, name);
        count++;
        System.out.println("Student added successfully");
    }

    static void displayStudents() 
    {
        if (count == 0) 
        {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\nStudent List: ");
        for (int i = 0; i < count; i++) 
        {
            System.out.println("ID: " + students[i].id + ", Name: " + students[i].name);
        }
    }

    static void searchStudent() 
    {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();
        for (int i = 0; i < count; i++) 
        {
            if (students[i].id == id) 
            {
                System.out.println("Found: ID = " + students[i].id + ", Name = " + students[i].name);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void deleteStudent() 
    {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        for (int i = 0; i < count; i++) 
        {
            if (students[i].id == id) 
            {
            
                for (int j = i; j < count - 1; j++) 
                {
                    students[j] = students[j + 1];
                }
                students[count - 1] = null;
                count--;
                System.out.println("Student deleted successfully");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void main(String[] args) 
    {
        while (true) 
        {
            System.out.println("\nStudent Management System Menu");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if (choice == 1) 
            {
                addStudent();
            } 
            else if (choice == 2) 
            {
                displayStudents();
            } 
            else if (choice == 3) 
            {
                searchStudent();
            } 
            else if (choice == 4) 
            {
                deleteStudent();
            } 
            else if (choice == 5) 
            {
                System.out.println("Exiting the system");
                break; 
            } 
            else 
            {
                System.out.println("Invalid choice");
            }

        }
    }
}
