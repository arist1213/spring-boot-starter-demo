package com.example.websocketdemo.model;

/**
 * created by yanming on 2018/8/11
 */
public class DrawMessage {
    //var p = {x1:prev.x, y1:prev.y, x2:curr.x, y2:curr.y}

    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    @Override
    public String toString() {
        return "{x1:"+x1+", y1:" +y1+"; x2:"+x2+", y2:"+y2+"}";
    }
}
