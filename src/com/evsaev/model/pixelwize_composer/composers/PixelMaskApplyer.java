package com.evsaev.model.pixelwize_composer.composers;

import com.evsaev.model.Pixel;

public class PixelMaskApplyer extends PixelComposer {

    public int composePixels(int maskedPixel, int maskPixel) {
        super.composePixels(maskedPixel, maskPixel);

        //p1 - masked, p2 - mask
        int a = validateValue((int) (this.p1.a * (float)this.p2.a/255));
        int r = validateValue((int) (this.p1.r * (float)this.p2.r/255));
        int g = validateValue((int) (this.p1.g * (float)this.p2.g/255));
        int b = validateValue((int) (this.p1.b * (float)this.p2.b/255));

        return Pixel.value(a, r, g, b);
    }
}
