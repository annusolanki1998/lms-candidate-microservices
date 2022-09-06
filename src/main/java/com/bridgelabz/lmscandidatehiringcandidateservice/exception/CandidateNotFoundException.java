package com.bridgelabz.lmscandidatehiringcandidateservice.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Purpose : CandidateNotFoundException is used to handle the exceptions
 * Version : 1.0
 * @author : Annu kumari
 * */

@ResponseStatus
public class CandidateNotFoundException extends RuntimeException {
    private int statusCode;
    private String statusMessage;

    public CandidateNotFoundException(int statusCode, String statusMessage) {
        super(statusMessage);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
