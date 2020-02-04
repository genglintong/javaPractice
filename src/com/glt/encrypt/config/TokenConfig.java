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
    //@Value("${token.programming.host:https://test.xiaohoucode.com}")
    private String host = "https://test.xiaohoucode.com";

    /**
     * 小猴编程 PATH
     */
    //@Value("${token.programming.interactPath:/api/public/dointeract}")
    private String interactPath = "/api/public/dointeract";

    /**
     * 小猴编程 RSA key
     */
    //@Value("${token.programming.secret:8wWqckrMtgF8MdsB}")
    private String secret = "weMoPjZaLas4MmBd";

    //@Value("${token.programming.accessKeyId:MsPh0iGtoL}")
    private String accessKeyId = "MsPh0iGtoL";

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
