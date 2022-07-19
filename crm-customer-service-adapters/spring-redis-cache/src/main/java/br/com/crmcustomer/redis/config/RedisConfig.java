package br.com.crmcustomer.redis.config;

import io.lettuce.core.ClientOptions;
import io.lettuce.core.resource.DefaultClientResources;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.CacheKeyPrefix;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.time.Duration.ofSeconds;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

@EnableCaching
@Configuration
@RequiredArgsConstructor
public class RedisConfig {

    private final RedisProperties redisProperties;

    @Value("${spring.redis.time-to-live}")
    private Long timeToLive;

    @Value("${spring.redis.key-prefix}")
    private String keyPrefix;

    public LettuceConnectionFactory lettuceConnectionFactory(){
        val lettuceProperties = redisProperties.getLettuce();
        val poolProperties = lettuceProperties.getPool();

        val poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(poolProperties.getMaxActive());
        poolConfig.setMaxIdle(poolConfig.getMinIdle());
        poolConfig.setMinIdle(poolConfig.getMinIdle());

        if (poolProperties.getMaxWait() != null){
            poolConfig.setMaxWaitMillis(poolProperties.getMaxWait().toMillis());
        }

        val clientOptions  = ClientOptions.builder()
                .autoReconnect(Boolean.TRUE)
                .disconnectedBehavior(ClientOptions.DisconnectedBehavior.DEFAULT)
                .pingBeforeActivateConnection(Boolean.TRUE)
                .cancelCommandsOnReconnectFailure(Boolean.TRUE)
                .build();

        val clientConfigBuilder =
                LettucePoolingClientConfiguration.builder()
                        .clientOptions(clientOptions)
                        .shutdownTimeout(lettuceProperties.getShutdownTimeout())
                        .commandTimeout(defaultIfNull(redisProperties.getTimeout(), ofSeconds(3)))
                        .clientResources(DefaultClientResources.create())
                        .poolConfig(poolConfig);

        val clientConfiguration = redisProperties.isSsl()
                ? clientConfigBuilder.useSsl().disablePeerVerification().build()
                : clientConfigBuilder.build();

        if (Objects.nonNull(redisProperties.getCluster())) {
            RedisClusterConfiguration clusterConfiguration = new RedisClusterConfiguration(redisProperties.getCluster().getNodes());
            val lettuceConnectionFactory = new LettuceConnectionFactory(clusterConfiguration, clientConfiguration);
            lettuceConnectionFactory.setValidateConnection(Boolean.TRUE);
            if (Objects.nonNull(redisProperties.getPassword())) {
                clusterConfiguration.setPassword(RedisPassword.of(redisProperties.getPassword()));
            }
            return lettuceConnectionFactory;

        } else {
            RedisStandaloneConfiguration redisConfiguration = new RedisStandaloneConfiguration();
            redisConfiguration.setHostName(redisProperties.getHost());
            redisConfiguration.setPort(redisProperties.getPort());
            if (Objects.nonNull(redisProperties.getPassword())){
                redisConfiguration.setPassword(RedisPassword.of(redisProperties.getPassword()));
            }
            val lettuceConnectionFactory = new LettuceConnectionFactory(redisConfiguration, clientConfiguration);
            lettuceConnectionFactory.setValidateConnection(Boolean.TRUE);
            return lettuceConnectionFactory;
        }
    }

    public RedisTemplate<?,?> redisTemplate(){
        RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
        template.setConnectionFactory(lettuceConnectionFactory());
        return template;
    }

    @Bean
    RedisCacheWriter redisCacheWriter(){ return RedisCacheWriter.lockingRedisCacheWriter(lettuceConnectionFactory());}

    @Bean
    public RedisCacheConfiguration defaultRedisCacheConfiguration(){
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(timeToLive))
                .prefixCacheNameWith(keyPrefix + CacheKeyPrefix.SEPARATOR)
                .disableCachingNullValues();
    }

    public CacheManager cacheManager(){
        Map<String, RedisCacheConfiguration> cacheNamesConfiguration = new HashMap<>();
        return new CustomerRedisCacheManager(redisCacheWriter(), RedisCacheConfiguration.defaultCacheConfig(), cacheNamesConfiguration);
    }
}
