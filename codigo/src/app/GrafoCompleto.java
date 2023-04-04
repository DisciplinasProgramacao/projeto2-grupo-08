package app;

public class GrafoCompleto extends Grafo {

    public GrafoCompleto(String nome) {
        super(nome);
    }

    @Override
    public Grafo grafoCompleto(int ordem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'grafoCompleto'");
    }

    // @Override
    // public Grafo grafoCompleto(int ordem) {
        
    //     GrafoCompleto grafo = new GrafoCompleto("Grafo completo de ordem: " + ordem);
        
    //     for(int i = 0; i < ordem; i++) {
    //         grafo.addVertice(i);
    //     }

    //     for(int i = 0; i < ordem; i++) {
    //         for(int j = 0; j < ordem; j++) {
    //             if (i != j) grafo.addAresta(i, j);
    //         }
    //     }

    //     return grafo;
    // }
    
}
