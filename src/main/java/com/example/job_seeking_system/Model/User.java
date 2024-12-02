package com.example.job_seeking_system.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
@NotEmpty(message = "name cannot be empty")
@Size(min = 4 ,message = "name must be more than 4 characters")
@Pattern(regexp = "^[a-zA-Z]+$",message = "Must contain only characters (no numbers)")
@Column(columnDefinition = "varchar(10) not null unique")
private String name ;
    @NotEmpty(message = "password cannot be empty")
    @Column(columnDefinition = "varchar(10) not null")
    private String password ;
    @NotNull(message = "age cannot be empty")
    @Positive(message = "age must be positive number")
@Min(value = 22,message = "age Must be more than 21")
    @Column(columnDefinition = "int not null")
    private Integer age;
    @NotEmpty(message = "email cannot be empty")
@Email(message = "invalid email")
    @Column(columnDefinition = "varchar(50) not null unique")
    private String email ;
    @NotEmpty(message = "role cannot be empty")
@Pattern(regexp = "JOB_SEEKER|EMPLOYER")
    @Column(columnDefinition = "varchar(15) not null")
    private String role ;



}
