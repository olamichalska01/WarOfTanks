package frames.start;

import image.SettingImages;

import javax.swing.*;
import java.awt.*;

public class StartPanelTitle extends JPanel {

    public StartPanelTitle() {
        setLayout(null);
        setBounds(10, 10, 580, 180);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(new SettingImages().getStartPanelTitle().getImage(), 0, 0, 580, 180, null);
    }
}
