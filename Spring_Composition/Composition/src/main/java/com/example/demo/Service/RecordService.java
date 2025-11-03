package com.example.demo.Service;


import com.example.demo.Entity.Doctor;
import com.example.demo.Entity.Patient;
import com.example.demo.Repository.DoctorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService implements CommandLineRunner {
    private DoctorRepository doctor;

    public RecordService(DoctorRepository doctor){
        this.doctor = doctor;
    }


    @Override
    public void run(String... args) throws Exception {
        Patient p1 = Patient.builder().name("Ravi").age(25).disease("Flu").build();
        Patient p2 = Patient.builder().name("Sita").age(30).disease("Cold").build();

        Doctor d = Doctor.builder()
                .name("Dr. Sharma")
                .specialization("General Physician")
                .patients(List.of(p1, p2))
                .build();

        doctor.save(d);
    }
}
