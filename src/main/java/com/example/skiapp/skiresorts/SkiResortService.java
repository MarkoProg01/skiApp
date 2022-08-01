package com.example.skiapp.skiresorts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service //Business Service(Biznis logika)
public class SkiResortService {
    @Autowired
    SkiResortRepository repository;


    public SkiResortService() {
        super();
    }
    public List<SkiResort> getAllSkiResorts(){

        return repository.findAll();
    }

    public Optional<SkiResort> getSkiResortById(int id) { //Umesto public Country ide Optional<Country>
       return repository.findById(id);

    }
    //Ako u skiResort Repository ne prihvati findByCountryId/
    public List<SkiResort> getSkiResortByCountryId(int id) { //Umesto public Country ide Optional<Country>
        return repository.findByCountryId(id);

    }
    //Ako u skiResort ne prihvati findByName
    public List<SkiResort> getSkiResortByName(String name) { //Umesto public Country ide Optional<Country>
        return repository.findByName(name);

    }

    public void addSkiResorts(SkiResort skiResort) {
        repository.save(skiResort);
        /*Ako ubacimo iste podatke sa primarnim kljucem koji vec
        postoji u bazi oon ce postojeci da zameni sa ovim koji unosimo*/

    }

    public void updateSkiResorts(SkiResort skiResort) {
        repository.save(skiResort);
    }

    public void removeSkiResortById(int id) {
      repository.deleteById(id);
     // repository.delete(country);
    }
}
