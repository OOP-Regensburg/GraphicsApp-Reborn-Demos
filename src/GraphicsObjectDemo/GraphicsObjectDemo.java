package GraphicsObjectDemo;

import de.mi.ur.gpr.app.GraphicsApp;
import de.mi.ur.gpr.colors.Color;
import de.mi.ur.gpr.colors.Colors;
import de.mi.ur.gpr.graphics.Circle;
import de.mi.ur.gpr.graphics.Ellipse;
import de.mi.ur.gpr.graphics.Line;

public class GraphicsObjectDemo extends GraphicsApp {

    private static final int Y_LINE_HEIGHT = 100;

    private Line line;
    private Circle circle;
    private Ellipse ellipse;

    @Override
    public void initialize() {
        line = new Line(150, Y_LINE_HEIGHT, 250, Y_LINE_HEIGHT, Colors.RED, 15);
        circle = new Circle(50, Y_LINE_HEIGHT, 20);
        ellipse = new Ellipse(100, Y_LINE_HEIGHT, 10, 30);
    }

    @Override
    public void draw() {
        line.draw();
        circle.draw();
        ellipse.draw();
    }
}
