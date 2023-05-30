package com.mdfit.app.domain.controllers;

import com.mdfit.app.domain.dto.NutritionDataDTO;
import com.mdfit.app.domain.model.NutritionData;
import com.mdfit.app.domain.services.NutritionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nutrition-data")
public class NutritionDataController {

    @Autowired
    private  NutritionDataService nutritionDataService;

    @GetMapping
    public ResponseEntity<List<NutritionData>> findAll() {
        List<NutritionData> nutritionDataList = nutritionDataService.findAll();
        return new ResponseEntity<>(nutritionDataList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NutritionData> findById(@PathVariable Long id) {
        return new ResponseEntity<>(nutritionDataService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<NutritionData>> getByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(nutritionDataService.getNutritionDataByUserId(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NutritionData> create(@RequestBody NutritionDataDTO nutritionDataDTO) {
        return new ResponseEntity<>(nutritionDataService.create(nutritionDataDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NutritionData> update(@PathVariable Long id, @RequestBody NutritionData nutritionData) {
        return new ResponseEntity<>(nutritionDataService.update(id, nutritionData), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        nutritionDataService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
