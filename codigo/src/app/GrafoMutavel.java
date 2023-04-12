package app;

public abstract class GrafoMutavel extends Grafo {

    public GrafoMutavel(String nome) {
        super(nome);
    }

    /**
     * Adiciona um vértice com o id especificado. Ignora a ação e retorna false se já existir
     * um vértice com este id
     * @param id O identificador do vértice a ser criado/adicionado
     * @return TRUE se houve a inclusão do vértice, FALSE se já existia vértice com este id
     */
    @Override
    public boolean addVertice(int id){
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    @Override
    public Vertice removeVertice(int id){
        return this.vertices.remove(id);
    }

    /**
     * Adiciona uma aresta entre dois vértices do grafo, caso os dois vértices existam no grafo. 
     * Caso a aresta já exista, ou algum dos vértices não existir, o comando é ignorado e retorna FALSE.
     * @param origem Vértice de origem
     * @param destino Vértice de destino
     * @param peso Peso da aresta
     * @return TRUE se foi inserida, FALSE caso contrário
     */
    public boolean addAresta(int origem, int destino, int peso){
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if(saida!=null && chegada !=null){
            adicionou = saida.addAresta(destino, peso);
        }
        return adicionou;
    }

    public boolean addAresta(int origem, int destino){
        return this.addAresta(origem, destino, 0);
    }

    public Aresta removeAresta(int origem, int destino){
        Vertice saida = this.existeVertice(origem);

        if(saida!=null){
            return saida.removeAresta(destino);
        }

        return null;
    }

    public void carregar(String nomeArquivo){

    }

    public void salvar(String nomeArquivo){
        ArquivoTextoEscrita arqEscrita = new ArquivoTextoEscrita(nomeArquivo);

        Vertice verticesGrafo[] = new Vertice[ordem()];
        verticesGrafo = this.vertices.allElements(verticesGrafo);
        int origem = 0;
        int destino = 0;
        int peso = 0;

        for(int i = 0; i < ordem(); i++){
            origem = verticesGrafo[i].getId();
            for(int j = 0; j < ordem(); j++) {
                Aresta a = verticesGrafo[i].existeAresta(verticesGrafo[j].getId());
                if(a != null) {
                    destino = verticesGrafo[j].getId();
                    peso = a.peso();
                    arqEscrita.escrever(origem+ ";"+ destino +";"+ peso +";");
                }
            }
        }
        arqEscrita.fecharArquivo();
    }
    
}
