package com.ismail.algo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class TopOfBooksResult extends ResponseMsg
{    
    public int recordsCount;
        
    public List<TopOfBook> topOfBooks;
    
    public TopOfBooksResult()
    {
        super(ApiMsgType.TopOfBookResults);
    }
}
