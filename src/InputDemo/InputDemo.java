package InputDemo;


import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.events.*;
import de.ur.mi.oop.graphics.Circle;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class InputDemo extends GraphicsApp {

    private Circle target;
    private float xSpeed = 0;
    private float ySpeed = 0;


    @Override
    public void initialize() {
        target = new Circle(getWidth() / 2, getHeight() / 2, 50, Colors.getRandomColor());
    }

    @Override
    public void draw() {
        drawBackground(Colors.WHITE);
        target.move(xSpeed, ySpeed);
        target.draw();
    }

    private void moveTo(int xPos, int yPos) {
        float xDelta = Math.abs(xPos - target.getXPos());
        float yDelta = Math.abs(yPos - target.getYPos());
        xSpeed = 1;
        ySpeed = xSpeed * (yDelta / xDelta);
        if (xPos < target.getXPos()) {
            xSpeed = -xSpeed;
        }
        if (yPos < target.getYPos()) {
            ySpeed = -ySpeed;
        }
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        switch (event.getKeyChar()) {
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

        switch (event.getKeyCode()) {
            case KeyPressedEvent.VK_UP:
                ySpeed = -1;
                xSpeed = 0;
                break;
            case KeyPressedEvent.VK_DOWN:
                ySpeed = 1;
                xSpeed = 0;
                break;
            default:
                break;
        }
    }

    @Override
    public void onMousePressed(MousePressedEvent event) {
        System.out.println("Mouse pressed [" + event.getXPos() + "/" + event.getYPos() + "]");
        moveTo(event.getXPos(), event.getYPos());
        target.setColor(Colors.getRandomColor());
    }

    @Override
    public void onMouseReleased(MouseReleasedEvent event) {
        System.out.println("Mouse released [" + event.getXPos() + "/" + event.getYPos() + "]");
        moveTo(event.getXPos(), event.getYPos());
        target.setColor(Colors.RED);
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}
