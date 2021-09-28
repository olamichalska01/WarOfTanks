package frames.start;

import image.SettingImages;

import javax.swing.*;
import java.awt.*;

public class StartPanelBackground extends JPanel {

    public StartPanelBackground() {
        setLayout(null);
        setBounds(0, 0, 600, 800);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(new SettingImages().getStartPanelBackground().getImage(), 0, 0, 600, 800, null);
    }

}