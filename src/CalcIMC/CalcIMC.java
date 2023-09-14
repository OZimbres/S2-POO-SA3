package CalcIMC;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcIMC extends JPanel {
   private JTextField pesoTextField, alturaTextField, resultadoTextField;
    private JButton calcularButton;

    public CalcIMC() {

        JLabel pesoLabel = new JLabel("Peso (kg):");
        JLabel alturaLabel = new JLabel("Altura (m):");
        JLabel resultadoLabel = new JLabel("IMC:");

        pesoTextField = new JTextField();
        alturaTextField = new JTextField();
        resultadoTextField = new JTextField();
        resultadoTextField.setEditable(false);

        calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });

        this.add(pesoLabel);
        this.add(pesoTextField);
        this.add(alturaLabel);
        this.add(alturaTextField);
        this.add(resultadoLabel);
        this.add(resultadoTextField);
        this.add(calcularButton);
    }

    private void calcularIMC() {
        try {
            double peso = Double.parseDouble(pesoTextField.getText());
            double altura = Double.parseDouble(alturaTextField.getText());

            double imc = peso / (altura * altura);

            resultadoTextField.setText(String.format("%.2f", imc));
        } catch (NumberFormatException e) {
            resultadoTextField.setText("Erro");
        }
    }
}
