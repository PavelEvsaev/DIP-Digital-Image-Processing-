package com.evsaev.model;

/**
 * Created by pavelyeusayeu on 10/2/16.
 */
public class PixelFactory {
    public static Pixel createPixel(int pixelValue) {
        return new Pixel(pixelValue);
    }
}
