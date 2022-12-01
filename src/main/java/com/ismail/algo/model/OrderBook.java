package com.ismail.algo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBook extends ResponseMsg
{    
    @JsonProperty("i")
    public String instrumentID = null;
        
    @JsonProperty("s")
    public String symbol = null;

    @JsonProperty("bq")
    public double bidQty = 0.0;

    @JsonProperty("b")
    public double bid = 0.0;

    @JsonProperty("a")
    public double ask = 0.0;

    @JsonProperty("aq")
    public double askQty = 0.0;

    @JsonProperty("l")
    public double last = 0.0;

    @JsonProperty("u")
    public long updateTime = 0L;

    @JsonProperty("un")
    public int updateNumber = 0;

    @JsonProperty("dl")
    public int depthLevels = 0;

    @JsonProperty("lv")
    public boolean live = false;
    
    @JsonProperty("bids")
    public List<OrderBookEntry> bids = null;

    @JsonProperty("asks")
    public List<OrderBookEntry> asks = null;

    public OrderBook()
    {
        super(ApiMsgType.OrderBook);
    }
}
