package frames.game;

import configuration.ConfObject;
import frames.game.bomb.Bomb;
import frames.game.bullets.Bullet;
import frames.game.tank.Tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class TankPanel extends JLayeredPane {

    public static int pointsLeft;
    public static int pointsRight;
    public TankPanel panel;
    public int amountOfBulletsLeft;
    public int amountOfBulletsRight;
    public int radius;
    public int velocity;
    public JLabel displayBulletsLeft;
    public JLabel displayPointsLeft;
    public JLabel displayBulletsRight;
    public JLabel displayPointsRight;
    public KeyAdapter keyAdapter;

    private final Tank leftTank;
    private final Tank rightTank;
    private final Bomb bomb;
    private final ArrayList<Bullet> bulletsL;
    private final ArrayList<Bullet> bulletsR;
    private final ArrayList<Bullet> bulletsForRemove;
    private final ConfObject confObject;
    private final int maxAmount;
    private boolean leftBarrelUp;
    private boolean leftBarrelDown;
    private boolean leftBodyUp;
    private boolean leftBodyDown;
    private boolean rightBarrelUp;
    private boolean rightBarrelDown;
    private boolean rightBodyUp;
    private boolean rightBodyDown;
    private boolean spaceWaiting;
    private boolean enterWaiting;
    private boolean isThreadRunning;

    {
        panel = this;
        leftTank = new Tank('l');
        rightTank = new Tank('r');
        bomb = new Bomb();
        bulletsL = new ArrayList<>();
        bulletsR = new ArrayList<>();
        bulletsForRemove = new ArrayList<>();
        leftBarrelUp = false;
        leftBarrelDown = false;
        leftBodyUp = false;
        leftBodyDown = false;
        rightBarrelUp = false;
        rightBarrelDown = false;
        rightBodyUp = false;
        rightBodyDown = false;
        spaceWaiting = false;
        enterWaiting = false;
        amountOfBulletsLeft = 0;
        amountOfBulletsRight = 0;
        pointsLeft = 0;
        pointsRight = 0;
        displayBulletsLeft = new JLabel(Integer.toString(amountOfBulletsLeft));
        displayBulletsRight = new JLabel(Integer.toString(amountOfBulletsRight));
        displayPointsLeft = new JLabel(Integer.toString(pointsLeft));
        displayPointsRight = new JLabel(Integer.toString(pointsRight));
        isThreadRunning = true;
        keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) leftBodyUp = true;
                if (e.getKeyCode() == KeyEvent.VK_S) leftBodyDown = true;
                if (e.getKeyCode() == KeyEvent.VK_A) leftBarrelUp = true;
                if (e.getKeyCode() == KeyEvent.VK_D) leftBarrelDown = true;
                if (e.getKeyCode() == KeyEvent.VK_UP) rightBodyUp = true;
                if (e.getKeyCode() == KeyEvent.VK_DOWN) rightBodyDown = true;
                if (e.getKeyCode() == KeyEvent.VK_LEFT) rightBarrelDown = true;
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) rightBarrelUp = true;
                if (e.getKeyCode() == KeyEvent.VK_SPACE && !spaceWaiting) {
                    if (amountOfBulletsLeft < maxAmount) {
                        spaceWaiting = true;
                        Bullet bullet = new Bullet(radius, panel, 'l');
                        bulletsL.add(bullet);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER && !enterWaiting) {
                    if (amountOfBulletsRight < maxAmount) {
                        enterWaiting = true;
                        Bullet bullet = new Bullet(radius, panel, 'r');
                        bulletsR.add(bullet);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) leftBodyUp = false;
                if (e.getKeyCode() == KeyEvent.VK_S) leftBodyDown = false;
                if (e.getKeyCode() == KeyEvent.VK_A) leftBarrelUp = false;
                if (e.getKeyCode() == KeyEvent.VK_D) leftBarrelDown = false;
                if (e.getKeyCode() == KeyEvent.VK_UP) rightBodyUp = false;
                if (e.getKeyCode() == KeyEvent.VK_DOWN) rightBodyDown = false;
                if (e.getKeyCode() == KeyEvent.VK_LEFT) rightBarrelDown = false;
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) rightBarrelUp = false;
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    spaceWaiting = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    enterWaiting = false;
                }
            }
        };
    }

    public TankPanel(ConfObject confObject) {
        setBounds(0, 200, 1000, 600);
        add(leftTank.body, Integer.valueOf(1));
        add(leftTank.barrel, Integer.valueOf(2));
        add(rightTank.body, Integer.valueOf(1));
        add(rightTank.barrel, Integer.valueOf(2));
        add(bomb, Integer.valueOf(5));
        addKeyListener(keyAdapter);
        this.confObject = confObject;
        maxAmount = confObject.getStartBulletAmount();
        radius = confObject.getStartBulletRadius();
        velocity = confObject.getStartBulletVelocity();

        new Thread(() -> {
            try {
                while (isThreadRunning) {
                    if (!GameTimer.isThreadRunning) stopThread();
                    if (leftBarrelUp) leftTank.barrel.setUp();
                    else if (leftBarrelDown) leftTank.barrel.setDown();
                    Thread.sleep(70);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(0);
            }
        }).start();

        new Thread(() -> {
            try {
                while (isThreadRunning) {
                    if (!GameTimer.isThreadRunning) stopThread();
                    if (rightBodyUp) {
                        if (rightTank.body.getY() > 10) {
                            rightTank.body.setBounds(rightTank.body.getX(), rightTank.body.getY() - 1, 200, 200);
                            rightTank.barrel.setBounds(rightTank.body.getX(), rightTank.body.getY() - 1, 200, 200);
                            rightTank.body.changeBody();
                        }
                    } else if (rightBodyDown) {
                        if (rightTank.body.getY() < 380) {
                            rightTank.body.setBounds(rightTank.body.getX(), rightTank.body.getY() + 1, 200, 200);
                            rightTank.barrel.setBounds(rightTank.body.getX(), rightTank.body.getY() + 1, 200, 200);
                            rightTank.body.changeBody();
                        }
                    }
                    Thread.sleep(30);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(0);
            }
        }).start();

        new Thread(() -> {
            try {
                while (isThreadRunning) {
                    if (!GameTimer.isThreadRunning) stopThread();
                    amountOfBulletsRight = bulletsR.size();
                    amountOfBulletsLeft = bulletsL.size();
                    checkCollision(bulletsR, 1);
                    checkCollision(bulletsL, 0);
                    changeBulletsCoordinates();
                    displayData(amountOfBulletsRight, displayPointsRight, displayBulletsRight, pointsRight, new Color(46, 72, 97));
                    displayData(amountOfBulletsLeft, displayPointsLeft, displayBulletsLeft, pointsLeft, new Color(113, 51, 52));
                    Thread.sleep(60 - velocity);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(0);
            }
        }).start();

        new Thread(() -> {
            try {
                while (isThreadRunning) {
                    if (!GameTimer.isThreadRunning) stopThread();
                    if (leftBodyUp) {
                        if (leftTank.body.getY() > 10) {
                            leftTank.body.setBounds(leftTank.body.getX(), leftTank.body.getY() - 1, 200, 200);
                            leftTank.barrel.setBounds(leftTank.body.getX(), leftTank.body.getY() - 1, 200, 200);
                            leftTank.body.changeBody();
                        }
                    } else if (leftBodyDown) {
                        if (leftTank.body.getY() < 380) {
                            leftTank.body.setBounds(leftTank.body.getX(), leftTank.body.getY() + 1, 200, 200);
                            leftTank.barrel.setBounds(leftTank.body.getX(), leftTank.body.getY() + 1, 200, 200);
                            leftTank.body.changeBody();
                        }
                    }
                    Thread.sleep(30);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(0);
            }
        }).start();

        new Thread(() -> {
            try {
                while (isThreadRunning) {
                    if (!GameTimer.isThreadRunning) stopThread();
                    if (rightBarrelUp) rightTank.barrel.setUp();
                    else if (rightBarrelDown) rightTank.barrel.setDown();
                    Thread.sleep(70);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(0);
            }
        }).start();
    }

    public Tank getLeftTank() {
        return leftTank;
    }

    public Tank getRightTank() {
        return rightTank;
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g2d);

        addBullets(g2d);
        removeBullets();
        CellsPanel.removeCells();
        repaint();
    }

    public void changeTankParameters() {
        if (radius - confObject.getChangeBulletRadius() > 5)
            radius -= confObject.getChangeBulletRadius();
        if (velocity + confObject.getChangeBulletVelocity() < 60)
            velocity += confObject.getChangeBulletVelocity();
    }

    private void removeBullets() {
        for (int b = 0; b < bulletsForRemove.size(); b++) {
            Bullet bulletForRemoval = bulletsForRemove.get(b);
            if (bulletForRemoval.getSide() == 'r') bulletsR.remove(bulletForRemoval);
            else bulletsL.remove(bulletForRemoval);
        }
    }

    private void addBullets(Graphics2D g2d) {
        for (int b = 0; b < bulletsL.size(); b++) {
            Bullet bullet = bulletsL.get(b);
            bullet.generateBullet(g2d);
        }
        for (int b = 0; b < bulletsR.size(); b++) {
            Bullet bullet = bulletsR.get(b);
            bullet.generateBullet(g2d);
        }
    }

    private void changeBulletsCoordinates() {
        for (int b = 0; b < bulletsR.size(); b++) {
            Bullet bullet = bulletsR.get(b);
            bullet.setBulletCoordinate();
            if (bullet.getPosX() < 200 || bullet.getPosY() < 0
                    || bullet.getPosY() > 560 - 2 * bullet.getRadius()) {
                bulletsForRemove.add(bullet);
            }
        }

        for (int b = 0; b < bulletsL.size(); b++) {
            Bullet bullet = bulletsL.get(b);
            bullet.setBulletCoordinate();
            if (bullet.getPosX() > 785 - 2 * bullet.getRadius()
                    || bullet.getPosY() < 0 || bullet.getPosY() > 560 - 2 * bullet.getRadius()) {
                bulletsForRemove.add(bullet);
            }
        }
    }

    private void checkCollision(ArrayList<Bullet> bullets, int side) {
        for (int b = 0; b < bullets.size(); b++) {
            Bullet bullet = bullets.get(b);
            for (int c = 0; c < CellsPanel.cells.size(); c++) {
                Cell cell = CellsPanel.cells.get(c);
                if (cell.getBounds().intersects(bullet.getBounds())) {
                    cell.decreaseCellPoints();
                    bulletsForRemove.add(bullet);
                    if (cell.cellCurrentPoints == 0) {
                        CellsPanel.cellsForRemove.add(cell);
                        if (cell.getIsAlone()) {
                            if (side == 0) pointsLeft += confObject.getStartCellPoints();
                            else pointsRight += confObject.getStartCellPoints();
                        } else if (--CellsPanel.colonies.get(cell.getWhichColony() - 1).life <= 0) {
                            if (side == 0) pointsLeft += CellsPanel.colonies.get(cell.getWhichColony() - 1).getPoints();
                            else pointsRight += CellsPanel.colonies.get(cell.getWhichColony() - 1).getPoints();
                        }
                        break;
                    }
                }
            }

            if (bomb.getShootingAreaBounds().intersects(bullet.getBounds())) {
                bomb.decreaseBombPoints();
                bulletsForRemove.add(bullet);
            }

            if (bomb.getRemainingBombArea().intersects(bullet.getBounds())) bulletsForRemove.add(bullet);
        }
    }

    private void stopThread() {
        isThreadRunning = false;
    }

    private void displayData(int amount, JLabel labelPoints, JLabel labelAmount, int points, Color color) {
        labelAmount.setText(Integer.toString(amount));
        labelPoints.setText(Integer.toString(points));
        if (amount < maxAmount) labelAmount.setForeground(Color.WHITE);
        else labelAmount.setForeground(color);
    }
}