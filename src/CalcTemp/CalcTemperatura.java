package CalcTemp;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CalcTemperatura extends JPanel {
    public CalcTemperatura() {
        super();

        // Setando Layout (modificou o Layout do Frame)
        this.setLayout(new GridBagLayout());
        GridBagConstraints elemento = new GridBagConstraints();

        // Temperatura de cima
        elemento.fill = GridBagConstraints.BOTH;
        elemento.weightx = 4;
        elemento.weighty = 2;
        elemento.gridx = 0;
        elemento.gridy = 0;
        elemento.gridwidth = 4;
        elemento.gridheight = 1;
        this.add(new TemperaturaTop(), elemento);

        // Botão para converter temperatura
        elemento.fill = GridBagConstraints.HORIZONTAL;
        elemento.weightx = 2;
        elemento.weighty = 5;
        elemento.gridx = 0;
        elemento.gridy = 0;
        elemento.gridwidth = 1;
        elemento.gridheight = 1;
        this.add(new JButton("CONVERTER"), elemento);

        // Temperatura de baixo
        elemento.fill = GridBagConstraints.BOTH;
        elemento.weightx = 4;
        elemento.weighty = 2;
        elemento.gridx = 0;
        elemento.gridy = 1;
        elemento.gridwidth = 4;
        elemento.gridheight = 1;
        this.add(new TemperaturaBottom(), elemento);
    }
}