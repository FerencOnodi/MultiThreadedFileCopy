import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by ferenc on 2017.06.08..
 */
public class MainDialog {

    static JFrame mainFrame;
    static JPanel buttonPanel;
    static JPanel progressPanel;
    static JButton copyButton;
    static JButton stopAllButton;

    public MainDialog() {
        prepareGUI();
    }

    private static void prepareGUI() {
        mainFrame = new JFrame("Multi Threaded Copy Application");
        mainFrame.setSize(500, 600);
        mainFrame.setLayout(new GridLayout(2, 1));
        //Exit the application ->
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        progressPanel = new JPanel();
        buttonPanel = new JPanel();

        mainFrame.add(progressPanel);
        mainFrame.add(buttonPanel);
        mainFrame.setVisible(true);
        showButton();
    }

    public static void showButton() {
        copyButton = new JButton("Copy");
        stopAllButton = new JButton("Stop all");

        //Actionlisteners come here
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PopUp();
            }
        });

        buttonPanel.add(copyButton);
        buttonPanel.add(stopAllButton);
        mainFrame.setVisible(true);
    }
}
