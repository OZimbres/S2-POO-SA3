package CalcTemp;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TemperaturaTop extends JPanel{
    // Declarar os Cards
    JPanel caixaSelecao = new JPanel(new CardLayout()); //Criou e já declarou qual layout que vai usar

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

        // Preenchendo cada Card
        cardCelcius.add(new JTextArea("celcius"));
        cardFahrenheit.add(new JTextArea("fahrenheit"));
        cardKelvin.add(new JTextArea("kelvin"));

        // Criando a caixa de selecão
        caixaSelecao.add(cardCelcius, CELCIUS);
        caixaSelecao.add(cardFahrenheit, FAHRENHEIT);
        caixaSelecao.add(cardKelvin, KELVIN);

        //Coloca a JComboBox em uma JPanel pra ficar mais bonito
        JPanel comboBoxPane = new JPanel(); //Usar flowlayout
        String comboBoxItens[] = {CELCIUS, FAHRENHEIT, KELVIN};
        JComboBox comboBox = new JComboBox(comboBoxItens);
        comboBox.setEditable(false);

        // Funcionalidade para trocar de Item (ao escolher temperatura)
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                CardLayout cl = (CardLayout)(caixaSelecao.getLayout());
                cl.show(caixaSelecao, (String)evt.getItem());
            }
        });

        comboBoxPane.add(comboBox);

        this.add(comboBoxPane, BorderLayout.PAGE_START);
        this.add(caixaSelecao, BorderLayout.CENTER);
    }
}
