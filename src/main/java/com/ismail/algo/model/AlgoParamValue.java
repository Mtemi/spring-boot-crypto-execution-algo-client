package com.ismail.algo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("n")
    public String name;
    
    @JsonProperty("v")
    public String value;
    
    @JsonProperty("d")
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
