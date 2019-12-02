package com.javaThink.chapter9;

/**
 * Description
 * <p>
 * </p>
 * DATE 2019/12/2.
 *
 * @author genglintong.
 */
public class InterfaceCollision {
}

interface I1 {
    void f();
}

interface I2 {
    int f(int i);
}

interface I3 {
    int f();
}

class C {
    public int f() {
        return 1;
    }
}

class C2 implements I1, I2 {

    /**
     * 重载
     */
    public void f() { };

    /**
     * 重载
     * @param i
     * @return
     */
    public int f(int i) {
        return 1;
    }
}

class C3 extends C implements I2 {
    /**
     * 重载
     * @param i
     * @return
     */
    public int f(int i) {
        return 0;
    }
}

class C4 extends C implements I3 {
    public int f(){
        return 1;
    };
}