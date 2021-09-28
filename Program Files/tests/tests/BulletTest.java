package tests;

import configuration.ConfObject;
import frames.game.TankPanel;
import frames.game.bullets.Bullet;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class BulletTest {
    @Test
    void setBulletCoordinateTest_when_rightSide() {
        ConfObject confObject = new ConfObject();
        TankPanel panel = new TankPanel(confObject);
        Bullet bullet = new Bullet(20, panel, 'r');

        int previousX = bullet.getPosX();
        int previousY = bullet.getPosY();
        bullet.setBulletCoordinate();

        int expectedX = previousX - 2;
        int resultX = bullet.getPosX();
        assertEquals(expectedX, resultX);

        int expectedY = previousY;
        int resultY = bullet.getPosY();
        assertEquals(expectedY, resultY);
    }

    @Test
    void setBulletCoordinateTest_when_leftSide() {
        ConfObject confObject = new ConfObject();
        TankPanel panel = new TankPanel(confObject);
        Bullet bullet = new Bullet(20, panel, 'l');

        int previous = bullet.getPosX();
        int previousY = bullet.getPosY();
        bullet.setBulletCoordinate();

        int expectedX = previous + 2;
        int resultX = bullet.getPosX();
        assertEquals(expectedX, resultX);

        int expectedY = previousY;
        int resultY = bullet.getPosY();
        assertEquals(expectedY, resultY);
    }
}
