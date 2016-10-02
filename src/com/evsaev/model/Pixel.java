package com.evsaev.model;

public class Pixel {

    private int value;
    public int a;
    public int r;
    public int g;
    public int b;

    public Pixel(int value) {
        this.setValue(value);
    }

    public void setValue(int value) {
        this.value = value;
        this.a = (value>>24)&0xff;
        this.r = (value>>16)&0xff;
        this.g = (value>>8)&0xff;
        this.b = value&0xff;
    }

    public int getValue() {
        return value;
    }

    public static int value(int a, int r, int g, int b) {
        return a<<24 | r<<16 | g<<8 | b;
    }
}
