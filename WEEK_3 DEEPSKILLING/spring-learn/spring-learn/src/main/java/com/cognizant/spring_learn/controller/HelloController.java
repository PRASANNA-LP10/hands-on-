package com.cognizant.spring_learn.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static  final Logger logger= LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String sayHello(){
        logger.info("Start of sayHello()");
        logger.info("End of sayHello()");
        return "Hello World";

    }


    @GetMapping("/")
    public String home(HttpSession session){
        return "Hello Welcome !!!" + session.getId();
    }
}
