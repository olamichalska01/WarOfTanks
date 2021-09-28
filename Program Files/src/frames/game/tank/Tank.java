package frames.game.tank;

public class Tank {

    public Barrel barrel;
    public Body body;

    private char side;

    public Tank(char s) {
        setSide(s);
        createTank();
    }

    private void setSide(char s) {
        if (s == 'r') side = 'r';
        else side = 'l';
    }

    private void createTank() {
        barrel = new Barrel(side);
        body = new Body(side);
    }
}
