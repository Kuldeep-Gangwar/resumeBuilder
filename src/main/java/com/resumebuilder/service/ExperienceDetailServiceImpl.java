package com.resumebuilder.service;

import com.resumebuilder.pojo.AcademicDetails;
import com.resumebuilder.pojo.ExperienceDetail;
import com.resumebuilder.pojo.ResumeDetails;
import com.resumebuilder.pojo.SkillSet;
import com.resumebuilder.repository.AcademicDeatilsRepo;
import com.resumebuilder.repository.ExperienceDetailsRepo;
import com.resumebuilder.repository.ResumeDetailsRepo;
import com.resumebuilder.repository.SkillSetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceDetailServiceImpl {

    @Autowired
    private ExperienceDetailsRepo experienceDetailsRepo;


    public ExperienceDetail saveExperienceDetails(ExperienceDetail details) {
        details.setResumeDetails(details.getResumeDetails());
        return experienceDetailsRepo.save(details);
    }


}