package com.dom.jobapplicationtracker.controller.dto;

public record JobApplicationResponse(Long id, String company, String role, String location, Integer salary) {
}
