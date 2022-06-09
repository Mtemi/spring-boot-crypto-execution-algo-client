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
public class Trade
{
    private long tradeID;

    private long parentOrderID;

    private long childOrderID;

    private String instrumentID;

    private String side;

    private double quantity;

    private double price;

    private long tradeTime;

    private String exchTradeID;

}
