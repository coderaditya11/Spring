package com.example.demo.Service;

import com.example.demo.Models.Doctor;
import com.example.demo.Repositories.DoctorRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService implements CommandLineRunner {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
       showDoctorsAndPatients();
    }


    public void showDoctorsAndPatients(){
        System.out.println("\n--- Fetching all doctors ---");
        List<Doctor> doctors = doctorRepository.findAll();

        System.out.println("\n--- Displaying doctor details ---");

        for (Doctor d : doctors) {
            System.out.println(d.getName() + " has " + d.getPatients().size() + " patients");
        }
    }


}
