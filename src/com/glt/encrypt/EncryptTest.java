package com.glt.encrypt;

import com.glt.encrypt.config.TokenConfig;
import com.glt.encrypt.dto.ProgrammingGameDto;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Description
 * <p>
 * </p>
 * DATE 2020/1/15.
 *
 * @author genglintong.
 */
public class EncryptTest {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        String bundleId = "1";
        String cityCode = "1";
        String studentId = "1";
        String studentName = "1";

        TokenConfig tokenConfig = new TokenConfig();

        ProgrammingGameDto programmingGameDto = new ProgrammingGameDto(bundleId, cityCode, studentId, studentName);
        programmingGameDto.addValue("accessKeyId", tokenConfig.getAccessKeyId());
        programmingGameDto.addValue("algorithm", EncryptionUtil.HMAC);

        String text = FormatUtil.formatUrlMapBySort(programmingGameDto.getProgrammingParams());

        assert text != null;
        text = "GET\n" + tokenConfig.getInteractPath() + "\n" + text;
        String sign = EncryptionUtil.signByHmac(text, tokenConfig.getSecret(), EncryptionUtil.HMAC);
        programmingGameDto.addValue("sign",sign);

        String host = tokenConfig.getHost() + tokenConfig.getInteractPath();

        String url = FormatUtil.formatUrlMap(host , programmingGameDto.getProgrammingParams());

        System.out.println(url);
    }
}
