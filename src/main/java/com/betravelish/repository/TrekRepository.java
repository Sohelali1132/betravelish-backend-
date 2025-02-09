package com.betravelish.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.betravelish.model.Trek;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface TrekRepository extends JpaRepository<Trek, Long> {
    Page<Trek> findAll(Pageable pageable);
}
