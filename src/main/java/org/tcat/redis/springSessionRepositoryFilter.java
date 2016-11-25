package org.tcat.redis;

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * 第二种类型 spring boot + redis 实现session共享
 * Session 拦截器
 * Created by Lin on 2016/11/25.
 */
@EnableRedisHttpSession(redisNamespace = "redis_spring_boot_session", maxInactiveIntervalInSeconds = 3600)
public class springSessionRepositoryFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
