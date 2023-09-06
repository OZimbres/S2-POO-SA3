package Calculadora;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Botoes extends JPanel {
    public Botoes() {
        super();
        
        this.setLayout(new GridLayout(4,4));

        for(int i = 0; i < 16; i++){
            this.add(new JButton(""+ i));
        }
    }
}
