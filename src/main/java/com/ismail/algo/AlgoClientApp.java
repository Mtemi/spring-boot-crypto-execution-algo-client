package com.ismail.algo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.ismail.algo.config.AlgoClientConfig;
import com.ismail.algo.config.ColorThemeConfig;

import lombok.extern.slf4j.Slf4j;


/**
 * Main App
 * 
 * @author ismail
 * @since 20220604
 */
@SpringBootApplication(scanBasePackages = "com.ismail.algo")
@EnableConfigurationProperties({ AlgoClientConfig.class, ColorThemeConfig.class })
@Slf4j
public class AlgoClientApp extends SpringBootServletInitializer
{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
    {
        return builder.sources(AlgoClientApp.class);
    }

    public static void main(String[] args)
    {
        SpringApplication.run(AlgoClientApp.class, args);
    }

}
