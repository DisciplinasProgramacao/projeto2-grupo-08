import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoTextoLeitura {

    private BufferedReader entrada;
    private Grafo grafo;

    public ArquivoTextoLeitura(String nomeArquivo) {
        try {
            entrada = new BufferedReader(new FileReader(nomeArquivo));
        } catch (FileNotFoundException excecao) {
            System.out.println("Arquivo não encontrado");
        }
    }

    public Grafo lerGrafo() throws IOException {
        grafo = new Grafo();

        String tipoGrafo = entrada.readLine();
        if (tipoGrafo.equals("D")) {
            grafo.setTipoGrafo(TipoGrafo.DIGRAFO);
        } else if (tipoGrafo.equals("G")) {
            grafo.setTipoGrafo(TipoGrafo.GRAFO);
        } else {
            System.out.println("Tipo de grafo inválido");
            return null;
        }

        String linha;
        while ((linha = entrada.readLine()) != null) {
            if (linha.equals("FIM")) {
                break;
            }
            String[] valores = linha.split(";");

            String origem = valores[0];
            String destino = valores[1];
            String peso = valores[2];

            if (!grafo.verticeExiste(origem)) {
                grafo.criarVertice(origem);
            }
            if (!grafo.verticeExiste(destino)) {
                grafo.criarVertice(destino);
            }

            grafo.criarAresta(origem, destino, Double.parseDouble(peso));
        }

        return grafo;
    }

    public void fecharArquivo() {
        try {
            entrada.close();
        } catch (IOException excecao) {
            System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);
        }
    }
}
public class ArquivoTextoEscrita {

    private BufferedWriter saida;

    public ArquivoTextoEscrita(String nomeArquivo) {

        try {
            saida = new BufferedWriter(new FileWriter(nomeArquivo)); //pede o nome do arquivo para salvar
        } catch (IOException excecao) {
            System.out.println("Erro de escrita: " + excecao);
        }
    }

    public void fecharArquivo() {

        try {
            saida.close(); //fechamento concluido
        } catch (IOException excecao) {
            System.out.println("Erro no fechamento do arquivo de escrita: " + excecao);
        }
    }

    public void escreverLinha(String texto) {

        try {
            saida.write(texto);
            saida.newLine();
        } catch (IOException excecao) {
            System.out.println("Erro de escrita: " + excecao);
        }
    }
}
