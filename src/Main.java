import javax.swing.*;

/**
 * Created by ferenc on 2017.06.08..
 */
public class Main {

    public static void main(String[] args) {
        MainDialog mainDialog = new MainDialog();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainDialog.showButton();
            }
        });

    }
}
