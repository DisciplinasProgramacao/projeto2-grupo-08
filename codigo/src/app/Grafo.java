package app;
/** 
 * MIT License
 *
 * Copyright(c) 2021-23 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

// Quando for não direcionado adicionar duas arestas ou só uma ? Caso adicionarmos somente uma
// precisaremos verificar se ele é ou não direcionado toda vez que formos trabalhar com as arestas

/** 
 * Classe básica para um Grafo simples não direcionado.
 */
public abstract class Grafo {
    public final String nome;
    protected ABB<Vertice> vertices;

    public static Grafo grafoCompleto(int ordem) {
        return new GrafoCompleto(ordem);
    }

    /**
     * Construtor. Cria um grafo vazio com um nome escolhido pelo usuário. Em caso de nome não informado 
     * (string vazia), recebe o nome genérico "Grafo"
     */
    public Grafo(String nome){
        if(nome.length()==0) 
            this.nome = "Grafo";
        else
            this.nome = nome;
        this.vertices = new ABB<>();
    }

    /**
     * Retorna o nome do grafo (string), caso seja necessário em outras classes/sistemas
     * @return O nome do grafo (uma string)
     */
    public String nome(){
        return this.nome;
    }
    
    /**
     * Adiciona um vértice com o id especificado. Ignora a ação e retorna false se já existir
     * um vértice com este id
     * @param id O identificador do vértice a ser criado/adicionado
     * @return TRUE se houve a inclusão do vértice, FALSE se já existia vértice com este id
     */
    public boolean addVertice(int id){
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    public Vertice removeVertice(int id){
        return this.vertices.remove(id);
    }

    public Vertice existeVertice(int idVertice){
        return this.vertices.find(idVertice);
    }

    public Aresta existeAresta(int verticeA, int verticeB){
        Vertice a = this.existeVertice(verticeA);
        Vertice b = this.existeVertice(verticeB);

        if (a != null && b !=null) {
            Aresta a1 = a.existeAresta(verticeB);
            Aresta a2 = b.existeAresta(verticeA);

            if(a1 != null) return a1;
            else if (a2 != null) return a2;
            return null;
        }

       return null;
    }
    
    
    public boolean completo(){
        Vertice v[] = new Vertice[ordem()]; 
        v = this.vertices.allElements(v);

        Aresta a = null;

        // percorrendo grau de cada vertice -> mais vantajoso
        
        for(int i = 0; i < ordem(); i++) {
            for(int j = 0; j < ordem(); j++) {
                if (i != j) {
                    a = v[i].existeAresta(v[j].getId());

                    if (a == null) return false;
                } 
            }
        }

       return (a == null ? false : true);
    }

    // public Grafo subGrafo(Lista<Integer> vertices){
    //     Grafo subgrafo = new Grafo("Subgrafo de "+this.nome);
        
    //     return subgrafo;
    // }
    
    // retorna a quantidade de arestas + a quantidade de vertices (não direcionado como fazer?)
    public int tamanho(){
        int qtdArestas = 0;

        Vertice v[] = new Vertice[ordem()]; 
        v = this.vertices.allElements(v);

        for(int i = 0; i < ordem(); i++) {
            qtdArestas += v[i].grau();
        }

        return (this.ordem() + qtdArestas);
    }
    
    // retorna quantos vertices o grafo tem
    public int ordem(){
        return this.vertices.size();
    }

}
