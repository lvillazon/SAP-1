import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Module {
    /*
    Base class for all hardware modules
    Each one includes a JPanel to provide the UI
     */

    protected SAP computer;  // link to the emulator to access other modules
    private JPanel panel;  // front end

    public Module(String name) {
        this.computer = computer;
        panel = new JPanel();
        Border border = BorderFactory.createLineBorder(Color.black);
        TitledBorder title = BorderFactory.createTitledBorder(border, name);
        title.setTitleJustification(TitledBorder.CENTER);
        panel.setBorder(title);
    }

    public JPanel getUI() {
        return panel;
    }

    public void tick() {
        panel.repaint();
    }
}
