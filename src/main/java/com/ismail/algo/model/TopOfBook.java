package com.ismail.algo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class TopOfBook
{    
    private String instrumentID = null;
        
    private String symbol = null;

    private double bidQty = 0.0;

    private double bid = 0.0;

    private double ask = 0.0;

    private double askQty = 0.0;

    private double last = 0.0;

    private double spread;
    
    private double spreadBps;
    
    private long updateTime = 0L;

    private String updateTimeDesc;
    
    private long updateNumber = 0;

    private int depthLevels = 0;
    
    private boolean live = false;
    

}
