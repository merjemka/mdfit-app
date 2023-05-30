package com.mdfit.app.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "workouts")
public class Workout {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    ) private Long workoutId;

    @Column(
            name = "title",
            nullable = false
    ) private String title;

    @Column(
            name = "video_link",
            nullable = false
    ) private String videoLink;

    @JsonBackReference
    @ManyToOne @JoinColumn(
            name="fitness_professional_id"
    ) private FitnessProfessional fitnessProfessional;

    @Column
    private String description;

    @ToString.Exclude
    @JsonManagedReference
    @OneToMany (
            mappedBy= "workout"
    ) private List<ActivityData> activityDataList;

    public Workout(String title, String videoLink, FitnessProfessional fitnessProfessional, String description) {
        this.title = title;
        this.videoLink = videoLink;
        this.fitnessProfessional = fitnessProfessional;
        this.description = description;
    }
}
