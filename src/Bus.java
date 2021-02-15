import javax.swing.*;
import java.awt.*;

public class Bus extends Module {
    private JLabel stateLabel;  // displays bus value
    private byte state; // the actual bus value

    public Bus() {
        super("bus");
        state = 0;
        stateLabel = new JLabel(Byte.toString(state));
        stateLabel.setVerticalAlignment(JLabel.CENTER);
        stateLabel.setHorizontalAlignment(JLabel.CENTER);
        getUI().setLayout(new BorderLayout());
        getUI().add(BorderLayout.CENTER, stateLabel);
    }

    public byte read() {
        return state;
    }

    public void write(byte value) {
        state = value;
        stateLabel.setText(Byte.toString(value));
        getUI().repaint();
    }
}
