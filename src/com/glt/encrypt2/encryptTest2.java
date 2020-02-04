package com.glt.encrypt2;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

/**
 * Description
 * <p>
 * </p>
 * DATE 2020/1/15.
 *
 * @author genglintong.
 */
public class encryptTest2 {
    public static void main(String[] args) throws Exception {
        // 开始 -> 修改这些参数
        final String httpMethod = "GET";
//        final String requestURI = "/api/public/v1/practices/search-page";
        final String requestURI = "/api/public/dointeract";
        final String accessKeyId = "MsPh0iGtoL";
        final String algorithm = "HmacSHA256";
        final String nonce = UUID.randomUUID().toString();
        // 结束 -> 修改这些参数
        final long ts = System.currentTimeMillis() / 1000;
        final String timestamp = String.valueOf(ts);

        Map<String, String> sortedParameters = new TreeMap<>();
        sortedParameters.put(Constants.QUERY_PARAM_ACCESS_KEY_ID, accessKeyId);
        sortedParameters.put(Constants.QUERY_PARAM_ALGORITHM, algorithm);
        sortedParameters.put(Constants.QUERY_PARAM_NONCE, nonce);
        sortedParameters.put(Constants.QUERY_PARAM_TIMESTAMP, timestamp);
        sortedParameters.put("bundleId", "1");
        sortedParameters.put("cityCode", "1");
        sortedParameters.put("studentId", "1");
        sortedParameters.put("studentName", "1");

        final String text = concat(httpMethod, requestURI, sortedParameters);
        String secretKey = "8wWqckrMtgF8MdsB";

        String sign = SignatureUtil.sign(text, secretKey, algorithm);
        System.out.println("https://test.xiaohoucode.com" + requestURI + "?" +
                Constants.QUERY_PARAM_ACCESS_KEY_ID + "=" + accessKeyId + "&" +
                Constants.QUERY_PARAM_ALGORITHM + "=" + algorithm + "&" +
                Constants.QUERY_PARAM_NONCE + "=" + nonce + "&" +
                Constants.QUERY_PARAM_TIMESTAMP + "=" + timestamp + "&" +
                "bundleId" + "=" + "1" + "&" +
                "cityCode" + "=" + "1" + "&" +
                "studentId" + "=" + "1" + "&" +
                "studentName" + "=" + "1" + "&" +
                Constants.QUERY_PARAM_SIGN + "=" + UriUtils.encode(sign));
    }

    private static String concat(
            String httpMethod, String requestURI, Map<String, String> sortedParameters) throws UnsupportedEncodingException {
        StringBuilder data = new StringBuilder();
        data.append(httpMethod);
        data.append("\n");
        data.append(requestURI.toLowerCase());
        data.append("\n");

        Iterator<Map.Entry<String, String>> pairs =
                sortedParameters.entrySet().iterator();
        while (((Iterator) pairs).hasNext()) {
            Map.Entry<String, String> pair = pairs.next();
            if (pair.getValue() != null) {
                // 对value编码
                data.append(pair.getKey() + "=" + UriUtils.encode(pair.getValue()));
            } else {
                data.append(pair.getKey() + "=");
            }
            if (pairs.hasNext()) {
                data.append("&");
            }
        }
        final String text = data.toString();
        return text;
    }
}
