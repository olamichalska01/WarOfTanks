package frames;

import javax.swing.*;

public class SettingsFrame {
    public JFrame frameSettings = new JFrame();

    public SettingsFrame() {
        setFrame(frameSettings);
    }

    private void setFrame(JFrame frame) {
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 100, 1000, 800);
    }
}
