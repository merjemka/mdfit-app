package com.mdfit.app.domain.services;

import com.mdfit.app.domain.dto.DiaryEntryDTO;
import com.mdfit.app.domain.model.DiaryEntry;
import com.mdfit.app.infrastracture.persistence.repositories.DiaryEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryEntryService {

    @Autowired
    FitnessDiaryService fitnessDiaryService;
    @Autowired
    DiaryEntryRepository diaryEntryRepository;


    public List<DiaryEntry> findAll() {
        return diaryEntryRepository.findAll();
    }

    public DiaryEntry findById(Long id) {
        return diaryEntryRepository.findById(id).orElse(null);
    }

    public DiaryEntry create(DiaryEntryDTO diaryEntryDTO) {

        return diaryEntryRepository.save(new DiaryEntry(
                diaryEntryDTO.getLogDateName(),
                fitnessDiaryService.findById(diaryEntryDTO.getFitnessDiaryId())
        ));
    }

    public DiaryEntry update(Long id, DiaryEntry diaryEntry) {
        if (diaryEntryRepository.existsById(id)) {
            diaryEntry.setDiaryEntryId(id);
            return diaryEntryRepository.save(diaryEntry);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        diaryEntryRepository.deleteById(id);
    }
}
