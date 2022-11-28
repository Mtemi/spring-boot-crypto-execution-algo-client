package com.ismail.algo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class TopOfBook extends ResponseMsg
{    
    public String instrumentID = null;
        
    public String symbol = null;

    public double bidQty = 0.0;

    public double bid = 0.0;

    public double ask = 0.0;

    public double askQty = 0.0;

    public double last = 0.0;

    public double spread;
    
    public double spreadBps;
    
    public long updateTime = 0L;

    public String updateTimeDesc;
    
    public String cxtTime;

    public long updateNumber = 0;

    public int depthLevels = 0;
    
    public String mdSource;
    
    public boolean live = false;
    
    public TopOfBook()
    {
        super(ApiMsgType.TopOfBook);
    }

}
