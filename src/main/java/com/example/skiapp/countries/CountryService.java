package com.example.skiapp.countries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service //Business Service(Biznis logika)
public class CountryService {
    @Autowired
    CountryRepository repository;


    public CountryService() {
        super();


    }
    public List<Country> getAllCountries(){
        return repository.findAll();
    }

    public Optional<Country> getCountryById(int id) { //Umesto public Country ide Optional<Country>
       return repository.findById(id);

    }

    public void addCountry(Country country) {
        repository.save(country);
        /*Ako ubacimo iste podatke sa primarnim kljucem koji vec
        postoji u bazi oon ce postojeci da zameni sa ovim koji unosimo*/

    }

    public void updateCountry(Country country) {
        repository.save(country);
    }

    public void removeCountryById(int id) {
      repository.deleteById(id);
     // repository.delete(country);
    }
}
