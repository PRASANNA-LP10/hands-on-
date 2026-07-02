package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) throws Exception {
		LOGGER.info("main method executing");
		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
		displayCountry();
	}
	public static void displayDate() throws Exception {
		ApplicationContext context=new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format=context.getBean("dateFormat",SimpleDateFormat.class);
		Date date=format.parse("01/07/2026");
		System.out.println(date);
	}
	public static void displayCountry() {
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		Country country =context.getBean("india", Country.class);
		LOGGER.info("Country : {}", country);

	}

}
