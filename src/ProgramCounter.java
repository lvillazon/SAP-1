import javax.swing.*;

public class ProgramCounter extends Register {
    private JLabel stateLabel;  // displays PC value

    public ProgramCounter() {
        super("PC");
    }

    private void increment() {
        // PC currently wraps at 15 because RAM is 16 bytes, so 0-15
        setState((getState() + 1) % 16);
    }

    @Override
    public void tick() {
        // only increment if PC enable flag is set
        if (isSet(ControlUnit.Flag.PC_EN)) {
            increment();
        }
        super.tick();
        // only output to the bus if PC OUT flag is set
        if (isSet(ControlUnit.Flag.PC_OUT)) {
            Bus.write(getState());
        }
    }

}
