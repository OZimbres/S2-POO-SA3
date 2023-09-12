package CalcTemp;

import java.awt.BorderLayout;

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
