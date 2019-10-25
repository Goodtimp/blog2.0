package com.blog2.backend.shiro.cache;

import com.blog2.backend.redis.RedisUtil;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author: goodtimp
 * @Date: 2019/10/24 16:51
 * @description : 重写Shiro缓存管理器
 */
public class CustomCacheManager implements CacheManager {
    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return new CustomCache<K, V>();
    }
}
