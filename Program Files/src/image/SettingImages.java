package image;

import javax.swing.*;
import java.util.List;
import java.util.Objects;

public class SettingImages {

    private final ImageIcon goBackButton0;
    private final ImageIcon goBackButton1;
    private final ImageIcon gameRules;
    private final ImageIcon startPanelBackground;
    private final ImageIcon startPanelButtons;
    private final ImageIcon startPanelTitle;
    private final ImageIcon bomb;
    private final ImageIcon plainTitle;

    {
        goBackButton0 = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("buttonImage/goBackButton_0.png"))).getImage());
        goBackButton1 = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("buttonImage/goBackButton_1.png"))).getImage());
        gameRules = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("helpImages/gameRules.png"))).getImage());
        startPanelBackground = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("startImages/background.png"))).getImage());
        startPanelButtons = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("startImages/panelButtons.png"))).getImage());
        startPanelTitle = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("startImages/titleGenerate.png"))).getImage());
        bomb = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/bomb/bomb.gif"))).getImage());
        plainTitle = new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/plainTitle.png"))).getImage());
    }

    public ImageIcon getGoBackButton0() {
        return goBackButton0;
    }

    public ImageIcon getGoBackButton1() {
        return goBackButton1;
    }

    public ImageIcon getGameRules() {
        return gameRules;
    }

    public ImageIcon getStartPanelBackground() {
        return startPanelBackground;
    }

    public ImageIcon getStartPanelButtons() {
        return startPanelButtons;
    }

    public ImageIcon getStartPanelTitle() {
        return startPanelTitle;
    }

    public ImageIcon getBomb() {
        return bomb;
    }

    public ImageIcon getPlainTitle() {
        return plainTitle;
    }

    public void setPanelButtons(List<ImageIcon> image) {
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("buttonImage/startButton_0.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("buttonImage/startButton_1.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("buttonImage/helpButton_0.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("buttonImage/helpButton_1.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("buttonImage/settingsButton_0.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("buttonImage/settingsButton_1.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("buttonImage/addFileButton_0.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("buttonImage/addFileButton_1.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("buttonImage/resetButton_0.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("buttonImage/resetButton_1.png"))).getImage()));
    }

    public void setLeftTankBarrel(List<ImageIcon> image) {
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/left/barrel/redTankBarrel_60.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/left/barrel/redTankBarrel_50.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/left/barrel/redTankBarrel_40.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/left/barrel/redTankBarrel_30.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/left/barrel/redTankBarrel_20.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/left/barrel/redTankBarrel_10.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/left/barrel/redTankBarrel_00.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/left/barrel/redTankBarrel_01.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/left/barrel/redTankBarrel_02.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/left/barrel/redTankBarrel_03.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/left/barrel/redTankBarrel_04.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/left/barrel/redTankBarrel_05.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/left/barrel/redTankBarrel_06.png"))).getImage()));
    }

    public void setLeftTankBody(List<ImageIcon> image) {
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/left/body/redTankBody_0.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/left/body/redTankBody_1.png"))).getImage()));
    }

    public void setRightTankBarrel(List<ImageIcon> image) {
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/right/barrel/blueTankBarrel_60.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/right/barrel/blueTankBarrel_50.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/right/barrel/blueTankBarrel_40.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/right/barrel/blueTankBarrel_30.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/right/barrel/blueTankBarrel_20.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/right/barrel/blueTankBarrel_10.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/right/barrel/blueTankBarrel_00.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/right/barrel/blueTankBarrel_01.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/right/barrel/blueTankBarrel_02.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/right/barrel/blueTankBarrel_03.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/right/barrel/blueTankBarrel_04.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/right/barrel/blueTankBarrel_05.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/right/barrel/blueTankBarrel_06.png"))).getImage()));
    }

    public void setRightTankBody(List<ImageIcon> image) {
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/right/body/blueTankBody_0.png"))).getImage()));
        image.add(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("gameImages/tank/right/body/blueTankBody_1.png"))).getImage()));
    }


}
