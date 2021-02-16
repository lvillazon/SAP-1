import javax.swing.*;
import java.awt.*;

public class SAP_GUI {
    // provides the front end for the emulator
    private final int WIDTH = 600;
    private final int HEIGHT = 600;

    public enum Position {LEFT, CENTRE, RIGHT}
    private JFrame frame;
    private JPanel lefthandSide;
    private JPanel righthandSide;
    private JPanel centre;

    public SAP_GUI() {
        // create the container for all the computer modules
        // each module is repsonsible for its own UI
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLayout(new GridLayout(0,3, 5, 5));
        lefthandSide = new JPanel();
        righthandSide = new JPanel();
        centre = new JPanel();
        lefthandSide.setLayout(new GridLayout(0,1));
        righthandSide.setLayout(new BoxLayout(righthandSide,BoxLayout.PAGE_AXIS));
        centre.setLayout(new GridLayout(0,1));
        frame.add(lefthandSide);
        frame.add(centre);
        frame.add(righthandSide);
        frame.setVisible(true);
    }

    public void add(Position p, Module m) {
        // place the JPanel containing the module UI
        // into the correct column of the frame
        switch (p) {
            case LEFT:
                lefthandSide.add(m.getUI());
                break;
            case CENTRE:
                centre.add(m.getUI());
                break;
            case RIGHT:
                righthandSide.add(m.getUI());
                break;
        }
        frame.revalidate();
    }
}
