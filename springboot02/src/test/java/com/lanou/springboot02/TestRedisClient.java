package com.lanou.springboot02;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class TestRedisClient {

    @Test
    public void  testConnection(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.auth("123456");
        System.out.println(jedis.ping());
    }

    @Test
    public void  testString(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.auth("123456");
        System.out.println(jedis.ping());
        jedis.set("school","河南蓝鸥");
        System.out.println(jedis.get("school"));
    }

    @Test
    public void  testList(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.auth("123456");
        System.out.println(jedis.ping());
        jedis.lpush("手机","华为");
        jedis.lpush("手机","小米");
        jedis.lpush("手机","OPPO");
        List<String> list =jedis.lrange("手机",0,jedis.llen("手机"));
        for (String s:list
             ) {
            System.out.println(s);
        }
    }

    @Test
    public void  testHash(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.auth("123456");
        Set set = jedis.keys("*");
        for (Object s:set
        ) {
            System.out.println(s);
        }

        jedis.hset("user","id","1001");
        jedis.hset("user","username","杜杰");
        System.out.println(jedis.hget("user","id"));
        System.out.println(jedis.hgetAll("user"));

    }


}
