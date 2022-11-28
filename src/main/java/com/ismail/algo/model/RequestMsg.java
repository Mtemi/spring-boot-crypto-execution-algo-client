package com.ismail.algo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class RequestMsg implements Serializable
{  
    public static final long serialVersionUID = 1;
    
    /**
     * see {@link ApiMsgType}
     */
    @JsonProperty(FIXTags.TAGMsgType)
    public int msgType;

    /**
     * Time the request was sent by client
     */
    @JsonProperty(FIXTags.TAGSendingTime)
    public long time;

    
    public RequestMsg()
    {
        
    }
    
    public RequestMsg(int messageType)
    {
        this.msgType = messageType;
    }
}
