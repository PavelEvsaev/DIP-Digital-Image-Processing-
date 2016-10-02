package com.evsaev.model.pixelwize_filter.processors;

import com.evsaev.model.Pixel;

public class ConstantCorrectionProcessor extends PixelProcessor {
    private float mulCoefficient;
    private float addCoefficient;

    public ConstantCorrectionProcessor(float mulCoefficient, float addCoefficient) {
        this.mulCoefficient = mulCoefficient;
        this.addCoefficient = addCoefficient;
    }

    @Override
    public int processPixel(int pixel) {
        super.processPixel(pixel);

        GrayScaledProcessor grayScaledProcessor = new GrayScaledProcessor();
        grayScaledProcessor.processPixel(pixel);

        int brightness = (int)(mulCoefficient * grayScaledProcessor.brightness + addCoefficient);
        int result = brightness > 255 ? 255 : (brightness < 0 ? 0 : brightness);

        return Pixel.value(this.pixel.a<<24, result, result, result);
    }
}
