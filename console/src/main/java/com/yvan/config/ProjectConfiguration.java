package com.yvan.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @author v_yangfeng01
 * @date 2021/2/13
 */
@Service
@Configuration
public class ProjectConfiguration {

    @Value("${datahub.redis.gateway.apiService.quota.key}")
    private String datahubRedisApiServiceQuotaKay;

    @Value("${datahub.redis.gateway.appkey.usedcount.key}")
    private String datahubRedisAppkeyUsedcountKey;

    public String getDatahubRedisApiServiceQuotaKay() {
        return datahubRedisApiServiceQuotaKay;
    }

    public void setDatahubRedisApiServiceQuotaKay(String datahubRedisApiServiceQuotaKay) {
        this.datahubRedisApiServiceQuotaKay = datahubRedisApiServiceQuotaKay;
    }

    public String getDatahubRedisAppkeyUsedcountKey() {
        return datahubRedisAppkeyUsedcountKey;
    }

    public void setDatahubRedisAppkeyUsedcountKey(String datahubRedisAppkeyUsedcountKey) {
        this.datahubRedisAppkeyUsedcountKey = datahubRedisAppkeyUsedcountKey;
    }
}
