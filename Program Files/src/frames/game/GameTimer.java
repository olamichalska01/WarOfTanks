package frames.game;

import configuration.ConfObject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameTimer {
    public static Thread timer;
    public static JLabel timerText = new JLabel();
    public static boolean isThreadRunning = true;

    private int gameTime;

    public GameTimer(ConfObject confObject) {
        gameTime = confObject.getGameDuration() * 60_000;

        timerText.setBounds(45, 20, 130, 50);
        timerText.setForeground(Color.white);
        timerText.setFont(new Font("Monospaced", Font.PLAIN, 28));

        timer = new Thread(() -> {
            try {
                while(isThreadRunning) {
                    displayTime();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });

    }

    public static void takeScreenshot(JFrame frame) {
        BufferedImage img = null;

        try {
            img = new Robot().createScreenCapture(new Rectangle(
                    frame.getLocationOnScreen().x + 8,
                    frame.getLocationOnScreen().y + 6,
                    frame.getWidth() - 16,
                    frame.getHeight() - 14));
        } catch (AWTException ignored) {
        }

        try {
            File imageFile = new File("component-screenshot.png");
            ImageIO.write(img, "png", imageFile);
        } catch (IOException e) {
            System.err.println("Unable to write image to file.");
        }
    }

    public void stopThread() {
        isThreadRunning = false;
    }

    private void displayTime() {
        int numOfMinutes = gameTime / 60_000;
        int numOfSeconds = (gameTime - numOfMinutes * 60_000) / 1000;

        if (numOfSeconds < 10) timerText.setText(numOfMinutes + " : 0" + numOfSeconds);
        else timerText.setText(numOfMinutes + " : " + numOfSeconds);

        gameTime -= 1000;

        if (numOfSeconds <= 0 && numOfMinutes <= 0) {
            stopThread();
            GameFrame.tankPanel.setEnabled(false);
            if(TankPanel.pointsRight > TankPanel.pointsLeft)
                GameFrame.rightWon.setVisible(true);
            else if(TankPanel.pointsRight < TankPanel.pointsLeft)
                GameFrame.leftWon.setVisible(true);
            else GameFrame.tie.setVisible(true);
            takeScreenshot(GameFrame.gameFrame);
        }
    }
}