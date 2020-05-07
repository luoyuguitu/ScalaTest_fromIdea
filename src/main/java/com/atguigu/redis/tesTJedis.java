package com.atguigu.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class tesTJedis {
    public static void main(String[] args) {
        //准备链接信息
        String host="192.168.1.105";
        int port=6379;
        //创建连接对象
        Jedis jedis = new Jedis(host, port);
        //操作服务器
        String s = jedis.set("animal", "rabbit");
        System.out.println(s);
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        Long sadd = jedis.sadd("people", "zhangsan", "lisi", "wangwu");
        Set<String> people = jedis.smembers("people");
        for (String person : people) {
            System.out.println(person);
        }
        System.out.println("*****************");
        System.out.println(sadd);
        //关闭连接对象
        jedis.close();
        //master做的修改
        //在new_branch添加的代码
    }
}
