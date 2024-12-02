package com.example.job_seeking_system.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class JobPost {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer jobPostId ;
    @NotEmpty(message = "title cannot be empty")
    @Size(min = 4 ,message = "title must be more than 4 characters")
    @Column(columnDefinition = "varchar(10) not null")
    private String title ;
    @NotEmpty(message = "description cannot be empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String description ;
    @NotEmpty(message = "location cannot be empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String location ;
    @NotNull(message = "salary cannot be empty")
    @Positive(message = "salary must be positive number")
    @Column(columnDefinition = "int not null")
    private Integer salary ;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "postingDate must be Future Or Present")
    @Column(columnDefinition = "datetime not null")

    private LocalDate postingDate;
}
