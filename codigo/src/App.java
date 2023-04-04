import app.*;
public class App {

      
    public static void main(String[] args) throws Exception {

        //Expecificando o nome do arquivo para leitura
        System.out.print("Insira o nome do arquivo>> ");
        String nomeArquivo = MyIO.readString();

        //Definindo o nome do grafo
        System.out.print("Insira o nome do Grafo>> ");
        String nomeGrafo = MyIO.readString();
        
        int op1;

        do {
            System.out.println("Digite uma das opções abaixo: ");
            System.out.println("[1] Grafo Completo");
            System.out.println("[2] Grafo Mutável");
            System.out.println("[0] Finalizar programa");
            System.out.print(">> ");
            op1 = MyIO.readInt();
            switch (op1){
                case 1:
                    //Inicializado e atribuindo nome ao grafo
                    GrafoCompleto novoGrafoC = new GrafoCompleto(nomeGrafo); 
                    break;
                case 2:
                    int op2;
                    
                    do{
                        System.out.println("Digite uma das opções abaixo: ");
                        System.out.println("[1] Direcionado");
                        System.out.println("[2] Não Direcionado");
                        System.out.println("[0] Finalizar programa");
                        System.out.print(">> ");
                        op2 = MyIO.readInt();

                        switch (op2){
                            case 1:
                                //Inicializado e atribuindo nome ao grafo
                                GrafoDirecionado novoGrafoD = new GrafoDirecionado(nomeGrafo);
                                
                                break;
                            case 2:
                                //Inicializado e atribuindo nome ao grafo
                                GrafoNaoDirecionado novoGrafoND = new GrafoNaoDirecionado(nomeGrafo);
                                
                                break;
                        }
                    }while(op2!=0);
                        
                    
                    break;
                case 0:
                    System.out.println("Finalizando programa.");
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
            }

        }while (1!=0);

    }
}
