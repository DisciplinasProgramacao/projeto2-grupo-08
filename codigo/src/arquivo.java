import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
}

//TESTES

public class ArquivoTextoLeituraTest {

    private ArquivoTextoLeitura arquivoLeitura;

    @Before
    public void setUp() throws Exception {
        arquivoLeitura = new ArquivoTextoLeitura("grafo.txt");
    }

    @After
    public void tearDown() throws Exception {
        arquivoLeitura.fecharArquivo();
    }

    @Test
    public void testLerGrafo() throws IOException {
        Grafo grafo = arquivoLeitura.lerGrafo();

        assertNotNull("Grafo não pode ser nulo", grafo);
        assertEquals("Tipo de grafo deve ser DIGRAFO", TipoGrafo.DIGRAFO, grafo.getTipoGrafo());
        assertTrue("Deve existir um vértice com o nome 'A'", grafo.verticeExiste("A"));
        assertTrue("Deve existir um vértice com o nome 'B'", grafo.verticeExiste("B"));
        assertTrue("Deve existir um vértice com o nome 'C'", grafo.verticeExiste("C"));
        assertTrue("Deve existir um vértice com o nome 'D'", grafo.verticeExiste("D"));
        assertTrue("Deve existir uma aresta entre os vértices 'A' e 'B'", grafo.existeAresta("A", "B"));
        assertTrue("Deve existir uma aresta entre os vértices 'A' e 'C'", grafo.existeAresta("A", "C"));
        assertTrue("Deve existir uma aresta entre os vértices 'C' e 'D'", grafo.existeAresta("C", "D"));
        assertNull("Não deve existir uma aresta entre os vértices 'B' e 'C'", grafo.getAresta("B", "C"));
    }

    @Test
    public void testArquivoInexistente() throws IOException {
        try {
            arquivoLeitura = new ArquivoTextoLeitura("nao_existe.txt");
            fail("Deveria lançar uma exceção");
        } catch (Exception e) {
            assertEquals("Arquivo não encontrado", e.getMessage());
        }
    }

    @Test
    public void testTipoGrafoInvalido() throws IOException {
        BufferedReader entrada = new BufferedReader(new FileReader("tipo_invalido.txt"));
        arquivoLeitura = new ArquivoTextoLeitura("tipo_invalido.txt");
        try {
            arquivoLeitura.lerGrafo();
            fail("Deveria lançar uma exceção");
        } catch (Exception e) {
            assertEquals("Tipo de grafo inválido", e.getMessage());
        } finally {
            entrada.close();
        }
    }
}

public class ArquivoTextoEscritaTest {

    @Test
    void testEscreverLinha() {
        // Cria um arquivo para escrita
        ArquivoTextoEscrita escrita = new ArquivoTextoEscrita("teste.txt");
        
        // Escreve uma linha no arquivo
        escrita.escreverLinha("Testando a escrita de linhas em arquivo.");
        
        // Fecha o arquivo
        escrita.fecharArquivo();
        
        // Lê a linha do arquivo e verifica se é igual ao esperado
        try {
            BufferedReader leitura = new BufferedReader(new FileReader("teste.txt"));
            String linha = leitura.readLine();
            assertEquals("Testando a escrita de linhas em arquivo.", linha);
            leitura.close();
        } catch (IOException e) {
            fail("Erro ao ler o arquivo de teste.");
        }
    }

    @Test
    void testFecharArquivo() {
        // Cria um arquivo para escrita
        ArquivoTextoEscrita escrita = new ArquivoTextoEscrita("teste.txt");
        
        // Fecha o arquivo
        escrita.fecharArquivo();
        
        // Verifica se o arquivo foi fechado corretamente
        try {
            escrita.escreverLinha("Testando a escrita após fechar o arquivo.");
            fail("Não deveria ser possível escrever no arquivo fechado.");
        } catch (IOException e) {
            // Se o arquivo estiver fechado, deve gerar uma exceção ao tentar escrever
        }
    }
}
