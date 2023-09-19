package Calculadora;

import java.awt.Color;
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
        elemento.weighty = 1;
        elemento.gridx = 0;
        elemento.gridy = 0;
        elemento.gridwidth = 1;
        elemento.gridheight = 1;
        Visor visor = new Visor();
        this.add(visor, elemento);

        elemento.fill = GridBagConstraints.BOTH;
        elemento.weightx = 1;
        elemento.weighty = 6;
        elemento.gridx = 0;
        elemento.gridy = 1;
        elemento.gridwidth = 1;
        elemento.gridheight = 1;
        Botoes botoes = new Botoes(visor);
        this.add(botoes, elemento);

        this.setBackground(Color.DARK_GRAY);
    }
}