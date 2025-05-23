package com.resumebuilder.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table
public class ExperienceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String projectName;
    @Column
    private String projectDetails;
    @Column
    private String acheivements;    @Column
  /*  @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)*/
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fromDate;
    @Column
   /* @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)*/
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date toDate;
    @ManyToOne
    @JoinColumn(name = "resumedidetails_id")
    @JsonBackReference
    @ToString.Exclude
    private  ResumeDetails resumeDetails;

/*
    public LocalDate getFromDate() {
        return LocalDate.from(this.fromDate);
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = LocalDate.from(this.fromDate);
    }

    public LocalDate getToDate() {
        return LocalDate.from(this.toDate);
    }

    public void setToDate(Date toDate) {
        this.toDate = LocalDate.from(this.toDate);
    }*/

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
