package Calculadora;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class Visor extends JPanel {
    public Visor() {
        super();

        this.setLayout(new BorderLayout());

        JTextArea visor = new JTextArea();
        visor.setLineWrap(true);
        
        //Definindo a fonte
        Font font = new Font("Arial", Font.BOLD, 40);
        //Setando a fonte no JTextArea
        visor.setFont(font);

        //Setando pra escrever da direita para a esquerda
        visor.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        // Scroll caso o número seja muito grande
        JScrollPane areaScroll = new JScrollPane(visor);
        // Definindo o tipo de scroll
        areaScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        this.add(areaScroll);

        this.setBorder(new EtchedBorder());
    }
}
