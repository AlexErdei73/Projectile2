import java.awt.*;
import java.awt.event.*;
public class ControlFrame {
    ControlFrame() {
        Simulation projectile = new Simulation();
        Frame controlFrame = new Frame("Control Frame");
        controlFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        Panel controlPanel = new Panel();
        Button launchButton = new Button("Launch");
        launchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                projectile.launch(0.05, 9.8995, 45);
            }
        });
        controlPanel.add(launchButton);
        controlFrame.add(controlPanel);
        controlFrame.pack();
        controlFrame.setVisible(true);
    }
}
