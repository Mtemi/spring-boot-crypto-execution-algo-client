package com.ismail.algo.model;

import java.util.List;

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
public class Algo extends ResponseMsg
{
    private String strategyID = null;
    
    private String shortDesc = null;
        
    private String desc = null;
    
    private List<AlgoParamDef> params = null;
    
    public Algo()
    {
        super(ApiMsgType.AlgoDefinition);
    }
    
    
    public int getParamsCount()
    {
        return (params==null ? 0 : params.size());
    }
        
    public AlgoParamDef getParameterByName(String pParamName)
    {
        if (params != null)
        {
            for (AlgoParamDef param : params)
            {
                if (pParamName.equals(param.getName()))
                    return param;
            }
        }
        
        return null;
    }
}
