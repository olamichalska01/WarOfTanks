package frames.start;

import frames.GameFrame;
import frames.HelpFrame;
import frames.SettingsFrame;

import javax.swing.*;

public class StartFrame {

    public JFrame startFrame = new JFrame();

    //public ConfObject con;

    public GameFrame game = new GameFrame();
    public SettingsFrame settings = new SettingsFrame();
    public HelpFrame help = new HelpFrame();


    public StartFrame() {
        long t1 = System.currentTimeMillis();

        setFrame(startFrame);
        startFrame.add(new PanelButtons(this));
        startFrame.add(new PanelTitle());
        startFrame.add(new PanelBackground());
        startFrame.setVisible(true);

        long t2 = System.currentTimeMillis();
        System.out.println("StartFrame: " + (t2 - t1));
    }

    private void setFrame(JFrame frame) {
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 100, 615, 800);
    }

}
