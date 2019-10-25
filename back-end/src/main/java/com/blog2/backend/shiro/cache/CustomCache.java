package com.blog2.backend.shiro.cache;

import com.blog2.backend.enums.TokenEnum;
import com.blog2.backend.jwt.JwtUtil;
import com.blog2.backend.redis.RedisUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static com.blog2.backend.enums.RedisEnum.REFRESH_TOKEN_PREFIX;
import static com.blog2.backend.enums.RedisEnum.SHIRO_CACHE_PERFIX;
import static com.blog2.backend.enums.TokenEnum.SHIRO_CACHE_EXPIRE_TIME;

/**
 * 重写Shiro的Cache保存读取
 * todo 这个类似乎没用，我们用redis进行手动管理
 *
 * @author dolyw.com
 * @date 2018/9/4 17:31
 */
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class CustomCache<K, V> implements Cache<K, V> {
    private final RedisUtil redisUtil;

    /**
     * 缓存的key名称获取为shiro:cache:account
     *
     * @param key
     * @return java.lang.String
     * @author dolyw.com
     * @date 2018/9/4 18:33
     */
    private String getKey(Object key) {
        return SHIRO_CACHE_PERFIX.getCode() + JwtUtil.getClaim(key.toString(), TokenEnum.PAYLOAD_USER_TAG.getCode());
    }

    /**
     * 获取缓存
     */
    @Override
    public Object get(Object key) throws CacheException {
        return null;
//        return redisUtil.get(this.getKey(key));
    }

    /**
     * 保存缓存
     */
    @Override
    public Object put(Object key, Object value) throws CacheException {
        // 读取配置文件，获取Redis的Shiro缓存过期时间
        // 设置Redis的Shiro缓存 似乎没什么用
//        return redisUtil.set(this.getKey(key), value, Long.parseLong(SHIRO_CACHE_EXPIRE_TIME.getCode()));
        return null;
    }


    /**
     * 移除缓存
     */
    @Override
    public Object remove(Object key) throws CacheException {
//        redisUtil.del(this.getKey(key));
        return null;
    }

    /**
     * 清空所有shiro缓存
     */
    @Override
    public void clear() throws CacheException {
//        redisUtil.clear(REFRESH_TOKEN_PREFIX.getCode());
    }

    /**
     * 缓存的个数
     */
    @Override
    public int size() {
//        return redisUtil.getAllKeyLength(REFRESH_TOKEN_PREFIX.getCode());
        return 0;
    }

    /**
     * 获取所有的key
     */
    @Override
    public Set keys() {
//        return redisUtil.getAllKey(REFRESH_TOKEN_PREFIX.getCode());
        return new HashSet();
    }

    /**
     * 获取所有的value
     */
    @Override
    public Collection values() {
//        Set keys = this.keys();
//        List<Object> values = new ArrayList<Object>();
//        for (Object key : keys) {
//            values.add(redisUtil.get(key.toString()));
//        }
//        return values;
        return new ArrayList();
    }
}
