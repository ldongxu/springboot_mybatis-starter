package com.example.demo;

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
    

    @Test
    void contextLoads() {
        ProxyWhitelist en = new ProxyWhitelist();
        en.setHost("a.b.com");
        proxyWhitelistMapper.insertSelective(en);
    }

}
