package com.mdfit.app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NutritionDataDTO {

    private String foodName;
    private double calories;
    private double protein;
    private double carbs;
    private double fats;
    private Long diaryEntryId;
}
