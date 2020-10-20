package AudioDemo;

import de.ur.mi.oop.audio.AudioClip;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.graphics.Rectangle;

public class SoundBlock {

    public static final int DEFAULT_SIZE = 100;
    private static final Color BACKGROUND_COLOR = Colors.WHITE;
    private static final Color BLOCK_COLOR = new Color(150,0,30);
    private static final Color INITIAL_OVERLAY_COLOR = new Color(255, 255, 255, 25);
    private static final int BORDER_SIZE = 10;
    private static final int ALPHA_PULSE_SPEED = 2; // Amount of alpha changes per frame during pulsing state
    private static final int MIN_ALPHA = 25; // For overlay
    private static final int MAX_ALPHA = 200; // For overlay
    private AudioClip clip;
    private Rectangle background;
    private Rectangle block;
    private Rectangle overlay;
    private boolean active;
    private boolean pulsingUp;

    public SoundBlock(int x, int y, String path) {
        this.clip = new AudioClip(path);
        this.background = new Rectangle(x,y,DEFAULT_SIZE,DEFAULT_SIZE,BACKGROUND_COLOR);
        this.block = new Rectangle(x+BORDER_SIZE, y+BORDER_SIZE, DEFAULT_SIZE-2*BORDER_SIZE, DEFAULT_SIZE-2*BORDER_SIZE, BLOCK_COLOR);
        this.overlay = new Rectangle(x+BORDER_SIZE, y+BORDER_SIZE, DEFAULT_SIZE-2*BORDER_SIZE, DEFAULT_SIZE-2*BORDER_SIZE, INITIAL_OVERLAY_COLOR);
        this.active = false;
    }

    public boolean hitTest(int x, int y) {
        return block.hitTest(x, y);
    }

    public void toggle() {
        if (!active) {
            enable();
        } else {
            disable();
        }
    }

    public void enable() {
        clip.loop();
        active = true;
        pulsingUp = true;
    }

    public void disable() {
        clip.stop();
        active = false;
        overlay.setColor(INITIAL_OVERLAY_COLOR);
    }

    public void update() {
        if (active) {
            Color currentOverlayColor = overlay.getColor();
            Color newOverlayColor;
            if (pulsingUp) {
                newOverlayColor = new Color(INITIAL_OVERLAY_COLOR.red(), INITIAL_OVERLAY_COLOR.green(), INITIAL_OVERLAY_COLOR.blue(), currentOverlayColor.alpha() + ALPHA_PULSE_SPEED);
            } else {
                newOverlayColor = new Color(INITIAL_OVERLAY_COLOR.red(), INITIAL_OVERLAY_COLOR.green(), INITIAL_OVERLAY_COLOR.blue(), currentOverlayColor.alpha() - ALPHA_PULSE_SPEED);
            }
            if(pulsingUp && currentOverlayColor.alpha() > MAX_ALPHA) {
                pulsingUp = false;
            }
            if(!pulsingUp && currentOverlayColor.alpha() < MIN_ALPHA) {
                pulsingUp = true;
            }
            overlay.setColor(newOverlayColor);
        }
    }

    public void draw() {
        background.draw();
        block.draw();
        overlay.draw();
    }

}
