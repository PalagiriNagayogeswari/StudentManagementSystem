package com.bridgelabz;

import com.bridgelabz.model.Student;
import com.bridgelabz.service.StudentService;

import java.util.List;
import java.util.Scanner;


//main method consisiting all the options so that user can select what to do.
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService service = new StudentService();

        int choice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    sc.nextLine();

                    System.out.print("Enter Name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email : ");
                    String email = sc.nextLine();

                    System.out.print("Enter Course : ");
                    String course = sc.nextLine();

                    System.out.print("Enter Marks : ");
                    int marks = sc.nextInt();

                    Student student = new Student(name, email, course, marks);

                    service.addStudent(student);

                    break;

                case 2:

                    List<Student> students = service.getStudents();

                    if (students.isEmpty()) {

                        System.out.println("No Students Found.");

                    } else {

                        for (Student s : students) {

                            System.out.println("-----------------------------");
                            System.out.println("ID : " + s.getId());
                            System.out.println("Name : " + s.getName());
                            System.out.println("Email : " + s.getEmail());
                            System.out.println("Course : " + s.getCourse());
                            System.out.println("Marks : " + s.getMarks());

                        }

                    }

                    break;

                case 3:

                    System.out.print("Enter Student ID : ");

                    int id = sc.nextInt();

                    Student s = service.getStudent(id);

                    if (s != null) {

                        System.out.println("ID : " + s.getId());
                        System.out.println("Name : " + s.getName());
                        System.out.println("Email : " + s.getEmail());
                        System.out.println("Course : " + s.getCourse());
                        System.out.println("Marks : " + s.getMarks());

                    } else {

                        System.out.println("Student Not Found.");

                    }

                    break;

                case 4:

                    System.out.print("Enter Student ID : ");

                    int updateId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter New Name : ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Email : ");
                    String newEmail = sc.nextLine();

                    System.out.print("Enter New Course : ");
                    String newCourse = sc.nextLine();

                    System.out.print("Enter New Marks : ");
                    int newMarks = sc.nextInt();

                    Student updatedStudent =
                            new Student(updateId,
                                    newName,
                                    newEmail,
                                    newCourse,
                                    newMarks);

                    service.updateStudent(updatedStudent);

                    break;

                case 5:

                    System.out.print("Enter Student ID : ");

                    int deleteId = sc.nextInt();

                    service.deleteStudent(deleteId);

                    break;

                case 6:

                    System.out.println("Thank You!");

                    break;

                default:

                    System.out.println("Invalid Choice.");

            }

        } while (choice != 6);

    }

}