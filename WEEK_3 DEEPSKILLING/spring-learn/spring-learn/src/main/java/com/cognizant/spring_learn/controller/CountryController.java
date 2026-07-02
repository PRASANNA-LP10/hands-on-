package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    @Autowired
    CountryService countryService;



    @GetMapping("/Countries")
    public List<Country> getAllCountry(){

        return countryService.getAllCountry();

    }

    @GetMapping("/Countries/{code}")
    public Country getCountryBasedOnCode(@PathVariable String code){
        return countryService.getCountryBasedOnCode(code);
    }
}
