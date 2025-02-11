package com.betravelish.repository;

import java.util.List;
import com.betravelish.model.Trek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrekRepository extends JpaRepository<Trek, Long> {
    // JpaRepository already provides findAll()
}
