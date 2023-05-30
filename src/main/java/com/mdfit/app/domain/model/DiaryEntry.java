package com.mdfit.app.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "diary_entries")
public class DiaryEntry {

    @Id @GeneratedValue(
        strategy = GenerationType.IDENTITY
    ) private Long diaryEntryId;

    @Column(
            name = "log_date_name",
            columnDefinition = "DATETIME"
    ) private LocalDateTime logDateName;

    @JsonBackReference
    @ManyToOne @JoinColumn(
            name="fitness_diary_id"
    ) private FitnessDiary fitnessDiary;


    @ToString.Exclude
    @JsonManagedReference
    @OneToMany (
            mappedBy= "diaryEntry"
    ) private List<ActivityData> activityDataList;

    @ToString.Exclude
    @JsonManagedReference
    @OneToMany (
            mappedBy= "diaryEntry"
    ) private List<NutritionData> nutritionDataList;

    public DiaryEntry(LocalDateTime logDateName, FitnessDiary fitnessDiary) {
        this.logDateName = logDateName;
        this.fitnessDiary = fitnessDiary;
    }
}
