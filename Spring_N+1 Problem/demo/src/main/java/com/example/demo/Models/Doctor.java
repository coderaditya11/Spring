package com.example.demo.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "doctor",fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Patient> patients;


    public Long getId() { return id; }
    public String getName() { return name; }
    public List<Patient> getPatients() { return patients; }


}
