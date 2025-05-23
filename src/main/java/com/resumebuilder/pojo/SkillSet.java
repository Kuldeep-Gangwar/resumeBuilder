package com.resumebuilder.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table
public class SkillSet {
    private  String Catagory;
    private  String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @ToString.Exclude
    @JsonBackReference
    @JoinColumn(name = "resumeDetails_id") // Foreign key to ParentEntity
    private ResumeDetails resumeDetails;
}
