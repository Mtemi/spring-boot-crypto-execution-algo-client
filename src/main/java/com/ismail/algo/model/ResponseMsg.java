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
public class ResponseMsg implements Serializable
{  
    public static final long serialVersionUID = 1;

    /**
     * see {@link ApiMsgType}
     */
    @JsonProperty(FIXTags.TAGMsgType)
    public int msgType;
    
    @JsonProperty(FIXTags.TAGSendingTime)
    public long time;
    
    @JsonProperty("s")
    public boolean success;

    @JsonProperty("e")
    public String errorMessage;
    
    @JsonProperty("err")
    public String errorDetail;
    
    public ResponseMsg()
    {

    }
    
    public ResponseMsg(int messageType)
    {
        this.msgType = messageType;
    }
    
    public ResponseMsg(int messageType, boolean success)
    {
        this.msgType = messageType;
        this.success = success;
    }
    
    
    public ResponseMsg(int messageType, String errorMessage)
    {
        this.msgType = messageType;
        this.success = false;
        this.errorMessage = errorMessage;
    }
}
