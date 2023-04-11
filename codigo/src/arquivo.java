import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoTextoLeitura {

	private BufferedReader entrada;
	
	ArquivoTextoLeitura(String nomeArquivo) {	
		
		try {
			entrada = new BufferedReader(new FileReader(nomeArquivo)); //pede o nome do arquivo para abrir
		}
		catch (FileNotFoundException excecao) {
			System.out.println("Arquivo nao encontrado"); //se o nome do arquivo estiver errado, ou não existir, mostra o erro
		}
	}
	
	public void fecharArquivo() {
		
		try {
			entrada.close();
		}
		catch (IOException excecao) {
			System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);	//erro para fechar a leitura do arquivo
		}
	}
	
	
	@SuppressWarnings("finally")
	public String lerArquivo() {

		String textoEntrada = null;

		try {
			textoEntrada = entrada.readLine();
			if (textoEntrada.equals("  ")) { // verificando se a última linha foi atingida
				textoEntrada = null;
				return textoEntrada;
			}
		} catch (EOFException excecao) { // Excecao de final de arquivo.
			textoEntrada = null;
		} catch (IOException excecao) {
			System.out.println("Erro de leitura: " + excecao);
			textoEntrada = null;
		} finally {
			return textoEntrada;
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

/*
main seria algo do tipo:


public static void main(String[] args) {
    String nomeArquivo = "meu_grafo.txt";

    // Lê o grafo do arquivo
    ArquivoTextoLeitura leitura = new ArquivoTextoLeitura(nomeArquivo);
    String linha = leitura.lerArquivo();
    while (linha != null && !linha.trim().isEmpty()) {
        // Processa cada linha do grafo
        // ...

        linha = leitura.lerArquivo();
    }
    leitura.fecharArquivo();

    // Faz algumas modificações no grafo
    // ...

    // Sobrescreve o arquivo original com as modificações
    ArquivoTextoEscrita escrita = new ArquivoTextoEscrita(nomeArquivo);
    escrita.escreverArquivo("nova linha 1\n");
    escrita.escreverArquivo("nova linha 2\n");
    escrita.fecharArquivo();
}
 * 
 * 
 * 
 */
