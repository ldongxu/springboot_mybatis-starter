package com.example.demo.dao;

import com.example.demo.entity.ProxyWhitelist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProxyWhitelistConfDao {

    Long insertEntry(ProxyWhitelist proxyConf);

    Long insert(@Param("host") String host, @Param("uuapAppKey") String uuapAppKey);

    int deleteById(long id);

    int updateBaseInfo(ProxyWhitelist proxyConf);

    ProxyWhitelist findById(long id);

    int countListByHostAndDate(@Param("host") String host,
                               @Param("startDate") String startDate, @Param("endDate") String endDate);

    List<ProxyWhitelist> findListByHostAndDate(String host, String startDate, String endDate, int pageFirst,
            int pageSize);

}
