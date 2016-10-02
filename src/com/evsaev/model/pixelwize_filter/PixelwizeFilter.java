package com.evsaev.model.pixelwize_filter;

import com.evsaev.model.pixelwize_filter.processors.*;

import java.awt.image.BufferedImage;

public class PixelwizeFilter {

    public BufferedImage binaryImage(BufferedImage image, int threshold) {
        PixelProcessor processor = new BinaryProcessor(threshold);
        return this.applyProcessor(image, processor);
    }

    public BufferedImage brightnessSlicedImage(BufferedImage image, int min, int max) {
        PixelProcessor processor = new BrightnessSliceProcessor(min, max);
        return this.applyProcessor(image, processor);
    }

    public BufferedImage grayScaledImage(BufferedImage image) {
        PixelProcessor processor = new GrayScaledProcessor();
        return this.applyProcessor(image, processor);
    }

    public BufferedImage negativeImage(BufferedImage image) {
        PixelProcessor processor = new NegativeProcessor();
        return this.applyProcessor(image, processor);
    }

    public BufferedImage brightnessCorrectedImage(BufferedImage image, float mulC, float addC) {
        PixelProcessor processor = new ConstantCorrectionProcessor(mulC, addC);
        return this.applyProcessor(image, processor);
    }

    public BufferedImage sawtoothBrightnessSlicedImage(BufferedImage image, int numberOfIntervals) {
        PixelProcessor processor = new SawtoothProcessor(numberOfIntervals);
        return this.applyProcessor(image, processor);
    }

    public BufferedImage equlizedGistogrammImage(BufferedImage image, float[] gist) {
        PixelProcessor processor = new GistogrammProcessor(gist);
        return this.applyProcessor(image, processor);
    }

    private BufferedImage applyProcessor(BufferedImage image, PixelProcessor processor) {

        int width = image.getWidth();
        int height = image.getHeight();
        int type = image.getType();

        BufferedImage outImage = new BufferedImage(width, height, type);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                int processedPixel = processor.processPixel(pixel);
                outImage.setRGB(x, y, processedPixel);
            }
        }

        return outImage;
    }


}
