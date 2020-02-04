package com.glt.encrypt;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

/**
 * Description
 * <p>
 * </p>
 * DATE 2019/11/2.
 *
 * @author genglintong.
 */
public class EncryptionUtil {
    /**
     * 秘钥
     */
    private static String KEY = "XoO26FAyyGh3C1Zl";

    /**
     * 编码方式
     */
    private static final String CHARACTER_ENCODING = "UTF-8";

    /**
     * 签名方式
     */
    public static final String HMAC = "HmacSHA256";

    /**
     * 计算RSA 签名
     * @param text
     * @param privateKeyData
     * @return
     * @throws GeneralSecurityException
     */
    public static String signByRSA(final byte[] text, final byte[] privateKeyData) throws GeneralSecurityException {
        byte[] base64PrivateKey = Base64.getDecoder().decode(privateKeyData);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(base64PrivateKey);
        KeyFactory keyFactory       = KeyFactory.getInstance("RSA");
        PrivateKey privateKey       = keyFactory.generatePrivate(keySpec);
        Signature signatureChecker  = Signature.getInstance("SHA256WITHRSA");
        signatureChecker.initSign(privateKey);
        signatureChecker.update(text);
        byte[] sign =  signatureChecker.sign();

        return Base64.getEncoder().encodeToString(sign);
    }

    /**
     * 使用给定的算法和密钥对文本签名，之后转换为base64字符串
     */
    public static String signByHmac(final String text, final String secretKey, final String algorithm)
            throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Mac mac = Mac.getInstance(algorithm);
        mac.init(new SecretKeySpec(secretKey.getBytes(CHARACTER_ENCODING), algorithm));
        byte[] signature = mac.doFinal(text.getBytes(CHARACTER_ENCODING));
        String sign =  Base64.getEncoder().encodeToString(signature);

        return UriUtils.encode(sign);
    }
}
