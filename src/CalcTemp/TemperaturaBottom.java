package CalcTemp;

import javax.swing.JPanel;

public class TemperaturaBottom extends JPanel {
    public TemperaturaBottom(){
        super();
        this.setLayout(new BorderLayout());

        this.add(new JTextArea(5, 50));

        this.setBorder(new EtchedBorder());
    }
    
}
