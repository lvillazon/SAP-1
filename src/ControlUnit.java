import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ControlUnit extends Module {
    // implements all the control signals
    // and for debugging, allows them to be manually set
    public enum Flag {
        HALT,
        MEM_IN,
        ADDRESS_IN,
        MEM_OUT,
        INSTRUCTION_OUT,
        INSTRUCTION_IN,
        A_REG_IN,
        A_REG_OUT,
        ALU_OUT,
        SUBTRACT,
        B_REG_IN,
        OUTPUT,
        PC_ENABLE,
        PC_OUT,
        JUMP
    }
    private ArrayList<JCheckBox> flagBoxes;

    public ControlUnit() {
        super("control flags");
        flagBoxes = new ArrayList<>();
        getUI().setLayout(new GridLayout(0, 2));
        for (Flag f: Flag.values()) {
            JCheckBox box = new JCheckBox();
            box.setText(f.name());
            flagBoxes.add(box);
            getUI().add(box);
        }

    }
}
