import app.*;
public class App {

      
    public static void main(String[] args) throws Exception {

        //Expecificando o nome do arquivo para leitura
    	
        System.out.print("Insira o nome do arquivo>> ");
        String nomeArquivo = MyIO.readString();
        
        
        //Lendo Arquivo
        //Arquivo deve conter um caractere declarando o tipo de grafo
        //"C" Completo,"D" Direcionado,"N" Não Direcionado
        //Ler primeira linha Char e atribuir a "tipoGrafo"
        //Padrão ler "xx;xx;xx"
        //Realizar split e alocar 
        /*ArquivoTextoLeitura file = new ArquivoTextoLeitura(nomeArquivo);*/
        Char tipoGrafo;
        
        //Definindo o nome do grafo
        System.out.print("Insira o nome do Grafo>> ");
        String nomeGrafo = MyIO.readString();       
            
            switch (tipoGrafo){
                case C:
                     
                    break;
                case D:
                    
                    break;
                case N:
                	
                	break;
                case F:
                    System.out.println("Finalizando programa.");
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
            }
            
            System.out.println("");
    }
}
