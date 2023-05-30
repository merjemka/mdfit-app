package com.mdfit.app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDataDTO {

    private Long userId;
    private Double duration;
    private String activityType;
    private Long diaryEntryId;
    private Long workoutId;
}
