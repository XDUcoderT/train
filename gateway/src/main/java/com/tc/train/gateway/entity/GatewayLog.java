package com.tc.train.gateway.entity;

import lombok.Data;

/**
 * @author ：Shine
 * @description：
 * @date ：2021/6/24 9:00
 */
@Data
public class GatewayLog {
    private String requestPath;
    private String requestMethod;
    private String schema;
    private String requestBody;
    private String responseBody;
    private String ip;
    private String requestTime;
    private String responseTime;
    private Long executeTime;

}
