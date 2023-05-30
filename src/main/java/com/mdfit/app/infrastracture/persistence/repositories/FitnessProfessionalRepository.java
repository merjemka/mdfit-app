package com.mdfit.app.infrastracture.persistence.repositories;

import com.mdfit.app.domain.model.FitnessProfessional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FitnessProfessionalRepository extends JpaRepository<FitnessProfessional, Long> {
}