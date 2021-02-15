import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Clock extends Module implements ActionListener {

    private final int MARGIN = 20;
    private final int BUTTON_WIDTH = 100;
    private final int BUTTON_HEIGHT = 30;
    private JButton step;  // single steps the clock
    private ArrayList<Module> connectedModules;  // list of modules that are notified on each tick

    public Clock() {
        super("clock");
        step = new JButton("single step");
        step.setBounds(MARGIN, MARGIN, BUTTON_WIDTH, BUTTON_HEIGHT);
        step.addActionListener(this);
        getUI().add(step);
        connectedModules = new ArrayList<>();
    }

    public void connect(Module m) {
        // add this module to the list that are notified on each tick
        connectedModules.add(m);
    }

    public void tick() {
        // set a clock pulse to all connected modules
        for(Module m: connectedModules) {
            m.tick();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("single step")) {
            tick();
        }
    }


}
