package com.ismail.algo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties("algo")
public class AlgoClientConfig
{
    public int ordersMaxRecordsDefault = 50;

    public int childOrdersMaxRecordsDefault = 50;

    public int tradesMaxRecordsDefault = 50;

    
    // Algo Server base domain
    
    
    private String baseDomain;


                
    // Algo Server URLs
    
    private String urlPrefix;

    private String algoUrl;

    private String algosUrl;

    private String instrumentUrl;

    private String instrumentsUrl;

    private String topOfBookUrl;

    private String orderBookUrl;

    
    private String orderUrl;

    private String ordersUrl;

    private String childOrderUrl;

    private String childOrdersUrl;

    private String tradeUrl;

    private String tradesUrl;
    
    // Websockets
    
    private String urlPrefixWebsockets;
    
    private String wsTopOfBookUrl;
    
    
    
    // Algo ClientID
    
    private String clientId;

    
    // Web page related
    
    private String webMainTitle;
    
    private String webColorTheme;
    
    // contact us url
    
    private String contactUsUrl;
}
