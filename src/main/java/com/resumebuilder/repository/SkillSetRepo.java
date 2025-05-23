package com.resumebuilder.repository;

import com.resumebuilder.pojo.AcademicDetails;
import com.resumebuilder.pojo.SkillSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillSetRepo extends JpaRepository<SkillSet, Long> {

}
