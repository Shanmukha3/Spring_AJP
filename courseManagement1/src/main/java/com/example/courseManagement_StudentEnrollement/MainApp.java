package com.example.courseManagement_StudentEnrollement;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example")
public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);
        CourseService courseService = (CourseService)context.getBean("courseService");
        courseService.runMenu();

    }

}
