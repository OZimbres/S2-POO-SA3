package CalcTemp;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class TemperaturaTop extends JPanel{
    // Declarar os Cards
    JPanel caixaSelecao = new JPanel(new CardLayout()); //Criou e já declarou qual layout que vai usar

    final String CELCIUS = "CELCIUS";
    final String FAHRENHEIT = "FAHRENHEIT";
    final String KELVIN = "KELVIN";

    // Componentes controlados pelo CardLayout
    // Criando os cards
    JPanel cardCelcius = new JPanel(new BorderLayout()); //Criou e já declarou qual layout que vai usar
    JPanel cardFahrenheit = new JPanel(new BorderLayout()); //Criou e já declarou qual layout que vai usar
    JPanel cardKelvin = new JPanel(new BorderLayout()); //Criou e já declarou qual layout que vai usar

    // Criando ComboBox
    public JComboBox<String> comboBox;

    //Criando os campos
    JTextArea campoC;
    JTextArea campoF;
    JTextArea campoK;

    public TemperaturaTop(){
        super();

        this.setLayout(new BorderLayout());

        // Preenchendo cada Card
        // Tem q ter o casting de tipo pra funcionar ( (JComponent) )
        campoC = new JTextArea(new LimitedDocument(32)); // Criando campo para colocar nos cards
        campoC.setLineWrap(true);

        campoF = new JTextArea(new LimitedDocument(32)); // Criando campo para colocar nos cards
        campoF.setLineWrap(true);

        campoK = new JTextArea(new LimitedDocument(32)); // Criando campo para colocar nos cards
        campoK.setLineWrap(true);

        //Definindo a fonte
        Font font = new Font("Arial", Font.BOLD, 40);
        //Setando a fonte no JTextArea
        campoC.setFont(font);
        campoF.setFont(font);
        campoK.setFont(font);

         // Scroll caso o número seja muito grande
        JScrollPane areaScrollC = new JScrollPane(campoC);
        JScrollPane areaScrollF = new JScrollPane(campoF);
        JScrollPane areaScrollK = new JScrollPane(campoK);

        areaScrollC.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        areaScrollF.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        areaScrollK.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        ((JComponent) cardCelcius.add(areaScrollC)).setBorder(new LineBorder(Color.BLACK));


        ((JComponent) cardFahrenheit.add(areaScrollF)).setBorder(new LineBorder(Color.BLACK));


        ((JComponent) cardKelvin.add(areaScrollK)).setBorder(new LineBorder(Color.BLACK));

        // Criando a caixa de selecão
        caixaSelecao.add(cardCelcius, CELCIUS);
        caixaSelecao.add(cardFahrenheit, FAHRENHEIT);
        caixaSelecao.add(cardKelvin, KELVIN);

        //Coloca a JComboBox em uma JPanel pra ficar mais bonito
        JPanel comboBoxPane = new JPanel(); //Usar flowlayout
        String comboBoxItens[] = {CELCIUS, FAHRENHEIT, KELVIN};
        comboBox = new JComboBox<String>(comboBoxItens);
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
