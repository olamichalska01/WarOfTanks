package frames.help;

import image.SettingImages;

import javax.swing.*;
import java.awt.*;

public class HelpPanelTitle extends JPanel {

    public HelpPanelTitle() {
        setLayout(null);
        setBounds(10, 10, 580, 180);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(new SettingImages().getGameRules().getImage(), 0, 0, 580, 180, null);
    }
}
