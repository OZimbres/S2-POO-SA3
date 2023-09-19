package CalcTemp;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CalcTemperatura extends JPanel {
    //Importando a lógica
    CalcTempController controller = new CalcTempController(new TemperaturaTop(), new TemperaturaBottom());

    // Declarando Objeto
    TemperaturaTop tempTop = new TemperaturaTop();
    TemperaturaBottom tempBottom = new TemperaturaBottom();

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
        this.add(tempTop, elemento);

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
        this.add(tempBottom, elemento);
        
        // Fazendo a conversão quando clicar no botão
        converter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    //Pegando o tipo de temperatura ativa
                    String opcaoTop = tempTop.comboBox.getSelectedItem().toString();
                    String opcaoBottom = tempBottom.comboBox.getSelectedItem().toString();

                    String resultado;

                    switch (opcaoTop) {
                        case "CELCIUS":
                            String valorCampoC = tempTop.campoC.getText();
                            resultado = controller.Converter(opcaoTop, opcaoBottom, valorCampoC);
                            
                            switch(opcaoBottom){
                                case "CELCIUS":
                                    tempBottom.campoC.setText(resultado);
                                    break;

                                case "FAHRENHEIT":
                                    tempBottom.campoF.setText(resultado);
                                    break;

                                case "KELVIN":
                                    tempBottom.campoK.setText(resultado);
                                    break;
                            }
                            break;

                        case "FAHRENHEIT":
                            String valorCampoF = tempTop.campoF.getText();
                            resultado = controller.Converter(opcaoTop, opcaoBottom, valorCampoF);
                            
                            switch(opcaoBottom){
                                case "CELCIUS":
                                    tempBottom.campoC.setText(resultado);
                                    break;

                                case "FAHRENHEIT":
                                    tempBottom.campoF.setText(resultado);
                                    break;

                                case "KELVIN":
                                    tempBottom.campoK.setText(resultado);
                                    break;
                            }
                            break;

                        case "KELVIN":
                            String valorCampoK = tempTop.campoK.getText();
                            resultado = controller.Converter(opcaoTop, opcaoBottom, valorCampoK);
                            
                            switch(opcaoBottom){
                                case "CELCIUS":
                                    tempBottom.campoC.setText(resultado);
                                    break;

                                case "FAHRENHEIT":
                                    tempBottom.campoF.setText(resultado);
                                    break;

                                case "KELVIN":
                                    tempBottom.campoK.setText(resultado);
                                    break;
                            }
                            break;
                    }

                } catch (Exception exception){
                    tempBottom.campoC.setText("Insira um valor válido");
                    tempBottom.campoF.setText("Insira um valor válido");
                    tempBottom.campoK.setText("Insira um valor válido");
                }
                
            }
        });
    }
}