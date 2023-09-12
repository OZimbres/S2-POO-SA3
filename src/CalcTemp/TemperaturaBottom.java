package CalcTemp;

import java.awt.BorderLayout;
<<<<<<< HEAD
=======

>>>>>>> 7d75e79bd93cab3c2d009b74912ac79693005fc0
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class TemperaturaBottom extends JPanel {
    public TemperaturaBottom(){
        super();
        this.setLayout(new BorderLayout());

        this.add(new JTextArea(5, 50));

        this.setBorder(new EtchedBorder());
    }
    
}
