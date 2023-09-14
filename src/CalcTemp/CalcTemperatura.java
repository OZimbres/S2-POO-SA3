package CalcTemp;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CalcTemperatura extends JPanel {
    public CalcTemperatura() {
        super();

        // Setando Layout (modificou o Layout do Frame)
        this.setLayout(new GridBagLayout());
        GridBagConstraints elemento = new GridBagConstraints();

        // Temperatura de cima
        elemento.weightx = 1;
        elemento.weighty = 3;
        elemento.gridx = 0;
        elemento.gridy = 0;
        elemento.fill = GridBagConstraints.BOTH;
        this.add(new TemperaturaTop(), elemento);

        // Botão para converter temperatura
        JButton converter = new JButton("CONVERTER");
        elemento.weightx = 1;
        elemento.weighty = 1;
        elemento.gridx = 0;
        elemento.gridy = 1;
        elemento.fill = GridBagConstraints.NONE;
        this.add(converter, elemento);

        // Temperatura de baixo
        elemento.weightx = 1;
        elemento.weighty = 3;
        elemento.gridx = 0;
        elemento.gridy = 2;
        elemento.fill = GridBagConstraints.BOTH;
        this.add(new TemperaturaBottom(), elemento);
        
        // Fazendo a conversão quando clicar no botão
        converter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
}