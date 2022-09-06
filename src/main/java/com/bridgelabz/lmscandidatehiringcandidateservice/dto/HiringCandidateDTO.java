package com.bridgelabz.lmscandidatehiringcandidateservice.dto;



import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/*
 * Purpose : HiringCandidateDTO are used to create and update hiring candidate details
 * Version : 1.0
 * @author : Annu Kumari
 * */

@Data
public class HiringCandidateDTO {

    @NotNull(message = "Cic id should not be empty")
    private String cicId;

    @NotNull(message = "FullName should not be empty ")
    @Pattern(regexp = "[A-Z][a-z]{2,}", message = "Fullname should start with capital letter and  atleast min of three character")
    private String fullName;

    @NotNull(message = "Email id should not be empty")
    @Pattern(regexp = "[a-z][A-Z a-z 0-9]+[@][a-z]+[.][a-z]{2,}", message = "Invalid email id")
    private String email;

    @NotNull(message = "Mobilenumber should not be empty")
    @Pattern(regexp = "[+]91 [6-9]\\d{9}", message = "Invalid mobile number")
    private String mobileNumber;

    @NotNull(message = "Hired date should not be empty")
    private String hiredDate;

    @NotNull(message = "Degree should not be empty")
    @Pattern(regexp = "[A-Z][a-z]{2,}", message = "Invalid degree")
    private String degree;

    @NotNull(message = "Aggregate percentage should not be empty")
    private Double aggrPer;

    @NotNull(message = "City should not be empty")
    @Pattern(regexp = "[A-Z][a-z]{2,}", message = "Invalid city name")
    private String city;

    @NotNull(message = "State should not be empty")
    @Pattern(regexp = "[A-Z][a-z]{2,}", message = "Invalid state name")
    private String state;

    @NotNull(message = "Preferred job location should not be empty")
    @Pattern(regexp = "[A-Z][a-z]{2,}", message = "Invalid preferred job location")
    private String preferredJobLocation;

    @NotNull(message = "Status should not be empty")
    @Pattern(regexp = "[A-Z][a-z]{2,}", message = "Invalid status")
    private String status;

    @NotNull(message = "Passed out year should not be empty")
    private String passedOutYear;

    @NotNull(message = "Creator user should not be empty")
    @Pattern(regexp = "[A-Z][a-z]{2,}", message = "Invalid creator user")
    private String creatorUser;

    @NotNull(message = "Candidate status should not be empty")
    @Pattern(regexp = "[A-Z][a-z]{2,}", message = "Invalid candidate status")
    private String candidateStatus;
}




