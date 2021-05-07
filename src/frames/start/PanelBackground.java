package frames.start;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class PanelBackground extends JPanel {

    private final Image img = new ImageIcon(Objects.requireNonNull(getClass().getResource("background.png"))).getImage();

    public PanelBackground() {
        long t1 = System.currentTimeMillis();

        setLayout(null);
        setBounds(0, 0, 600, 800);

        long t2 = System.currentTimeMillis();
        System.out.println("PanelBackground: " + (t2 - t1));

        /*
        try {
            img = ImageIO.read(new File("Projekt_Java/WarOfTanks/src/frames/start/background.png"));
        } catch (IOException e) {
            System.err.println("Starting image error: " + e.getMessage());
        }

        long t1 = System.currentTimeMillis();

        setLayout(null);
        setBounds(0,0,600,800);

        long t2 = System.currentTimeMillis();
        System.out.println("PanelBackground: " + (t2-t1));
        */
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, 600, 800, null);
    }

}
