package BallDemo;



import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Colors;

import java.util.Random;

public class BallDemo extends GraphicsApp {

    private static final int MAX_BALLS = 100;
    private Ball[] balls;
    private Random rand;

    @Override
    public void initialize() {
        balls = new Ball[MAX_BALLS];
        for(int i = 0; i < balls.length; i++) {
            balls[i] = createRandomBall();
        }
    }

    private Ball createRandomBall() {
        if(rand == null) {
            rand = new Random();
        }
        int startX = rand.nextInt(getWidth());
        int startY = rand.nextInt(getHeight());
        int speedX = -5 + rand.nextInt(10);
        if(speedX == 0) {
            speedX = 1;
        }
        int speedY = -5 + rand.nextInt(10);
        if(speedY == 0) {
            speedY = 1;
        }
        return new Ball(startX, startY, speedX, speedY);
    }

    @Override
    public void draw() {
        drawBackground(Colors.WHITE);
        for(int i = 0; i < balls.length; i++) {
            balls[i].update();
            balls[i].draw();
        }
    }
}