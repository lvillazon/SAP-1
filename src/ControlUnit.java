import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class ControlUnit extends Module implements ItemListener {
    // implements all the control signals
    // and for debugging, allows them to be manually set
    public enum Flag {
        HALT,
        MEM_IN,
        ADD_IN,
        MEM_OUT,
        INS_OUT,
        INS_IN,
        A_REG_IN,
        A_REG_OUT,
        ALU_OUT,
        SUBTRACT,
        B_REG_IN,
        OUTPUT,
        PC_EN,
        PC_OUT,
        JUMP
    }
    private static ArrayList<Boolean> flags;
    private static ArrayList<JCheckBox> flagBoxes;

    public ControlUnit() {
        super("control flags");
        flags = new ArrayList<>();
        flagBoxes = new ArrayList<>();
        getUI().setLayout(new GridLayout(0, 2));
        for (Flag f: Flag.values()) {
            JCheckBox box = new JCheckBox();
            box.addItemListener(this);
            box.setText(f.name());
            flagBoxes.add(box);
            flags.add(false);
            getUI().add(box);
        }
    }

    public static boolean get(Flag f) {
        return flags.get(f.ordinal());
    }

    public static void set(Flag f, boolean state) {
        flags.set(f.ordinal(), state);
        flagBoxes.get(f.ordinal()).setSelected(state);
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        // sync the boolean flags with the checkbox state
        for (int i= 0; i<flagBoxes.size(); i++) {
            JCheckBox cb = flagBoxes.get(i);
            flags.set(i, cb.isSelected());
        }
        display();
    }

    @Override
    public void display() {
        // console output for the module
        // overridden, because this modules doesn't have a simple 8-bit state value
        System.out.print("flags: ");
        int i = 0;
        for (Flag f: Flag.values()) {
            System.out.print(f.name() + "=");
            if (flags.get(i)) {
                System.out.print("1, ");
            } else {
                System.out.print("0, ");
            }
            i++;
        }
        System.out.println();
    }
}
