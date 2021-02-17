public class BRegister extends Register {
    // The B register works like the A register, except that it does not output to the bus, only the accumulator

    public BRegister() {
        super("B");
    }

    @Override
    public void tick() {
        // read/write the bus depending on flag status
        if (isSet(ControlUnit.Flag.B_REG_IN)) {
            setState(busRead());
        }
        super.tick();
    }

}
