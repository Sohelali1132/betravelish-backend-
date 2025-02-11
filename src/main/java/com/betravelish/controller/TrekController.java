package com.betravelish.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import jakarta.validation.Valid;
import com.betravelish.model.Trek;
import com.betravelish.service.TrekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;

@RestController
@RequestMapping("/api/treks")
public class TrekController {

    @Autowired
    private TrekService trekService;

    // Get all treks (Paginated)
    @GetMapping
    public List<Trek> getAllTreks() {
        return trekService.getAllTreks();
    }
    

    // Get trek by ID
    @GetMapping("/{id}")
    public ResponseEntity<Trek> getTrekById(@PathVariable Long id) {
        return trekService.getTrekById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new trek
    @PostMapping
    public ResponseEntity<?> createTrek(@Valid @RequestBody Trek trek, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }
        Trek savedTrek = trekService.createTrek(trek);
        return ResponseEntity.ok(savedTrek);
    }

    // Update an existing trek
    @PutMapping("/{id}")
    public ResponseEntity<Trek> updateTrek(@PathVariable Long id, @Valid @RequestBody Trek updatedTrek, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(null);
        }
        Trek updated = trekService.updateTrek(id, updatedTrek);
        return ResponseEntity.ok(updated);
    }

    // Delete a trek
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrek(@PathVariable Long id) {
        trekService.deleteTrek(id);
        return ResponseEntity.noContent().build();
    }
}
