package frames.help;

import frames.GoBackButton;
import frames.start.StartFrame;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.io.*;

public class HelpFrame {
    public JFrame helpFrame;

    private final JPanel helpPanel;
    private final JTextPane gameRulesText;
    private final JScrollPane scrollPane;

    {
        helpFrame = new JFrame();
        helpPanel = new JPanel();
        gameRulesText = new JTextPane();
        scrollPane = new JScrollPane(gameRulesText);
    }

    public HelpFrame() {
        helpFrame.setBounds(500, 100, 615, 800);
        helpFrame.setResizable(false);
        readGameRules();
        createHelpPanel();
        createScrollPane();
        helpFrame.add(scrollPane);
        createRulesTextArea();
        helpFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void readGameRules() {
        File file;
        BufferedReader input;

        try {
            file = new File("frames/help/gameRules.txt");
            input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            gameRulesText.read(input, "reading game rules...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createRulesTextArea() {

        gameRulesText.setEditable(false);
        gameRulesText.setOpaque(false);
        gameRulesText.setSelectionColor(new Color(141, 168, 152));
        gameRulesText.setBounds(50, 200, 500, 300);
        gameRulesText.setFont(new Font("Monospaced", Font.PLAIN, 18));
        SimpleAttributeSet attributes = new SimpleAttributeSet();
        StyleConstants.setAlignment(attributes, StyleConstants.ALIGN_JUSTIFIED);
        gameRulesText.setParagraphAttributes(attributes, true);
    }

    private void createScrollPane(){
        scrollPane.setBounds(25,200,550,380);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors(){
                this.thumbColor = new Color(141, 168, 152);
                this.trackColor = new Color(141, 168, 152);
                this.thumbDarkShadowColor = new Color(141, 168, 152);
                this.thumbHighlightColor = new Color(141, 168, 152);
                this.thumbLightShadowColor = new Color(141, 168, 152);
                this.trackHighlightColor = new Color(141, 168, 152);
            }
            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton button = super.createDecreaseButton(orientation);
                button.setBackground(new Color(141, 168, 152));
                button.setForeground(new Color(141, 168, 152));
                return button;
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton button = super.createIncreaseButton(orientation);
                button.setBackground(new Color(141, 168, 152));
                return button;
            }
        });

        scrollPane.getViewport().setBackground(new Color(141, 168, 152));
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);
    }

    private void createHelpPanel() {
        helpFrame.setContentPane(helpPanel);
        helpPanel.setLayout(null);
        helpPanel.setBackground(new Color(141, 168, 152));

        JButton helpGoBackButton = new GoBackButton(helpFrame, StartFrame.startFrame, 200, 600);
        helpPanel.add(helpGoBackButton);

        helpPanel.add(new HelpPanelTitle());
    }
}