package com.example.skiapp.countries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CountryController {
    @Autowired
    CountryService service;
    @RequestMapping("/countries")
    public List<Country> getCountries(){
        return service.getAllCountries();
    }
    @RequestMapping("countries/{id}")
    public Optional<Country> getCountryById(@PathVariable int id){ // id u vitičastim zagradama iznad ce dati vrednost ovom int id

        return service.getCountryById(id);
    }
    @RequestMapping(value = "/countries",method = RequestMethod.POST )
    public void addCountry(@RequestBody Country country){
        service.addCountry(country);
    }
    @RequestMapping(value = "/countries",method = RequestMethod.PUT)
    public void updateCountry(@RequestBody Country country){

         service.updateCountry(country);
    }

    @RequestMapping(value = "countries/{id}",method = RequestMethod.DELETE)
    public void removeCountryById(@PathVariable int id){ // id u vitičastim zagradama iznad ce dati vrednost ovom int id

        service.removeCountryById(id);
    }

}

