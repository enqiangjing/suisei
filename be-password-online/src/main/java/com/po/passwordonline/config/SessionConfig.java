package com.po.passwordonline.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 使用 Redis Session，原server.session.timeout属性将失效
 *
 * @author eq
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400 * 7)
public class SessionConfig {
    //--- 配置 ---//
}
