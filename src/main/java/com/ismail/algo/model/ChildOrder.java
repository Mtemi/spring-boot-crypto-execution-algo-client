package com.ismail.algo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ChildOrder
{
    public long childOrderID;

    public long parentOrderID;

    public String instrumentID;
        
    public boolean active;
    
    public String status;

    public long createdTime;

    public long updatedTime;

    public String side;
    
    public int orderType;
    
    public String orderTypeDesc;
    
    public int timeInForce;
    
    public String timeInForceDesc;

    public double quantity;
    
    public double price;

    public double stopPrice;
    
    // Execution
    
    public double quantityFilled;
    
    public double averagePrice;

    public int tradesCount;
    
    public String lastTradeVenue;
    
    // latency stats
    
    public long acceptedTime;
    
    public long firstTradeTime;
}
