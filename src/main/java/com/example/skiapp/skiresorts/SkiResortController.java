package com.example.skiapp.skiresorts;

import com.example.skiapp.countries.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SkiResortController {
    @Autowired
    SkiResortService service;
    @RequestMapping("/skiresorts")
    public List<SkiResort> getskiresorts(){

        return service.getAllSkiResorts();
    }
    @RequestMapping("skiresorts/{id}")
    public Optional<SkiResort> getSkiResortsById(@PathVariable int id){ // id u vitičastim zagradama iznad ce dati vrednost ovom int id

        return service.getSkiResortById(id);
    }
    @RequestMapping(value = "/skiresorts",method = RequestMethod.POST )
    public void addSkiResorts(@RequestBody SkiResort skiResort){
        service.addSkiResorts(skiResort);
    }
    @RequestMapping(value = "/skiresorts",method = RequestMethod.PUT)

    public void updateSkiResorts(@RequestBody SkiResort skiResort){

         service.updateSkiResorts(skiResort);
    }

    @RequestMapping(value = "skiresorts/{id}",method = RequestMethod.DELETE)
    public void removeSkiResortsById(@PathVariable int id){ // id u vitičastim zagradama iznad ce dati vrednost ovom int id

        service.removeSkiResortById(id);
    }

    @RequestMapping(value = "/countries/{id}/skiresorts",method = RequestMethod.POST )
    public void addSkiResorts(@RequestBody SkiResort skiResort,@PathVariable int id){
        skiResort.setCountry(new Country(id,"",""));
        service.addSkiResorts(skiResort);
        /*Ako postoji drzava sa datim id,on ce je smestiti u skiResort
        ako ne napravice je u bazi sa id koji smo dali ali ce
        polja za name i descr biti prazna ""
         */
    }
    //Ako u skiResort Repository ne prihvati findByCountryId/
    @RequestMapping("/countries/{id}/skiresorts")
    public List<SkiResort> getSkiResortsByCountryId(@PathVariable int id){ // id u vitičastim zagradama iznad ce dati vrednost ovom int id

        return service.getSkiResortByCountryId(id);
    }
    //Ako u skiResort Repository ne prihvati findByName
    @RequestMapping("/skiresorts/byName/{name}")
    public List<SkiResort> getSkiResortsByName(@PathVariable String name){ // id u vitičastim zagradama iznad ce dati vrednost ovom int id

        return service.getSkiResortByName(name);
    }




}

