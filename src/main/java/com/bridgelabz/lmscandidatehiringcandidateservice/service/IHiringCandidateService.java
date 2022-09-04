package com.bridgelabz.lmscandidatehiringcandidateservice.service;

import com.bridgelabz.lmscandidatehiringcandidateservice.dto.HiringCandidateDTO;
import com.bridgelabz.lmscandidatehiringcandidateservice.model.HiringCandidateModel;
import com.bridgelabz.lmscandidatehiringcandidateservice.util.ResponseUtil;

import java.util.List;

public interface IHiringCandidateService {

    ResponseUtil addHiringCandidate(HiringCandidateDTO hiringCandidateDTO, String token);

    ResponseUtil updateHiringCandidate(HiringCandidateDTO hiringCandidateDTO, String token, Long id);

    List<HiringCandidateModel> getHiringCandidates(String token);

    ResponseUtil deleteHiringCandidate(String token, Long id);

    ResponseUtil getHiringCandidate(String token, Long id);
}
