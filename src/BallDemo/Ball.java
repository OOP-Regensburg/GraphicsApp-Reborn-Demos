package BallDemo;


import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.graphics.Circle;

public class Ball {

    private static final int DEFAULT_RADIUS = 10;

    private int xPos;
    private int yPos;
    private int xSpeed;
    private int ySpeed;
    private Circle circle;

    public Ball(int x, int y, int xSpeed, int ySpeed) {
        this.xPos = x;
        this.yPos = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.circle = new Circle(x, y, DEFAULT_RADIUS, Colors.getRandomColor());
    }

    public void update() {
        circle.move(xSpeed, ySpeed);
    }

    public void draw() {
        circle.draw();
    }


}
