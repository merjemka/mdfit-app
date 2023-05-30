package com.mdfit.app.domain.controllers;

import com.mdfit.app.domain.model.FitnessDiary;
import com.mdfit.app.domain.model.Workout;
import com.mdfit.app.domain.services.FitnessDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fitness-diary")
public class FitnessDiaryController {

    @Autowired
    private FitnessDiaryService fitnessDiaryService;

    @GetMapping
    public ResponseEntity<List<FitnessDiary>> findAll() {
        return new ResponseEntity<>(fitnessDiaryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FitnessDiary> findById(@PathVariable Long id) {
        return new ResponseEntity<>(fitnessDiaryService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FitnessDiary> create(@RequestBody FitnessDiary fitnessDiary) {
        return new ResponseEntity<>(fitnessDiaryService.create(fitnessDiary), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FitnessDiary> update(@PathVariable Long id, @RequestBody FitnessDiary fitnessDiary) {
        return new ResponseEntity<>(fitnessDiaryService.update(id, fitnessDiary), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fitnessDiaryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<FitnessDiary> getByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(fitnessDiaryService.getFitnessDiaryByUserId(userId), HttpStatus.OK);
    }


}