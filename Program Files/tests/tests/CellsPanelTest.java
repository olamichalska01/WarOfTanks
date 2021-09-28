package tests;

import configuration.ConfObject;
import frames.game.CellsPanel;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class CellsPanelTest {
    @Test
    void changeCellSideTest_when_shouldBeAbleToChange() {
        ConfObject confObject = new ConfObject();
        CellsPanel cellsPanel = new CellsPanel(confObject);
        int cellSide = 60;
        int change = 15;

        int expected = 45;
        int result = cellsPanel.changeCellSize(cellSide, change);

        assertEquals(expected, result);
    }

    @Test
    void changeCellSideTest_when_shouldNotBeAbleToChange() {
        ConfObject confObject = new ConfObject();
        CellsPanel cellsPanel = new CellsPanel(confObject);
        int cellSide = 20;
        int change = 15;

        int expected = 20;
        int result = cellsPanel.changeCellSize(cellSide, change);

        assertEquals(expected, result);
    }
}
