package SimpleDemo;


import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.graphics.Rectangle;

public class SimpleDemo extends GraphicsApp {

    private Rectangle rect;

    @Override
    public void initialize() {
        rect = new Rectangle(5,5,100,100);

    }

    @Override
    public void draw() {
        drawBackground(Colors.WHITE);
        rect.draw();
    }
}
