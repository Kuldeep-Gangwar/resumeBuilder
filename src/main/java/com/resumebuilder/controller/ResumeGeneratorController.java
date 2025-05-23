package com.resumebuilder.controller;

import com.resumebuilder.aspect.LogExecutionTime;
import com.resumebuilder.pojo.AcademicDetails;
import com.resumebuilder.pojo.ExperienceDetail;
import com.resumebuilder.pojo.ResumeDetails;
import com.resumebuilder.pojo.SkillSet;
import com.resumebuilder.service.AcademicDetailServiceImpl;
import com.resumebuilder.service.ExperienceDetailServiceImpl;
import com.resumebuilder.service.ResumeGeneratorServiceImpl;
import com.resumebuilder.service.SkillSetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RequestMapping("/api")
@RestController
public class ResumeGeneratorController {
    @Autowired
    ResumeGeneratorServiceImpl resumeGeneratorService;
    @Autowired
    SkillSetServiceImpl skillSetService;
    @Autowired
    AcademicDetailServiceImpl academicDetailService;
    @Autowired
    ExperienceDetailServiceImpl experienceDetailService;

    @PostMapping("/user/saveresume")
    @ResponseBody
    @LogExecutionTime
    public ResumeDetails saveResumeDetails(@RequestBody  ResumeDetails content) {
        return  resumeGeneratorService.saveResumeDetails(content);
    }

    @PostMapping("/user/addskillset")
    @ResponseBody
    @LogExecutionTime
    public SkillSet addSkillSetDetails(@RequestBody SkillSet content) {
        return skillSetService.saveSkillSetDetails(content);
    }

    @PostMapping("/user/addacademicdeatils")
    @ResponseBody
    @LogExecutionTime
    public AcademicDetails addAcademicDetails(@RequestBody AcademicDetails content) {
        return academicDetailService.saveAcademicDetails(content);
    }

    @PostMapping("/user/addexperiencedetails")
    @ResponseBody
    @LogExecutionTime
    public ExperienceDetail addexperienceDetails(@RequestBody ExperienceDetail content) {
        return experienceDetailService.saveExperienceDetails(content);
    }
    @GetMapping("/user/getresume/{email}")
    @ResponseBody
    @LogExecutionTime
    public ResumeDetails getResumeRecords(@PathVariable String email) {
        return resumeGeneratorService.getResumeDetails(email).get();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/user/statistics")
    @ResponseBody
    @LogExecutionTime
    public String getStatistics() {
        return "Only admins can see this : DB size: 300 records";
    }

    @GetMapping("/admin/delete")
    @ResponseBody
    @LogExecutionTime
    public String delete(@PathVariable String email) {
        return "Only admins can see this : deleting the records";
    }
}
