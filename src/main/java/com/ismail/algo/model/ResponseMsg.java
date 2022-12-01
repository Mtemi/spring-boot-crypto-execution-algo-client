package com.ismail.algo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ismail.algo.FIXTags;

import lombok.ToString;

/**
 * @author ismail
 * @since 20221001
 */
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ResponseMsg  extends ApiMsg implements Serializable
{  
    public static final long serialVersionUID = 1;
   
    @JsonProperty("sc")
    public boolean success;

    @JsonProperty("er")
    public String errorMessage;
    
    @JsonProperty("erd")
    public String errorDetail;
    
    public ResponseMsg()
    {

    }
    
    public ResponseMsg(int messageType)
    {
        super(messageType);
    }
    
    public ResponseMsg(int messageType, boolean success)
    {
        super(messageType);
        this.success = success;
    }
    
    
    public ResponseMsg(int messageType, String errorMessage)
    {
        super(messageType);
        this.success = false;
        this.errorMessage = errorMessage;
    }
}
