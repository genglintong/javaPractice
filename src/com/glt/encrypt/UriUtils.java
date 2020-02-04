package com.glt.encrypt;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Description
 * <p>
 * </p>
 * DATE 2020/1/15.
 *
 * @author genglintong.
 */
public class UriUtils {
    public static String encode(String rawValue) throws UnsupportedEncodingException {
        if (rawValue == null || rawValue.isEmpty()) {
            return rawValue;
        }
        // Sun官方说明了空格编码为"+"不是bug，符合HTML4.01标准
        final String encoded = URLEncoder
                .encode(rawValue, String.valueOf(StandardCharsets.UTF_8))
                .replace("+", "%20")
                .replace("*", "%2A")
                .replace("%7E", "~");
        return encoded;
    }
}
