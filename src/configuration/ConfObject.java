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

    public ConfObject(){
        startBulletVelocity = 10;
        startBulletAmount = 15;
        startBulletRadius = 20;
        startCellVelocity = 14;
        startCellPoints = 3;
        startCellSide = 50;
        changesTime = 60;
        changeBulletVelocity = 3;
        changeCellVelocity = 4;
        changeBulletRadius = 2;
        changeCellSide = 3;
        increaseCellValueTime = 100;
        gameDuration = 5;
    }


    public Integer getStartBulletVelocity() {
        return startBulletVelocity;
    }

    public Integer getStartBulletAmount() {
        return startBulletAmount;
    }

    public Integer getStartBulletRadius() {
        return startBulletRadius;
    }

    public Integer getStartCellVelocity() {
        return startCellVelocity;
    }

    public Integer getStartCellPoints() {
        return startCellPoints;
    }

    public Integer getStartCellSide() {
        return startCellSide;
    }

    public Integer getChangesTime() {
        return changesTime;
    }

    public Integer getChangeBulletVelocity() {
        return changeBulletVelocity;
    }

    public Integer getChangeCellVelocity() {
        return changeCellVelocity;
    }

    public Integer getChangeBulletRadius() {
        return changeBulletRadius;
    }

    public Integer getChangeCellSide() {
        return changeCellSide;
    }

    public Integer getIncreaseCellValueTime() {
        return increaseCellValueTime;
    }

    public Integer getGameDuration() {
        return gameDuration;
    }

    public void setStartBulletVelocity(Integer startBulletVelocity) {
        this.startBulletVelocity = startBulletVelocity;
    }

    public void setStartBulletAmount(Integer startBulletAmount) {
        this.startBulletAmount = startBulletAmount;
    }

    public void setStartBulletRadius(Integer startBulletRadius) {
        this.startBulletRadius = startBulletRadius;
    }

    public void setStartCellVelocity(Integer startCellVelocity) {
        this.startCellVelocity = startCellVelocity;
    }

    public void setStartCellPoints(Integer startCellPoints) {
        this.startCellPoints = startCellPoints;
    }

    public void setStartCellSide(Integer startCellSide) {
        this.startCellSide = startCellSide;
    }

    public void setChangesTime(Integer changesTime) {
        this.changesTime = changesTime;
    }

    public void setChangeBulletVelocity(Integer changeBulletVelocity) {
        this.changeBulletVelocity = changeBulletVelocity;
    }

    public void setChangeCellVelocity(Integer changeCellVelocity) {
        this.changeCellVelocity = changeCellVelocity;
    }

    public void setChangeBulletRadius(Integer changeBulletRadius) {
        this.changeBulletRadius = changeBulletRadius;
    }

    public void setChangeCellSide(Integer changeCellSide) {
        this.changeCellSide = changeCellSide;
    }

    public void setIncreaseCellValueTime(Integer increaseCellValueTime) {
        this.increaseCellValueTime = increaseCellValueTime;
    }

    public void setGameDuration(Integer gameDuration) {
        this.gameDuration = gameDuration;
    }
}