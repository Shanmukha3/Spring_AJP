package com.example.courseManagement_StudentEnrollement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private Course course;
    private Map<Integer, Course> courseDatabase = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    private Map<Integer, Student> studentDatabase = new HashMap<>();
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Map<Integer, Course> getCourseDatabase() {
        return courseDatabase;
    }

    public void setCourseDatabase(Map<Integer, Course> courseDatabase) {
        this.courseDatabase = courseDatabase;
    }

    public void addCourse(Course course) {
        courseDatabase.put(course.getCourseId(), course);
    }

    public void updateCourse(Course updatedCourse) {
        courseDatabase.put(updatedCourse.getCourseId(), updatedCourse);
    }

    public void deleteCourse(int courseId) {
        courseDatabase.remove(courseId);
    }

    public Course getCourse(int courseId) {
        return courseDatabase.get(courseId);
    }

    public void runMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Course");
            System.out.println("2. Update Course Info");
            System.out.println("3. Delete Course");
            System.out.println("4. Get Course by ID");
            System.out.println("5. Display All Courses");
            System.out.println("6. Enroll Student");
            System.out.println("7. Update Student Info");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCourseFromInput();
                    break;
                case 2:
                    updateCourseFromInput();
                    break;
                case 3:
                    deleteCourseFromInput();
                    break;
                case 4:
                    getCourseById();
                    break;
                case 5:
                    displayAllCourses();
                    break;
                case 6:
                    enrollStudent();
                    break;
                case 7:
                    StudentInfo();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void StudentInfo() {

        while(true) {
            System.out.println("\n1. Display Student Information");
            System.out.println("2. Delete student");
            System.out.println("3. Update Student Info");
            System.out.println("4. Get Student By Id");
            System.out.println("5. exit");
            System.out.println("Enter choice");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayAllStudents();
                    break;
                case 2:
                    deleteStudentFromInput();
                    break;
                case 3:
                    updateStudentFromInput();
                    break;
                case 4:
                    getStudentById();
                    break;
                case 5:
                    return ;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }

    public void addStudent(Student student) {
        studentDatabase.put(student.getStudentId(), student);
    }

    public void updateStudent(Student updatedStudent) {
        studentDatabase.put(updatedStudent.getStudentId(), updatedStudent);
    }

    public void deleteStudent(int studentId) {
        studentDatabase.remove(studentId);
    }

    public Student getStudent(int studentId) {
        return studentDatabase.get(studentId);
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
        if (studentDatabase.isEmpty()) {
            System.out.println("No student found");
            return;
        }


        System.out.println("Students List:");
        for (Student i : studentDatabase.values()) {
            System.out.println(i);
        }
    }

    private void updateStudentFromInput() {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        Student existingStudent = getStudent(id);
        if (existingStudent != null) {
            System.out.print("Enter updated student name: ");
            String name = scanner.next();
            existingStudent.setName(name);
            updateStudent(existingStudent);
            System.out.println("Student name updated successfully.");
        } else {
            System.out.println("Student not found with ID " + id);
        }
    }

    private void enrollStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        if (studentDatabase.containsKey(id)) {
            return ;
        }
        System.out.print("Enter student name: ");
        String name = scanner.next();

        System.out.print("Enter course id: ");
        int courseId = scanner.nextInt();
        if (!courseDatabase.containsKey(courseId)) {
            System.out.println("course not found so add course");
            addCourseFromInput();
        }
        Student newStudent = new Student();
        newStudent.setStudentId(id);
        newStudent.setName(name);
        newStudent.setEnrolledCourseId(courseId);
        studentDatabase.put(id, newStudent);
        System.out.println("Student added successfully.");

    }

    private void addCourseFromInput() {
        System.out.print("Enter course ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter course name: ");
        String name = scanner.next();
        System.out.print("Enter course duration: ");
        String duration = scanner.next();

        Course newCourse = new Course();
        newCourse.setCourseId(id);
        newCourse.setCourseName(name);
        newCourse.setCourseDuration(duration);
        addCourse(newCourse);
        System.out.println("Course added successfully.");
    }

    private void updateCourseFromInput() {
        System.out.print("Enter course ID to update: ");
        int id = scanner.nextInt();
        Course existingCourse = getCourse(id);
        if (existingCourse != null) {
            System.out.print("Enter updated course duration: ");
            String duration = scanner.next();
            existingCourse.setCourseDuration(duration);
            updateCourse(existingCourse);
            System.out.println("Course duration updated successfully.");
        } else {
            System.out.println("Course not found with ID " + id);
        }
    }

    private void deleteCourseFromInput() {
        System.out.print("Enter course ID to delete: ");
        int id = scanner.nextInt();
        Course existingCourse = getCourse(id);
        if (existingCourse != null) {
            deleteCourse(id);
            System.out.println("Course deleted successfully.");
        } else {
            System.out.println("Course not found with ID " + id);
        }
    }

    private void getCourseById() {
        System.out.print("Enter course ID to retrieve: ");
        int id = scanner.nextInt();
        Course existingCourse = getCourse(id);
        if (existingCourse != null) {
            System.out.println("Course details:");
            System.out.println(existingCourse);
        } else {
            System.out.println("Course not found with ID " + id);
        }
    }

    public void displayAllCourses() {
        System.out.println("Courses List:");
        for (Course i : courseDatabase.values()) {
            System.out.println(i);
        }
    }
}
