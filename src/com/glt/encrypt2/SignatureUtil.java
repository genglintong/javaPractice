package com.glt.encrypt2;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Description
 * <p>
 * </p>
 * DATE 2020/1/15.
 *
 * @author genglintong.
 */
public class SignatureUtil {
    private static final String CHARACTER_ENCODING = "UTF-8";

    /**
     * 使用给定的算法和密钥对文本签名，之后转换为base64字符串
     */
    public static String sign(final String text, final String secretKey, final String algorithm)
            throws NoSuchAlgorithmException, InvalidKeyException {
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(secretKey.getBytes(CHARACTER_ENCODING), algorithm));
            byte[] signature = mac.doFinal(text.getBytes(CHARACTER_ENCODING));
            String signatureBase64 = Base64.getEncoder().encodeToString(signature);
            return signatureBase64;
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
