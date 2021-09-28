package frames.game;

import configuration.ConfObject;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Colony {
    public ArrayList<Cell> cellsOfColony = new ArrayList<>();;
    public Cell midCell;
    public int indexOfColony;
    public int life;

    private final int points;

    public Colony(ConfObject confObject, ArrayList<Cell> cells, JPanel panel, int indexColony) {
        indexOfColony = indexColony;
        makeColony(confObject, panel, cells, new Random().nextInt(4) + 2);
        points = confObject.getStartCellPoints() * cellsOfColony.size();
        life = cellsOfColony.size();
    }

    public int getPoints() {
        return points;
    }

    public void changeSizeOfCellsInColony(int changedSize) {
        if (midCell.cellSide - changedSize > 25) {
            midCell.cellSide -= changedSize;
            for (int i = 0; i < cellsOfColony.size(); i++) {
                if (cellsOfColony.get(i).getIndexOfColony() == 0) continue;
                cellsOfColony.get(i).cellSide -= changedSize;
                cellsOfColony.get(i).xPos = getPosX(cellsOfColony.get(i).getIndexOfColony());
                cellsOfColony.get(i).yPos = getPosY(cellsOfColony.get(i).getIndexOfColony());
            }
        }
    }

    private void addCell(Cell cell, JPanel panel, ArrayList<Cell> cells) {
        cell.setCellColor();
        cells.add(cell);
        cellsOfColony.add(cell);
        panel.add(cell);
        cell.setWhichColony(indexOfColony);
    }

    private Cell getCellOfIndex(int index, ConfObject confObject) {
        Cell cell = new Cell(confObject, getPosX(index), getPosY(index));
        cell.setIndexOfColony(index);
        return cell;
    }

    private int getPosX(int index) {
        switch (index) {
            case 1:
            case 4:
            case 6:
                return midCell.xPos - midCell.cellSide;
            case 2:
            case 0:
            case 7:
                return midCell.xPos;
            default:
                return midCell.xPos + midCell.cellSide;
        }
    }

    private int getPosY(int index) {
        switch (index) {
            case 1:
            case 2:
            case 3:
                return midCell.yPos - midCell.cellSide;
            case 4:
            case 0:
            case 5:
                return midCell.yPos;
            default:
                return midCell.yPos + midCell.cellSide;
        }
    }

    private void makeColony(ConfObject confObject, JPanel panel, ArrayList<Cell> cells, int index) {
        midCell = new Cell(confObject, (int) (Math.random() * 150) + 170, -140);
        addCell(midCell, panel, cells);
        int indexesSize = 8;
        Integer[] indexes = {1, 2, 3, 4, 5, 6, 7, 8};
        while (index-- > 1) {
            int newIndex = new Random().nextInt(indexesSize--);
            addCell(getCellOfIndex(indexes[newIndex], confObject), panel, cells);
            for (int k = 0; k < indexes.length - 1; k++) {
                if (k >= newIndex)
                    indexes[k] = indexes[k + 1];
            }
        }
    }
}
