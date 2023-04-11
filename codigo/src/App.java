 import app.*;

 public class App {

//     public static void metodoLeitura(){
//
//     }

     public static void main(String[] args) throws Exception {

         //Expecificando o nome do arquivo para leitura
         System.out.print("Insira o nome do arquivo>> ");
         String nomeArquivo = MyIO.readString();


         //Lendo Arquivo
         ArquivoTextoLeitura file = new ArquivoTextoLeitura(nomeArquivo);

         String tipoGrafo = file.lerArquivo();

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

         if(tipoGrafo == "D") {
             GrafoDirecionado novoGrafo = new GrafoDirecionado(nomeGrafo);
             while (file.lerArquivo() != "FIM") {
                 entrada = MyIO.readLine();

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
             }
         } else if (tipoGrafo == "N"){
             GrafoNaoDirecionado novoGrafo = new GrafoNaoDirecionado(nomeGrafo);
             while(file.lerArquivo() != "FIM"){
                 entrada = MyIO.readLine();

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
             }
         }

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
                        if (tipoGrafo == "D"){
                            //novoGrafo.subgrafo();
                        }
                        else {
                            //novoGrafo.buscaEmProfundidade();
                        }
                     break;
                 case 2:

                     break;
                 case 0:
                     System.out.println("Finalizando programa.");
                     break;
                 default:
                     System.out.println("Digite uma opção válida.");
             }
         } while (op != 0);

         //Escrever grafo em arquivo .txt

     }
 }
