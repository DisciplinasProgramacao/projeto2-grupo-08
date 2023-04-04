import app.*;

public class App {


    public static void main(String[] args) throws Exception {

        //Expecificando o nome do arquivo para leitura
        System.out.print("Insira o nome do arquivo>> ");
        String nomeArquivo = MyIO.readString();


        //Lendo Arquivo
        //Arquivo deve conter um caractere declarando o tipo de grafo
        //"D" Direcionado,"N" Não Direcionado
        //Ler primeira linha Char e atribuir a "tipoGrafo"
        //Padrão ler "xx;xx;xx"
        //Realizar split e alocar 
        /*ArquivoTextoLeitura file = new ArquivoTextoLeitura(nomeArquivo);*/

        //Definindo o nome do grafo
        char tipoGrafo = ' ';
        System.out.print("Insira o nome do Grafo>> ");
        String nomeGrafo = MyIO.readString();

        switch (tipoGrafo) {
            case 'D':
                GrafoDirecionado novoGrafoDirecionado = new GrafoDirecionado(nomeGrafo);

                break;
            case 'N':
                GrafoNaoDirecionado novoGrafoNaoDirecionado = new GrafoNaoDirecionado(nomeGrafo);

                break;
            case 'F':
                System.out.println("Finalizando programa.");
                break;
            default:
                System.out.println("Digite uma opção válida.");
        }

        System.out.println("=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Imprimir subgrafo?");
        System.out.println("[1]Sim");
        System.out.println("[2]Finalizar programa");
        System.out.print(">> ");

        int op = MyIO.readInt();

        do {
            switch (op) {
                case 1:
                    
                    break;
                case 2:
                    System.out.println("Finalizando programa.");
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        } while (op != 0);
    }
}

