package frames;

import frames.start.StartFrame;

import javax.swing.*;


public class MainOfWar {

    public static void main (String [] args) {
        long t1 = System.currentTimeMillis();

        SwingUtilities.invokeLater(StartFrame::new);

        long t2 = System.currentTimeMillis();
        System.out.println("MainOfWar: " + (t2-t1));
    }
}
