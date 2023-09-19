package Calculadora;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Botoes extends JPanel {
    // Importar visor
    private Visor visor;
    private JTextArea visorTextArea;

    private boolean teclaProcessada = false; // Controle pra não ter duplicação na hora de digitar

    // "Histórico" de números para os cálculos
    ArrayList<Float> numeros = new ArrayList<Float>();
    // "Histórico" de operadores para os cálculos
    ArrayList<String> operadores = new ArrayList<String>();

    //Botões
    ArrayList<JButton> botoes = new ArrayList<JButton>(){
        {
            add(new JButton("7"));
            add(new JButton("8"));
            add(new JButton("9"));
            add(new JButton("CLEAR"));
            
            add(new JButton("4"));
            add(new JButton("5"));
            add(new JButton("6"));
            add(new JButton("+"));
            add(new JButton("DEL"));
            
            add(new JButton("1"));
            add(new JButton("2"));
            add(new JButton("3"));
            add(new JButton("-"));
            add(new JButton("="));
            
            add(new JButton("."));
            add(new JButton("0"));
            add(new JButton("/"));
            add(new JButton("*"));

        }
    };


    public Botoes(Visor visor){
        super();

        this.visor = visor;
        this.visorTextArea = visor.visorTextArea;

        this.setLayout(new GridBagLayout());
        // Posições dos botões
        int[][] buttonPositions = {
            {0, 0, 1, 1, 1, 1},
            {1, 0, 1, 1, 1, 1},
            {2, 0, 1, 1, 1, 1},
            {3, 0, 2, 1, 2, 1},

            {0, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1},
            {2, 1, 1, 1, 1, 1},
            {3, 1, 1, 1, 1, 1},
            {4, 1, 1, 1, 1, 1},

            {0, 2, 1, 1, 1, 1},
            {1, 2, 1, 1, 1, 1},
            {2, 2, 1, 1, 1, 1},
            {3, 2, 1, 1, 1, 1},
            {4, 2, 1, 2, 1, 2},

            {0, 3, 1, 1, 1, 1},
            {1, 3, 1, 1, 1, 1},
            {2, 3, 1, 1, 1, 1},
            {3, 3, 1, 1, 1, 1},
        };
        GridBagConstraints elemento = new GridBagConstraints();
        elemento.fill = GridBagConstraints.BOTH;

        for (int i = 0; i < botoes.size(); i++) {
            elemento.gridx = buttonPositions[i][0];
            elemento.gridy = buttonPositions[i][1];
            elemento.gridwidth = buttonPositions[i][2];
            elemento.gridheight = buttonPositions[i][3];
            elemento.weightx = buttonPositions[i][4];
            elemento.weighty = buttonPositions[i][5];

            JButton botao = botoes.get(i);
            botao.setBackground(Color.DARK_GRAY);
            //Definindo a fonte
            Font font = new Font("Arial", Font.BOLD, 24);
            botao.setFont(font); //Setando a fonte no JTextArea
            botao.setForeground(Color.WHITE);// Setando cor do texto

            botoes.get(3).setBackground(Color.RED);
            botoes.get(13).setBackground(Color.GREEN);

            // ActionListener pros botões
            botao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Decisao(botao.getText());
                }
            });

            this.add(botao, elemento);
        }

        //ActionListener, mas agora para o teclado
        visorTextArea.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){} // Não vai precisar

            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    e.consume(); //Cancela a ação padrão do enter
                }
                
                char tecla = e.getKeyChar();
                
                if (TeclaValida(tecla) && !teclaProcessada){
                    teclaProcessada = true;
                    Decisao(String.valueOf(tecla));
                }
            }

            @Override
            public void keyReleased(KeyEvent e){
                teclaProcessada = false;
            }
        });

    }

    private void Decisao(String pressionado){
        float numero;

        String opcoes[] = {"+", "-", "*", "/", ".", "="};

        // Evitar nullPointerException
        String conteudoVisor = visorTextArea.getText();
        int contadorDePonto = 0;

        if(conteudoVisor.equals("")){
            numero = 0f;
        }
        else{
            numero = PegarDigitos(conteudoVisor);
        }

        for (String opcao : opcoes) {
            if(pressionado.equals(opcao)){
                numeros.add(numero);
                operadores.add(opcao);
                contadorDePonto = 0; //Zerando contadorDePonto

                visor.visorTextArea.setText("");
            }
        }

        if(pressionado.equals(".")){
            if(contadorDePonto == 0){
                contadorDePonto++;
                visor.adicionarTexto(pressionado);
            }
        }
        else if(pressionado.equals("=")){
            if(PegarDigitos(conteudoVisor) != 0f){ // se retornar 0 é pq está vazio
                numeros.add(numero);
                contadorDePonto = 0; //Zerando contadorDePonto

                float resultado = Float.parseFloat(Calcular());

                visor.visorTextArea.setText(String.valueOf(resultado));

                // Resetando ArrayList's
                numeros.clear();
                numeros.trimToSize();
                operadores.clear();
                operadores.trimToSize();

                //Pegando o resultado
                numeros.set(0, resultado);
            }
        }
        else if(pressionado.equalsIgnoreCase("CLEAR")){
            contadorDePonto = 0;
            // Resetando ArrayList's
            numeros.clear();
            numeros.trimToSize();
            operadores.clear();
            operadores.trimToSize();

            visor.visorTextArea.setText("");
        }
        else if(pressionado.equalsIgnoreCase("DEL")){
            if(!conteudoVisor.isEmpty()){
                conteudoVisor = conteudoVisor.substring(0, conteudoVisor.length() - 1); // remover o último caractere
                visor.visorTextArea.setText(conteudoVisor);
            }
        }
        else{
            if(!teclaProcessada){
                visor.adicionarTexto(pressionado); // Chame o método no visor para atualizar o texto
            }
        }
    }

    //Função pra limpar os + - . / e pegar apenas o número (em Float)
    private float PegarDigitos(String conteudoVisor) {
        String str = conteudoVisor;
        StringBuilder numero = new StringBuilder();
        String numeroLimpo;
    
        Pattern regex = Pattern.compile("[0-9.]+");
        Matcher matcher = regex.matcher(str);
    
        while (matcher.find()) {
            numero.append(matcher.group());
        }
    
        numeroLimpo = numero.toString();
    
        if (numeroLimpo.isEmpty()) {
            return 0f; // Retorne 0 se não houver dígitos
        }
    
        return Float.parseFloat(numeroLimpo);
    }

    //Função para calcular tudo
    private String Calcular(){
        Float resultado = numeros.get(0);

        for (int i = 0; i < operadores.size(); i++) {
            switch (operadores.get(i)) {
                case "+":
                    resultado += numeros.get(i+1);
                    break;

                case "-":
                    resultado -= numeros.get(i+1);
                    break;

                case "*":
                    resultado *= numeros.get(i+1);
                    break;

                case "/":
                    resultado /= numeros.get(i+1);
                    break;
            
                default:
                    break;
            }
        }

        return String.valueOf(resultado);
    }

    private boolean TeclaValida(char c){
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '.' || c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9';
    }
}
