package com.ismail.algo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBookEntry
{    
    @JsonProperty("q")
    public double quantity = 0.0;

    @JsonProperty("p")
    public double price = 0.0;


}
