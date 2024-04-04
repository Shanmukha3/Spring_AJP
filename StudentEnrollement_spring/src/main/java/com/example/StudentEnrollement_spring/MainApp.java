package com.example.StudentEnrollement_spring;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.example")
public class MainApp {
    public static void main(String[] args) {
        // Load the Spring context
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);

        // Retrieve the bean from the Spring context
        StudentService teamService = (StudentService) context.getBean("studentService");

        teamService.runMenu();
    }
}
