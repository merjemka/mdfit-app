package com.mdfit.app.domain.controllers;

import com.mdfit.app.domain.dto.DiaryEntryDTO;
import com.mdfit.app.domain.model.DiaryEntry;
import com.mdfit.app.domain.services.DiaryEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diary-entry")
public class DiaryEntryController {

    @Autowired
    private DiaryEntryService diaryEntryService;

    @GetMapping
    public ResponseEntity<List<DiaryEntry>> findAll() {
        return new ResponseEntity<>(diaryEntryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiaryEntry> findById(@PathVariable Long id) {
        return new ResponseEntity<>(diaryEntryService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DiaryEntry> create(@RequestBody DiaryEntryDTO diaryEntryDTO) {
        return new ResponseEntity<>(diaryEntryService.create(diaryEntryDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiaryEntry> update(@PathVariable Long id, @RequestBody DiaryEntry diaryEntry) {
        return new ResponseEntity<>(diaryEntryService.update(id, diaryEntry), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        diaryEntryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}