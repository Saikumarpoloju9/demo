package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("hi sai");
		for(int i=1;i<=5;i++)
		{
			System.out.println(i);
			System.out.println("---------");
	
	}
	}

}
