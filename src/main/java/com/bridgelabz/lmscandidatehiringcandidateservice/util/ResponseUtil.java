package com.bridgelabz.lmscandidatehiringcandidateservice.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Purpose : ResponseUtil class used to return response
 * Version : 1.0
 * @author : Annu Kumari
 * */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUtil {
    private int statusCode;
    private String statusMessage;
    private Object object;
}
