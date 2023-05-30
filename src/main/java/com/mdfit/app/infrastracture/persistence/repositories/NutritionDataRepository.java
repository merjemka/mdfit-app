package com.mdfit.app.infrastracture.persistence.repositories;

import com.mdfit.app.domain.model.NutritionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NutritionDataRepository extends JpaRepository<NutritionData, Long> {

    @Query(nativeQuery = true,value = " select nu.* from nutrition_data nu join diary_entries de on de.diary_entry_id = nu.diary_entry_id join fitness_diaries fd on fd.fitness_diary_id = de.fitness_diary_id join users u on u.user_id = fd.user_id where u.user_id = :userId")
    List<NutritionData> getNutritionDataByUserId(@Param("userId") Long userId);
}