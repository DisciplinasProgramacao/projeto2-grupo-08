package app;

public class GrafoMutavel extends Grafo{
    /**
     * Construtor. Cria um grafo vazio com um nome escolhido pelo usuário. Em caso de nome não informado
     * (string vazia), recebe o nome genérico "Grafo"
     *
     * @param nome
     */
    public GrafoMutavel(String nome) {
        super(nome);
    }
}
