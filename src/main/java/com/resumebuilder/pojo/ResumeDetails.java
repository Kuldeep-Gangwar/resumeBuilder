package com.resumebuilder.pojo;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.processing.Exclude;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Entity
@Data
@Table (uniqueConstraints={
@UniqueConstraint(columnNames={"email"}),
        @UniqueConstraint(columnNames={"phNumber"})}
)
public class ResumeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column
    @Nonnull
    private String email;
    @Column
    @Nonnull
    private String phNumber;

    @Column
    private String introduction;

   @OneToMany(mappedBy = "resumeDetails", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<AcademicDetails> academicDetail = new ArrayList<>();
    @JsonManagedReference
    @OneToMany(mappedBy = "resumeDetails", cascade = {CascadeType.MERGE,CascadeType.PERSIST, CascadeType.DETACH}, fetch = FetchType.LAZY)
    private List<SkillSet> skillsets = new ArrayList<>();
   @JsonManagedReference
    @OneToMany(mappedBy = "resumeDetails", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<ExperienceDetail> experienceDetail = new ArrayList<>();

    public ResumeDetails() {

    }


    @Transient
    public Map<String, List<SkillSet>> getSkillsetMap() {
        return skillsets.stream().collect(Collectors.groupingBy(SkillSet::getCatagory));
    }
}
