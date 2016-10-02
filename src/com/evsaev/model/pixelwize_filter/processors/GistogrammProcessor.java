package com.evsaev.model.pixelwize_filter.processors;

import com.evsaev.model.Pixel;

public class GistogrammProcessor extends PixelProcessor {
    private float[] gist;

    public GistogrammProcessor(float[] gist) {
        this.gist = gist;
    }

    @Override
    public int processPixel(int pixelValue) {
        super.processPixel(pixelValue);

        GrayScaledProcessor grayScaledProcessor = new GrayScaledProcessor();
        grayScaledProcessor.processPixel(pixelValue);

        int brightness = grayScaledProcessor.brightness;
        int result = (int) (gist[brightness] * 255);

        return Pixel.value(this.pixel.a, result, result, result);
    }
}
