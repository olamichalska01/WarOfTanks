package frames.game;

import configuration.ConfObject;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;


public class CellsPanel {
    public static JPanel cellsPanel;
    public static ArrayList<Cell> cells;
    public static ArrayList<Cell> cellsForRemove;
    public static ArrayList<Colony> colonies;
    public static Thread generateThread;
    public static Thread moveThread;
    public static Thread changeValueThread;

    private final Integer panelWidth;
    private final Integer panelHeight;
    private final ConfObject confObject;
    private final Integer changeCellVelocity;
    private boolean isThreadRunning;
    private int indexOfColony;
    private Integer cellVelocity;

    {
        cellsPanel = new JPanel();
        cells = new ArrayList<>();
        cellsForRemove = new ArrayList<>();
        colonies = new ArrayList<>();
        panelWidth = 585;
        panelHeight = 600;
        isThreadRunning = true;
        indexOfColony = 1;
    }

    public CellsPanel(ConfObject confObject) {
        this.confObject = confObject;
        changeCellVelocity = confObject.getChangeCellVelocity();
        cellVelocity = confObject.getStartCellVelocity();
        cellsPanel.setBounds(200, 0, panelWidth, panelHeight);
        cellsPanel.setLayout(null);
        setUpGenerateThread();
        setUpMoveThread();
        setUpChangeValueThread();
    }

    public int changeCellSize(int cellSide, int changeCellSide) {
        if (cellSide - changeCellSide > 25) cellSide -= changeCellSide;
        return cellSide;
    }

    public static void removeCells() {
        for (int c = 0; c < cellsForRemove.size(); c++) {
            Cell cell = cellsForRemove.get(c);
            cellsPanel.remove(cell);
            CellsPanel.cells.remove(cell);
        }
    }

    public void applyChangesToCells(int cellSide) {
        for (int c = 0; c < cells.size(); c++) {
            Cell cell = cells.get(c);
            if (cell.getIsAlone())
                cell.cellSide = cellSide;
        }
        cellVelocity = cellsSpeed();
    }

    public void applyChangesToColony() {
        for (int c = 0; c < colonies.size(); c++) {
            colonies.get(c).changeSizeOfCellsInColony(confObject.getChangeCellSide());
        }
    }

    private int generateCellOrColony() {
        if (new Random().nextInt(2) == 0) {
            Cell generatedCell = new Cell(confObject, (int) ((Math.random() * 400) + 100));
            generatedCell.setCellColor();
            cellsPanel.add(generatedCell);
            cells.add(generatedCell);
            return generatedCell.cellSide;
        } else {
            Colony generatedColony = new Colony(confObject, cells, cellsPanel, indexOfColony);
            colonies.add(generatedColony);
            indexOfColony++;
            return generatedColony.midCell.cellSide * 3;
        }
    }

    private void moveCells() {
        for (int c = 0; c < cells.size(); c++) {
            Cell cell = cells.get(c);
            cell.yPos++;
            cell.drawCell();
            if (cell.yPos > 585) cellsForRemove.add(cell);
        }
    }

    private int cellsSpeed() {
        if (cellVelocity > changeCellVelocity) cellVelocity -= changeCellVelocity;
        return cellVelocity;
    }

    private void changeCellsValue() {
        for (int c = 0; c < cells.size(); c++) {
            Cell cell = cells.get(c);
            cell.increaseCellPoints();
        }
    }

    private void setUpChangeValueThread() {
        changeValueThread = new Thread(() -> {
            try {
                while (isThreadRunning) {
                    if (!GameTimer.isThreadRunning) stopThread();
                    changeCellsValue();
                    Thread.sleep(confObject.getIncreaseCellValueTime() * 1000);
                }
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });
        changeValueThread.setDaemon(true);
    }

    private void setUpGenerateThread() {
        generateThread = new Thread(() -> {
            try {
                while (isThreadRunning) {
                    if (!GameTimer.isThreadRunning) stopThread();
                    Thread.sleep((long) generateCellOrColony() * cellVelocity * 2);
                }

            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });
        generateThread.setDaemon(true);
    }

    private void setUpMoveThread() {
        moveThread = new Thread(() -> {
            try {
                while (isThreadRunning) {
                    if (!GameTimer.isThreadRunning) stopThread();
                    moveCells();
                    Thread.sleep(cellVelocity);
                }
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        });
        moveThread.setDaemon(true);
    }

    private void stopThread() {
        isThreadRunning = false;
    }
}