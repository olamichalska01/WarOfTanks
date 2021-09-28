package frames.game.tank;

import image.SettingImages;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Barrel extends JLabel {

    private final List<ImageIcon> images;
    private char side;
    private Integer currentIndex;

    {
        images = new ArrayList<>();
        currentIndex = 6;
    }

    public Barrel(char s) {
        setSide(s);
        setImg(images);
        setBarrelBounds();
        setIcon(images.get(currentIndex));
    }

    public void setUp() {
        if (currentIndex > 0) {
            currentIndex--;
            setIcon(images.get(currentIndex));
        }
    }

    public void setDown() {
        if (currentIndex < 12) {
            currentIndex++;
            setIcon(images.get(currentIndex));
        }
    }

    public Integer getCurrentIndex() {
        return currentIndex;
    }

    private void setSide(char s) {
        if (s == 'r') side = 'r';
        else side = 'l';
    }

    private void setBarrelBounds() {
        if (side == 'r')this.setBounds(800, 200, 200, 200);
        else this.setBounds(0, 200, 200, 200);
    }

    private void setImg(List<ImageIcon> image) {
        if (side == 'r') new SettingImages().setRightTankBarrel(image);
        else if (side == 'l') new SettingImages().setLeftTankBarrel(image);
    }

}
