package com.mdfit.app.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id @GeneratedValue(
            strategy = GenerationType.IDENTITY
    ) private Long userId;

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
            name = "address"
    ) private String address;

    @Column(
            name = "age"
    ) private Integer age;

    @Column(
            name = "gender"
    ) private String gender;

    @Column(
            name = "height"
    ) private Integer height;

    @Column(
            name = "weight"
    ) private Integer weight;

    @Column(
            name = "fitness_goal"
    ) private String fitnessGoal;






}
