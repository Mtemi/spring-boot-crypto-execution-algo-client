package com.ismail.algo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ChildOrdersResult
{
    public int pageNumber;
    
    public int pageSize;

    public int recordCount;

    public int pageCount;
    
    public int pageRecordCount;
    
    public List<ChildOrder> childOrders;
        
}
