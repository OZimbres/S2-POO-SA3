package CalcTemp;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

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

        this.setLayout(new BorderLayout());

        // Preenchendo cada Card
        // Tem q ter o casting de tipo pra funcionar ( (JComponent) )
        JTextArea campo = new JTextArea(); // Criando campo para colocar nos cards
        campo.setLineWrap(true);

        ((JComponent) cardCelcius.add(campo)).setBorder(new LineBorder(Color.BLACK));
        cardCelcius.setBorder(new EtchedBorder());

        ((JComponent) cardFahrenheit.add(new JTextArea(1, 25))).setBorder(new LineBorder(Color.BLACK));
        cardFahrenheit.setBorder(new EtchedBorder());

        ((JComponent) cardKelvin.add(new JTextArea(1, 35))).setBorder(new LineBorder(Color.BLACK));
        cardKelvin.setBorder(new EtchedBorder());

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
