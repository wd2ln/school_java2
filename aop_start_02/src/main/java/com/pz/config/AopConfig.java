package com.pz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com.pz")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration
public class AopConfig {
}
