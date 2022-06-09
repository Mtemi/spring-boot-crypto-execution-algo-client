package com.ismail.algo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ismail.algo.config.AlgoClientConfig;
import com.ismail.algo.config.ColorThemeConfig;
import com.ismail.algo.service.AlgoClientApiService;

/**
 * AppClient Service Lookup; for jsp pages
 * 
 * We can't inject dependencies in JSP pages; so resorting to this trick
 * 
 * @author ismail
 * @since 20220604
 */
@Service
public class AppClientServices
{
    private static AppClientServices sMe;

    @Autowired
    public ColorThemeConfig colorTheme;
    
    @Autowired
    public AlgoClientConfig config;
    
    @Autowired
    public AlgoClientApiService apiService;
    
    
    public AppClientServices()
    {
        sMe = this;
    }
    
    public static AppClientServices getInstance()
    {
        return sMe;
    }
    

}
