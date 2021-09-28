package frames.game.bullets;

import frames.game.TankPanel;

import java.awt.*;

public class Bullet {

    private final Integer radius;
    private final Integer degree;
    private final Integer[] yPosOfBarrel;
    private final Integer[] xPosOfBarrelLeft;
    private final Integer[] xPosOfBarrelRight;
    private Integer xPos;
    private Integer yPos;
    private char side;

    {
        yPosOfBarrel = new Integer[]{0, 15, 25, 45, 60, 80, 100, 120, 140, 155, 175, 185, 200};
        xPosOfBarrelLeft = new Integer[]{150, 175, 195, 205, 210, 215, 220, 215, 210, 205, 195, 175, 150};
        xPosOfBarrelRight = new Integer[]{50, 25, 5, -5, -10, -15, -20, -15, -10, -5, 5, 25, 50};
    }

    public Bullet(Integer r, TankPanel pane, char s) {
        radius = r;
        setSide(s);
        setPosition(pane);
        if (side == 'r') degree = pane.getRightTank().barrel.getCurrentIndex();
        else degree = pane.getLeftTank().barrel.getCurrentIndex();
    }

    public void generateBullet(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (side == 'l') g2d.setColor(new Color(132, 67, 68));
        else g2d.setColor(new Color(46, 72, 97));
        g2d.fillOval(xPos, yPos, 2 * radius, 2 * radius);
    }

    public void setBulletCoordinate() {
        int isRight;
        if (side == 'r') isRight = -1;
        else isRight = 1;
        switch (degree) {
            case 0:
                xPos += 2 * isRight;
                yPos -= 3;
                break;
            case 1:
                xPos += 2 * isRight;
                yPos -= 2;
                break;
            case 2:
                xPos += 2 * isRight;
                yPos -= 1;
                break;
            case 3:
            case 4:
                xPos += 2 * isRight;
                yPos--;
                break;
            case 5:
                xPos += 3 * isRight;
                yPos--;
                break;
            case 6:
                xPos += 2 * isRight;
                break;
            case 7:
                xPos += 3 * isRight;
                yPos++;
                break;
            case 8:
            case 9:
                xPos += 2 * isRight;
                yPos++;
                break;
            case 10:
                xPos += 2 * isRight;
                yPos += 1;
                break;
            case 11:
                xPos += 2 * isRight;
                yPos += 2;
                break;
            case 12:
                xPos += 2 * isRight;
                yPos += 3;
                break;
            default:
                break;
        }
    }

    public char getSide() {
        return side;
    }

    public Integer getPosX() {
        return xPos;
    }

    public Integer getPosY() {
        return yPos;
    }

    public Integer getRadius() {
        return radius;
    }

    public Rectangle getBounds() {
        return new Rectangle(xPos, yPos, radius * 2, radius * 2);
    }

    private void setPosition(TankPanel pane) {
        if (side == 'l') {
            Integer indexOfBarrel = pane.getLeftTank().barrel.getCurrentIndex();
            xPos = pane.getLeftTank().barrel.getX() + xPosOfBarrelLeft[indexOfBarrel] - radius;
            yPos = pane.getLeftTank().barrel.getY() + yPosOfBarrel[indexOfBarrel] - radius;
        } else {
            Integer indexOfBarrel = pane.getRightTank().barrel.getCurrentIndex();
            xPos = pane.getRightTank().barrel.getX() + xPosOfBarrelRight[indexOfBarrel] - radius;
            yPos = pane.getRightTank().barrel.getY() + yPosOfBarrel[indexOfBarrel] - radius;
        }
    }

    private void setSide(char s) {
        if (s == 'r') side = 'r';
        else side = 'l';
    }
}


