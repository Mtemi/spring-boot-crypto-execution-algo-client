package com.ismail.algo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

/**
 * @author ismail
 * @since 20221001
 */
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ApiMsg implements Serializable
{
    public static final long serialVersionUID = 1;

    /**
     * see {@link ApiMsgType}
     */
    @JsonProperty("s")
    public int msgType;

    @JsonProperty("t")
    public long time;

    public ApiMsg()
    {

    }

    public ApiMsg(int messageType)
    {
        this.msgType = messageType;
    }
}
