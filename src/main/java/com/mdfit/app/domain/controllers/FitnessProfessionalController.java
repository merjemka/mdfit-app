package com.mdfit.app.domain.controllers;

import com.mdfit.app.domain.dto.FitnessProfessionalDTO;
import com.mdfit.app.domain.model.FitnessProfessional;
import com.mdfit.app.domain.services.FitnessProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fitness-professionals")
public class FitnessProfessionalController {

    @Autowired
    private  FitnessProfessionalService fitnessProfessionalService;

    @GetMapping
    public ResponseEntity<List<FitnessProfessional>> findAll() {
        return new ResponseEntity<>(fitnessProfessionalService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FitnessProfessional> findById(@PathVariable Long id) {
        return new ResponseEntity<>(fitnessProfessionalService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FitnessProfessional> create(@RequestBody FitnessProfessionalDTO fitnessProfessionalDTO) {
        return new ResponseEntity<>(fitnessProfessionalService.create(fitnessProfessionalDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FitnessProfessional> update(@PathVariable Long id, @RequestBody FitnessProfessional fitnessProfessional) {
        return new ResponseEntity<>(fitnessProfessionalService.update(id, fitnessProfessional), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fitnessProfessionalService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
