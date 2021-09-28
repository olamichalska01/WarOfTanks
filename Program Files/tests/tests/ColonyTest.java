package tests;

import configuration.ConfObject;
import frames.game.Cell;
import frames.game.Colony;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ColonyTest {

    @Test
    void changeSizeOfCellsInColonyTest_when_shouldBeAbleToChange() {
        ConfObject confObject = new ConfObject();
        JPanel panel = new JPanel();
        ArrayList<Cell> cells = new ArrayList<>();
        Colony colony = new Colony(confObject, cells, panel, 4);
        colony.changeSizeOfCellsInColony(10);

        int expected = 60;
        int result = colony.midCell.cellSide;

        assertEquals(expected, result);
    }

    @Test
    void changeSizeOfCellsInColonyTest_when_shouldNotBeAbleToChange() {
        ConfObject confObject = new ConfObject();
        confObject.setStartCellSide(35);
        JPanel panel = new JPanel();
        ArrayList<Cell> cells = new ArrayList<>();
        Colony colony = new Colony(confObject, cells, panel, 4);
        colony.changeSizeOfCellsInColony(100);

        for(int i = 0; i < colony.cellsOfColony.size(); i++) {
            int expected = 35;
            int result = colony.cellsOfColony.get(i).cellSide;

            assertEquals(expected, result);
        }

    }
}
