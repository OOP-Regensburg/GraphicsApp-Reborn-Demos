package HelloWorldDemo;

import de.mi.ur.gpr.app.GraphicsApp;
import de.mi.ur.gpr.graphics.Label;

public class HelloWorldDemo extends GraphicsApp {

    private Label label;

    @Override
    public void initialize() {
        label = new Label(50,50,"Hello World");
    }

    @Override
    public void draw() {
        label.draw();
    }
}
