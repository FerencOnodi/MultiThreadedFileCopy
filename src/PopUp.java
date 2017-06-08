import javax.swing.*;
import java.awt.*;

/**
 * Created by ferenc on 2017.06.08..
 */
public class PopUp extends JDialog {

    private JFrame mainFrame;
    private JPanel fromPanel;
    private JPanel toPanel;
    private JPanel buttonPanel;

    JTextField fromText = null;
    JTextField toText = null;

    public PopUp() {
        preparePOPUP();
    }

    private void preparePOPUP() {
        mainFrame = new JFrame("Path");
        mainFrame.setSize(400, 200);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.setVisible(true);

        fromPanel = new JPanel();
        toPanel = new JPanel();
        buttonPanel = new JPanel();

        mainFrame.add(fromPanel);
        mainFrame.add(toPanel);
        mainFrame.add(buttonPanel);

        showPath();
        showButton();
    }

    private void showPath() {
        JLabel from = new JLabel("From: ", JLabel.LEFT);
        JLabel to = new JLabel("To: ", JLabel.LEFT);
        fromText = new JTextField("", 20);
        toText = new JTextField("", 20);

        fromPanel.add(from);
        fromPanel.add(fromText);
        toPanel.add(to);
        toPanel.add(toText);
        mainFrame.setVisible(true);
    }

    private void showButton() {
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        mainFrame.setVisible(true);
    }
}
