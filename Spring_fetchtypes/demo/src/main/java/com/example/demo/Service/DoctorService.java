package com.example.demo.Service;


import com.example.demo.Entities.Doctor;
import com.example.demo.Entities.Patient;
import com.example.demo.Repositories.DoctorRepository;
import com.example.demo.Repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;

public class DoctorService implements CommandLineRunner {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public DoctorService(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (doctorRepository.count() == 0) {
            Doctor doctor = new Doctor();
            doctor.setName("Dr. Sharma");

            Patient p1 = new Patient();
            p1.setName("Alice");
            p1.setDoctor(doctor);

            Patient p2 = new Patient();
            p2.setName("Bob");
            p2.setDoctor(doctor);

            doctor.getPatients().add(p1);
            doctor.getPatients().add(p2);

            doctorRepository.save(doctor);
        }
        System.out.println("\n==== Fetching Doctor ====");
        Doctor doctor = doctorRepository.findById(1L).orElseThrow();
        System.out.println("Doctor: " + doctor.getName());

        System.out.println("\n==== Accessing Patients ====");
        System.out.println("Total Patients: " + doctor.getPatients().size());

    }
}
