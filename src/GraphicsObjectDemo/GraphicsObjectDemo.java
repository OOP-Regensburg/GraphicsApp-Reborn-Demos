package GraphicsObjectDemo;

import de.mi.ur.gpr.app.GraphicsApp;
import de.mi.ur.gpr.colors.Color;
import de.mi.ur.gpr.graphics.Circle;
import de.mi.ur.gpr.graphics.Ellipse;

public class GraphicsObjectDemo extends GraphicsApp {

    private Circle circle;
    private Ellipse ellipse;

    @Override
    public void initialize() {
        circle = new Circle(50, 100, 20);
        ellipse = new Ellipse(100, 100, 10, 30);
    }

    @Override
    public void draw() {
        circle.draw();
        ellipse.draw();
    }
}
