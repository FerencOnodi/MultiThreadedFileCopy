import javax.swing.*;

/**
 * Created by ferenc on 2017.06.08..
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainDialog();
            }
        });

    }
}
