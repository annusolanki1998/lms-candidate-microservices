package com.bridgelabz.lmscandidatehiringcandidateservice.controller;

import com.bridgelabz.lmscandidatehiringcandidateservice.dto.CandidateDTO;
import com.bridgelabz.lmscandidatehiringcandidateservice.model.CandidateModel;
import com.bridgelabz.lmscandidatehiringcandidateservice.service.ICandidateService;
import com.bridgelabz.lmscandidatehiringcandidateservice.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    ICandidateService candidateService;

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to LMS Spring application project";
    }


    @PostMapping("/addcandidate")
    public ResponseEntity<ResponseUtil> addCandidate(@Valid @RequestBody CandidateDTO candidateDTO,
                                                     @RequestHeader String token) {
        ResponseUtil responseUtil = candidateService.addCandidate(candidateDTO,token);
        return new ResponseEntity<>(responseUtil, HttpStatus.OK);

    }


    @PutMapping("/updatecandidate/{id}")
    public ResponseEntity<ResponseUtil> updateCandidate(@PathVariable Long id,
                                                        @RequestHeader String token,
                                                        @Valid @RequestBody CandidateDTO candidateDTO) {
        ResponseUtil responseUtil = candidateService.updateCandidate(candidateDTO,token,id);
        return new ResponseEntity<>(responseUtil, HttpStatus.OK);
    }

    @GetMapping("/getcandidates")
    public ResponseEntity<List<?>> getCandidates(@RequestHeader String token) {
        List<CandidateModel> responseUtil = candidateService.getCandidates(token);
        return new ResponseEntity<>(responseUtil, HttpStatus.OK);

    }


    @DeleteMapping("deletecandidate/{id}")
    public ResponseEntity<ResponseUtil> deleteCandidate(@PathVariable Long id,
                                                        @RequestHeader String token) {
        ResponseUtil responseUtil = candidateService.deleteCandidate(token,id);
        return new ResponseEntity<>(responseUtil, HttpStatus.OK);
    }

    @GetMapping("getcandidate/{id}")
    public ResponseEntity<ResponseUtil> getCandidate(@PathVariable Long id,
                                       @RequestHeader String token) {
        ResponseUtil responseUtil = candidateService.getCandidate(token,id);
        return new ResponseEntity<>(responseUtil, HttpStatus.OK);
    }

    @GetMapping("/countByStatus")
    public ResponseEntity<Long> getCountByStatus(@RequestHeader String token,
                                                 @RequestParam String status) {
        Long responseUtil = candidateService.getCountByStatus(token, status);
        return new ResponseEntity<>(responseUtil, HttpStatus.OK);
    }
}
