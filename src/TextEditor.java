import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class TextEditor extends Notepad {

    public TextEditor(){
       window = new JFrame("Easy NotePad Demo beta1.0");
       textArea = new JTextArea(100,100);
       menuBar = new JMenuBar();
    }

    @Override
    public void init() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void saveFile(File file) {

    }

    @Override
    public void openFIle(File file) {

    }

    @Override
    public int exitAsk() {
        return 0;
    }
}
