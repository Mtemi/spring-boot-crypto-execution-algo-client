package com.ismail.algo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Order
{
    public long orderID;
    
    public String instrumentID;

    public String clientID;

    public String account;

    public boolean active;
    
    public String status;
    
    public String rejectReason;
    
    public double quantityFilled;
    
    public double averagePrice;

    public int tradesCount;

    public int childOrdersCount;
    
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
    
    public String algoStrategyID;
    
    public List<AlgoParamValue> algoParams;
    
    public TopOfBook topOfBook;
    
    @JsonIgnore
    public AlgoParamValue getParamByName(String pParamName)
    {
        if (algoParams != null)
        {
            for (AlgoParamValue param : algoParams)
            {
                if (param.getName().equals(pParamName))
                    return param;
            }
        }
        
        return null;
    }
    
}
