package com.evsaev.model.pixelwize_filter.processors;

import com.evsaev.model.Pixel;

public class BrightnessSliceProcessor extends PixelProcessor {
    private int min;
    private int max;

    public BrightnessSliceProcessor(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public int processPixel(int pixel) {
        super.processPixel(pixel);

        GrayScaledProcessor grayScaledProcessor = new GrayScaledProcessor();
        grayScaledProcessor.processPixel(pixel);

        int brightness = grayScaledProcessor.brightness;
        int result = (min <= brightness && brightness <= max) ? brightness : 0;

        return Pixel.value(this.pixel.a, result, result, result);
    }
}
