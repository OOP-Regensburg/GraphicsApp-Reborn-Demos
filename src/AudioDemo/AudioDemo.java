package AudioDemo;

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.events.MousePressedEvent;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

import java.util.ArrayList;

public class AudioDemo extends GraphicsApp {

    private static final int GRID_SIZE = SoundBlock.SIZE;
    private ArrayList<SoundBlock> blocks;

    @Override
    public void initialize() {
        setCanvasSize(300, 300);
        initSounds();
    }

    private void initSounds() {
        blocks = new ArrayList<SoundBlock>();
        blocks.add(new SoundBlock(0, 0,  "data/sounds/chord-1.wav"));
        blocks.add(new SoundBlock(100, 0, "data/sounds/chord-2.wav"));
        blocks.add(new SoundBlock(200, 0, "data/sounds/chord-3.wav"));
        blocks.add(new SoundBlock(0, 100, "data/sounds/chord-4.wav"));
        blocks.add(new SoundBlock(100, 100, "data/sounds/chord-5.wav"));
        blocks.add(new SoundBlock(200, 100, "data/sounds/chord-6.wav"));
        blocks.add(new SoundBlock(0, 200, "data/sounds/chord-7.wav"));
        blocks.add(new SoundBlock(100, 200, "data/sounds/chord-8.wav"));
        blocks.add(new SoundBlock(200, 200, "data/sounds/chord-9.wav"));
    }

    @Override
    public void draw() {
        drawBackground(Colors.GREY);
        for (SoundBlock block : blocks) {
            block.update();
            block.draw();
        }
    }

    @Override
    public void onMousePressed(MousePressedEvent event) {
        for(SoundBlock block: blocks) {
            if(block.isClicked(event.getXPos(), event.getYPos())) {
                block.toggle();
            }
        }
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}

