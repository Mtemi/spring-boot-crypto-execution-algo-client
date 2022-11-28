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
public class Trade extends ResponseMsg
{
    public long tradeID;

    public long parentOrderID;

    public long childOrderID;

    public String instrumentID;

    public String side;

    public double quantity;

    public double price;

    public String venue;
    
    public long tradeTime;

    public String exchTradeID;

    public Trade()
    {
        super(ApiMsgType.Trade);
    }
}
