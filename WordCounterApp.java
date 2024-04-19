package codeWithharry;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterApp extends JFrame {
    private JTextArea textArea;
    private JButton countButton;
    private JLabel resultLabel;

    public WordCounterApp() {
        setTitle("Word Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea(10, 40);
        countButton = new JButton("Count Words");
        resultLabel = new JLabel();

        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int wordCount = countWords(text);
                resultLabel.setText("Word count: " + wordCount);
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JScrollPane(textArea));
        panel.add(countButton);
        panel.add(resultLabel);

        add(panel);
        pack();
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    public int countWords(String text) {
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCounterApp();
            }
        });
    }
}
