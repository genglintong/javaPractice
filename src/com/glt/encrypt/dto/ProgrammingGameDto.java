package com.glt.encrypt.dto;

import java.util.HashMap;
import java.util.UUID;

/**
 * Description
 * <p>
 * </p>
 * DATE 2020/1/9.
 *
 * @author genglintong.
 */
public class ProgrammingGameDto {
    /**
     * 题组ID bundleId
     * 城市编号 cityCode
     * 学生ID studentId
     * 学生名称 studentName
     * 当前时间戳 timestamp
     * 唯一随机字符串 nonce
     */
    private HashMap<String, String> programmingParams;

    public ProgrammingGameDto(String bundleId, String cityCode, String studentId, String studentName) {
        this.programmingParams = new HashMap<>(8);

        this.programmingParams.put("bundleId", bundleId);
        this.programmingParams.put("cityCode", cityCode);
        this.programmingParams.put("studentId", studentId);
        this.programmingParams.put("studentName", studentName);
        this.programmingParams.put("timestamp", String.valueOf(System.currentTimeMillis()));
        this.programmingParams.put("nonce", UUID.randomUUID().toString());
    }

    public void addValue(String key , String value) {
        this.programmingParams.put(key, value);
    }

    public HashMap<String, String> getProgrammingParams() {
        return programmingParams;
    }
}
