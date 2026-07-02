package com.cognizant.spring_learn;

import lombok.Getter;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

public class Country {

    private static final Logger logger= LoggerFactory.getLogger(Country.class);


    private  String name;
   private  String code;

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public  Country(){
        logger.info("Inside Country constructor");
        logger.debug("Inside country constructor");
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }



}
