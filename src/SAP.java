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
    private final int WIDTH = 800;
    private final int HEIGHT = 400;

    private JFrame gui;  // front end
    private ClockModule clock;

    private int pc;  // program counter


    public SAP() {
        // initialise registers and RAM to known state

        // create the GUI
        gui = new JFrame();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(WIDTH, HEIGHT);
        gui.setLayout(new GridLayout(0,2, 5, 5));
        clock = new ClockModule(this);
        ClockModule clock2 = new ClockModule(this);
        ClockModule clock3 = new ClockModule(this);
        gui.setVisible(true);
    }

    public JFrame getGUI(){
        return gui;
    }

    public void tick() {
        // generate a "clock pulse" for all connected modules
        //Scanner pause = new Scanner(System.in);
        //pause.nextLine();
        System.out.println("tick");
    }

}
