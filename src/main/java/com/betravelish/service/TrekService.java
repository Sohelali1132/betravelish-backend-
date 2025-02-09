package com.betravelish.service;

import com.betravelish.model.Trek;
import com.betravelish.repository.TrekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrekService {

    @Autowired
    private TrekRepository trekRepository;

    // ✅ Fix: Accept Pageable for pagination
    public Page<Trek> getAllTreks(Pageable pageable) {
        return trekRepository.findAll(pageable);
    }

    public Optional<Trek> getTrekById(Long id) {
        return trekRepository.findById(id);
    }

    public Trek createTrek(Trek trek) {
        return trekRepository.save(trek);
    }

    public Trek updateTrek(Long id, Trek updatedTrek) {
        return trekRepository.findById(id).map(existingTrek -> {
            existingTrek.setName(updatedTrek.getName());
            existingTrek.setLocation(updatedTrek.getLocation());
            existingTrek.setDuration(updatedTrek.getDuration());
            existingTrek.setPrice(updatedTrek.getPrice());
            existingTrek.setDifficulty(updatedTrek.getDifficulty());
            existingTrek.setDescription(updatedTrek.getDescription());
            return trekRepository.save(existingTrek);
        }).orElseThrow(() -> new RuntimeException("Trek not found"));
    }

    public void deleteTrek(Long id) {
        trekRepository.deleteById(id);
    }
}
