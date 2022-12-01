package com.ismail.algo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class AlgoParamValidValue
{
    @JsonProperty("v")
    public String value = null;
    
    @JsonProperty("sdesc")
    public String shortDesc = null;
    
    @JsonProperty("desc")
    public String desc = null;
        
}
