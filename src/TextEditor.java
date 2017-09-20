import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class TextEditor extends Notepad {

    JMenuItem item;

    public TextEditor(){
        init();
        setUI();
    }

    @Override
    public void init() {

        window = new JFrame("Easy NotePad Demo beta1.0");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuBar = new JMenuBar();
        textArea = new JTextArea(30,70);
        scrollRight = new JScrollPane(textArea);
        file = new JMenu("文件");
        edit = new JMenu("编辑");
        view = new JMenu("查看");

        textArea.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void insertUpdate(DocumentEvent e) {
                        saveFlag = false;
                    }
                    public void removeUpdate(DocumentEvent e) {
                        saveFlag = false;
                    }
                    public void changedUpdate(DocumentEvent e) {
                        saveFlag = false;
                    }
                }
        );
    }

    private void setUI(){

        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(file);
        file.add(item = new JMenuItem("新建"));
        file.add(item = new JMenuItem("打开"));
        file.add(item = new JMenuItem("保存"));
        file.add(item = new JMenuItem("另存为"));
        file.add(item = new JMenuItem("退出"));

        menuBar.add(edit);
        edit.add(item = new JMenuItem("查找"));
        edit.add(item = new JMenuItem("替换"));


        menuBar.add(view);
        view.add(item = new JMenuItem("字体"));
        view.add(item = new JMenuItem("颜色"));


        window.setLayout(new BorderLayout(2,1));
        window.add(menuBar,BorderLayout.NORTH);
        window.add(scrollRight,BorderLayout.CENTER);

        window.pack();
        window.setVisible(true);
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
