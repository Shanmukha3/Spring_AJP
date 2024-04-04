package com.javatpoint.springboothelloworldexample;  
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;  
@SpringBootApplication 
@ComponentScan(basePackages=("com.javatpoint.controller"))
public class SpringBootHelloWorldExampleApplication  
{  
	public static void main(String[] args)   
	{  
	SpringApplication.run(SpringBootHelloWorldExampleApplication.class, args);  
	}  
}  