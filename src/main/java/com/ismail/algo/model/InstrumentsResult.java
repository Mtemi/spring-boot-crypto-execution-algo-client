package com.ismail.algo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstrumentsResult extends ResponseMsg
{    
    public int recordsCount;
    
    public List<Instrument> instruments;
    
    public InstrumentsResult()
    {
        super(ApiMsgType.InstrumentResults);
    }
}
