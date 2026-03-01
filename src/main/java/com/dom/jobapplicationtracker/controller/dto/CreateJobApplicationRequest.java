package com.dom.jobapplicationtracker.controller.dto;

public record CreateJobApplicationRequest(String company, String role, String location, Integer salary) {

}
