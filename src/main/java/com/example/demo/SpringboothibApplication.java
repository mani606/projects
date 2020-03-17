package com.example.demo;



import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import com.example.demo.bean.Hobby;

@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
public class SpringboothibApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringboothibApplication.class, args);
		
		
	}

}
