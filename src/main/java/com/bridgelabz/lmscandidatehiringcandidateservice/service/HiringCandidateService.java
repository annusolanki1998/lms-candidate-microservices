package com.bridgelabz.lmscandidatehiringcandidateservice.service;

import com.bridgelabz.lmscandidatehiringcandidateservice.dto.HiringCandidateDTO;
import com.bridgelabz.lmscandidatehiringcandidateservice.exception.CandidateNotFoundException;
import com.bridgelabz.lmscandidatehiringcandidateservice.model.HiringCandidateModel;
import com.bridgelabz.lmscandidatehiringcandidateservice.repository.HiringCandidateRepository;
import com.bridgelabz.lmscandidatehiringcandidateservice.util.ResponseUtil;
import com.bridgelabz.lmscandidatehiringcandidateservice.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HiringCandidateService implements IHiringCandidateService {

    @Autowired
    HiringCandidateRepository hiringCandidateRepository;

    @Autowired
    TokenUtil tokenUtil;

    @Autowired
    MailService mailService;

    @Autowired
    RestTemplate restTemplate;


    @Override
    public ResponseUtil addHiringCandidate(HiringCandidateDTO hiringCandidateDTO, String token) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8081/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            HiringCandidateModel hiringCandidateModel = new HiringCandidateModel(hiringCandidateDTO);
            hiringCandidateModel.setCreationTimeStamp(LocalDateTime.now());
            hiringCandidateRepository.save(hiringCandidateModel);
            String body = "Candidate is added successfully with candidateId " + hiringCandidateModel.getId();
            String subject = "Candidate registration successfully";
            mailService.send(hiringCandidateModel.getEmail(), subject, body);
            return new ResponseUtil(200, "Sucessfully", hiringCandidateModel);
        }
        throw new CandidateNotFoundException(400, "Token is wrong");
    }

    @Override
    public ResponseUtil updateHiringCandidate(HiringCandidateDTO hiringCandidateDTO, String token, Long id) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8081/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            Optional<HiringCandidateModel> isCandidatePresent = hiringCandidateRepository.findById(id);
            if (isCandidatePresent.isPresent()) {
                isCandidatePresent.get().setCicId(hiringCandidateDTO.getCicId());
                isCandidatePresent.get().setFullName(hiringCandidateDTO.getFullName());
                isCandidatePresent.get().setEmail(hiringCandidateDTO.getEmail());
                isCandidatePresent.get().setMobileNumber(hiringCandidateDTO.getMobileNumber());
                isCandidatePresent.get().setHiredDate(hiringCandidateDTO.getHiredDate());
                isCandidatePresent.get().setDegree(hiringCandidateDTO.getDegree());
                isCandidatePresent.get().setAggrPer(hiringCandidateDTO.getAggrPer());
                isCandidatePresent.get().setCity(hiringCandidateDTO.getCity());
                isCandidatePresent.get().setState(hiringCandidateDTO.getState());
                isCandidatePresent.get().setPreferredJobLocation(hiringCandidateDTO.getPreferredJobLocation());
                isCandidatePresent.get().setStatus(hiringCandidateDTO.getStatus());
                isCandidatePresent.get().setPassedOutYear(hiringCandidateDTO.getPassedOutYear());
                isCandidatePresent.get().setCreatorUser(hiringCandidateDTO.getCreatorUser());
                isCandidatePresent.get().setCandidateStatus(hiringCandidateDTO.getCandidateStatus());
                isCandidatePresent.get().setUpdatedTimeStamp(LocalDateTime.now());
                hiringCandidateRepository.save(isCandidatePresent.get());
                String body = "Candidate is added successfully with candidateId " + isCandidatePresent.get().getId();
                String subject = "Candidate registration successfully";
                mailService.send(isCandidatePresent.get().getEmail(), subject, body);
                return new ResponseUtil(200, "Sucessfully", isCandidatePresent.get());
            } else {
                throw new CandidateNotFoundException(400, "Candidate not found");
            }
        }
        throw new CandidateNotFoundException(400, "Token is wrong");

    }


    @Override
    public List<HiringCandidateModel> getHiringCandidates(String token) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8081/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            List<HiringCandidateModel> isCandidatePresent = hiringCandidateRepository.findAll();
            if (isCandidatePresent.size() > 0) {
                return isCandidatePresent;
            } else {
                throw new CandidateNotFoundException(400, "No candidate is present");
            }
        }

        throw new CandidateNotFoundException(400, "Token is wrong");
    }

    @Override
    public ResponseUtil deleteHiringCandidate(String token, Long id) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8081/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            Optional<HiringCandidateModel> isCandidatePresent = hiringCandidateRepository.findById(id);
            if (isCandidatePresent.isPresent()) {
                hiringCandidateRepository.delete(isCandidatePresent.get());
                return new ResponseUtil(200, "Sucessfully", isCandidatePresent.get());
            } else {
                throw new CandidateNotFoundException(400, "Candidate not found");
            }
        }
        throw new CandidateNotFoundException(400, "Token is wrong");
    }


    @Override
    public ResponseUtil getHiringCandidate(String token, Long id) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8081/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            Optional<HiringCandidateModel> isCandidatePresent = hiringCandidateRepository.findById(id);
            if (isCandidatePresent.isPresent()) {
                return new ResponseUtil(200, "Sucessfully", isCandidatePresent.get());
            } else {
                throw new CandidateNotFoundException(400, "Candidate not found");
            }
        }
        throw new CandidateNotFoundException(400, "Token is wrong");
    }
}

