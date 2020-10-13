package SimpleDemo;


import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.graphics.Rectangle;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class SimpleDemo extends GraphicsApp {

    private Rectangle rect;
    int frameCount = 0;

    @Override
    public void initialize() {
        rect = new Rectangle(5, 5, 100, 100);

    }

    @Override
    public void draw() {
        drawBackground(Colors.WHITE);
        if(frameCount < 300) {
            rect.draw();
            frameCount++;
        } else {
            rect = null;
        }
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}
