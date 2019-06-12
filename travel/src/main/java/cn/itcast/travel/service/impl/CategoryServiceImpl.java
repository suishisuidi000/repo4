package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao dao = new CategoryDaoImpl();
    @Override
    public List<Category> findA() {
        Jedis jedis = JedisUtil.getJedis();
        Set<Tuple> tuples = jedis.zrangeWithScores("cla", 0, -1);
        List<Category> list = null;
        if(tuples==null||tuples.size()==0){
            list = dao.find();
            for (Category category : list) {
                jedis.zadd("cla",category.getCid(),category.getCname());
            }
        }else {
           list = new ArrayList<Category>();
            for (Tuple tuple : tuples) {
                Category category = new Category();
                category.setCname(tuple.getElement());
                category.setCid((int)tuple.getScore());
                list.add(category);
         }
     }
            jedis.close();
            return list;
        }


    }

