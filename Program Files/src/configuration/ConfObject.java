package configuration;

public class ConfObject {

    private Integer startBulletVelocity;
    private Integer startBulletAmount;
    private Integer startBulletRadius;
    private Integer startCellVelocity;
    private Integer startCellPoints;
    private Integer startCellSide;
    private Integer changesTime;
    private Integer changeBulletVelocity;
    private Integer changeCellVelocity;
    private Integer changeBulletRadius;
    private Integer changeCellSide;
    private Integer increaseCellValueTime;
    private Integer gameDuration;

    public ConfObject() {
        startBulletVelocity = 30;
        startBulletAmount = 7;
        startBulletRadius = 20;
        startCellVelocity = 60;
        startCellPoints = 3;
        startCellSide = 70;
        changesTime = 30;
        changeBulletVelocity = 5;
        changeCellVelocity = 10;
        changeBulletRadius = 5;
        changeCellSide = 5;
        increaseCellValueTime = 10;
        gameDuration = 3;
    }

    public Integer getStartBulletVelocity() {
        return startBulletVelocity;
    }

    public void setStartBulletVelocity(Integer startBulletVelocity) {
        this.startBulletVelocity = startBulletVelocity;
    }

    public Integer getStartBulletAmount() {
        return startBulletAmount;
    }

    public void setStartBulletAmount(Integer startBulletAmount) {
        this.startBulletAmount = startBulletAmount;
    }

    public Integer getStartBulletRadius() {
        return startBulletRadius;
    }

    public void setStartBulletRadius(Integer startBulletRadius) {
        this.startBulletRadius = startBulletRadius;
    }

    public Integer getStartCellVelocity() {
        return startCellVelocity;
    }

    public void setStartCellVelocity(Integer startCellVelocity) {
        this.startCellVelocity = startCellVelocity;
    }

    public Integer getStartCellPoints() {
        return startCellPoints;
    }

    public void setStartCellPoints(Integer startCellPoints) {
        this.startCellPoints = startCellPoints;
    }

    public Integer getStartCellSide() {
        return startCellSide;
    }

    public void setStartCellSide(Integer startCellSide) {
        this.startCellSide = startCellSide;
    }

    public Integer getChangesTime() {
        return changesTime;
    }

    public void setChangesTime(Integer changesTime) {
        this.changesTime = changesTime;
    }

    public Integer getChangeBulletVelocity() {
        return changeBulletVelocity;
    }

    public void setChangeBulletVelocity(Integer changeBulletVelocity) {
        this.changeBulletVelocity = changeBulletVelocity;
    }

    public Integer getChangeCellVelocity() {
        return changeCellVelocity;
    }

    public void setChangeCellVelocity(Integer changeCellVelocity) {
        this.changeCellVelocity = changeCellVelocity;
    }

    public Integer getChangeBulletRadius() {
        return changeBulletRadius;
    }

    public void setChangeBulletRadius(Integer changeBulletRadius) {
        this.changeBulletRadius = changeBulletRadius;
    }

    public Integer getChangeCellSide() {
        return changeCellSide;
    }

    public void setChangeCellSide(Integer changeCellSide) {
        this.changeCellSide = changeCellSide;
    }

    public Integer getIncreaseCellValueTime() {
        return increaseCellValueTime;
    }

    public void setIncreaseCellValueTime(Integer increaseCellValueTime) {
        this.increaseCellValueTime = increaseCellValueTime;
    }

    public Integer getGameDuration() {
        return gameDuration;
    }

    public void setGameDuration(Integer gameDuration) {
        this.gameDuration = gameDuration;
    }
}
