package tests;

import configuration.ConfObject;
import frames.game.TankPanel;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TankPanelTest {
    @Test
    void changeTankParametersTest_when_shouldBeAbleToChange() {
        ConfObject confObject = new ConfObject();
        confObject.setStartBulletRadius(40);
        confObject.setChangeBulletRadius(10);
        confObject.setStartBulletVelocity(20);
        confObject.setChangeBulletVelocity(2);
        TankPanel tankPanel = new TankPanel(confObject);

        tankPanel.changeTankParameters();

        int expectedRadius = 30;
        int resultRadius = tankPanel.radius;
        assertEquals(expectedRadius, resultRadius);

        int expectedVelocity = 22;
        int resultVelocity = tankPanel.velocity;
        assertEquals(expectedVelocity, resultVelocity);
    }

    @Test
    void changeTankParametersTest_when_shouldNotBeAbleToChange() {
        ConfObject confObject = new ConfObject();
        confObject.setStartBulletRadius(18);
        confObject.setChangeBulletRadius(14);
        confObject.setStartBulletVelocity(50);
        confObject.setChangeBulletVelocity(17);
        TankPanel tankPanel = new TankPanel(confObject);

        tankPanel.changeTankParameters();

        int expectedRadius = 18;
        int resultRadius = tankPanel.radius;
        assertEquals(expectedRadius, resultRadius);

        int expectedVelocity = 50;
        int resultVelocity = tankPanel.velocity;
        assertEquals(expectedVelocity, resultVelocity);
    }
}
