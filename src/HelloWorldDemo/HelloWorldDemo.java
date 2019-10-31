package HelloWorldDemo;


import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.graphics.Label;

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
