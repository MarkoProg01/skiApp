package com.example.skiapp.countries;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Iterator;

@Service //Business Service(Biznis logika)
public class CountryService {
    private ArrayList<Country> countries = null;


    public CountryService() {
        super();
        countries = new ArrayList<Country>();
        countries.add(new Country(1,"Serbia","Serbia description"));
        countries.add(new Country(2,"Slovenia","Slovenia description"));
        countries.add(new Country(3,"Croatia","Croatia description"));
        countries.add(new Country(4,"BIH","BIH description"));
        countries.add(new Country(5,"Montenegro","Montenegro description"));

    }
    public ArrayList<Country> getAllCountries(){
        return countries;
    }

    public Country getCountryById(int id) {
        /*Ova funkcija trazi uneti id u listi i ako postoji
        vrati nam sve elemente pod tim id-jem ,a ako nema tog
        id,vrati null.
         */
        Iterator<Country> it = countries.iterator();
        Country tempCountry;
        while (it.hasNext()){
            tempCountry = it.next();
            if(tempCountry.getId() == id){
                return tempCountry;
            }
        }
        return null;

        //Preko lamde
       // return countries.stream().filter(t -> (t.getId()==id)).findFirst().get();

    }

    public void addCountry(Country country) {
        countries.add(country);
    }

    public void updateCountry(Country country, int id) {
        Iterator<Country> it = countries.iterator();
        Country tempCountry;
        int i=0;
        while (it.hasNext()){
            tempCountry = it.next();
            if(tempCountry.getId() == id){
                countries.set(i,country);
                return;
            }
            i++;
        }

    }

    public void removeCountryById(int id) {
        Iterator<Country> it = countries.iterator();
        Country tempCountry;
        int i=0;
        while (it.hasNext()){
            tempCountry = it.next();
            if(tempCountry.getId() == id){
                countries.remove(i);
                return;
            }
            i++;
        }
    }
}
