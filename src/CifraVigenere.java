import javax.swing.JOptionPane;

public class CifraVigenere {
    public static void main(String[] args) throws Exception {
        String[] options = {"Cifrar", "Decifrar"};
        int escolha = JOptionPane.showOptionDialog(
            null,
            "O que você deseja fazer?",
            "Cifra de Vigenère",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]
        );

        String texto = JOptionPane.showInputDialog(
            "Digite o texto:"
        );
        String chave = JOptionPane.showInputDialog(
            "Digite a chave:"
        );

        texto = texto.toUpperCase();
        chave = chave.toUpperCase();

        StringBuilder resultado = new StringBuilder();

        if (escolha == 0) {
            // Cifragem
            for (int i = 0, j = 0; i < texto.length(); i++) {
                char letraOriginal = texto.charAt(i);
                if (Character.isLetter(letraOriginal)) {
                    char letraChave = chave.charAt(j % chave.length());
                    char letraCifrada = (char) ((letraOriginal + letraChave - 2 * 'A') % 26 + 'A');
                    resultado.append(letraCifrada);
                    j++;
                } else {
                    resultado.append(letraOriginal);
                }
            }
            JOptionPane.showMessageDialog(
                null,
                "Texto Original: " + texto +
                "\nChave: " + chave +
                "\nTexto Cifrado: " + resultado.toString()
            );
        } else if (escolha == 1) { 
            // Decifragem
            for (int i = 0, j = 0; i < texto.length(); i++) {
                char letraCifrada = texto.charAt(i);
                if (Character.isLetter(letraCifrada)) {
                    char letraChave = chave.charAt(j % chave.length());
                    char letraDecifrada = (char) ((letraCifrada - letraChave + 26) % 26 + 'A');
                    resultado.append(letraDecifrada);
                    j++;
                } else {
                    resultado.append(letraCifrada);
                }
            }
            JOptionPane.showMessageDialog(
                null,
                "Texto Cifrado: " + texto +
                "\nChave: " + chave +
                "\nTexto Decifrado: " + resultado.toString()
            );
        }
    }
}
