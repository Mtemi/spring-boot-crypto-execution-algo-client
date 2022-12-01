package com.ismail.algo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class TopOfBook extends ResponseMsg
{    
    @JsonProperty("i")
    public String instrumentID = null;

    @JsonProperty("s")
    public String symbol = null;

    @JsonProperty("bq")
    public double bidQty = 0.0;

    @JsonProperty("b")
    public double bid = 0.0;

    @JsonProperty("a")
    public double ask = 0.0;

    @JsonProperty("aq")
    public double askQty = 0.0;

    @JsonProperty("l")
    public double last = 0.0;

    @JsonProperty("spr")
    public double spread;

    @JsonProperty("sprb")
    public double spreadBps;

    @JsonProperty("ut")
    public long updateTime = 0L;

    @JsonProperty("cxt")
    public String cxtTime;

    @JsonProperty("un")
    public long updateNumber = 0;

    @JsonProperty("dl")
    public int depthLevels = 0;

    @JsonProperty("mds")
    public String mdSource;

    @JsonProperty("lv")
    public boolean live = false;
    
    public TopOfBook()
    {
        super(ApiMsgType.TopOfBook);
    }

}
