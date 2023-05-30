package com.mdfit.app.domain.services;

import com.mdfit.app.domain.dto.NutritionDataDTO;
import com.mdfit.app.domain.model.NutritionData;
import com.mdfit.app.infrastracture.persistence.repositories.NutritionDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NutritionDataService {

    @Autowired
    NutritionDataRepository nutritionDataRepository;

    @Autowired
    DiaryEntryService diaryEntryService;

    public List<NutritionData> findAll() {
        return nutritionDataRepository.findAll();
    }

    public NutritionData findById(Long id) {
        return nutritionDataRepository.findById(id).orElse(null);
    }

    public NutritionData create(NutritionDataDTO nutritionDataDTO) {
        return nutritionDataRepository.save(new NutritionData(
                nutritionDataDTO.getFoodName(),
                nutritionDataDTO.getCalories(),
                nutritionDataDTO.getProtein(),
                nutritionDataDTO.getCarbs(),
                nutritionDataDTO.getFats(),
                diaryEntryService.findById(nutritionDataDTO.getDiaryEntryId())
        ));
    }

    public NutritionData update(Long id, NutritionData nutritionData) {
        if (nutritionDataRepository.existsById(id)) {
            nutritionData.setNutritionDataId(id);
            return nutritionDataRepository.save(nutritionData);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        nutritionDataRepository.deleteById(id);
    }

    public List<NutritionData> getNutritionDataByUserId(Long userId){
        return nutritionDataRepository.getNutritionDataByUserId(userId);
    }
}
