package AudioDemo;

import de.ur.mi.oop.audio.AudioClip;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.graphics.Rectangle;

public class SoundBlock {

    public static final int SIZE = 100;
    private static final int BORDER_SIZE = 10;
    public static final int INNER_SIZE = SIZE - 2 * BORDER_SIZE;
    private static final Color BACKGROUND_COLOR = Colors.WHITE;
    private static final Color BLOCK_COLOR = new Color(150, 0, 30);
    private static final Color DEFAULT_OVERLAY_COLOR = new Color(255, 255, 255, 25);
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
        this.background = new Rectangle(x, y, SIZE, SIZE, BACKGROUND_COLOR);
        this.block = new Rectangle(x + BORDER_SIZE, y + BORDER_SIZE, INNER_SIZE, INNER_SIZE, BLOCK_COLOR);
        this.overlay = new Rectangle(x + BORDER_SIZE, y + BORDER_SIZE, INNER_SIZE, INNER_SIZE, DEFAULT_OVERLAY_COLOR);
        this.active = false;
    }

    public boolean isClicked(int x, int y) {
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
        overlay.setColor(DEFAULT_OVERLAY_COLOR);
    }

    public void update() {
        if (!active) {
            return;
        }
        int currentAlpha = overlay.getColor().alpha();
        if (pulsingUp) {
            currentAlpha += ALPHA_PULSE_SPEED;
            if (currentAlpha > MAX_ALPHA) {
                pulsingUp = false;
            }
        } else {
            currentAlpha -= ALPHA_PULSE_SPEED;
            if (currentAlpha < MIN_ALPHA) {
                pulsingUp = true;
            }
        }
        Color newColor = new Color(DEFAULT_OVERLAY_COLOR.red(), DEFAULT_OVERLAY_COLOR.green(), DEFAULT_OVERLAY_COLOR.blue(), currentAlpha);
        overlay.setColor(newColor);
    }

    public void draw() {
        background.draw();
        block.draw();
        overlay.draw();
    }

}
