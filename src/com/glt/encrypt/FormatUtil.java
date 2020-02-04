package com.glt.encrypt;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Description
 * <p>
 *     格式化
 * </p>
 * DATE 2020/1/10.
 *
 * @author genglintong.
 */
public class FormatUtil {

    /**
     * 按照字典序排序
     * @param paraMap
     * @return
     */
    public static String formatUrlMapBySort(Map<String, String> paraMap) {
        String buff = "";
        List<Map.Entry<String, String>> infoIds = new ArrayList<>(paraMap.entrySet());
        // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）
        infoIds.sort(Map.Entry.comparingByKey());

        try {
            buff = formatUrl(infoIds, true);
        } catch (UnsupportedEncodingException e)
        {
            return null;
        }

        return buff;
    }

    public static String formatUrlMap(String host , Map<String, String> paraMap) {
        List<Map.Entry<String, String>> infoIds = new ArrayList<>();

        for (Map.Entry<String, String> entry : paraMap.entrySet()) {
            if ("timestamp".equals(entry.getKey())) {
                infoIds.add(0, entry);
            }else {
                infoIds.add(entry);
            }
        }

        try {
            String url = host + "?" + formatUrl(infoIds, false);

            //return UriUtils.encode(url);
            return url;
        }catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    private static String formatUrl(List<Map.Entry<String, String>> infoIds , boolean encode) throws UnsupportedEncodingException {
        String buff = "";
        // 构造URL 键值对的格式
        StringBuilder buf = new StringBuilder();
        for (Map.Entry<String, String> item : infoIds)
        {
            if (!"".equals(item.getKey()))
            {
                String key = item.getKey();
                String val = item.getValue();

                if (encode) {
                    val = UriUtils.encode(val);
                }

                buf.append(key).append("=").append(val).append("&");
            }
        }

        // 去除最后一个 &
        buff = buf.toString();
        if (!buff.isEmpty())
        {
            buff = buff.substring(0, buff.length() - 1);
        }

        return buff;
    }
}
