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
public class OrderCancelResponse extends ResponseMsg
{  
    public String clientID;
    
    public String clientOrderID;
    

    public long orderID;

    public boolean success;

    public String cancelRejectReason;
    
    public long responseTime;

    public OrderCancelResponse()
    {
        super(ApiMsgType.OrderCancelResponse);
    }
}
