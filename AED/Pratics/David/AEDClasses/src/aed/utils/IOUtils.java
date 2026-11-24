package aed.utils;

import javax.swing.*;
import java.io.File;

public class IOUtils {

    public static File chooseFileToOpen() {
        JDialog dialog = new JDialog();
        JFileChooser chooser = new JFileChooser();
        return chooser.showOpenDialog(dialog) == JFileChooser.APPROVE_OPTION ? chooser.getSelectedFile() : null;
    }

    public static File chooseFileToSave() {
        JDialog dialog = new JDialog();
        JFileChooser chooser = new JFileChooser();
        return chooser.showSaveDialog(dialog) == JFileChooser.APPROVE_OPTION ? chooser.getSelectedFile() : null;
    }
}
