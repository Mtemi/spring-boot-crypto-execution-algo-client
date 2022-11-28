package com.ismail.algo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlgoApiError extends ResponseMsg
{
    /**
     * Error code.
     */
    @JsonProperty("ec")
    public int errorCode;
    
    public AlgoApiError()
    {
        super(ApiMsgType.Error);
    }

}
