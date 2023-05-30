package com.mdfit.app.infrastracture.persistence.repositories;
import com.mdfit.app.domain.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    @Query(nativeQuery = true,value = " select w.* from workouts w join activity_data ad on w.workout_id = ad.workout_id join diary_entries de on de.diary_entry_id = ad.diary_entry_id join fitness_diaries fd on fd.fitness_diary_id = de.fitness_diary_id join users u on u.user_id = fd.user_id where u.user_id = :userId")
    List<Workout> getWorkoutsByUserId(@Param("userId") Long userId);
}