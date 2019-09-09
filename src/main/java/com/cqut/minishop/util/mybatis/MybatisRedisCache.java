package com.cqut.minishop.util.mybatis;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MybatisRedisCache implements Cache {

    private String id;

    //读写锁
    private final ReadWriteLock READWRITELOCK = new ReentrantReadWriteLock();

    private static RedisTemplate redisTemplate;

    public MybatisRedisCache(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {
        redisTemplate.boundHashOps(getId()).put(key, value);
    }

    @Override
    public Object getObject(Object key) {
        return redisTemplate.boundHashOps(getId()).get(key);
    }

    @Override
    public Object removeObject(Object key) {
        return redisTemplate.boundHashOps(getId()).delete(key);
    }

    @Override
    public void clear() {
        redisTemplate.delete(getId());
    }

    @Override
    public int getSize() {
        Long size = redisTemplate.boundHashOps(getId()).size();
        return size ==  0 ? 0 : size.intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.READWRITELOCK;
    }

    public static void setRedisTemplate(RedisTemplate redisTemplate){
        MybatisRedisCache.redisTemplate = redisTemplate;
    }

}