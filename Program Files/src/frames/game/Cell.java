package frames.game;

import configuration.ConfObject;

import javax.swing.*;
import java.awt.*;

public class Cell extends JLabel {
    public final Integer cellStartPoints;
    public Integer cellSide;
    public Integer cellCurrentPoints;
    public Color[] cellsColor;
    public Integer yPos;
    public Integer xPos;

    private final boolean isAlone;
    private Integer indexOfColony;
    private Integer whichColony;

    {
        cellsColor = new Color[]{
                new Color(154, 79, 80),
                new Color(154, 79, 80),
                new Color(193, 118, 91),
                new Color(190, 149, 92),
                new Color(147, 161, 103),
                new Color(110, 170, 120),
                new Color(104, 172, 169),
                new Color(124, 161, 192),
                new Color(102, 96, 146),
                new Color(67, 52, 85)};
    }

    public Cell(ConfObject confObject, int xPos) {
        cellStartPoints = confObject.getStartCellPoints();
        cellCurrentPoints = cellStartPoints;
        cellSide = confObject.getStartCellSide();
        setOpaque(true);
        setText(Integer.toString(cellCurrentPoints));
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setForeground(Color.white);
        this.xPos = xPos;
        yPos = -1 * cellSide;
        isAlone = true;
        indexOfColony = 0;
        whichColony = -1;
    }

    public Cell(ConfObject confObject, int xPos, int yPos) {
        cellStartPoints = confObject.getStartCellPoints();
        cellCurrentPoints = cellStartPoints;
        cellSide = confObject.getStartCellSide();
        setOpaque(true);
        setText(Integer.toString(cellCurrentPoints));
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setForeground(Color.white);
        this.xPos = xPos;
        this.yPos = yPos;
        isAlone = false;
        indexOfColony = 0;
    }

    public void drawCell() {
        setBounds(xPos, yPos, cellSide, cellSide);
    }

    public void setCellColor() {
        setBackground(cellsColor[cellCurrentPoints]);
        changeCellPointsText(cellCurrentPoints);
    }

    public void increaseCellPoints() {
        if (cellCurrentPoints < cellsColor.length - 1)
            cellCurrentPoints++;
        setCellColor();
    }

    public void decreaseCellPoints() {
        if (cellCurrentPoints > 0)
            cellCurrentPoints--;
        setCellColor();
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(xPos + 200, yPos, cellSide, cellSide);
    }

    public boolean getIsAlone() {
        return isAlone;
    }

    public int getIndexOfColony() {
        return indexOfColony;
    }

    public void setIndexOfColony(int index) {
        indexOfColony = index;
    }

    public void setWhichColony(int indexColony) {
        whichColony = indexColony;
    }

    public int getWhichColony() {
        return whichColony;
    }

    private void changeCellPointsText(Integer points) {
        setText(Integer.toString(points));
    }
}
