package com.mdfit.app.domain.services;

import com.mdfit.app.domain.model.FitnessDiary;
import com.mdfit.app.domain.model.User;
import com.mdfit.app.domain.model.Workout;
import com.mdfit.app.infrastracture.persistence.repositories.FitnessDiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnessDiaryService {

    @Autowired
    FitnessDiaryRepository fitnessDiaryRepository;
    @Autowired
    UserService userService;

    public List<FitnessDiary> findAll() {
        return fitnessDiaryRepository.findAll();
    }

    public FitnessDiary findById(Long id) {
        return fitnessDiaryRepository.findById(id).orElse(null);
    }

    public FitnessDiary create(FitnessDiary fitnessDiary) {
        return fitnessDiaryRepository.save(fitnessDiary);
    }

    public FitnessDiary update(Long id, FitnessDiary fitnessDiary) {
        if (fitnessDiaryRepository.existsById(id)) {
            fitnessDiary.setFitnessDiaryId(id);
            return fitnessDiaryRepository.save(fitnessDiary);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        fitnessDiaryRepository.deleteById(id);
    }

    public FitnessDiary getFitnessDiaryByUserId(Long userId){
        User user = userService.findById(userId);
        return fitnessDiaryRepository.findByUser(user);
    }
}
