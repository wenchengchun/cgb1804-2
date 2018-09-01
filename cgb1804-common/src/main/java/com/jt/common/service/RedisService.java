package com.jt.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Service
public class RedisService {
    //spring控制redis分片池
    /*
     * autowired表示立即注入一个对象，但现在其实还没有这个对象
     * 所以需要给他配延时加载
     * 
     */
  /*  @Autowired(required=false)//程序启动的时候不会注入，调用时才注入 
    private ShardedJedisPool shardedJedisPool;
    
    
    
    *//**
     * 自己包装set
     * @param key
     * @param value
     *//*
    public void set(String key,String value) {
        ShardedJedis jedis = shardedJedisPool.getResource();
        jedis.set(key, value);
        shardedJedisPool.returnResource(jedis);
    }
    *//**
     * 设置超时的set
     * @param key
     * @param value
     *//*
    public void set(String key,int seconds,String value) {
        ShardedJedis jedis = shardedJedisPool.getResource();
        jedis.setex(key,seconds,value);
        shardedJedisPool.returnResource(jedis);
    }
    *//**
     * 自己包装get
     * @param key
     * @return
     *//*
    public String get(String key) {
        ShardedJedis jedis = shardedJedisPool.getResource();
        String result = jedis.get(key);
        shardedJedisPool.returnResource(jedis);
        return result;
    }*/
    
    
    @Autowired(required=false)
    private JedisSentinelPool sentinelPool;
    
    public void set(String key ,String value) {
        Jedis jedis = sentinelPool.getResource();
        jedis.set(key, value);
        sentinelPool.returnResource(jedis);
    }
    public String get(String key) {
        Jedis jedis = sentinelPool.getResource();
        String result = jedis.get(key);
        sentinelPool.returnResource(jedis);
        return result;
    }
}
