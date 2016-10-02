package com.evsaev.model.pixelwize_filter.processors;

import com.evsaev.model.Pixel;
import com.evsaev.model.PixelFactory;

public class PixelProcessor {
    public Pixel pixel;

    public int processPixel(int pixelValue) {
        this.pixel = PixelFactory.createPixel(pixelValue);
        return pixelValue;
    }
}
