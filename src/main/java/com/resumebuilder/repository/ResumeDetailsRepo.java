package com.resumebuilder.repository;

import com.resumebuilder.pojo.ResumeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResumeDetailsRepo extends JpaRepository<ResumeDetails, Long> {
    Optional<ResumeDetails> findByEmail(String email);
}
