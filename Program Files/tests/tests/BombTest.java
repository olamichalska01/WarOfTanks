package tests;

import frames.game.GameTimer;
import frames.game.bomb.Bomb;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class BombTest {

    @AfterEach
    void tearDown() {
        GameTimer.isThreadRunning = true;
    }

    @Test
    void decreaseBombPointsTest() {
        Bomb bomb = new Bomb();
        bomb.bombCurrentPoints = 32;
        bomb.decreaseBombPoints();

        int expected = 31;
        int result = bomb.bombCurrentPoints;

        assertEquals(expected, result);

        boolean expectedIsTimerRunning = true;
        boolean resultIsTimerRunning = GameTimer.isThreadRunning;

        assertEquals(expectedIsTimerRunning, resultIsTimerRunning);
    }
}
