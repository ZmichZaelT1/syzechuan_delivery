package com.syzechuan.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "syzechuan.jwt")
@Data
public class JwtProperties {

    /**
     * admin jwt token
     */
    private String adminSecretKey;
    private long adminTtl;
    private String adminTokenName;

    /**
     * user jwt token
     */
    private String userSecretKey;
    private long userTtl;
    private String userTokenName;

}
