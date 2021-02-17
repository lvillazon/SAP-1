import javax.swing.*;

public class Register extends Module {
    private byte state;  // the value stored in this register
    private JLabel stateLabel;  // displays the value

    public Register(String name) {
        super(name);
        state = 0;
        stateLabel = new JLabel(Byte.toString(state));
        getUI().add(stateLabel);
    }

    @Override
    public void display() {
        // console output of current state
        System.out.println(name + ": " + Byte.toString(state));
    }

    protected byte getState() {
        return state;
    }

    protected void setState(byte value) {
        state = value;
        stateLabel.setText(Byte.toString(state));
        stateLabel.repaint();
    }

    protected void setState(int value) {
        // internally handle casting int parameters to byte
        setState((byte) value);
    }
}
