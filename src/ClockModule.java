import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockModule extends Module implements ActionListener {

    private final int MARGIN = 20;
    private final int BUTTON_WIDTH = 100;
    private final int BUTTON_HEIGHT = 30;
    private JButton step;  // single steps the clock

    public ClockModule(SAP computer) {
        super(computer);
        step = new JButton("single step");
        step.setBounds(MARGIN, MARGIN, BUTTON_WIDTH, BUTTON_HEIGHT);
        step.addActionListener(this);
        panel.add(step);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("single step")) {
            computer.tick();
        }
    }


}
