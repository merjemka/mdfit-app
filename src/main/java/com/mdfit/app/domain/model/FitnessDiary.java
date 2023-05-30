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
@Table(name = "fitness_diaries")
public class FitnessDiary {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    ) private Long fitnessDiaryId;

    @ToString.Exclude
    @JsonManagedReference
    @OneToMany (
            mappedBy= "fitnessDiary"
    ) private List<DiaryEntry> diaryEntries;

    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    ) @JoinColumn(
            name = "user_id",
            referencedColumnName = "userId"
    ) private User user;

}
