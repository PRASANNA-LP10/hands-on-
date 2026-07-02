package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Service
@Component
public class CountryService {

    ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
    List<Country> list=context.getBean("list", ArrayList.class);



    public List<Country> getAllCountry(){
        return list;
    }


    public Country getCountryBasedOnCode(String code){
        for(Country c:list){
            if(c.getCode().equals(code.toUpperCase()))return c;
        }
        return null;
    }

}
