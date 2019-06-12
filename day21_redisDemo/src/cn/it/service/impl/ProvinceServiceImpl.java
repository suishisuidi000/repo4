package cn.it.service.impl;

import cn.it.Dao.ProvinceDao;
import cn.it.Dao.impl.ProvinceDaoImpl;
import cn.it.domain.Province;
import cn.it.service.ProvinceService;
import cn.it.until.JedisPoolUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
   private ProvinceDao dao = new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String proRedis() {
       /* Jedis jedis = JedisPoolUtils.getJedis();*/
       Jedis jedis = new Jedis();
        String pro = jedis.get("province");
        if(pro==null||pro.length()==0){
            List<Province> list = dao.findAll();
            ObjectMapper mapper = new ObjectMapper();
            try {
               pro =  mapper.writeValueAsString(list);

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province",pro);
            jedis.close();
        }
        return pro;
    }
}
