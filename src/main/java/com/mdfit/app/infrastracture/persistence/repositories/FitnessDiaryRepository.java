package com.mdfit.app.infrastracture.persistence.repositories;

import com.mdfit.app.domain.model.FitnessDiary;
import com.mdfit.app.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnessDiaryRepository extends JpaRepository<FitnessDiary, Long> {

    FitnessDiary findByUser(User user);
}