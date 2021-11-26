import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Gui extends JFrame implements ActionListener {


    JTextArea textArea;
    JScrollPane scrollPane;
    JButton jButton;

    public Gui() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Hello GUI");
        this.setLayout(new FlowLayout());
        this.setSize(500,500);
        this.setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial",Font.PLAIN,20));

        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(450,450));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jButton = new JButton("Click Me");
        jButton.addActionListener(this);

        this.add(scrollPane);
        this.add(jButton);
        this.setVisible(true);

    }

    public static void main(String[] args) {

        new Gui();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        textArea.append("123");


        /*if(e.getSource() == button){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(frame);

            if(response == JFileChooser.APPROVE_OPTION){
                Path path = fileChooser.getSelectedFile().toPath();
                try {
                    List<String> list = Files.readAllLines(path);

                    StringBuilder sb = new StringBuilder();
                    sb.append("<html>");
                    for (String s : list) {
                        sb.append(s).append("<br>");
                    }
                    sb.append("</html>");
                    System.out.println(sb.toString());
                    label.setText(sb.toString());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }*/
    }
}
