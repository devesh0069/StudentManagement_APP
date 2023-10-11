import java.util.*;
class Student {
    int Stu_age, Stu_roll;
    String Stu_name, Stu_father, Stu_grade, Stu_class;

    public Student(String Stu_name, String Stu_father, int Stu_roll, String Stu_grade, int Stu_age, String Stu_class) {
        this.Stu_age = Stu_age;
        this.Stu_roll = Stu_roll;
        this.Stu_name = Stu_name;
        this.Stu_father = Stu_father;
        this.Stu_grade = Stu_grade;
        this.Stu_class = Stu_class;
    }

    public int getRollNumber() {
        return Stu_roll;
    }

    public int getAge() {
        return Stu_age;
    }

    public String getName() {
        return Stu_name;
    }

    public String getFatherName() {
        return Stu_father;
    }

    public String getGrade() {
        return Stu_grade;
    }

    public String getClassName() {
        return Stu_class;
    }

    public String toString() {
        return "Name: " + Stu_name + ", Roll Number: " + Stu_roll + ", Grade: " + Stu_grade + ", Father Name: "
                + Stu_father + ", Age: " + Stu_age + ", Class: " + Stu_class;
    }
}

class StudentManagementSystem {
    ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<Student>();
    }

    public boolean AddStudent(Student student) {
        if (students.contains(student)) {
            return false; // Student already exists in the list
        } else {
            students.add(student);
            return true; // Student successfully added to the list
        }
    }

    public void RemoveStudent(int Stu_roll) {
        students.removeIf(stu -> stu.getRollNumber() == Stu_roll);
    }

    public Student SearchStudent(int Stu_roll) {
        for (Student stud : students) {
            if (stud.getRollNumber() == Stu_roll) {
                return stud;
            }
        }
        return null;
    }

    public void DisplayStudent() {
        for (Student stud : students) {
            System.out.println(stud);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int n = -1;
        Scanner ob = new Scanner(System.in);
        int age, roll;
        String name, father, grade, classes;
        StudentManagementSystem SMS = new StudentManagementSystem();

        while (n != 0) {
            System.out.println("\t\t\tStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("0. To Exit");
            System.out.print("Enter your choice: ");
            n = ob.nextInt();
            ob.nextLine(); // Consume newline character

            switch (n) {
                case 1:
                    System.out.print("Enter Name: ");
                    name = ob.nextLine();
                    System.out.print("Enter Father Name: ");
                    father = ob.nextLine();
                    System.out.print("Enter Grade: ");
                    grade = ob.nextLine();
                    System.out.print("Enter Class: ");
                    classes = ob.nextLine();
                    System.out.print("Enter Age: ");
                    age = ob.nextInt();
                    System.out.print("Enter Roll Number: ");
                    roll = ob.nextInt();
                    ob.nextLine(); // Consume newline

                    Student student = new Student(name, father, roll, grade, age, classes);
                    SMS.AddStudent(student);
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    System.out.print("Enter Roll Number to Remove: ");
                    roll = ob.nextInt();
                    ob.nextLine(); // Consume newline
                    SMS.RemoveStudent(roll);
                    System.out.println("Student removed successfully.");
                    break;
                case 3:
                    System.out.print("Enter Roll Number to Search: ");
                    roll = ob.nextInt();
                    ob.nextLine(); // Consume newline
                    Student foundStudent = SMS.SearchStudent(roll);
                    if (foundStudent != null) {
                        System.out.println("Student found:");
                        System.out.println(foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.println("All Students:");
                    SMS.DisplayStudent();
                    break;
                case 0:
                    System.out.println("Exiting the Student Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

