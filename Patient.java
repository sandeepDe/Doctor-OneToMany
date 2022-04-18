


package com.doctorapp.model;

import lombok.*;

import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Patient {

    @Column(length = 40)
    private String patientName;

    @Column(length = 40)
    @Id
    @GeneratedValue(generator = "patient_gen" , strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "patient_gen" , sequenceName = "patient_seq" , initialValue = 100 , allocationSize = 1)
    private Integer patientId;

    @Column(length = 40)
    @Enumerated(EnumType.STRING)
    private  Specialization specialization;

    @Column(length = 40)
    private String illness;

   // @Column(length = 40)
   // private Symptoms symptoms (I will add it maam if needed)


    @ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Patient(String patientName, Specialization specialization, String illness) {
        this.patientName = patientName;
        this.specialization = specialization;
        this.illness = illness;
    }
}
