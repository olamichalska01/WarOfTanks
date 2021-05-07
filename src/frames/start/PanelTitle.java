package frames.start;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class PanelTitle extends JPanel {

    private final Image img = new ImageIcon(Objects.requireNonNull(getClass().getResource("titleGenerate.png"))).getImage();

    public PanelTitle() {
        setLayout(null);
        setBounds(10, 10, 580, 180);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, 580, 180, null);
    }

}
