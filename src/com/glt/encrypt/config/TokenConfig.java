package com.glt.encrypt.config;

/**
 * Description
 * <p>
 * </p>
 * DATE 2020/1/10.
 *
 * @author genglintong.
 */
public class TokenConfig {
    /**
     * 获取小猴编程的URL
     */
    //@Value("${token.programming.host:}")
    private String host = "";

    /**
     * 小猴编程 PATH
     */
    //@Value("${token.programming.interactPath:/api/public/dointeract}")
    private String interactPath = "/api/public/dointeract";

    /**
     * 小猴编程 RSA key
     */
    //@Value("${token.programming.secret:}")
    private String secret = "";

    //@Value("${token.programming.accessKeyId:}")
    private String accessKeyId = "";

    public String getHost() {
        return host;
    }

    public String getInteractPath() {
        return interactPath;
    }

    public String getSecret() {
        return secret;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }
}
