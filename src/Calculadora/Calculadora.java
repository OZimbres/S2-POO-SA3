package Calculadora;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class Calculadora extends JPanel {
    public Calculadora() {
        super();

        // Setando Layout (modificou o Layout do Frame)
        this.setLayout(new GridBagLayout());
        GridBagConstraints elemento = new GridBagConstraints();

        elemento.fill = GridBagConstraints.BOTH;
        elemento.weightx = 1;
        elemento.weighty = 2;
        elemento.gridx = 0;
        elemento.gridy = 0;
        elemento.gridwidth = 1;
        elemento.gridheight = 1;
        this.add(new Visor(), elemento);

        elemento.fill = GridBagConstraints.BOTH;
        elemento.weightx = 1;
        elemento.weighty = 8;
        elemento.gridx = 0;
        elemento.gridy = 1;
        elemento.gridwidth = 1;
        elemento.gridheight = 1;
        this.add(new Botoes(), elemento);
    }
}