package com.evsaev.model.pixelwize_composer.composers;

import com.evsaev.model.Pixel;
import com.evsaev.model.pixelwize_filter.processors.BinaryProcessor;

public class PixelLogicalComposer extends PixelComposer {
    private LOGICAL_OPERATION operation;
    private int threshold;

    public PixelLogicalComposer(LOGICAL_OPERATION operation, int threshold) {
        this.operation = operation;
        this.threshold = threshold;
    }

    @Override
    public int composePixels(int pixel1, int pixel2) {
        super.composePixels(pixel1, pixel2);

        BinaryProcessor binaryProcessor = new BinaryProcessor(this.threshold);

        binaryProcessor.processPixel(pixel1);
        boolean x1 = binaryProcessor.getChannelsValue() == 0xff;

        binaryProcessor.processPixel(pixel2);
        boolean x2 = binaryProcessor.getChannelsValue() == 0xff;

        int result = this.operationResult(x1, x2) ? 0xff : 0x00;

        return Pixel.value(this.p1.a, result, result, result);
    }

    private boolean operationResult(boolean x1, boolean x2) {
        boolean result = false;

        switch (this.operation) {
            case AND:
                result = x1 && x2;
                break;
            case NAND:
                result = !(x1 && x2);
                break;
            case OR:
                result = x1 || x2;
                break;
            case NOR:
                result = !(x1 || x2);
                break;
            case XOR:
                result = (x1 && !x2) || (!x1 && x2);
                break;
        }

        return result;
    }
}
