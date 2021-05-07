package frames.start;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class PanelButtons extends JPanel {
    private final Image img = new ImageIcon(Objects.requireNonNull(getClass().getResource("panelButtons.png"))).getImage();
    private JButton startButton;
    private JButton helpButton;
    private JButton settingsButton;
    private JButton addFileButton;
    private JButton resetButton;
    private final Integer widthButtons = 200;
    private final Integer heightButtons = 100;
    private final StartFrame start;

    private final List<ImageIcon> imgs = new ArrayList<>() {

    };

    private void setImages(){
        imgs.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("buttonImage/startButton_0.png"))).getImage()));
        imgs.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("buttonImage/startButton_1.png"))).getImage()));
        imgs.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("buttonImage/helpButton_0.png"))).getImage()));
        imgs.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("buttonImage/helpButton_1.png"))).getImage()));
        imgs.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("buttonImage/settingsButton_0.png"))).getImage()));
        imgs.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("buttonImage/settingsButton_1.png"))).getImage()));
        imgs.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("buttonImage/addFileButton_0.png"))).getImage()));
        imgs.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("buttonImage/addFileButton_1.png"))).getImage()));
        imgs.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("buttonImage/resetButton_0.png"))).getImage()));
        imgs.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("buttonImage/resetButton_1.png"))).getImage()));
    }



    private final ActionListener startListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("otwieram gameframe");
            start.startFrame.setVisible(false);
            start.game.frameGame.setVisible(true);
        }
    };
    private final ActionListener helpListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("otwieram helpFrame");
            start.startFrame.setVisible(false);
            start.help.helpFrame.setVisible(true);
        }
    };
    private final ActionListener settingsListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("otwieram settingsFrame");
            start.startFrame.setVisible(false);
            start.settings.frameSettings.setVisible(true);
        }
    };
    private final ActionListener addFileListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("otwieram addFile");
        }
    };
    private final ActionListener resetListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("resetuje plik conf");
        }
    };

    public PanelButtons(StartFrame s) {
        long t1 = System.nanoTime();

        start = s;
        setImages();
        setLayout(null);
        setBounds(180, 225, 240, 528);

        setStartButton();
        setHelpButton();
        setSettingsButton();
        setAddFileButton();
        setResetButton();

        add(startButton);
        add(helpButton);
        add(settingsButton);
        add(addFileButton);
        add(resetButton);

        long t2 = System.nanoTime();
        System.out.println("PanelButtons: " + TimeUnit.NANOSECONDS.toMillis(t2 - t1));
    }

    private void setStartButton() {
        long t1 = System.currentTimeMillis();

        startButton = new JButton();
        startButton.addActionListener(startListener);
        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        startButton.setIcon(imgs.get(0));
        startButton.setRolloverEnabled(true);
        startButton.setRolloverIcon(imgs.get(1));

        startButton.setBounds(20, 10, widthButtons, heightButtons);

        long t2 = System.currentTimeMillis();
        System.out.println("setStartButton: " + (t2-t1));
    }

    private void setHelpButton() {
        long t1 = System.currentTimeMillis();
        helpButton = new JButton();
        helpButton.addActionListener(helpListener);
        helpButton.setOpaque(false);
        helpButton.setContentAreaFilled(false);
        helpButton.setBorderPainted(false);
        helpButton.setIcon(imgs.get(2));
        helpButton.setRolloverIcon(imgs.get(3));
        helpButton.setBounds(20, 112, widthButtons, heightButtons);

        long t2 = System.currentTimeMillis();
        System.out.println("setHelpButton: " + (t2-t1));
    }

    private void setSettingsButton() {
        long t1 = System.currentTimeMillis();

        settingsButton = new JButton();
        settingsButton.addActionListener(settingsListener);
        settingsButton.setOpaque(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setBorderPainted(false);
        settingsButton.setIcon(imgs.get(4));
        settingsButton.setRolloverIcon(imgs.get(5));
        settingsButton.setBounds(20, 214, widthButtons, heightButtons);

        long t2 = System.currentTimeMillis();
        System.out.println("setSettingsButton: " + (t2-t1));
    }

    private void setAddFileButton() {
        long t1 = System.currentTimeMillis();

        addFileButton = new JButton();
        addFileButton.addActionListener(addFileListener);
        addFileButton.setOpaque(false);
        addFileButton.setContentAreaFilled(false);
        addFileButton.setBorderPainted(false);
        addFileButton.setIcon(imgs.get(6));
        addFileButton.setRolloverIcon(imgs.get(7));
        addFileButton.setBounds(20, 316, widthButtons, heightButtons);

        long t2 = System.currentTimeMillis();
        System.out.println("setAddFileButton: " + (t2-t1));
    }

    private void setResetButton() {
        long t1 = System.currentTimeMillis();

        resetButton = new JButton();
        resetButton.addActionListener(resetListener);
        resetButton.setOpaque(false);
        resetButton.setContentAreaFilled(false);
        resetButton.setBorderPainted(false);
        resetButton.setIcon(imgs.get(8));
        resetButton.setRolloverIcon(imgs.get(9));
        resetButton.setBounds(20, 418, widthButtons, heightButtons);

        long t2 = System.currentTimeMillis();
        System.out.println("setResetButton: " + (t2-t1));
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, 240, 528, null);
    }
}
