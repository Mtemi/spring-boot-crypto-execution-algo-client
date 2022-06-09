package com.ismail.algo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Instrument
{
    private String instrumentID;

    private String symbol;

    private String exchange;

    private String primaryExchange;

    private String desc;

    private String instType;

    private String baseAsset;

    private String quoteAsset;

    private String timezone;

    private double contractSize;

    private double tickSize;

    private double tickSizeQty;

    private double lotSize;

    private int priceDecimals;

    private int quantityDecimals;

    private boolean synthetic;

    private long histDataSince;

    private long tickDataSince;

    private double lastPrice;

    private long lastPriceTime;

    private boolean live;
    
    private TopOfBook topOfBook;
}
