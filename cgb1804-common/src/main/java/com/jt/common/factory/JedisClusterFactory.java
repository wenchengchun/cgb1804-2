package com.jt.common.factory;

import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.Resource;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

public class JedisClusterFactory implements FactoryBean<JedisCluster>{
    
    private JedisPoolConfig jdc;
    public void setJdc(JedisPoolConfig jdc) {
        this.jdc = jdc;
    }
    private Resource redisSource;
    public void setRedisSource(Resource redisSource) {
        this.redisSource = redisSource;
    }
    
    private String keyPrefix;
    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }
    
    @Override
    public JedisCluster getObject() throws Exception {
        Set<HostAndPort> nodes = getNodes();
        JedisCluster cluster = new JedisCluster(nodes, jdc);       
        return cluster;
    }
    /**
     * 获得jedis.propeties里面的集群配置 ,封装成hostAndPort,放到Set nodes中取
     * @return
     */
    public Set<HostAndPort> getNodes() {
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        Properties properties = new Properties();
        try {
            properties.load(redisSource.getInputStream());//无序set集合
            //遍历properties中的数据，获得节点数据信息
            for (Object node : properties.keySet()) {
                String strNode =(String)node;
                //找出以redis.cluster开头的,把他们存到set里取
                if(strNode.startsWith(keyPrefix)) {
                    //是redis的节点信息的key
                    String value = properties.getProperty(strNode);
                    //截取
                    String[] args = value.split(":");
                    //封装
                    HostAndPort hostAndPort = new HostAndPort(args[0],Integer.parseInt(args[1]));
                    nodes.add(hostAndPort);
                }
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return nodes;
    }
    //标明该FactoryBean实例化的对象的类型，不写么autowoired找不到resouce找的到
    
    @Override
    public Class<?> getObjectType() {
        // TODO Auto-generated method stub
        return JedisCluster.class;
    }

    @Override
    public boolean isSingleton() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
