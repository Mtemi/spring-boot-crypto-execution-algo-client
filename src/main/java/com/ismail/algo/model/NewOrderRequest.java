package com.ismail.algo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ismail.algo.FIXTags;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class NewOrderRequest
{
    @JsonProperty(FIXTags.TAGSymbol)
    public String instrumentID;


    @JsonProperty(FIXTags.TAGClientID)
    public String clientID;
    

    @JsonProperty(FIXTags.TAGClOrdID)
    public String clOrdID;
    

    @JsonProperty(FIXTags.TAGAccount)
    public String account;
    

    @JsonProperty(FIXTags.TAGAcctIDSource)
    public String subAccount;
    

    @JsonProperty(FIXTags.TAGTransactTime)
    public long requestTime;


    @JsonProperty(FIXTags.TAGSide)
    public char side;


    @JsonProperty(FIXTags.TAGOrdType)
    public char orderType;


    @JsonProperty(FIXTags.TAGTimeInForce)
    public char timeInForce;


    @JsonProperty(FIXTags.TAGOrderQty)
    public double quantity;


    @JsonProperty(FIXTags.TAGPrice)
    public double price;


    @JsonProperty(FIXTags.TAGStopPx)
    public double stopPrice;


    @JsonProperty(FIXTags.TAGTargetStrategy)
    public String algoStrategyID;

    @JsonProperty(FIXTags.TAGTargetStrategyParameters)
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
