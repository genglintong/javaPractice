package com.glt;

/**
 * Description
 * <p>
 * </p>
 * DATE 2019/12/5.
 *
 * @author genglintong.
 */
public class StringTest {
    /**
     * 校验字符串 不可变
     */
    private void stringTest(String s) {
        s = s.concat("test");
    }

    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
        String ss = "glt";

        stringTest.stringTest(ss);
    }
}
