package com.javaThink.chapter8;

import com.javaThink.util.Util;

/**
 * Description
 * <p>
 * </p>
 * DATE 2019/11/13.
 *
 * @author genglintong.
 */
public class ReferenceCounting {
    public static void main(String[] args) {
        Shared shared;
        shared = new Shared();
        Composing[] composings = {
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared),
                new Composing(shared)
        };

        for (Composing c : composings) {
            c.dispose();
        }
    }
}

class Shared {
    private int refcount = 0;
    private static long counter = 0;
    private final long id = counter++;

    public Shared() {
        Util.print("Creating " + this);
    }

    public void addRef() {
        refcount++;
    }

    protected void dispose() {
        if (--refcount == 0) {
            Util.print("Dispose " + this);
        }
    }

    public String toString() {
        return "Shared " + id;
    }
}

class Composing {
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;

           public Composing(Shared shared) {
        Util.print("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    protected void dispose() {
        Util.print("Dispose " + this);
        shared.dispose();
    }

    public String toString() {
        return "Composing " + id;
    }
}
