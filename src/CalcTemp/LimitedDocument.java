package CalcTemp;
//Arquivo que define as regras de limitação de digitação do usuário (permitir apenas números e "-")

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitedDocument extends PlainDocument {
    private int maximoCaracteres;

    public LimitedDocument(int maximoCaracteres) {
        super();
        this.maximoCaracteres = maximoCaracteres;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException{
        if (str == null) return; // Não fazer nada caso a string for nula

        // Verificar se o comprimento da string já "atuante" mais a ser inserida vai ser menor ou igual ao tamanho liberado
        if ((getLength() + str.length()) <= maximoCaracteres) {
            String textoAtual = getText(0, getLength()); // Obtém o texto atual do documento

            // Verifica se já existe um hífen no texto atual
            boolean contemHifen = textoAtual.contains("-");

            // Verificar se são os caracteres permitidos (números ou um único hífen)
            if (str.matches("[-0-9]+") && (!contemHifen || !str.equals("-"))) {
                super.insertString(offset, str, attr); // Inserir a string no documento
            }
        }
    }
}
