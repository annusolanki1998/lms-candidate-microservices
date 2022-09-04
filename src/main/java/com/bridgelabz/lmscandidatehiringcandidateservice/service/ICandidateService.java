package com.bridgelabz.lmscandidatehiringcandidateservice.service;

import com.bridgelabz.lmscandidatehiringcandidateservice.dto.CandidateDTO;
import com.bridgelabz.lmscandidatehiringcandidateservice.model.CandidateModel;
import com.bridgelabz.lmscandidatehiringcandidateservice.util.ResponseUtil;

import java.util.List;

public interface ICandidateService {


    ResponseUtil addCandidate(CandidateDTO candidateDTO, String token);

    ResponseUtil updateCandidate(CandidateDTO candidateDTO, String token, Long id);

    List<CandidateModel> getCandidates(String token);

    ResponseUtil deleteCandidate(String token, Long id);

    ResponseUtil getCandidate(String token, Long id);

    Long getCountByStatus(String token, String status);
}
