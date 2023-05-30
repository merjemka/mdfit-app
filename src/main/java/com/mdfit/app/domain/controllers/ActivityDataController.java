package com.mdfit.app.domain.controllers;

import com.mdfit.app.domain.dto.ActivityDataDTO;
import com.mdfit.app.domain.model.ActivityData;
import com.mdfit.app.domain.services.ActivityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity-data")
public class ActivityDataController {

    @Autowired
    private ActivityDataService activityDataService;

    @GetMapping
    public ResponseEntity<List<ActivityData>> findAll() {
        return new ResponseEntity<>(activityDataService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityData> findById(@PathVariable Long id) {
        return new ResponseEntity<>(activityDataService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ActivityData>> getByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(activityDataService.getActivityDataByUserId(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ActivityData> create(@RequestBody ActivityDataDTO activityDataDTO) {
        return new ResponseEntity<>(activityDataService.create(activityDataDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityData> update(@PathVariable Long id, @RequestBody ActivityData activityData) {
        return new ResponseEntity<>(activityDataService.update(id, activityData), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        activityDataService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
