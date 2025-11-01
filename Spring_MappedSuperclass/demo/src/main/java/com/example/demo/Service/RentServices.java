package com.example.demo.Service;


import com.example.demo.Entity.Dalal;
import com.example.demo.Entity.HouseOwner;
import com.example.demo.Repository.RentRepository;
import lombok.Builder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RentServices implements CommandLineRunner {

    private RentRepository raman;

    public RentServices(RentRepository raman){
        this.raman = raman;
    }


    @Override
    public void run(String... args) throws Exception {


        Dalal d1 = Dalal.builder()
                .Address("R.B. 3 vasant colony")
                .Agreement("Bacha huya hai")
                .Review("GOOD ENVIRONMENT").build();


        Dalal d2 = Dalal.builder()
                .Address("Sector 62, Noida")
                .Agreement("3 months left")
                .Review("Nice area")
                .build();

        Dalal d3 = Dalal.builder()
                .Address("Rajiv Chowk, Delhi")
                .Agreement("Expired")
                .Review("Too noisy")
                .build();

        // Save all at once
        raman.saveAll(List.of(d1, d2, d3));

    }
}
