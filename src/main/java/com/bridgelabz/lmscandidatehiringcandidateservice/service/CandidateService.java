package com.bridgelabz.lmscandidatehiringcandidateservice.service;

import com.bridgelabz.lmscandidatehiringcandidateservice.dto.CandidateDTO;
import com.bridgelabz.lmscandidatehiringcandidateservice.exception.CandidateNotFoundException;
import com.bridgelabz.lmscandidatehiringcandidateservice.model.CandidateModel;
import com.bridgelabz.lmscandidatehiringcandidateservice.repository.CandidateRepository;
import com.bridgelabz.lmscandidatehiringcandidateservice.util.ResponseUtil;
import com.bridgelabz.lmscandidatehiringcandidateservice.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateService implements ICandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    MailService mailService;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public ResponseUtil addCandidate(CandidateDTO candidateDTO, String token) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8081/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            CandidateModel candidateModel = new CandidateModel(candidateDTO);
            candidateModel.setCreationTimeStamp(LocalDateTime.now());
            candidateRepository.save(candidateModel);
            String body = "Candidate is added successfully with candidateId " + candidateModel.getId();
            String subject = "Candidate registration successfully";
            mailService.send(candidateModel.getEmail(), subject, body);
            return new ResponseUtil(200, "Sucessfully", candidateModel);
        }
        throw new CandidateNotFoundException(400, "Token is wrong");
    }


    @Override
    public ResponseUtil updateCandidate(CandidateDTO candidateDTO, String token, Long id) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8081/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            Optional<CandidateModel> isCandidatePresent = candidateRepository.findById(id);
            if (isCandidatePresent.isPresent()) {
                isCandidatePresent.get().setCicId(candidateDTO.getCicId());
                isCandidatePresent.get().setFullName(candidateDTO.getFullName());
                isCandidatePresent.get().setEmail(candidateDTO.getEmail());
                isCandidatePresent.get().setMobileNumber(candidateDTO.getMobileNumber());
                isCandidatePresent.get().setHiredDate(candidateDTO.getHiredDate());
                isCandidatePresent.get().setDegree(candidateDTO.getDegree());
                isCandidatePresent.get().setAggrPer(candidateDTO.getAggrPer());
                isCandidatePresent.get().setCity(candidateDTO.getCity());
                isCandidatePresent.get().setState(candidateDTO.getState());
                isCandidatePresent.get().setPreferredJobLocation(candidateDTO.getPreferredJobLocation());
                isCandidatePresent.get().setStatus(candidateDTO.getStatus());
                isCandidatePresent.get().setPassedOutYear(candidateDTO.getPassedOutYear());
                isCandidatePresent.get().setCreatorUser(candidateDTO.getCreatorUser());
                isCandidatePresent.get().setCandidateStatus(candidateDTO.getCandidateStatus());
                isCandidatePresent.get().setUpdatedTimeStamp(LocalDateTime.now());
                candidateRepository.save(isCandidatePresent.get());
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
    public List<CandidateModel> getCandidates(String token) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8081/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            List<CandidateModel> isCandidatePresent = candidateRepository.findAll();
            if (isCandidatePresent.size() > 0) {
                return isCandidatePresent;
            } else {
                throw new CandidateNotFoundException(400, "No candidate is present");
            }
        }
        throw new CandidateNotFoundException(400, "Token is wrong");
    }


    @Override
    public ResponseUtil deleteCandidate(String token, Long id) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8081/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            Optional<CandidateModel> isCandidatePresent = candidateRepository.findById(id);
            if (isCandidatePresent.isPresent()) {
                candidateRepository.delete(isCandidatePresent.get());
                return new ResponseUtil(200, "Sucessfully", isCandidatePresent.get());
            } else {
                throw new CandidateNotFoundException(400, "Candidate not found");
            }
        }
        throw new CandidateNotFoundException(400, "Token is wrong");
    }

    @Override
    public ResponseUtil getCandidate(String token, Long id) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8081/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
                    Optional<CandidateModel> isCandidatePresent = candidateRepository.findById(id);
            if (isCandidatePresent.isPresent()) {
                return new ResponseUtil(200, "Sucessfully", isCandidatePresent.get());
            } else {
                throw new CandidateNotFoundException(400, "Candidate not found");
            }
        }
        throw new CandidateNotFoundException(400, "Token is wrong");
        }



    @Override
    public Long getCountByStatus(String token, String status) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8080/admin/validate/" + token, Boolean.class);
        if (isUserPresent) {
            Long isCandidate = candidateRepository.getCountByStatus(status);
            return isCandidate;
        }
        throw new CandidateNotFoundException(400, "Token Wrong");
    }

}
