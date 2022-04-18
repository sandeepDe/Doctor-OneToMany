package com.doctorapp.model;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Doctor {

    @Column(length = 40)
    private String doctorName;

    @Id
    @GeneratedValue(generator = "doctor_gen" , strategy = GenerationType.AUTO)
    @SequenceGenerator(name="doctor_gen" , sequenceName = "doctor_seq" , initialValue = 10 , allocationSize = 1)
    private Integer doctorId;

    @Column(length = 40)
    private double fees;

    @Column(length = 40)
    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @Column(length = 40)
    @Enumerated(EnumType.STRING)
    private Proficiency proficiency;

    @Column(length = 40 )
    private String location;


    @Column
    private Integer experience;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private Set<Patient> patients;

    public Doctor(String doctorName, double fees, Specialization specialization, Proficiency proficiency, String location, Integer experience) {
        this.doctorName = doctorName;
        this.fees = fees;
        this.specialization = specialization;
        this.proficiency = proficiency;
        this.location = location;
        this.experience = experience;
    }
}




