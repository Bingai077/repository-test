package com.bingai.service.impl;

import com.bingai.dao.ProvinceDao;
import com.bingai.dao.impl.ProvinceDaoImpl;
import com.bingai.domain.Province;
import com.bingai.jedis.util.JedisPoolUtils;
import com.bingai.service.ProvinceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.ObservableMap;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author bingai
 * @create 2019-12-05 16:24
 */
public class ProvinceServiceImpl implements ProvinceService {
    //声明dao
    private ProvinceDao dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    /**
     * 使用redis缓存
     * @return
     */
    @Override
    public String findAllJson() {
        //1.先从redis中查询数据
        //1.1 获取redis客户端连接
        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");

        //2.判断province_json数据是否为null
        if(province_json == null ||  province_json.length() == 0){
            //redis中没有数据
            System.out.println("redis中没数据，查询数据库。。。。");
            //2.1从数据库中查询
            List<Province> ps = dao.findAll();
            //2.2将list序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            //2.3将json数据存入redis中
            jedis.set("province",province_json);
            //归还连接
            jedis.close();
        }else{
            System.out.println("redis中有数据，查询缓存。。。。");

        }
        return province_json;
    }
}
