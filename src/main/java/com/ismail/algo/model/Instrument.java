package com.ismail.algo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Instrument
{    
    public String instrumentID;

    public String symbol;

    public String exchange;

    public String primaryExchange;

    public String desc;

    public String instType;

    public String baseAsset;

    public String quoteAsset;

    public String timezone;

    public double contractSize;

    public double tickSize;

    public double tickSizeQty;

    public double lotSize;

    public int priceDecimals;

    public int quantityDecimals;

    public boolean synthetic;

    public long histDataSince;

    public long tickDataSince;

    public double lastPrice;

    public long lastPriceTime;

    public boolean live;
    
    public TopOfBook topOfBook;
    
    public List<TopOfBook> topOfBooks;
}
