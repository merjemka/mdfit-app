package com.mdfit.app.domain.controllers;

import com.mdfit.app.domain.dto.WorkoutDTO;
import com.mdfit.app.domain.model.ActivityData;
import com.mdfit.app.domain.model.Workout;
import com.mdfit.app.domain.services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;


    @GetMapping
    public ResponseEntity<List<Workout>> findAll() {
        List<Workout> workoutList = workoutService.findAll();
        return new ResponseEntity<>(workoutList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Workout> findById(@PathVariable Long id) {
       return new ResponseEntity<>(workoutService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Workout>> getByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(workoutService.getWorkoutsByUserId(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Workout> create(@RequestBody WorkoutDTO workoutDTO) {
        return new ResponseEntity<>(workoutService.create(workoutDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Workout> update(@PathVariable Long id, @RequestBody WorkoutDTO workoutDTO) {
       return new ResponseEntity<>(workoutService.update(id, workoutDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        workoutService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
