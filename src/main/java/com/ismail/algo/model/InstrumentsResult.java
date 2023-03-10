package com.ismail.algo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstrumentsResult extends ResponseMsg
{    
    @JsonProperty("r")
    public int recordsCount;
    
    @JsonProperty("instruments")
    public List<Instrument> instruments;
    
    public InstrumentsResult()
    {
        super(ApiMsgType.InstrumentsResult);
    }
}
