import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class TextEditor extends Notepad {

    JMenuItem item;
    int exitFlag = -1;

    public TextEditor(){
        init();
        setUI();
    }

    @Override
    public void init() {

        window = new JFrame("Easy NotePad Demo beta1.0");
        window.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        item.addActionListener(this::actionPerformed);
        file.add(item = new JMenuItem("打开"));
        item.addActionListener(this::actionPerformed);
        file.addSeparator();
        file.add(item = new JMenuItem("保存"));
        item.addActionListener(this::actionPerformed);
        file.add(item = new JMenuItem("另存为"));
        item.addActionListener(this::actionPerformed);
        file.addSeparator();
        file.add(item = new JMenuItem("退出"));
        item.addActionListener(this::actionPerformed);

        menuBar.add(edit);
        edit.add(item = new JMenuItem("查找"));
        item.addActionListener(this::actionPerformed);
        edit.add(item = new JMenuItem("替换"));
        item.addActionListener(this::actionPerformed);


        menuBar.add(view);
        view.add(item = new JMenuItem("字体"));
        item.addActionListener(this::actionPerformed);
        view.add(item = new JMenuItem("颜色"));
        item.addActionListener(this::actionPerformed);


        window.setLayout(new BorderLayout(2,1));
        window.add(menuBar,BorderLayout.NORTH);
        window.add(scrollRight,BorderLayout.CENTER);

        window.pack();
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("新建")){
            System.out.println(command);
        }
        if(command.equals("打开")){
            System.out.println(command);
        }
        if(command.equals("保存")){
            System.out.println(command);
        }
        if(command.equals("退出")){
            if(exitAsk() == 1){
                System.exit(0);
            }else{
                return;
            }
        }
    }

    @Override
    public void saveFile(File file) {

    }

    @Override
    public void openFile(File file) {

    }


    public int exitAsk() {
        if (saveFlag) {
            exitFlag = 1;
        } else {
            final JDialog exitDialog = new JDialog(window, "注意");
            exitDialog.add(new JLabel("该文本未被保存，是否保存？"), BorderLayout.CENTER);
            JPanel buttonPanel = new JPanel(new FlowLayout());
            JButton yes = new JButton("是");
            JButton no = new JButton("否");

            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.add(yes);
            buttonPanel.add(no);

            exitDialog.add(buttonPanel,BorderLayout.SOUTH);
            exitDialog.setLocationRelativeTo(window);
            exitDialog.pack();
            exitDialog.setVisible(true);

            yes.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    saveFile(currentFile);
                    saveFlag = true;
                    exitFlag = 1;
                }
            });

            no.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
        }

        return exitFlag;
    }

}
