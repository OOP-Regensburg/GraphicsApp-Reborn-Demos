package SimpleDemo;

import de.mi.ur.gpr.app.GraphicsApp;
import de.mi.ur.gpr.colors.Colors;
import de.mi.ur.gpr.graphics.Rectangle;

public class SimpleDemo extends GraphicsApp {

    private Rectangle rect;

    @Override
    public void init() {
        rect = new Rectangle(5,5,100,100);

    }

    @Override
    public void draw() {
        drawBackground(Colors.WHITE);
        rect.draw();
    }
}
