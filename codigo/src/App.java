import java.util.List;

import app.*;

public class App {

    public static void main(String[] args) throws Exception {

        //Expecificando o nome do arquivo para leitura
        System.out.print("Insira o nome do arquivo>> ");
        String nomeArquivo = MyIO.readString();


        //Lendo Arquivo
        ArquivoTextoLeitura file = new ArquivoTextoLeitura(nomeArquivo);

        String tipoGrafo = file.ler();

        String entrada;

        //expecificações arquivo
//        - primeira linha deve conter char que declara o tipo do grafo
//        - segunda linha pra frente, tipo de leitura "x;y;z"
//        - x → origem / y → destino / z → peso
//        - é realizado um Split a cada ";" e valores são atribuídos a variáveis "origem", "desino", "peso"
//        - caso origem e destino existam, criar aresta
//        - caso não existam, criar vértices com o respectivo id e criar aresta
//        - ao final um flag "FIM" interrompendo leitura


        //Definindo o nome do grafo
        System.out.print("Insira o nome do Grafo>> ");
        String nomeGrafo = MyIO.readString();
        
        GrafoMutavel novoGrafo1 = null;

        if(tipoGrafo == "D") {
            GrafoDirecionado novoGrafo = new GrafoDirecionado(nomeGrafo);
            entrada = file.ler();

            while (file.ler() != "FIM") {

                int origem = Integer.parseInt(entrada.split(";")[0]);
                if (novoGrafo.existeVertice(origem) == null) {
                    novoGrafo.addVertice(origem);
                }
                int destino = Integer.parseInt(entrada.split(";")[1]);
                if (novoGrafo.existeVertice(destino) == null) {
                    novoGrafo.addVertice(origem);
                }
                int peso = Integer.parseInt(entrada.split(";")[2]);

                novoGrafo.addAresta(origem, destino, peso);
                
                entrada = file.ler();
            }
            
            novoGrafo1 = novoGrafo;
        } else if (tipoGrafo == "N"){
            GrafoNaoDirecionado novoGrafo = new GrafoNaoDirecionado(nomeGrafo);
            entrada = file.ler();

            while(file.ler() != "FIM"){

                int origem = Integer.parseInt(entrada.split(";")[0]);
                if (novoGrafo.existeVertice(origem) == null){
                    novoGrafo.addVertice(origem);
                }
                int destino = Integer.parseInt(entrada.split(";")[1]);
                if (novoGrafo.existeVertice(destino) == null){
                    novoGrafo.addVertice(origem);
                }
                int peso = Integer.parseInt(entrada.split(";")[2]);

                novoGrafo.addAresta(origem,destino,peso);
                
                entrada = file.ler();
            }
            
            novoGrafo1 = novoGrafo;
        }

        file.fecharArquivo();

        System.out.println("=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("[1]Imprimir subgrafo");
        System.out.println("[2]Busca em profundidade");
        System.out.println("[0]Finalizar programa");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=");
        System.out.print(">> ");

        int op = MyIO.readInt();

        do {
            switch (op) {
                case 1:
                    int op2 = 1;
                    Lista<Integer> vert = new Lista<Integer>();

                    while (op2 != 0){
                        System.out.print("Escreva quais vertices deseja (Digite 0 para encerrar)>> ");
                        op2 = MyIO.readInt();
                        vert.add(op2);
                    }
                    
                    novoGrafo1.subGrafo(vert);
                    break;
                case 2:
                    novoGrafo1.BFS();
                    break;
                case 0:
                    System.out.println("Finalizando programa.");
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        } while (op != 0);

        novoGrafo1.salvar("arqParaEscrita");
        System.out.println("Grafo Salvo.");
    }
}
