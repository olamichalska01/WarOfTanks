package tests;

import configuration.ConfObject;
import frames.game.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class CellTest {

    @Test
    void increaseCellPointsTest_when_cellCurrentPointsNotMax() {
        ConfObject confObject = new ConfObject();
        confObject.setStartCellPoints(3);
        Cell cell = new Cell(confObject, 100);
        cell.increaseCellPoints();

        int expected = 4;
        int result = cell.cellCurrentPoints;

        assertEquals(expected, result);
    }

    @Test
    void increaseCellPointsTest_when_cellCurrentPointsMax() {
        ConfObject confObject = new ConfObject();
        confObject.setStartCellPoints(9);
        Cell cell = new Cell(confObject, 100);
        cell.increaseCellPoints();

        int expected = 9;
        int result = cell.cellCurrentPoints;

        assertEquals(expected, result);
    }

    @Test
    void decreaseCellPointsTest_when_cellCurrentPointsMin() {
        ConfObject confObject = new ConfObject();
        confObject.setStartCellPoints(0);
        Cell cell = new Cell(confObject, 100);
        cell.decreaseCellPoints();

        int expected = 0;
        int result = cell.cellCurrentPoints;

        assertEquals(expected, result);
    }

    @Test
    void decreaseCellPointsTest_when_cellCurrentPointsNotMin() {
        ConfObject confObject = new ConfObject();
        confObject.setStartCellPoints(5);
        Cell cell = new Cell(confObject, 100);
        cell.decreaseCellPoints();

        int expected = 4;
        int result = cell.cellCurrentPoints;

        assertEquals(expected, result);
    }

    @Test
    void getIsAloneTest_when_notPartOfColony() {
        ConfObject confObject = new ConfObject();
        Cell cell = new Cell(confObject, 100);
        boolean expected = true;
        boolean result = cell.getIsAlone();

        assertEquals(expected, result);
    }

    @Test
    void getIsAloneTest_when_isPartOfColony() {
        ConfObject confObject = new ConfObject();
        Cell cell = new Cell(confObject, 100, 20);
        boolean expected = false;
        boolean result = cell.getIsAlone();

        assertEquals(expected, result);
    }

    @Test
    void getWhichColonyTest_when_notPartOfColony() {
        ConfObject confObject = new ConfObject();
        Cell cell = new Cell(confObject, 100);
        int expected = -1;
        int result = cell.getWhichColony();

        assertEquals(expected, result);
    }
}
