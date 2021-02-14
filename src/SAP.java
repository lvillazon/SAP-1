
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

    private SAP_GUI gui;  // front end
    private int pc;  // program counter

    public SAP() {
        // initialise registers and RAM to known state

        // create the GUI
        gui = new SAP_GUI(this);
        pc = 0;

        gui.update(); // make sure the display mirrors the emulator
    }

    public void tick() {
        // generate a "clock pulse" for all connected modules
        //Scanner pause = new Scanner(System.in);
        //pause.nextLine();
        System.out.println("tick");
        incrementPC();

        gui.update(); // make sure the display mirrors the emulator
    }

    private void incrementPC() {
        // PC counts from 0 to 15 and then wraps
        pc = (pc + 1) % 16;
    }

    public int getPC() {
        return pc;
    }
}
