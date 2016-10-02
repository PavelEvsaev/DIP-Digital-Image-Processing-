package com.evsaev.model.pixelwize_filter.processors;

import com.evsaev.model.Pixel;

public class GrayScaledProcessor extends PixelProcessor {
    public int brightness;

    @Override
    public int processPixel(int pixel) {
        super.processPixel(pixel);

        brightness = (int)(this.pixel.r*0.3 + this.pixel.g*0.59 + this.pixel.b*0.11);

        return Pixel.value(this.pixel.a, brightness, brightness, brightness);
    }
}
