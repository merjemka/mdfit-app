package com.mdfit.app.domain.services;

import com.mdfit.app.domain.dto.FitnessProfessionalDTO;
import com.mdfit.app.domain.model.ActivityData;
import com.mdfit.app.domain.model.FitnessProfessional;
import com.mdfit.app.infrastracture.persistence.repositories.FitnessProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnessProfessionalService {


    @Autowired
    FitnessProfessionalRepository fitnessProfessionalRepository;

    public List<FitnessProfessional> findAll() {
        return fitnessProfessionalRepository.findAll();
    }

    public FitnessProfessional findById(Long id) {
        return fitnessProfessionalRepository.findById(id).orElse(null);
    }

    public FitnessProfessional create(FitnessProfessionalDTO fitnessProfessionalDTO) {
        FitnessProfessional fitnessProfessional = fitnessProfessionalRepository.save(new FitnessProfessional(
                fitnessProfessionalDTO.getName(),
                fitnessProfessionalDTO.getEmail(),
                fitnessProfessionalDTO.getPassword(),
                fitnessProfessionalDTO.getExperience(),
                fitnessProfessionalDTO.getSpeciality()
        ));
        return fitnessProfessionalRepository.save(fitnessProfessional);
    }

    public FitnessProfessional update(Long id, FitnessProfessional fitnessProfessional) {
        if (fitnessProfessionalRepository.existsById(id)) {
            fitnessProfessional.setFitnessProfessionalId(id);
            return fitnessProfessionalRepository.save(fitnessProfessional);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        fitnessProfessionalRepository.deleteById(id);
    }


}
