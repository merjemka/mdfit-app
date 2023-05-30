package com.mdfit.app.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "nutrition_data")
public class NutritionData {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    ) private Long nutritionDataId;

    @Column(
            name = "food_name",
            nullable = false
    ) private String foodName;

    @Column
    private double calories;

    @Column
    private double protein;

    @Column
    private double carbs;

    @Column
    private double fats;

    @JsonBackReference
    @ManyToOne @JoinColumn(
            name="diary_entry_id"
    ) private DiaryEntry diaryEntry;

    public NutritionData(String foodName, double calories, double protein, double carbs, double fats, DiaryEntry diaryEntry) {
        this.foodName = foodName;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
        this.diaryEntry = diaryEntry;
    }

}
