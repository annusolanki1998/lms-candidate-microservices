package com.bridgelabz.lmscandidatehiringcandidateservice.model;

import com.bridgelabz.lmscandidatehiringcandidateservice.dto.HiringCandidateDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/*
 * Purpose : HiringCandidateModel are used to transfer the data into database
 * Version : 1.0
 * @author : Annu Kumari
 * */

@Data
@Entity
@Table(name = "hiringcandidate")
public class HiringCandidateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cicId;
    private String fullName;
    private String email;
    private String mobileNumber;
    private String hiredDate;
    private String degree;
    private Double aggrPer;
    private String city;
    private String state;
    private String preferredJobLocation;
    private String status;
    private String passedOutYear;
    private String creatorUser;
    private String candidateStatus;
    private LocalDateTime creationTimeStamp;
    private LocalDateTime updatedTimeStamp;

    public HiringCandidateModel(HiringCandidateDTO hiringCandidateDTO) {
        this.cicId = hiringCandidateDTO.getCicId();
        this.fullName = hiringCandidateDTO.getFullName();
        this.email = hiringCandidateDTO.getEmail();
        this.mobileNumber = hiringCandidateDTO.getMobileNumber();
        this.hiredDate = hiringCandidateDTO.getHiredDate();
        this.degree = hiringCandidateDTO.getDegree();
        this.aggrPer = hiringCandidateDTO.getAggrPer();
        this.city = hiringCandidateDTO.getCity();
        this.state = hiringCandidateDTO.getState();
        this.preferredJobLocation = hiringCandidateDTO.getPreferredJobLocation();
        this.status = hiringCandidateDTO.getStatus();
        this.passedOutYear = hiringCandidateDTO.getPassedOutYear();
        this.creatorUser = hiringCandidateDTO.getCreatorUser();
        this.candidateStatus = hiringCandidateDTO.getCandidateStatus();

    }

    public HiringCandidateModel() {

    }


}