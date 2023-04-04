package app;

public class GrafoCompleto extends Grafo {

    public GrafoCompleto(int ordem) {
        super("Grafo completo de ordem: " + ordem);
        
        for(int i = 0; i < ordem; i++) {
            addVertice(i);
        }

        for(int i = 0; i < ordem; i++) {
            for(int j = 0; j < ordem; j++) {
                if (i != j) {
                    Vertice saida = existeVertice(i);
                    Vertice chegada = existeVertice(j);

                    if(saida != null && chegada != null){
                        saida.addAresta(j);
                    }
                }
            }
        }
    }
    
}
