package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4Jex {

    public static void main(String[] args){
        String name="Prasanna";
        Logger logger= LoggerFactory.getLogger("SampleLogger");
        logger.info("Sample log written by Prasanna");
        logger.error("This is a Error msg");
        logger.warn("Warning from {}",name);
    }
}
