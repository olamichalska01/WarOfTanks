package frames;

import javax.swing.*;

public class GameFrame {
    public JFrame frameGame = new JFrame();

    public GameFrame(){
        long t1 = System.currentTimeMillis();

        setFrame(frameGame);

        long t2 = System.currentTimeMillis();
        System.out.println("GameFrame: " + (t2-t1));
    }

    private void setFrame(JFrame frame){
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500,100, 1000,800);
    }
}
