import java.awt.*;
import java.awt.event.*;
public class ControlFrame {
    ControlFrame() {
        Simulation projectile = new Simulation();
        Frame controlFrame = new Frame("Control Frame");
        controlFrame.setLayout(new GridLayout(0, 1));
        controlFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        Panel controlPanel = new Panel();
        DoubleScroller angleScroller = new DoubleScroller("Launch angle in degrees = ", 0, 90, 1, 45 );
        DoubleScroller dragScroller = new DoubleScroller("Launch drag in 1/m = ", 0, 2, 0.005, 1 );
        DoubleScroller speedScroller = new DoubleScroller("Launch speed in m/s = ", 0, 50, 1, 10 );
        Button launchButton = new Button("Launch");
        launchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                projectile.launch(dragScroller.getValue(), speedScroller.getValue(), angleScroller.getValue());
            }
        });
        controlPanel.add(launchButton);
        controlFrame.add(controlPanel);
        controlFrame.add(dragScroller);
        controlFrame.add(speedScroller);
        controlFrame.add(angleScroller);
        controlFrame.pack();
        controlFrame.setVisible(true);
    }
}
