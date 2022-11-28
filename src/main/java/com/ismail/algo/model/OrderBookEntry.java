package com.ismail.algo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBookEntry
{    
    private double quantity = 0.0;

    private double price = 0.0;


}
