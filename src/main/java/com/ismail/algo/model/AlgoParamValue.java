package com.ismail.algo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class AlgoParamValue
{
    public String name;
    
    public String value;
    
    public String valueDesc;
        

    @JsonIgnore
    public double getValueAsDouble()
    {
        return Double.parseDouble(value);
    }
    
    @JsonIgnore
    public int getValueAsInt()
    {
        return Integer.parseInt(value);
    }
    
    @JsonIgnore
    public long getValueAsLong()
    {
        return Long.parseLong(value);
    }
}
