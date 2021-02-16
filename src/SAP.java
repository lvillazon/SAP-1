public class SAP {
    // emulates the Simple As Possible (SAP-1) computer
    // see https://wisdomstack.blogspot.com/2015/09/overview-of-sap-simple-as-possible-1.html

    // 'modules' emulated from the hardware device
    /*
    Clock - generates clock ticks - may eventually also do rising/falling edges
    Program Counter - counts 0 to 15 and repeats. Can be set to other values
    Accumulator - 8-bit register connected to the bus and ALU
    ALU - either adds or subtracts the contents of B to/from the accumulator
    B-register - 8-bit register to the bus and ALU
    RAM - 16 bytes
    Instruction decoder
    Step counter - cycles through the 6 instruction steps of the Fetch-Execute cycle
    Bus - 8-bits wide
    Control flags
     */
    private final int WIDTH = 600;
    private final int HEIGHT = 600;

    private SAP_GUI gui;  // front end
    private Clock clock;
    private Bus bus;
    private ProgramCounter pc;
    private ControlUnit cu;


    public SAP() {
        // initialise registers and RAM to known state

        // initialise all the modules
        clock = new Clock();
        bus = new Bus();
        cu = new ControlUnit();
        pc = new ProgramCounter(bus, cu);

        // connect up the required modules to the clock signal
        clock.connect(pc);

        createGUI();
    }

    private void createGUI() {
        // GUI initialisation kept here, to make it easy to toggle on/off
        gui = new SAP_GUI();
        // place each module in the correct position on the UI
        gui.add(SAP_GUI.Position.LEFT, clock);
        gui.add(SAP_GUI.Position.RIGHT, pc);
        gui.add(SAP_GUI.Position.CENTRE, bus);

        // placeholder UIs - replace these with actual modules, as they are implemented
        gui.add(SAP_GUI.Position.LEFT, new Module("placeholder Memory address register"));
        gui.add(SAP_GUI.Position.LEFT, new Module("placeholder RAM"));
        gui.add(SAP_GUI.Position.LEFT, new Module("placeholder Instruction register"));
        gui.add(SAP_GUI.Position.LEFT, new Module("placeholder Instruction decoder"));
        gui.add(SAP_GUI.Position.RIGHT, new Module("placeholder A register"));
        gui.add(SAP_GUI.Position.RIGHT, new Module("placeholder ALU"));
        gui.add(SAP_GUI.Position.RIGHT, new Module("placeholder B register"));
        gui.add(SAP_GUI.Position.RIGHT, new Module("placeholder output"));

        gui.add(SAP_GUI.Position.RIGHT, cu);
    }

    public void run() {
        // execute the current program
        clock.tick();
    }

}
