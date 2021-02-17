public class ALU extends Register {
    // the Arithmetic Logic Unit always holds the sum of the A & B registers
    // the SUBTRACT flag makes it subtract B from A instead
    // the sum is computed instantly
    // but only output to the bus when the clock ticks (if ALU_OUT is set)

    private Register a, b;

    public ALU(Register a, Register b) {
        super("ALU");
        this.a = a;
        this.b = b;
    }

    @Override
    protected byte getState() {
        // add or subtract depending on flag
        //TODO This does not automatically update the label when A or B change - how can I do this?
        if (isSet(ControlUnit.Flag.SUBTRACT)) {
            return (byte) (a.getState() - b.getState());
        }
        return (byte) (a.getState() + b.getState());
    }

    @Override
    public void tick() {
        setState(getState()); // force the GUI label to update
        // output to the bus depending on flag status
        if (isSet(ControlUnit.Flag.ALU_OUT)) {
            busWrite(getState());
        }
        super.tick();
    }

}
