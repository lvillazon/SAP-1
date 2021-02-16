import javax.swing.*;

public class ProgramCounter extends Module {
    private JLabel stateLabel;  // displays PC value
    private Bus bus;
    private ControlUnit flags;

    public ProgramCounter(Bus bus, ControlUnit flags) {
        super("PC");
        this.bus = bus;
        this.flags = flags;
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
        // only increment if PC enable flag is set
        if (flags.get(ControlUnit.Flag.PC_EN)) {
            increment();
        }
        super.tick();
        // only output to the bus if PC OUT flag is set
        if (flags.get(ControlUnit.Flag.PC_OUT)) {
            bus.write(state);
        }
    }

}
