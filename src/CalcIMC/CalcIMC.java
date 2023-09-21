package CalcIMC;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcIMC extends JPanel {
    private JTextField pesoTextField, alturaTextField, resultadoTextField;
    private JButton calcularButton;

    public CalcIMC() {

        // Criação dos painéis
        JPanel painelPrincipal = new JPanel(new BorderLayout()); // Border Layout
        JPanel painelBotoes = new JPanel();
        JPanel painelInputs = new JPanel(new GridLayout(1, 1));
        JPanel painelResultado = new JPanel();
        JLabel pesoLabel = new JLabel("Peso (kg):");
        JLabel alturaLabel = new JLabel("Altura (cm):");
        JLabel resultadoLabel = new JLabel("IMC:");

        pesoTextField = new JTextField();
        alturaTextField = new JTextField();
        resultadoTextField = new JTextField();
        calcularButton = new JButton("Calcular");

        // adicionando os componentes aos painéis
        painelInputs.add(alturaLabel);
        painelInputs.add(alturaTextField);
        painelInputs.add(pesoLabel);
        painelInputs.add(pesoTextField);
        painelBotoes.add(calcularButton);
        painelResultado.add(resultadoLabel);
        painelResultado.add(resultadoTextField);

        // adicionando os painéis ao painel principal
        painelPrincipal.add(painelInputs, BorderLayout.NORTH);
        painelPrincipal.add(painelBotoes, BorderLayout.CENTER);
        painelPrincipal.add(painelResultado, BorderLayout.SOUTH);

        this.add(painelPrincipal);
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcIMC();
            }
        });
    }

    private void calcIMC() {
        try {
            double peso = Double.parseDouble(pesoTextField.getText());
            double altura = Double.parseDouble(alturaTextField.getText());

            double imc = peso / ((altura / 100) * (altura / 100));

            resultadoTextField.setText(String.format("%.2f", imc));
            resultadoTextField.setVisible(true);
            resultadoTextField.setEditable(false);
            
        } catch (NumberFormatException e) {
            resultadoTextField.setText("Erro");
        }
    } 
}
