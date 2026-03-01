package com.dom.jobapplicationtracker.controller.dto;

import jakarta.validation.constraints.Min;

public record UpdateJobApplicationRequest(String company, String role, String location,
                                          @Min(0)
                                          Integer salary) {
}
