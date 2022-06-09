package com.ismail.algo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBook
{    
    private String instrumentID = null;
        
    private String symbol = null;

    private double bidQty = 0.0;

    private double bid = 0.0;

    private double ask = 0.0;

    private double askQty = 0.0;

    private double last = 0.0;

    private long updateTime = 0L;

    private int updateNumber = 0;

    private int depthLevels = 0;

    private boolean live = false;
    
    private List<OrderBookEntry> bids = null;

    private List<OrderBookEntry> asks = null;

}
