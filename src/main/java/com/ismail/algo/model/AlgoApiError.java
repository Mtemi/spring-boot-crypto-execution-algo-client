package com.ismail.algo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlgoApiError
{
    /**
     * Error code.
     */
    private int errorCode;

    /**
     * Error message.
     */
    private String errorMsg;

    /**
     * Error Detail.
     */
    private String errorDetail;

}
