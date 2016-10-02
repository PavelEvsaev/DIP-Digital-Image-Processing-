package com.evsaev.model.pixelwize_composer.composers;


import com.evsaev.model.Pixel;
import com.evsaev.model.PixelFactory;

public class PixelComposer {
    protected Pixel p1;
    protected Pixel p2;

    private void extractPixels(int pixel1, int pixel2) {
        this.p1 = PixelFactory.createPixel(pixel1);
        this.p2 = PixelFactory.createPixel(pixel2);
    }

    public int composePixels(int pixel1, int pixel2) {
        this.extractPixels(pixel1, pixel2);
        return pixel1;
    }

    protected int validateValue(int value) {
        return value > 255 ? 255 : (value < 0 ? 0 : value);
    }
}
