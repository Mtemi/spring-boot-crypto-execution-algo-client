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
public class OrderCancelRequest extends RequestMsg
{
    public String clientID;

    public String clientOrderID;

    public String account;
    
    public String subAccount;
    
    public long orderID;

    public long requestTime;
    
    public OrderCancelRequest()
    {
        super(ApiMsgType.OrderCancelRequest);
    }

}
