package com.evsaev;

import com.evsaev.model.GistogrammCalculator;
import com.evsaev.model.ImageLoader;
import com.evsaev.model.pixelwize_composer.ImageComposer;
import com.evsaev.model.pixelwize_composer.composers.LOGICAL_OPERATION;
import com.evsaev.model.pixelwize_filter.PixelwizeFilter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {

        ImageLoader loader = new ImageLoader();

        BufferedImage spaceImage = loader.loadImage("src_space.jpg");
        BufferedImage lemurImage = loader.loadImage("src_lemur.jpg");
        BufferedImage maskImage = loader.loadImage("src_mask.jpg");

        PixelwizeFilter imageFilter = new PixelwizeFilter();
        BufferedImage resultImage1 = imageFilter.sawtoothBrightnessSlicedImage(lemurImage, 4);
        BufferedImage resultImage2 = imageFilter.brightnessCorrectedImage(lemurImage, 1.f, -50.f);

        ImageComposer imageComposer = new ImageComposer();
        BufferedImage resultImage4 = imageComposer.subtrack(spaceImage, lemurImage, 0.7f);
        BufferedImage resultImage5 = imageComposer.add(spaceImage, lemurImage, 0.5f);
        BufferedImage resultImage6 = imageComposer.operation(lemurImage, spaceImage, LOGICAL_OPERATION.OR, 125);
        BufferedImage resultImage7 = imageComposer.operation(lemurImage, spaceImage, LOGICAL_OPERATION.AND, 125);
        BufferedImage resultImage8 = imageComposer.mask(lemurImage, maskImage);

        loader.storeImage(resultImage1, "res_sawtoothLemur.jpg");
        loader.storeImage(resultImage2, "res_brightnessLemur.jpg");
        loader.storeImage(resultImage4, "res_space - lemur.jpg");
        loader.storeImage(resultImage5, "res_space + lemur.jpg");
        loader.storeImage(resultImage6, "res_lemur OR space.jpg");
        loader.storeImage(resultImage7, "res_lemur AND space.jpg");
        loader.storeImage(resultImage8, "res_lemur * mask.jpg");

        launch(args);
    }
}
