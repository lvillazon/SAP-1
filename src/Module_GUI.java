import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Module_GUI extends JPanel {
    // simple interface for the different modules

    private SAP emulator;  // link the GUI back to the emulator
    private JFrame frame;
    private final int WIDTH = 500;
    private final int HEIGHT = 400;
    private final int MARGIN = 20;
    private final int BUTTON_WIDTH = 100;
    private final int BUTTON_HEIGHT = 30;
    private final int COLUMN2 = 300;

    private JButton step;
    private JLabel pcLabel; // program counter
    private JLabel[] ramLabel; // memory contents

    public Module_GUI(SAP emulator) {
        this.emulator = emulator;

        frame = new JFrame();
        frame.setSize(WIDTH, HEIGHT);
        frame.setLayout(null);

        // create all GUI widgets
        step = new JButton("single step");
        step.setBounds(MARGIN, MARGIN, BUTTON_WIDTH, BUTTON_HEIGHT);

        frame.add(step);

        pcLabel = new JLabel();
        pcLabel.setBounds(COLUMN2, MARGIN, 150, BUTTON_HEIGHT);
        frame.add(pcLabel);

        // 16 labels for the memory contents
        ramLabel = new JLabel[16];
        for (int i = 0; i < 16; i++) {
            ramLabel[i] = new JLabel();
            ramLabel[i].setBounds(MARGIN, MARGIN + BUTTON_HEIGHT / 2 * (i + 2), BUTTON_WIDTH, BUTTON_HEIGHT);
            frame.add(ramLabel[i]);
        }

        // close program when window closes
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // display the frame
        frame.setVisible(true);
    }

    public void update() {
        // update display to reflect the state of the emulator
        pcLabel.setText("program counter: " );

        // ram
        for (int i = 0; i < 16; i++) {
            ramLabel[i].setText(Integer.toString(i));
        }

        frame.repaint();
    }
}

