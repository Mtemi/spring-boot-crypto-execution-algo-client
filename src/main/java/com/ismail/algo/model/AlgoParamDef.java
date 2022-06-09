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
public class AlgoParamDef
{
    public String name = null;
    
    public String label = null;
        
    public boolean mandatory = false;
    
    public String defaultValue = null;

    public String defaultValueDesc = null;

    public List<AlgoParamValidValue> validValues = null;
    
    public String type = null;

    public String typeFormat = null;

    public String shortDesc = null;
    
    public String desc = null;
    
    @JsonIgnore
    public int getValidValuesCount()
    {
        return (validValues==null ? 0 : validValues.size());
    }
}
