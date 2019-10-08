package ExpandingCircleDemo;

import de.mi.ur.gpr.app.GraphicsApp;
import de.mi.ur.gpr.colors.Colors;
import de.mi.ur.gpr.graphics.Circle;

public class ExpandingCircle extends GraphicsApp {

    private static final int INITIAL_RADIUS = 10;
    private Circle circle;

    @Override
    public void initialize() {
        circle = new Circle(getWidth()/2, getHeight()/2, INITIAL_RADIUS);
    }

    @Override
    public void draw() {
        drawBackground(Colors.WHITE);
        int newRadius = circle.getRadius() + 1;
        circle.setRadius(newRadius);
        circle.draw();
    }
}
