package com.example.skiapp.countries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {
    @RequestMapping("/countries")
    public List<Country> getCountries(){
        //Business logic
        //JSON
        //Ovi podaci se ćesto smeštaju u Service klasu
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country(1,"Serbia","Serbia description"));
        countries.add(new Country(2,"Slovenia","Slovenia description"));
        countries.add(new Country(3,"Croatia","Croatia description"));
        countries.add(new Country(4,"BIH","BIH description"));
        countries.add(new Country(5,"Montenegro","Montenegro description"));
        return countries;

    }
}
