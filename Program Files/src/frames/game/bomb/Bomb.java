package frames.game.bomb;

import frames.game.GameFrame;
import frames.game.GameTimer;
import frames.game.TankPanel;
import image.SettingImages;

import javax.swing.*;
import java.awt.*;

public class Bomb extends JLabel {
    public Integer bombCurrentPoints;

    public Bomb() {
        bombCurrentPoints = 50;
        setIcon(new SettingImages().getBomb());
        setBounds(428, 405, 144, 160);
    }

    public Rectangle getShootingAreaBounds() {
        return new Rectangle(468,435,65,5);
    }

    public Rectangle getRemainingBombArea() {
        return new Rectangle(435, 440, 130, 120);
    }

    public void decreaseBombPoints() {
        if(bombCurrentPoints > 0) bombCurrentPoints--;
        if(bombCurrentPoints == 0) {
            GameTimer.isThreadRunning = false;
            if(TankPanel.pointsRight > TankPanel.pointsLeft)
                GameFrame.rightWon.setVisible(true);
            else if(TankPanel.pointsRight < TankPanel.pointsLeft)
                GameFrame.leftWon.setVisible(true);
            else GameFrame.tie.setVisible(true);
            GameTimer.takeScreenshot(GameFrame.gameFrame);
        }
    }

}
