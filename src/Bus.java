import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Bus {
    // this behaves a lot like a register, with a single byte value that can be read or set
    // but it is implemented separately as a static class because
    //  a) it appears differently on the UI, and
    //  b) the registers are connected to a bus, but the bus itself, obviously, isn't

    private static JPanel busPanel;
    private static JLabel busLabel;
    private static byte state;

    public Bus() {
        state = 0;
        // this currently copies the look of the Module panel
        // but it doesn't have to - might change it later to something more bus-y
        busPanel = new JPanel();
        Border border = BorderFactory.createLineBorder(Color.black);
        TitledBorder title = BorderFactory.createTitledBorder(border, "bus");
        title.setTitleJustification(TitledBorder.CENTER);
        busPanel.setBorder(title);

        busLabel = new JLabel();
        busLabel.setVerticalAlignment(JLabel.CENTER);
        busLabel.setHorizontalAlignment(JLabel.CENTER);
        busPanel.setLayout(new BorderLayout());
        busPanel.add(BorderLayout.CENTER, busLabel);
    }

    public JPanel getUI() {
        return busPanel;
    }

    public static byte read() {
        return state;
    }

    public static void write(byte value) {
        state = value;
        busLabel.setText(Byte.toString(state));
        busPanel.repaint();
        display();
    }

    public static void display() {
        // console output
        System.out.println("bus: " + Byte.toString(state));
    }
}
