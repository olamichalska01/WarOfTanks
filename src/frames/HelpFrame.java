package frames;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class HelpFrame {
    public JFrame helpFrame = new JFrame("Game rules");
    private JPanel helpPanel = new JPanel();
    private JTextArea gameRulesText = new JTextArea(10, 10);

    public HelpFrame() {
        helpFrame.setBounds(100, 100, 400, 600);
        helpFrame.setResizable(false);
        readGameRules();
        createHelpPanel();
        helpPanel.add(gameRulesText);
        createRulesTextArea();
        helpFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void readGameRules() {
        File file;

        try {
            file = new File("src/frames/gameRules.txt");
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            gameRulesText.read(input, "reading game rules...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createRulesTextArea() {
        gameRulesText.setEditable(false);
        gameRulesText.setLineWrap(true);
        gameRulesText.setOpaque(false);
        gameRulesText.setBounds(50, 50, 200, 300);
    }

    private void createHelpPanel() {
        helpFrame.setContentPane(helpPanel);
        helpPanel.setLayout(null);
        helpPanel.setBackground(Color.pink);
    }
}