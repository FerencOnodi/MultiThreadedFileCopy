import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    JProgressBar progressBar;
    CopyProgress copyProgress;

    public PopUp() {
        preparePOPUP();
    }

    private void preparePOPUP() {
        mainFrame = new JFrame("Path");
        mainFrame.setSize(400, 150);
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
        fromText = new JTextField("/home/ferenc/Downloads/ideaIU-2016.3.4.tar.gz", 20);
        toText = new JTextField("/home/ferenc/Desktop/1", 20);

        fromPanel.add(from);
        fromPanel.add(fromText);
        toPanel.add(to);
        toPanel.add(toText);
        mainFrame.setVisible(true);
    }

    private void showButton() {
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showProgress();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        mainFrame.setVisible(true);
    }
    public void showProgress() {
        JPanel container = new JPanel();
        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        JButton stopButton = new JButton("Stop");
        container.add(new Label(toText.getText()));
        container.add(progressBar);
        container.add(stopButton);

        MainDialog.progressPanel.add(container);

        MainDialog.progressPanel.validate();
        MainDialog.progressPanel.repaint();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                copyProgress = new CopyProgress(fromText, toText, progressBar);
                copyProgress.execute();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copyProgress.cancel(true);
            }
        });
    }
}