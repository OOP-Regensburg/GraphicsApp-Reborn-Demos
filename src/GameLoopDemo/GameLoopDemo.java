package GameLoopDemo;


import de.mi.ur.gpr.app.GraphicsApp;
import de.mi.ur.gpr.colors.Color;
import de.mi.ur.gpr.colors.Colors;
import de.mi.ur.gpr.graphics.Rectangle;

import java.util.ArrayList;
import java.util.Random;

public class GameLoopDemo extends GraphicsApp {

    private static final int MAX_CARS = 100;
    private static final int MIN_SPEED = 1;
    private static final int MAX_SPEED = 5;

    private Random rand;
    private ArrayList<Rectangle> cars;

    @Override
    public void initialize() {
        System.out.println("in: init");
        rand = new Random();
        cars = new ArrayList<Rectangle>();

        int startX = 5;
        int startY = 5;
        int width = 30;
        int height = 4;
        int margin = 4;

        for(int i = 0; i < MAX_CARS; i++) {
            Color color = Colors.getRandomColor();
            Rectangle rect = new Rectangle(startX, startY, width, height, color);
            startY += (height + margin);
            cars.add(rect);
        }
    }

    @Override
    public void draw() {
        for(Rectangle car: cars) {
            int speed = rand.nextInt((MAX_SPEED - MIN_SPEED) + 1) + MIN_SPEED;
            car.move(speed, 0);
            car.draw();
        }
    }
}
