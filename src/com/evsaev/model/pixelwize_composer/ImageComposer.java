package com.evsaev.model.pixelwize_composer;
import com.evsaev.model.pixelwize_composer.composers.*;

import java.awt.image.BufferedImage;

public class ImageComposer {

    public BufferedImage add(BufferedImage image1, BufferedImage image2, float weight) {
        PixelComposer composer = new PixelAdder(weight);
        return this.applyCompose(image1, image2, composer);
    }

    public BufferedImage subtrack(BufferedImage image1, BufferedImage image2, float weight) {
        PixelComposer composer = new PixelSubtracker(weight);
        return this.applyCompose(image1, image2, composer);
    }

    public BufferedImage mask(BufferedImage image, BufferedImage maskImage) {
        PixelComposer composer = new PixelMaskApplyer();
        return this.applyCompose(image, maskImage, composer);
    }

    public BufferedImage operation(BufferedImage image1, BufferedImage image2, LOGICAL_OPERATION op, int binThreshold) {
        PixelComposer composer = new PixelLogicalComposer(op, binThreshold);
        return this.applyCompose(image1, image2, composer);
    }

    public BufferedImage applyCompose(BufferedImage image1, BufferedImage image2, PixelComposer composer) {

        int width1 = image1.getWidth();
        int width2 = image2.getWidth();

        int height1 = image1.getHeight();
        int height2 = image2.getHeight();

        if (width1 != width2 || height1 != height2) {
            throw new IllegalArgumentException("Images aren't the same size");
        }

        BufferedImage outImage = new BufferedImage(width1, height1, image1.getType());

        for (int y = 0; y < height1; y++) {
            for (int x = 0; x < width1; x++) {

                int pixelValue1 = image1.getRGB(x, y);
                int pixelValue2 = image2.getRGB(x, y);
                int resultValue = composer.composePixels(pixelValue1, pixelValue2);

                outImage.setRGB(x, y, resultValue);
            }
        }

        return outImage;
    }
}
