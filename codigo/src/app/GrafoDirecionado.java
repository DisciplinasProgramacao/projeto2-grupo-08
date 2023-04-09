package app;

public class GrafoDirecionado extends GrafoMutavel{

    public GrafoDirecionado(String nome) {
        super(nome);
    }

    /**
     * Adiciona uma aresta entre dois vértices do grafo, caso os dois vértices existam no grafo. 
     * Caso a aresta já exista, ou algum dos vértices não existir, o comando é ignorado e retorna FALSE.
     * @param origem Vértice de origem
     * @param destino Vértice de destino
     * @param peso Peso da aresta
     * @return TRUE se foi inserida, FALSE caso contrário
     */
    @Override
    public boolean addAresta(int origem, int destino, int peso){
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if(saida!=null && chegada !=null){
            adicionou = saida.addAresta(destino, peso);
        }
        return adicionou;
    }
    
    @Override
    public boolean addAresta(int origem, int destino){
        return this.addAresta(origem, destino, 0);
    }

    @Override
    public Aresta removeAresta(int origem, int destino){
        Vertice saida = this.existeVertice(origem);
        Vertice entrada = this.existeVertice(destino);

        if(saida!=null && entrada != null){
            return saida.removeAresta(destino);
        }

        return null;
    }
    
}
