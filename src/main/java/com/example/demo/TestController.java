package com.example.demo;

import com.example.demo.dao.ProxyWhitelistMapper;
import com.example.demo.entity.ProxyWhitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private ProxyWhitelistMapper proxyWhitelistMapper;

    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        ProxyWhitelist entry = proxyWhitelistMapper.selectByPrimaryKey(1L);
        return entry.getHost();
    }

}
