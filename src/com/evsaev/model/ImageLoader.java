package com.evsaev.model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {

    public BufferedImage loadImage(String path) {

        File f = new File(path);
        BufferedImage img = null;

        try {
            img = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return img;
    }

    public void storeImage(BufferedImage img, String path) {

        File f = new File(path);

        try {
            String extension = this.fileExtension(path);
            ImageIO.write(img, extension, f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String fileExtension(String path) {
        int i = path.lastIndexOf('.');
        return path.substring(i+1);
    }
}
