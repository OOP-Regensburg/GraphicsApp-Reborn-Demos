package InputDemo;

import de.mi.ur.gpr.app.GraphicsApp;
import de.mi.ur.gpr.colors.Color;
import de.mi.ur.gpr.colors.Colors;
import de.mi.ur.gpr.events.KeyPressedEvent;
import de.mi.ur.gpr.events.MouseClickedEvent;
import de.mi.ur.gpr.graphics.Circle;

public class InputDemo extends GraphicsApp {

    private Circle target;
    private float xSpeed = 0;
    private float ySpeed = 0;


    @Override
    public void init() {
        target = new Circle(getWidth() / 2, getHeight() / 2, 50, Colors.getRandomColor());
    }

    @Override
    public void draw() {
        drawBackground(Colors.WHITE);
        target.move(xSpeed, ySpeed);
        target.draw();
    }

    private void moveTo(int xPos, int yPos) {
        float xDelta = Math.abs(xPos - target.getxPos());
        float yDelta = Math.abs(yPos - target.getyPos());
        xSpeed = 1;
        ySpeed = xSpeed * (yDelta / xDelta);
        if (xPos < target.getxPos()) {
            xSpeed = -xSpeed;
        }
        if (yPos < target.getyPos()) {
            ySpeed = -ySpeed;
        }
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        switch (event.keyChar) {
            case 'w':
                ySpeed = -1;
                xSpeed = 0;
                break;
            case 'd':
                ySpeed = 0;
                xSpeed = 1;
                break;
            case 's':
                ySpeed = 1;
                xSpeed = 0;
                break;
            case 'a':
                ySpeed = 0;
                xSpeed = -1;
                break;
            case 'x':
                ySpeed = 0;
                xSpeed = 0;
                break;
            default:
                break;
        }
    }

    @Override
    public void onMouseClicked(MouseClickedEvent event) {
        System.out.println("Mouse clicked [" + event.xPos + "/" + event.yPos + "]");
        moveTo(event.xPos, event.yPos);
    }
}