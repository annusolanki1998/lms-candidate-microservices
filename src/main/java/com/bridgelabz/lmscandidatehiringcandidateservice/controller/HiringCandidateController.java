package com.bridgelabz.lmscandidatehiringcandidateservice.controller;

import com.bridgelabz.lmscandidatehiringcandidateservice.dto.HiringCandidateDTO;
import com.bridgelabz.lmscandidatehiringcandidateservice.model.HiringCandidateModel;
import com.bridgelabz.lmscandidatehiringcandidateservice.service.IHiringCandidateService;
import com.bridgelabz.lmscandidatehiringcandidateservice.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hiringcandidate")
public class HiringCandidateController {
    @Autowired
    IHiringCandidateService hiringCandidateService;


    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to LMS Spring application project";
    }


    @PostMapping("/addhiringcandidate")
    public ResponseEntity<ResponseUtil> addHiringCandidate(@Valid @RequestBody HiringCandidateDTO hiringCandidateDTO,
                                                   @RequestHeader String token) {
        ResponseUtil responseUtil = hiringCandidateService.addHiringCandidate(hiringCandidateDTO,token);
        return new ResponseEntity<>(responseUtil, HttpStatus.OK);
    }


    @PutMapping("/updatehiringcandidate/{id}")
    public ResponseEntity<ResponseUtil> updateHiringCandidate(@PathVariable Long id,
                                                      @Valid @RequestBody HiringCandidateDTO hiringCandidateDTO,
                                                      @RequestHeader String token) {
        ResponseUtil responseUtil = hiringCandidateService.updateHiringCandidate(hiringCandidateDTO,token,id);
        return new ResponseEntity<>(responseUtil, HttpStatus.OK);
    }

    @GetMapping("/gethiringcandidates")
    public ResponseEntity<List<?>> getHiringCandidates(@RequestHeader String token) {
        List<HiringCandidateModel> responseUtil = hiringCandidateService.getHiringCandidates(token);
        return new ResponseEntity<>(responseUtil, HttpStatus.OK);
    }


    @DeleteMapping("deletehiringcandidate/{id}")
    public ResponseEntity<ResponseUtil> deleteHiringCandidate(@PathVariable Long id,
                                                              @RequestHeader String token) {
        ResponseUtil responseUtil = hiringCandidateService.deleteHiringCandidate(token,id);
        return new ResponseEntity<>(responseUtil, HttpStatus.OK);

    }

    @GetMapping("gethiringcandidate/{id}")
    public ResponseEntity<ResponseUtil> getHiringCandidate(@PathVariable Long id,
                                                           @RequestHeader String token) {
        ResponseUtil responseUtil = hiringCandidateService.getHiringCandidate(token,id);
        return new ResponseEntity<>(responseUtil, HttpStatus.OK);

    }
}
