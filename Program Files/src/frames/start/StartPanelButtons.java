package frames.start;

import configuration.ConfFrame;
import configuration.ConfObject;
import frames.game.CellsPanel;
import frames.game.GameFrame;
import frames.game.GameTimer;
import image.SettingImages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StartPanelButtons extends JPanel {
    private final Integer widthButtons;
    private final Integer heightButtons;
    private final StartFrame start;
    private final List<ImageIcon> images;
    private final ActionListener helpListener;
    private final ActionListener addFileListener;
    private final ActionListener resetListener;
    private final ActionListener startListener;
    private JButton startButton;
    private JButton helpButton;
    private JButton addFileButton;
    private JButton resetButton;

    {
        widthButtons = 200;
        heightButtons = 100;
        images = new ArrayList<>();
        helpListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartFrame.startFrame.setVisible(false);
                start.help.helpFrame.setVisible(true);
            }
        };
        addFileListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartFrame.confFrame = new ConfFrame();
                StartFrame.confFrame.setParameters(start.con);
            }
        };
        resetListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.con = new ConfObject();
            }
        };
        startListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartFrame.startFrame.setVisible(false);
                new GameTimer(start.con);
                GameTimer.timer.start();
                CellsPanel.changeValueThread.start();
                CellsPanel.moveThread.start();
                CellsPanel.generateThread.start();
                GameFrame.changesThread.start();
                GameFrame.gameFrame.setVisible(true);
            }
        };
    }

    public StartPanelButtons(StartFrame s) {
        start = s;
        new SettingImages().setPanelButtons(images);
        setLayout(null);
        setBounds(180, 225, 240, 528);
        setStartButton();
        setHelpButton();
        setAddFileButton();
        setResetButton();
        add(startButton);
        add(helpButton);
        add(addFileButton);
        add(resetButton);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(new SettingImages().getStartPanelButtons().getImage(), 0, 0, 240, 528, null);
    }

    private void setStartButton() {
        startButton = new JButton();
        startButton.addActionListener(startListener);
        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        startButton.setIcon(images.get(0));
        startButton.setRolloverEnabled(true);
        startButton.setRolloverIcon(images.get(1));
        startButton.setBounds(20, 30, widthButtons, heightButtons);
    }

    private void setHelpButton() {
        helpButton = new JButton();
        helpButton.addActionListener(helpListener);
        helpButton.setOpaque(false);
        helpButton.setContentAreaFilled(false);
        helpButton.setBorderPainted(false);
        helpButton.setIcon(images.get(2));
        helpButton.setRolloverIcon(images.get(3));
        helpButton.setBounds(20, 150, widthButtons, heightButtons);
    }

    private void setAddFileButton() {
        addFileButton = new JButton();
        addFileButton.addActionListener(addFileListener);
        addFileButton.setOpaque(false);
        addFileButton.setContentAreaFilled(false);
        addFileButton.setBorderPainted(false);
        addFileButton.setIcon(images.get(6));
        addFileButton.setRolloverIcon(images.get(7));
        addFileButton.setBounds(20, 270, widthButtons, heightButtons);

    }

    private void setResetButton() {
        resetButton = new JButton();
        resetButton.addActionListener(resetListener);
        resetButton.setOpaque(false);
        resetButton.setContentAreaFilled(false);
        resetButton.setBorderPainted(false);
        resetButton.setIcon(images.get(8));
        resetButton.setRolloverIcon(images.get(9));
        resetButton.setBounds(20, 380, widthButtons, heightButtons);
    }

}
