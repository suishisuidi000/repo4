package cn.it.demo;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

public class Text {
    @Test
    public void Test01(){
        Jedis jedis = new Jedis();

        jedis.hset("myhash","name","张三");
        jedis.hset("myhash","age","22");
        jedis.hset("myhash","gender","male");
        Map<String, String> myhash = jedis.hgetAll("myhash");
        System.out.println(myhash);
    }
    @Test
    public void Test02(){
        Jedis jedis = new Jedis();
        jedis.lpush("melist","a","s","d");
        jedis.rpush("melist","a","s","d");
        String melist = jedis.rpop("melist");
        System.out.println(melist);
        List<String> melist1 = jedis.lrange("melist", 0, -1);
        System.out.println(melist1);


    }
}
