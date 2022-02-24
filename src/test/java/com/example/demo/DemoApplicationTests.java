package com.example.demo;

import com.example.demo.dao.ProxyWhitelistConfDao;
import com.example.demo.dao.ProxyWhitelistMapper;
import com.example.demo.entity.ProxyWhitelist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private ProxyWhitelistMapper proxyWhitelistMapper;
    @Resource
    private ProxyWhitelistConfDao proxyWhitelistConfDao;

    @Test
    void contextLoads() {
        ProxyWhitelist en = new ProxyWhitelist();
        en.setHost("a.b.com");
        proxyWhitelistMapper.insertSelective(en);
    }

    @Test
    void testDao(){
        int a = proxyWhitelistConfDao.countListByHostAndDate(null,"2022-01-24 18:39:37.458","2022-02-24 18:39:37.458");
        System.out.println(a);
    }

    @Test
    void testInsert(){
        Long a = proxyWhitelistConfDao.insert("aaa.com","aaaaaaaaa");
        System.out.println(a);
    }

}
