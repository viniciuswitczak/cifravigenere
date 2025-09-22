public class CifraVigenere {
    public static void main(String[] args) throws Exception {
        
        String textoOriginal = "TESTE";
        String chave = "CHAVE";

        StringBuilder textoCifrado = new StringBuilder();

        for (int i = 0, j = 0; i < textoOriginal.length(); i++) {
            char letraOriginal = textoOriginal.charAt(i);
            if (Character.isLetter(letraOriginal)) {
                char letraChave = chave.charAt(j % chave.length());
                char letraCifrada = (char) ((letraOriginal + letraChave - 2 * 'A') % 26 + 'A');
                textoCifrado.append(letraCifrada);
                j++;
            } else {
                textoCifrado.append(letraOriginal);
            }
        }
        
        System.out.println("Texto Original: " + textoOriginal);
        System.out.println("Chave: " + chave);
        System.out.println("Texto Cifrado: " + textoCifrado.toString());
    }
}
