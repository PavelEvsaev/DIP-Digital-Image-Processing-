package com.evsaev.model.pixelwize_filter.processors;

import com.evsaev.model.Pixel;

public class SawtoothProcessor extends PixelProcessor {
    private int intervalLength;
    private float k;

    public SawtoothProcessor(int numberOfInvervals) {
        this.intervalLength = 256 / numberOfInvervals;

        /*
        point1 - (0,0), point2 - (this.intervalLength, 255)
        (point1.y = k * point1.x + b) => (0 = 0 + b) => (b == 0);
        (point2.y = k * point2.x + 0) => (k = point2.y / point2.x)
        */

        this.k = 255 / this.intervalLength;
    }

    @Override
    public int processPixel(int pixelValue) {
        super.processPixel(pixelValue);

        GrayScaledProcessor grayScaledProcessor = new GrayScaledProcessor();
        grayScaledProcessor.processPixel(pixelValue);

        int brightness = grayScaledProcessor.brightness;
        int x = brightness % this.intervalLength;
        int y = (int) this.k * x;

        return Pixel.value(this.pixel.a, y, y, y);
    }
}
