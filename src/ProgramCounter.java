import javax.swing.*;

public class ProgramCounter extends Module {
    private JLabel stateLabel;  // displays PC value
    private byte state; // the actual PC value
    private Bus bus;

    public ProgramCounter(Bus bus) {
        super("PC");
        this.bus = bus;
        state = 0;
        stateLabel = new JLabel(Byte.toString(state));
        getUI().add(stateLabel);
    }

    private void increment() {
        // PC currently wraps at 15 because RAM is 16 bytes, so 0-15
        state = (byte) ((state + 1) % 16);
        stateLabel.setText(Byte.toString(state));
    }

    @Override
    public void tick() {
        // TODO only increment if PC enable flag is set
        increment();
        // TODO only output if PC OUT flag is set
        bus.write(state);
        super.tick();
    }
}
