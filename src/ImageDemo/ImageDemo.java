package ImageDemo;

import de.mi.ur.gpr.app.GraphicsApp;
import de.mi.ur.gpr.colors.Colors;
import de.mi.ur.gpr.graphics.Image;

import java.util.ArrayList;
import java.util.Random;

public class ImageDemo extends GraphicsApp {
    
    private Random rand;
    private int NUMBER_OF_IMAGES = 100;
    private ArrayList<Image> images;

    @Override
    public void initialize() {
        rand = new Random();
        images = new ArrayList<Image>();
        for(int i = 0; i < NUMBER_OF_IMAGES; i++) {
            int startX = rand.nextInt(getWidth());
            int startY = rand.nextInt(getHeight());
            Image image = new Image(startX, startY, "data/tux.png");
            image.setWidth(rand.nextInt(50) + 10);
            image.setHeight((int) (image.getWidth() * 1.1));
            images.add(image);
        }
    }

    @Override
    public void draw() {
        drawBackground(Colors.WHITE);
        for(Image image: images) {
            int newX = rand.nextInt(getWidth());
            int newY = rand.nextInt(getHeight());
            image.setXPos(newX);
            image.setYPos(newY);
            image.draw();
        }
    }
}
