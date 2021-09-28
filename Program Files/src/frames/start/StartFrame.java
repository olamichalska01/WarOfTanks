package frames.start;

import configuration.ConfFrame;
import configuration.ConfObject;
import frames.game.GameFrame;
import frames.help.HelpFrame;

import javax.swing.*;

public class StartFrame {

    public static JFrame startFrame;
    public static ConfFrame confFrame;
    public ConfObject con;
    public GameFrame game;
    public HelpFrame help;

    {
        startFrame = new JFrame();
        con = new ConfObject();
        game = new GameFrame(con);
        help = new HelpFrame();
    }

    public StartFrame() {
        setFrame(startFrame);
        startFrame.add(new StartPanelButtons(this));
        startFrame.add(new StartPanelTitle());
        startFrame.add(new StartPanelBackground());
        startFrame.setVisible(true);
    }

    private void setFrame(JFrame frame) {
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 100, 615, 800);
    }

}