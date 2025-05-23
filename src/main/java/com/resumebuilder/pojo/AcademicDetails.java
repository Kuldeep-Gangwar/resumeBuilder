package com.resumebuilder.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table
public class AcademicDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String Degree;
    @Column
    private String institution;
    @Column

   // @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date enrollmentYear;
    @Column
  //  @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date passOutYear;
    @ManyToOne
    @JoinColumn(name = "resumedetails_id")
    @JsonBackReference
    @ToString.Exclude
    private ResumeDetails resumeDetails;

   /* public LocalDate getEnrollmentYear() {
        return LocalDate.from(this.enrollmentYear);
    }

    public void setEnrollmentYear(Date enrollmentYear) {
        this.enrollmentYear = LocalDate.from(this.enrollmentYear);
    }

    public LocalDate getPassOutYear() {
        return LocalDate.from(this.passOutYear);
    }

    public void setPassOutYear(Date passOutYear) {
        this.passOutYear = LocalDate.from(this.passOutYear);
    }*/
}
