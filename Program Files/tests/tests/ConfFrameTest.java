package tests;

import configuration.ConfFrame;
import configuration.ConfObject;
import org.junit.jupiter.api.Test;

public class ConfFrameTest {

    @Test
    void setParametersTest() {
        ConfObject confObject = new ConfObject();
        ConfFrame confFrame = new ConfFrame();

        confFrame.parameters.forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println("Before:");
        System.out.println("-h1 " + confObject.getStartCellSide());
        System.out.println("-p1 " + confObject.getStartCellPoints());
        System.out.println("-v1 " + confObject.getStartBulletVelocity());
        System.out.println("-x1 " + confObject.getStartBulletAmount());
        System.out.println("-r1 " + confObject.getStartBulletRadius());
        System.out.println("-v2 " + confObject.getStartCellVelocity());
        System.out.println("-t1 " + confObject.getChangesTime());
        System.out.println("-dv1 " + confObject.getChangeBulletVelocity());
        System.out.println("-dv2 " + confObject.getChangeCellVelocity());
        System.out.println("-dr1 " + confObject.getChangeBulletRadius());
        System.out.println("-dh1 " + confObject.getChangeCellSide());
        System.out.println("-t2 " + confObject.getIncreaseCellValueTime());
        System.out.println("-t3 " + confObject.getGameDuration() + "\n");

        confFrame.setParameters(confObject);

        System.out.println("After:");
        System.out.println("-h1 " + confObject.getStartCellSide());
        System.out.println("-p1 " + confObject.getStartCellPoints());
        System.out.println("-v1 " + confObject.getStartBulletVelocity());
        System.out.println("-x1 " + confObject.getStartBulletAmount());
        System.out.println("-r1 " + confObject.getStartBulletRadius());
        System.out.println("-v2 " + confObject.getStartCellVelocity());
        System.out.println("-t1 " + confObject.getChangesTime());
        System.out.println("-dv1 " + confObject.getChangeBulletVelocity());
        System.out.println("-dv2 " + confObject.getChangeCellVelocity());
        System.out.println("-dr1 " + confObject.getChangeBulletRadius());
        System.out.println("-dh1 " + confObject.getChangeCellSide());
        System.out.println("-t2 " + confObject.getIncreaseCellValueTime());
        System.out.println("-t3 " + confObject.getGameDuration());
    }
}
