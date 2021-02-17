import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public abstract class Module {
    /*
    Base class for all hardware modules
    Each one includes a JPanel to provide the UI
     */

    private JPanel panel;  // front end
    protected String name;
//    private static ControlUnit flags;

    public Module(String name) {
        this.name = name;
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

    protected byte busRead() {
        return Bus.read();
    }

    protected void busWrite(byte value) {
        Bus.write(value);
    }

    protected boolean isSet(ControlUnit.Flag f) {
        return ControlUnit.get(f);
    }

    public abstract void display();
}
