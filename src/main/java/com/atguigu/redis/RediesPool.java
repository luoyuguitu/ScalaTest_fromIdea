package com.atguigu.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Protocol;

public class RediesPool {
    public static void main(String[] args) {
        //准备连接信息
        String host ="192.168.1.105";
        int port = Protocol.DEFAULT_PORT;
        //创建连接池对象
        JedisPool jedisPool = new JedisPool(host, port);
        //创建jedis对象
        Jedis jedis = jedisPool.getResource();
        //操作服务器
        String ping = jedis.ping();
        System.out.println(ping);
        //放回链接
        jedis.close();
        //关闭连接池
        jedisPool.close();
    }
}
