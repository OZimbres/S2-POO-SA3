package CalcTemp;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitedDocument extends PlainDocument {
    private int maximoCaracteres;
    private String tipoCalculadora;

    public LimitedDocument(int maximoCaracteres, String tipoCalculadora) {
        super();
        this.maximoCaracteres = maximoCaracteres;
        this.tipoCalculadora = tipoCalculadora;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) return; // Não fazer nada caso a string for nula

        if (tipoCalculadora.equals("Temp")) {
            // Verificar se o comprimento da string já "atuante" mais a ser inserida vai ser menor ou igual ao tamanho liberado
            if ((getLength() + str.length()) <= maximoCaracteres) {
                String textoAtual = getText(0, getLength()); // Obtém o texto atual do documento

                // Verifica se já existe um hífen no texto atual
                boolean contemHifen = textoAtual.contains("-");

                // Verificar se são os caracteres permitidos (números ou um único hífen na primeira posição)
                if ((str.equals("-") && (getLength() == 0 || offset == 0)) || (str.matches("[-0-9]+") && (!contemHifen || !str.equals("-")))) {
                    super.insertString(offset, str, attr); // Inserir a string no documento
                }
            }
        } else {
            if ((getLength() + str.length()) <= maximoCaracteres) {
                // Verificar se são os caracteres permitidos (apenas números)
                if (str.matches("[0-9.+\\-*/]")) {
                    super.insertString(offset, str, attr); // Inserir a string no documento
                }
            }
        }
    }
}