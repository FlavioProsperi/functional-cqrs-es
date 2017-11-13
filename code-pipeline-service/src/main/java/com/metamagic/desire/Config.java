package com.metamagic.desire;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@RefreshScope
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class Config {

}
