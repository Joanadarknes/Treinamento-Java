import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class Mascara {
    public static void main(String[] args) throws IOException {

        // Lita de palavras bloqueadas
        ArrayList<String> palavras = new ArrayList<>();
        palavras.add("banana");
        palavras.add("laranja");
        palavras.add("mexerica");

        String frase = "Fui na feira e comprei laranja, limão e mexerica.";
        String retorno = ""; // "Fui na feira e comprei ****, limão e ****.";

        // Número de elementos na minha lista de restrição
        int qtdLista = palavras.size();

        // Percorrendo "toda a lista de restrições" para descobrir se há ocorrências
        // ATENÇÃO, como é uma "frase", pode ocorrer mais de uma palavra restrita
        do {

            // Percorre a frase em busca de uma palavra restrita
            for (String palavra : palavras) {

                // Se achou, faz a substituição
                if (frase.contains(palavra)) {

                    // Retorna a frase formatada
                    retorno = formataDados(frase, palavra);
                    break;
                }
            }

            // Armazena o resultado no valor original já tratado e faz a avaliação novamente
            // até que o final da lista de restrições seja atingido.
            frase = retorno;
            qtdLista--;
        } while (qtdLista > 0);

        // Mostra a saída formatada
        System.out.println(retorno);
        
        
        // Gravando os dados em um arquivo
        gravaDados(retorno);
    }


    /**
     * 
     * @param frase
     * @param palavra
     * @return frase substituída, caso hajam ocorrências
     */
    public static String formataDados(String frase, String palavra) {
        String mascara = "";

        // Substituição dos caracteres da palavra por asteriscos
        for (int i = 0; i < palavra.length(); i++) {
            mascara += "*";
        }

        // Trocando a palavra e retornando
        frase = frase.replace(palavra, mascara);

        return frase;
    }

    /**
     * 
     * @param frase
     * @throws IOException
     */
    public static void gravaDados(String frase) throws IOException {
        // Nome do arquivo
        File arquivo = new File("chat.txt");

        // cria um arquivo (vazio)
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
        
        // escreve no arquivo
        FileWriter fw = new FileWriter(arquivo, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(frase);
        bw.newLine();
        bw.close();
        fw.close();
    }

}
