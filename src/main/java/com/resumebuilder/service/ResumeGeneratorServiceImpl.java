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

import java.util.Optional;

@Service
public class ResumeGeneratorServiceImpl {
    @Autowired
    private ResumeDetailsRepo resumeDetailsRepo;



   public ResumeDetails saveResumeDetails(ResumeDetails details) {
        details.getAcademicDetail().forEach(o->o.setResumeDetails(details));
        details.getExperienceDetail().forEach(o->o.setResumeDetails(details));
        details.getSkillsets().forEach(o->o.setResumeDetails(details));
        details.setAcademicDetail(details.getAcademicDetail());
        details.setExperienceDetail(details.getExperienceDetail());
        details.setSkillsets(details.getSkillsets());
        return resumeDetailsRepo.save(details);
    }
    public Optional<ResumeDetails> getResumeDetails(String email) {
        return resumeDetailsRepo.findByEmail(email);
    }

}
