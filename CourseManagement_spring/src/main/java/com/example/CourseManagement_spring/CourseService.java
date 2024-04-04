package com.example.CourseManagement_spring;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.CourseManagement_spring.Course;

@Service
public class CourseService  {
    @Autowired
    private Course course;
    private Map<Integer, Course> courseDatabase = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

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
        courseDatabase.put(course.getId(), course);
    }

    public void updateCourse(Course updatedCourse) {
        courseDatabase.put(updatedCourse.getId(), updatedCourse);
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
            System.out.println("6. Exit");
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
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void addCourseFromInput() {
        System.out.print("Enter course ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter course name: ");
        String name = scanner.next();
        System.out.print("Enter course duration: ");
        String courseDuration = scanner.next();
        
        Course newCourse = new Course();
        newCourse.setId(id);
        newCourse.setCourseName(name);
        newCourse.setCourseduration(courseDuration);
        addCourse(newCourse);
        System.out.println("Course added successfully.");
    }

    private void updateCourseFromInput() {
        System.out.print("Enter course ID to update: ");
        int id = scanner.nextInt();
        Course existingCourse = getCourse(id);
        if (existingCourse != null) {
            System.out.print("Enter updated course name: ");
            String name = scanner.next();
            existingCourse.setCourseName(name);
            System.out.print("Enter updated course duration: ");
            String courseDuration = scanner.next();
            existingCourse.setCourseduration(courseDuration);
            updateCourse(existingCourse);
            System.out.println("Course info updated successfully.");
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
        for (Course course : courseDatabase.values()) {
            System.out.println(course);
        }
    }
}
