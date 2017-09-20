

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public abstract class Notepad {
    public JFrame window ;
    public JTextArea textArea;
    public JScrollPane scrollRight;
    public JMenuBar menuBar;
    public JMenu file,edit,view;
    public File currentFile = null;
    public boolean saveFlag = true;

    public abstract void init();
    public abstract  void actionPerformed(ActionEvent e);
    public abstract void saveFile(File file);
    public abstract void openFIle(File file);
    public abstract int exitAsk();
}
