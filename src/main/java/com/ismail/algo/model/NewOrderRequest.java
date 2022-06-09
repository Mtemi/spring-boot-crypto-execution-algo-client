package com.ismail.algo.model;

import java.util.ArrayList;
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
public class NewOrderRequest
{
    public String instrumentID;

    public String clientID;
    
    public String clientOrderID;
    
    public String account;
    
    public String subAccount;
    
    public long requestTime;

    public char side;

    public char orderType;

    public char timeInForce;

    public double quantity;

    public double price;

    public double stopPrice;

    public String algoStrategyID;

    public List<AlgoParamValue> algoParams;
    
    public void addAlgoParam(AlgoParamValue algoParam)
    {
        if (algoParams == null)
            algoParams = new ArrayList<>();
        
        algoParams.add(algoParam);
    }

    @JsonIgnore
    public AlgoParamValue getAlgoParamByName(String paramName)
    {
        if (algoParams != null)
        {  
            for (AlgoParamValue param : algoParams)
            {
                if (param.getName().equals(paramName))
                    return param;
            }
        }
        
        return null;
    }
    
    @JsonIgnore
    public void removeAlgoParamByName(String paramName)
    {
        if (algoParams != null)
        {  
            for (int i=algoParams.size()-1; i>=0; i--)
            {
                AlgoParamValue  param = algoParams.get(i);
                
                if (param.getName().equals(paramName))
                {
                    algoParams.remove(i);
                }
            }
        }
    } 
}
