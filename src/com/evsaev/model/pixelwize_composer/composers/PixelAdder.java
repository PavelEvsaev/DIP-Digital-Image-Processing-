package com.evsaev.model.pixelwize_composer.composers;

import com.evsaev.model.Pixel;

public class PixelAdder extends PixelComposer {
    private float weight;

    public PixelAdder(float weight) {
        this.weight = weight;
    }

    @Override
    public int composePixels(int pixel1, int pixel2) {
        super.composePixels(pixel1, pixel2);

        int a = (int) (this.weight * this.p1.a + (1 - this.weight) * this.p2.a);
        int r = (int) (this.weight * this.p1.r + (1 - this.weight) * this.p2.r);
        int g = (int) (this.weight * this.p1.g + (1 - this.weight) * this.p2.g);
        int b = (int) (this.weight * this.p1.b + (1 - this.weight) * this.p2.b);

        a = validateValue(a);
        r = validateValue(r);
        g = validateValue(g);
        b = validateValue(b);

        return Pixel.value(a, r, g, b);
    }
}
