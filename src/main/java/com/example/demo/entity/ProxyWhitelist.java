package com.example.demo.entity;

import java.util.Date;

public class ProxyWhitelist {
    private Long id;

    private String host;

    private String uuapAppKey;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    public String getUuapAppKey() {
        return uuapAppKey;
    }

    public void setUuapAppKey(String uuapAppKey) {
        this.uuapAppKey = uuapAppKey == null ? null : uuapAppKey.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}