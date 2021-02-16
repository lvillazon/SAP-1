import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Module {
    /*
    Base class for all hardware modules
    Each one includes a JPanel to provide the UI
     */

    private JPanel panel;  // front end
    private String name;
    protected byte state;

    public Module(String name) {
        this.name = name;
        state = 0;
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
        // default action for a module is simply to update its output (both GUI and console)
        panel.repaint();
        display();
    }

    public void display() {
        // console output for the module
        System.out.println(name + ": " + state);
    }
}
