package com.example.jobapplicationtracker.jobapplication;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobApplication {
    @Id
    @GeneratedValue
    private long id;
    private String company;
    private String role;
    private String location;
    private int salary;

}
