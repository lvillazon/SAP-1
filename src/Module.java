import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Module {
    /*
    Base class for all hardware modules
    Each one includes a JPanel to provide the UI
     */

    protected SAP computer;
    protected JPanel panel;  // front end

    public Module(SAP computer) {
        this.computer = computer;
        panel = new JPanel();
        Border border = BorderFactory.createLineBorder(Color.black);
        TitledBorder title = BorderFactory.createTitledBorder(border, "title");
        title.setTitleJustification(TitledBorder.CENTER);
        panel.setBorder(title);
        computer.getGUI().add(panel);  // add the module UI to the frame for the SAP
    }
}
