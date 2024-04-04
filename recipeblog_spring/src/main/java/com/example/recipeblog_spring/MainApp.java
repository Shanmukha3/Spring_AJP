//package com.example.recipeblog_spring;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@ComponentScan("com.example")
//public class MainApp {
//
//    public static void main(String[] args) {
//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);
//        RecipeService recipeService = (RecipeService)context.getBean("recipeService");
//        recipeService.start();
//    }
//
//}

package com.example.recipeblog_spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Configuration
@ComponentScan("com.example")
public class MainApp {

    private static final Map<String, String> USERS = new HashMap<>();
    private static final Scanner SCANNER = new Scanner(System.in);

    static {
        USERS.put("shannu", "shannu");
 
    }

    public static void main(String[] args) {
        System.out.print("Enter username: ");
        String username = SCANNER.next();
        System.out.print("Enter password: ");
        String password = SCANNER.next();

        if (authenticate(username, password)) {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);
            RecipeService recipeService = context.getBean(RecipeService.class);
            recipeService.start();
        } else {
            System.out.println("Invalid username or password. Access denied.");
        }
    }

    private static boolean authenticate(String username, String password) {
        String storedPassword = USERS.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
}
