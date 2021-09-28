package frames;

import frames.start.StartFrame;

import javax.swing.*;

public class MainOfWar {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StartFrame::new);
    }
}
