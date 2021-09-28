package frames.game;

import configuration.ConfObject;
import image.SettingImages;

import javax.swing.*;
import java.awt.*;

public class GameFrame {
    public static JFrame gameFrame;
    public static TankPanel tankPanel;
    public static JLabel leftWon;
    public static JLabel rightWon;
    public static JLabel tie;
    public static Thread changesThread;
    public JPanel rightPointsPanel;
    public JPanel rightBulletCountPanel;
    public JPanel leftPointsPanel;
    public JPanel leftBulletCountPanel;
    public JPanel timerPanel;
    public JPanel titlePanel;
    public CellsPanel cellsPlace;
    public JLabel title;
    public ConfObject confObject;

    private boolean isThreadRunning;

    {
        gameFrame = new JFrame();
        leftWon = new JLabel();
        rightWon = new JLabel();
        tie = new JLabel();
        rightPointsPanel = new JPanel();
        rightBulletCountPanel = new JPanel();
        leftPointsPanel = new JPanel();
        leftBulletCountPanel = new JPanel();
        timerPanel = new JPanel();
        titlePanel = new JPanel();
        title = new JLabel();
        isThreadRunning = true;
    }

    public GameFrame(ConfObject conf) {
        confObject = conf;
        cellsPlace = new CellsPanel(conf);
        setFrame(gameFrame);
        tankPanel = new TankPanel(conf);
        addGameFramePanels();
        tankPanel.setFocusable(true);
        setUpChangesThread();
    }

    public void displayWinner() {
        leftWon.setText("LEFT WON!");
        leftWon.setFont(new Font("Monospaced", Font.BOLD, 32));
        leftWon.setForeground(new Color(132, 67, 68));
        leftWon.setBounds(20,250,200,50);
        leftWon.setOpaque(false);
        leftWon.setVisible(false);
        titlePanel.add(leftWon);

        rightWon.setText("RIGHT WON!");
        rightWon.setFont(new Font("Monospaced", Font.BOLD, 32));
        rightWon.setForeground(new Color(51, 76, 99));
        rightWon.setBounds(795,250,200,50);
        rightWon.setOpaque(false);
        rightWon.setVisible(false);
        titlePanel.add(rightWon);

        tie.setText("TIE!");
        tie.setFont(new Font("Monospaced", Font.BOLD, 64));
        tie.setForeground(new Color(255, 255, 255));
        tie.setBounds(228,100,200,50);
        tie.setOpaque(false);
        tie.setVisible(false);
        CellsPanel.cellsPanel.add(tie);
    }

    private void setFrame(JFrame frame) {
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 100, 1000, 800);
    }

    private void addGameFramePanels() {
        displayWinner();

        createCellsPanel();
        tankPanel.add(CellsPanel.cellsPanel);

        createRightBulletCountPanel();
        gameFrame.add(rightBulletCountPanel, new GridBagConstraints());

        createLeftBulletCountPanel();
        gameFrame.add(leftBulletCountPanel, new GridBagConstraints());

        createRightPointsCountPanel();
        gameFrame.add(rightPointsPanel);

        createLeftPointsCountPanel();
        gameFrame.add(leftPointsPanel);

        gameFrame.add(tankPanel);

        createTimerPanel();
        gameFrame.add(timerPanel);

        createTitlePanel();
        gameFrame.add(titlePanel);
    }

    private void createLeftBulletCountPanel() {
        tankPanel.displayBulletsLeft.setForeground(Color.white);
        tankPanel.displayBulletsLeft.setFont(new Font("Monospaced", Font.PLAIN, 28));

        leftBulletCountPanel.setBounds(200, 100, 200, 100);
        leftBulletCountPanel.setBackground(new Color(148, 90, 80));
        leftBulletCountPanel.setLayout(null);

        JLabel bulletsTextLeft = new JLabel("BULLETS");
        bulletsTextLeft.setForeground(new Color(82, 37, 38));
        bulletsTextLeft.setFont(new Font("Monospaced", Font.BOLD, 18));
        bulletsTextLeft.setBounds(60, -35, 100, 100);

        leftBulletCountPanel.add(bulletsTextLeft);
        tankPanel.displayBulletsLeft.setBounds(90,0,100,100);
        leftBulletCountPanel.add(tankPanel.displayBulletsLeft);
    }

    private void createRightBulletCountPanel() {
        tankPanel.displayBulletsRight.setForeground(Color.white);
        tankPanel.displayBulletsRight.setFont(new Font("Monospaced", Font.PLAIN, 28));

        rightBulletCountPanel.setBounds(585, 100, 200, 100);
        rightBulletCountPanel.setBackground(new Color(106, 138, 153));
        rightBulletCountPanel.setLayout(null);

        JLabel bulletsTextRight = new JLabel("BULLETS");
        bulletsTextRight.setForeground(new Color(36, 54, 73));
        bulletsTextRight.setFont(new Font("Monospaced", Font.BOLD, 18));
        bulletsTextRight.setBounds(60, -35, 100, 100);

        rightBulletCountPanel.add(bulletsTextRight);
        tankPanel.displayBulletsRight.setBounds(90,0,100,100);
        rightBulletCountPanel.add(tankPanel.displayBulletsRight);
    }

    private void createLeftPointsCountPanel() {
        tankPanel.displayPointsLeft.setForeground(Color.white);
        tankPanel.displayPointsLeft.setFont(new Font("Monospaced", Font.PLAIN, 28));

        leftPointsPanel.setBounds(0, 100, 200, 100);
        leftPointsPanel.setBackground(new Color(132, 67, 68));
        leftPointsPanel.setLayout(null);

        JLabel pointsTextLeft = new JLabel("POINTS");
        pointsTextLeft.setForeground(new Color(82, 37, 38));
        pointsTextLeft.setFont(new Font("Monospaced", Font.BOLD, 18));
        pointsTextLeft.setBounds(65, -35, 100, 100);

        leftPointsPanel.add(pointsTextLeft);
        tankPanel.displayPointsLeft.setBounds(90,0,100,100);
        leftPointsPanel.add(tankPanel.displayPointsLeft);
    }

    private void createRightPointsCountPanel() {
        tankPanel.displayPointsRight.setForeground(Color.white);
        tankPanel.displayPointsRight.setFont(new Font("Monospaced", Font.PLAIN, 28));

        rightPointsPanel.setBounds(785, 100, 200, 100);
        rightPointsPanel.setBackground(new Color(51, 76, 99));
        rightPointsPanel.setLayout(null);

        JLabel pointsTextRight = new JLabel("POINTS");
        pointsTextRight.setForeground(new Color(19, 41, 68));
        pointsTextRight.setFont(new Font("Monospaced", Font.BOLD, 18));
        pointsTextRight.setBounds(65, -35, 100, 100);

        rightPointsPanel.add(pointsTextRight);
        tankPanel.displayPointsRight.setBounds(90,0,100,100);
        rightPointsPanel.add(tankPanel.displayPointsRight);
    }

    private void createTitlePanel() {
        title.setIcon(new SettingImages().getPlainTitle());
        title.setBounds(280, 8, 430, 82);

        titlePanel.setLayout(null);
        titlePanel.setBounds(0, 0, 1000, 800);
        titlePanel.setBackground(new Color(36, 34, 46));
        titlePanel.add(title);
    }

    private void createCellsPanel() {
        CellsPanel.cellsPanel.setBackground(new Color(175, 207, 194));
    }

    private void createTimerPanel() {
        timerPanel.setBounds(400, 100, 200, 100);
        timerPanel.setBackground(new Color(53, 46, 61));
        timerPanel.setLayout(null);
        timerPanel.add(GameTimer.timerText);
    }

    private void setUpChangesThread() {
        changesThread = new Thread(() -> {
            try {
                while (isThreadRunning) {
                    if (!GameTimer.isThreadRunning) {
                        stopThread();
                    }
                    Thread.sleep(confObject.getChangesTime() * 1000);
                    int cellSide = cellsPlace.changeCellSize(confObject.getStartCellSide(), confObject.getChangeCellSide());
                    confObject.setStartCellSide(cellSide);
                    cellsPlace.applyChangesToColony();
                    cellsPlace.applyChangesToCells(cellSide);
                    tankPanel.changeTankParameters();
                }
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });
        changesThread.setDaemon(true);
    }
    private void stopThread() {
        isThreadRunning = false;
    }
}