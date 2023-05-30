package com.mdfit.app.domain.services;

import com.mdfit.app.domain.dto.WorkoutDTO;
import com.mdfit.app.domain.model.ActivityData;
import com.mdfit.app.domain.model.User;
import com.mdfit.app.domain.model.Workout;
import com.mdfit.app.infrastracture.persistence.repositories.WorkoutRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

    @Autowired
    WorkoutRepository workoutRepository;

    @Autowired
    FitnessProfessionalService fitnessProfessionalService;

    public List<Workout> findAll() {
        return workoutRepository.findAll();
    }

    public Workout findById(Long id) {
        return workoutRepository.findById(id).orElseThrow();
    }

    public Workout create(@NotNull WorkoutDTO workoutDTO) {
        return workoutRepository.save(
                new Workout(
                        workoutDTO.getTitle(),
                        workoutDTO.getVideoLink(),
                        fitnessProfessionalService.findById(workoutDTO.getFitnessProfessionalId()),
                        workoutDTO.getDescription()
                )
        );
    }

    public Workout update(Long id, WorkoutDTO workoutDTO) {
        Optional<Workout> workout = workoutRepository.findById(id);

        if (workout.isPresent()) {
            workout.get().setTitle(workoutDTO.getTitle());
            workout.get().setDescription(workoutDTO.getDescription());
            workout.get().setVideoLink(workoutDTO.getVideoLink());

            return workoutRepository.save(workout.get());
        } else throw new RuntimeException("Workout not found.");
    }

    public void delete(Long id) {
        workoutRepository.deleteById(id);
    }

    public List<Workout> getWorkoutsByUserId(Long userId){
        return workoutRepository.getWorkoutsByUserId(userId);
    }
}