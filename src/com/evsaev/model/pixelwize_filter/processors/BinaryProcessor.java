package com.evsaev.model.pixelwize_filter.processors;

import com.evsaev.model.Pixel;

public class BinaryProcessor extends PixelProcessor {
    private int threshold;
    private int channelsValue;

    public BinaryProcessor(int threshold) {
        this.threshold = threshold;
    }

    public int getChannelsValue() {
        return channelsValue;
    }

    @Override
    public int processPixel(int pixel) {
        super.processPixel(pixel);

        GrayScaledProcessor grayScaledProcessor = new GrayScaledProcessor();
        grayScaledProcessor.processPixel(pixel);

        channelsValue = grayScaledProcessor.brightness > this.threshold ? 255 : 0;

        return Pixel.value(this.pixel.a, channelsValue, channelsValue, channelsValue);
    }
}
