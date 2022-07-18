package br.com.crmcustomer.redis.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

import java.time.Duration;

@EnableCaching
@Configuration
public class RedisConfig {

    public RedisCacheConfiguration redisCacheConfiguration(){
        return RedisCacheConfiguration.defaultCacheConfig()
                .prefixCacheNameWith("Customer")
                .disableCachingNullValues()
                .entryTtl(Duration.ofMinutes(5));
    }
}
