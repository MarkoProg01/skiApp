package com.example.skiapp.skiresorts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkiResortRepository extends JpaRepository<SkiResort,Integer> {

    public List<SkiResort> findByName(String name);
    public List<SkiResort> findByCountryId(Integer id);
}
