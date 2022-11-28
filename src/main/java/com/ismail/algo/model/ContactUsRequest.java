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
public class ContactUsRequest extends RequestMsg
{
    public String name;

    public String email;

    public String subject;

    public String message;

    public String ipAddr;
    
    public String userAgent;

    public String appURL;

    public ContactUsRequest()
    {
        super(ApiMsgType.ContactUsRequest);
    }
}
