package Calculadora;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class Visor extends JPanel {
    public Visor() {
        super();

        this.setLayout(new BorderLayout());

        this.add(new JTextArea(5, 50));

        this.setBorder(new EtchedBorder());
    }
}
