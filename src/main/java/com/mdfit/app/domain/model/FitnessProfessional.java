package com.mdfit.app.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fitness_professional")
public class FitnessProfessional {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    ) private Long fitnessProfessionalId;

    @Column(
            name = "name",
            nullable = false
    ) private String name;

    @Column(
            name = "email",
            nullable = false
    ) private String email;

    @Column(
            name = "password",
            nullable = false
    ) private String password;

    @Column(
            name = "experience",
            nullable = false
    ) private Integer experience;

    @Column(
            name = "speciality",
            nullable = false
    ) private String speciality;

    @ToString.Exclude
    @JsonManagedReference
    @OneToMany (
            mappedBy= "fitnessProfessional"
    ) private List<Workout> workouts;

    public FitnessProfessional(String name, String email, String password, Integer experience, String speciality) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.experience = experience;
        this.speciality = speciality;
        this.workouts = workouts;
    }
}
