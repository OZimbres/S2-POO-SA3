package CalcTemp;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class TemperaturaTop extends JPanel implements ItemListener {
    // Declarar os Cards
    JPanel caixaSelecao = new JPanel(new CardLayout());

    final String CELCIUS = "CELCIUS";
    final String FAHRENHEIT = "FAHRENHEIT";
    final String KELVIN = "KELVIN";

    // Componentes controlados pelo CardLayout
    // Criando os cards
    JPanel cardCelcius = new JPanel();
    JPanel cardFahrenheit = new JPanel();
    JPanel cardKelvin = new JPanel();

    public TemperaturaTop(){
        super();

        // Criando a caixa de selecão
        caixaSelecao.add(cardCelcius, CELCIUS);
        caixaSelecao.add(cardFahrenheit, FAHRENHEIT);
        caixaSelecao.add(cardKelvin, KELVIN);

        //Coloca a JComboBox em uma JPanel pra ficar mais bonito
        JPanel comboBoxPane = new JPanel(); //Usar flowlayout
        String comboBoxItens[] = {CELCIUS, FAHRENHEIT, KELVIN};
        JComboBox comboBox = new JComboBox(comboBoxItens);
        comboBox.setEditable(false);
        comboBox.addItemListener(this);
        comboBoxPane.add(comboBox);

        this.add(comboBoxPane, BorderLayout.PAGE_START);
        this.add(caixaSelecao, BorderLayout.CENTER);
    }   
    
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(caixaSelecao.getLayout());
        cl.show(caixaSelecao, (String)evt.getItem());
    }
}
