package com.example.demo.dao;

import com.example.demo.entity.ProxyWhitelist;

public interface ProxyWhitelistMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProxyWhitelist record);


    int insertSelective(ProxyWhitelist record);

    ProxyWhitelist selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProxyWhitelist record);

    int updateByPrimaryKey(ProxyWhitelist record);
}