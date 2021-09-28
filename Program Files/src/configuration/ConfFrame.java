package configuration;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfFrame extends JFileChooser {
    public final Map<String, Integer> parameters;

    private final String[] keys;

    {
        parameters = new HashMap<>();
        keys = new String[]{"-v1", "-r1", "-v2", "-h1", "-t1", "-t2", "-t3", "-dv1", "-dv2", "-dr1", "-dh1", "-x1", "-p1"};
    }

    public ConfFrame() {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        setFileFilter(filter);
        setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = getSelectedFile();
            try {
                readFile(selectedFile);
            } catch (IOException ioe) {
                System.err.println("could not read file");
            }
        }
    }

    public void setParameters(ConfObject confObject) {
        if (parameters.get("-v1") != null && (50 >= parameters.get("-v1") && 10 <= parameters.get("-v1")))
            confObject.setStartBulletVelocity(parameters.get("-v1"));

        if (parameters.get("-x1") != null && (25 >= parameters.get("-x1") && 0 <= parameters.get("-x1")))
            confObject.setStartBulletAmount(parameters.get("-x1"));

        if (parameters.get("-r1") != null && (25 >= parameters.get("-r1") && 5 <= parameters.get("-r1")))
            confObject.setStartBulletRadius(parameters.get("-r1"));

        if (parameters.get("-v2") != null && (35 >= parameters.get("-v2") && 5 <= parameters.get("-v2")))
            confObject.setStartCellVelocity(parameters.get("-v2"));

        if (parameters.get("-h1") != null && (70 >= parameters.get("-h1") && 20 <= parameters.get("-h1")))
            confObject.setStartCellSide(parameters.get("-h1"));

        if (parameters.get("-p1") != null && (9 >= parameters.get("-p1") && 1 <= parameters.get("-p1")))
            confObject.setStartCellPoints(parameters.get("-p1"));

        if (parameters.get("-t1") != null && (180 >= parameters.get("-t1") && 30 <= parameters.get("-t1")))
            confObject.setChangesTime(parameters.get("-t1"));

        if (parameters.get("-dv1") != null && (25 >= parameters.get("-dv1") && 0 <= parameters.get("-dv1")))
            confObject.setChangeBulletVelocity(parameters.get("-dv1"));

        if (parameters.get("-dr1") != null && (10 >= parameters.get("-dr1") && 2 <= parameters.get("-dr1")))
            confObject.setChangeBulletRadius(parameters.get("-dr1"));

        if (parameters.get("-dv2") != null && (20 >= parameters.get("-dv2") && 0 <= parameters.get("-dv2")))
            confObject.setChangeCellVelocity(parameters.get("-dv2"));

        if (parameters.get("-dh1") != null && (10 >= parameters.get("-dh1") && 1 <= parameters.get("-dh1")))
            confObject.setChangeCellSide(parameters.get("-dh1"));

        if (parameters.get("-t2") != null && (40 >= parameters.get("-t2") && 5 <= parameters.get("-t2")))
            confObject.setIncreaseCellValueTime(parameters.get("-t2"));

        if (parameters.get("-t3") != null && (15 >= parameters.get("-t3") && 3 <= parameters.get("-t3")))
            confObject.setGameDuration(parameters.get("-t3"));
    }

    private void readFile(File selectedFile) throws IOException {
        selectedFile = new File(selectedFile.getAbsolutePath());
        FileReader fr = new FileReader(selectedFile);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (int i = 0; i < words.length; i += 2) {
                try {
                    for (String key : keys) {
                        if (words[i].equals(key)) {
                            boolean isNotKey = true;
                            for (String k : keys) {
                                if (words[i + 1].equals(k)) {
                                    isNotKey = false;
                                    break;
                                }
                            }
                            if (isNotKey) parameters.put(words[i], Integer.parseInt(words[i + 1]));
                        }
                    }
                } catch (NumberFormatException numberFormatException) {
                    // ignore
                }
            }
        }
    }
}
