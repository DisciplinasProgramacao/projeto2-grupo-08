package app;

public class GrafoNaoDirecionado extends GrafoMutavel{

    /**
     * Construtor. Cria um grafo vazio com um nome escolhido pelo usuário. Em caso de nome não informado
     * (string vazia), recebe o nome genérico "Grafo"
     *
     * @param nome
     */
    public GrafoNaoDirecionado(String nome) {
        super(nome);
    }
}
