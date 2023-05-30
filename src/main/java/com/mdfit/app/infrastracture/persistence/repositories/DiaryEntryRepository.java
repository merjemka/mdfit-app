package com.mdfit.app.infrastracture.persistence.repositories;

import com.mdfit.app.domain.model.DiaryEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryEntryRepository extends JpaRepository<DiaryEntry, Long> {
}
