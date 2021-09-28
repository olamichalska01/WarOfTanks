package frames.game.tank;

import image.SettingImages;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Body extends JLabel {

    private final List<ImageIcon> images;
    private Integer index;
    private char side;

    {
        images = new ArrayList<>();
        index = 0;
    }

    public Body(char s) {
        setSide(s);
        setImg(images);
        setBodyBounds();
        setIcon(images.get(index));
    }

    public void changeBody() {
        if (index == 1) index = 0;
        else index = 1;
        setIcon(images.get(index));
    }

    private void setSide(char s) {
        if (s == 'r') side = 'r';
        else side = 'l';
    }

    private void setBodyBounds() {
        if (side == 'r') this.setBounds(800, 200, 200, 200);
        else this.setBounds(0, 200, 200, 200);
    }

    private void setImg(List<ImageIcon> image) {
        if (side == 'r') new SettingImages().setRightTankBody(image);
        else new SettingImages().setLeftTankBody(image);
    }
}
