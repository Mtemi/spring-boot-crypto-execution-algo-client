package com.ismail.algo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBooksResult extends ResponseMsg
{    
    public int recordsCount;
        
    public List<OrderBook> orderBooks;    

    public OrderBooksResult()
    {
        super(ApiMsgType.OrderBookResults);
    }
}
