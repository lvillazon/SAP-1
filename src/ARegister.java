public class ARegister extends Register {

    public ARegister() {
        super("A");
    }

    @Override
    public void tick() {
        // read/write the bus depending on flag status
        if (isSet(ControlUnit.Flag.A_REG_IN)) {
            setState(busRead());
        }
        if (isSet(ControlUnit.Flag.A_REG_OUT)) {
            busWrite(getState());
        }
        super.tick();
    }

}
