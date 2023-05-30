package com.mdfit.app.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "activity_data")
public class ActivityData {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    ) private Long activityId;

    @JsonManagedReference
    @ManyToOne @JoinColumn (
            name="user",
            nullable = false
    ) private User user;

    @Column
    private Double duration;

    @Column(name = "activity_type")
    private String activityType;

    @JsonBackReference
    @ManyToOne @JoinColumn(
            name="diary_entry_id"
    ) private DiaryEntry diaryEntry;

    @JsonBackReference
    @ManyToOne @JoinColumn(
            name="workout_id"
    ) private Workout workout;

    @Column(
            name = "created_at"
    ) private LocalDateTime createdAt;

    public ActivityData(User user, Double duration, String activityType, DiaryEntry diaryEntry, Workout workout) {
        this.user = user;
        this.duration = duration;
        this.activityType = activityType;
        this.diaryEntry = diaryEntry;
        this.workout = workout;
        this.createdAt = LocalDateTime.now();
    }
}
