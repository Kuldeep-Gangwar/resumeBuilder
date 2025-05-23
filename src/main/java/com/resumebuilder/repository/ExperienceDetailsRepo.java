package com.resumebuilder.repository;

import com.resumebuilder.pojo.ExperienceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceDetailsRepo extends JpaRepository<ExperienceDetail, Long> {


}