import javax.swing.*;
import java.awt.*;

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

    // the bus is implemented as a static value in the Module class
    // but it also needs a GUI representation, defined here
    private JLabel busLabel;

    private SAP_GUI gui;  // front end
    private static Bus bus;
    private Clock clock;
    private ProgramCounter pc;
    private ControlUnit cu;
    private Register aRegister;
    private Register bRegister;
    private Register alu;


    public SAP() {
        // initialise registers and RAM to known state

        // initialise all the modules
        bus = new Bus();
        clock = new Clock();
        cu = new ControlUnit();
        pc = new ProgramCounter();
        aRegister = new ARegister();
        bRegister = new BRegister();
        alu = new ALU(aRegister, bRegister);

        // connect up the required modules to the clock signal
        clock.connect(pc);
        clock.connect(aRegister);
        clock.connect(bRegister);
        clock.connect(alu);

        createGUI();
    }

    private void createGUI() {
        // GUI initialisation kept here, to make it easy to toggle on/off
        gui = new SAP_GUI();

        // place each module in the correct position on the UI
        gui.add(SAP_GUI.Position.LEFT, clock.getUI());
        gui.add(SAP_GUI.Position.RIGHT, pc.getUI());
        gui.add(SAP_GUI.Position.RIGHT, aRegister.getUI());
        gui.add(SAP_GUI.Position.RIGHT, alu.getUI());
        gui.add(SAP_GUI.Position.RIGHT, bRegister.getUI());

        // create the centre panel to represent the bus, common to all modules
        gui.add(SAP_GUI.Position.CENTRE, bus.getUI());

        // placeholder UIs - replace these with actual modules, as they are implemented
        /*
        gui.add(SAP_GUI.Position.LEFT, new Module("placeholder Memory address register").getUI());
        gui.add(SAP_GUI.Position.LEFT, new Module("placeholder RAM"));
        gui.add(SAP_GUI.Position.LEFT, new Module("placeholder Instruction register"));
        gui.add(SAP_GUI.Position.LEFT, new Module("placeholder Instruction decoder"));

        gui.add(SAP_GUI.Position.RIGHT, new Module("placeholder output"));
*/
        gui.add(SAP_GUI.Position.RIGHT, cu.getUI());
    }

    public void run() {
        // execute the current program
        clock.tick();
    }

}
