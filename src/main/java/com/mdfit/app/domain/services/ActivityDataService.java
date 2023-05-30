package com.mdfit.app.domain.services;

import com.mdfit.app.domain.dto.ActivityDataDTO;
import com.mdfit.app.domain.model.ActivityData;
import com.mdfit.app.infrastracture.persistence.repositories.ActivityDataRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityDataService {
    @Autowired
    ActivityDataRepository activityDataRepository;
    @Autowired
    UserService userService;
    @Autowired
    WorkoutService workoutService;
    @Autowired
    DiaryEntryService diaryEntryService;

    public List<ActivityData> findAll() {
        return activityDataRepository.findAll();
    }

    public ActivityData findById(Long id) {
        return activityDataRepository.findById(id).orElse(null);
    }

    public ActivityData create(@NotNull ActivityDataDTO activityDataDTO) {
        return activityDataRepository.save(
                new ActivityData(
                    userService.findById(activityDataDTO.getUserId()),
                    activityDataDTO.getDuration(),
                    activityDataDTO.getActivityType(),
                    diaryEntryService.findById(activityDataDTO.getDiaryEntryId()),
                    workoutService.findById(activityDataDTO.getWorkoutId())
                )
        );
    }

    public ActivityData update(Long id, ActivityData activityData) {
        if (activityDataRepository.existsById(id)) {
            activityData.setActivityId(id);
            return activityDataRepository.save(activityData);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        activityDataRepository.deleteById(id);
    }

    public List<ActivityData> getActivityDataByUserId(Long userId){
        return activityDataRepository.getActivityDataByUserId(userId);
    }
}
