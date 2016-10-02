package com.evsaev.model;

import com.evsaev.model.pixelwize_filter.processors.GrayScaledProcessor;
import java.awt.image.BufferedImage;

public class GistogrammCalculator {

    private static int N = 256;

    public int[] getGistogramm(BufferedImage image) {

        int[] values = new int[N];

        for (int i = 0; i < N; i++) {
            values[i] = 0;
        }

        GrayScaledProcessor processor = new GrayScaledProcessor();

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {

                int pixel = image.getRGB(x, y);
                processor.processPixel(pixel);

                int brightness = processor.brightness;
                values[brightness] = values[brightness] + 1;
            }
        }

        return values;
    }

    public float[] getNormalizedGistogramm(BufferedImage image) {
        int[] values = this.getGistogramm(image);
        return this.normalize(values, image.getHeight() * image.getWidth());
    }

    public float[] getEqualizedGistogramm(BufferedImage image) {
        float[] normalizedValues = this.getNormalizedGistogramm(image);
        return this.equalize(normalizedValues);
    }

    private float[] equalize(float[] normalizedValues) {

        for (int i = 1; i < N; i++) {
            normalizedValues[i] = normalizedValues[i - 1] + normalizedValues[i];
        }

        return normalizedValues;
    }

    private float[] normalize(int[] values, int size) {

        float[] normalizedValues = new float[N];

        for (int i = 0; i < N; i++) {
            normalizedValues[i] = (float)values[i] / size;
        }

        return normalizedValues;
    }
}
