package com.example.StudentEnrollement_spring;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.StudentEnrollement_spring.Student;

@Service
public class StudentService {
    @Autowired
    private Student student;
    private Map<Integer, Student> studentDatabase = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Map<Integer, Student> getStudentDatabase() {
        return studentDatabase;
    }

    public void setStudentDatabase(Map<Integer, Student> studentDatabase) {
        this.studentDatabase = studentDatabase;
    }

    public void addStudent(Student student) {
        studentDatabase.put(student.getId(), student);
    }

    public void updateStudent(Student updatedStudent) {
        studentDatabase.put(updatedStudent.getId(), updatedStudent);
    }

    public void deleteStudent(int studentId) {
        studentDatabase.remove(studentId);
    }

    public Student getStudent(int studentId) {
        return studentDatabase.get(studentId);
    }

    public void runMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student Info");
            System.out.println("3. Delete Student");
            System.out.println("4. Get Student by ID");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudentFromInput();
                    break;
                case 2:
                    updateStudentFromInput();
                    break;
                case 3:
                    deleteStudentFromInput();
                    break;
                case 4:
                    getStudentById();
                    break;
                case 5:
                    displayAllStudents();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void addStudentFromInput() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter student name: ");
        String name = scanner.next();
        System.out.print("Enter course ID: ");
        String courseId = scanner.next();
        
        Student newStudent = new Student();
        newStudent.setId(id);
        newStudent.setStudentName(name);
        newStudent.setCourseid(courseId);
        addStudent(newStudent);
        System.out.println("Student added successfully.");
    }

    private void updateStudentFromInput() {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        Student existingStudent = getStudent(id);
        if (existingStudent != null) {
            System.out.print("Enter updated student name: ");
            String name = scanner.next();
            existingStudent.setStudentName(name);
            System.out.print("Enter updated course ID: ");
            String courseId = scanner.next();
            existingStudent.setCourseid(courseId);
            updateStudent(existingStudent);
            System.out.println("Student info updated successfully.");
        } else {
            System.out.println("Student not found with ID " + id);
        }
    }

    private void deleteStudentFromInput() {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        Student existingStudent = getStudent(id);
        if (existingStudent != null) {
            deleteStudent(id);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found with ID " + id);
        }
    }

    private void getStudentById() {
        System.out.print("Enter student ID to retrieve: ");
        int id = scanner.nextInt();
        Student existingStudent = getStudent(id);
        if (existingStudent != null) {
            System.out.println("Student details:");
            System.out.println(existingStudent);
        } else {
            System.out.println("Student not found with ID " + id);
        }
    }
    
    public void displayAllStudents() {
        System.out.println("Students List:");
        for (Student student : studentDatabase.values()) {
            System.out.println(student);
        }
    }
}
