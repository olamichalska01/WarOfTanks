package frames;

import image.SettingImages;

import javax.swing.*;
import java.awt.event.ActionListener;

public class GoBackButton extends JButton {

    public GoBackButton(JFrame currentFrame, JFrame previousFrame, int xPos, int yPos) {

        setVisible(true);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setBounds(xPos, yPos, 210, 100);
        ActionListener goBackListener = e -> {
            currentFrame.setVisible(false);
            previousFrame.setVisible(true);
        };
        addActionListener(goBackListener);
        setIcon(new SettingImages().getGoBackButton0());
        setRolloverIcon(new SettingImages().getGoBackButton1());
        setBackground(null);
    }
}
