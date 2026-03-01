package com.dom.jobapplicationtracker.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CreateJobApplicationRequest(
        @NotBlank
        String company,
        @NotBlank
        String role,
        @NotBlank
        String location,
        @Min(0)
        Integer salary) {

}
