package com.evsaev.model.pixelwize_filter.processors;

import com.evsaev.model.Pixel;

public class NegativeProcessor extends PixelProcessor {

    @Override
    public int processPixel(int pixel) {
        super.processPixel(pixel);

        int r = invert(this.pixel.r);
        int g = invert(this.pixel.g);
        int b = invert(this.pixel.b);

        return Pixel.value(this.pixel.a, r, g, b);
    }

    private int invert(int channel) {
        return 0xff - channel;
    }
}
