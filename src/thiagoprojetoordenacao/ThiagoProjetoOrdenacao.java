
package thiagoprojetoordenacao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 Thiago Luiz Pereira Nunes Matricula: 11414864
 */
public class ThiagoProjetoOrdenacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BufferedReader br = null;
        //String everything = new String();
        ArrayList<Aluno> matriculados = new ArrayList();
        //URL location = null;
        try {
            
            //location = ThiagoProjetoOrdenacao.class.getProtectionDomain().getCodeSource().getLocation();
            
            String workingDir = System.getProperty("user.dir");
            
            //Alterar Path do arquivo 
            
            if(args.length != 0) {
                
                //Passar Path do Arquivo como parâmetro
                br = new BufferedReader(new FileReader(args[0]));
            } else {
                //Path do diretorio do projeto
                br = new BufferedReader(new FileReader(workingDir+ "/db_1.txt"));
            }
            
            String line = br.readLine();
            
            while(line != null){
                String[] tokens = line.split(",");
                Aluno aluno = new Aluno(Integer.parseInt(tokens[0]), tokens[1], tokens[2]);
                matriculados.add(aluno);
                line = br.readLine();
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger("Erro leitura arquivos TXT");
            Logger.getLogger(ThiagoProjetoOrdenacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger("Erro linha arquivo TXT");
            Logger.getLogger(ThiagoProjetoOrdenacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger("Erro close buffer reader");
                Logger.getLogger(ThiagoProjetoOrdenacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for(int i=0; i<matriculados.size(); i++){
            System.out.println(matriculados.get(i).getNome()+ " "+matriculados.get(i).getMatricula());
        }
        System.out.println("");
        
        final long startTime = System.currentTimeMillis();
        matriculados = new AlgorithmSort().bubblerSort(matriculados);
        //matriculados = new AlgorithmSort().selectionSort(matriculados);
        //matriculados = new AlgorithmSort().insertionSort(matriculados);
        //matriculados = new AlgorithmSort().shellSort(matriculados);
        final long endTime = System.currentTimeMillis();
        
        System.out.println("");
        System.out.println("Time of execution algorithm: "+ (endTime - startTime) +" milliseconds");
        System.out.println("");
        
        for(int i=0; i<matriculados.size(); i++){
            System.out.println(matriculados.get(i).getNome()+ " "+matriculados.get(i).getMatricula());
        }
        
        
        System.out.println("");
        System.out.println("#####################BubbleSort##############################");
        System.out.println("O bubble sort, ou ordenação por flutuação,");
        System.out.println("é um algoritmo de ordenação dos mais simples.");
        System.out.println("A ideia é percorrer o vector diversas vezes, ");
        System.out.println("a cada passagem fazendo flutuar para o topo o ");
        System.out.println("maior elemento da sequência. No melhor caso, o algoritmo");
        System.out.println("executa n operações relevantes, onde n representa o número");
        System.out.println("de elementos do vector. No pior caso, são feitas n^2 operações.");
        System.out.println("");
        
        System.out.println("");
        System.out.println("#####################SelectionSort###########################");
        System.out.println("A ordenação por seleção é um algoritmo de ordenação ");
        System.out.println("baseadoem se passar sempre o menor valor do vetor para ");
        System.out.println("a primeira posição(ou o maior dependendo da ordem requerida),");
        System.out.println("depois o de segundo menor valor para a segunda posição,");
        System.out.println("e assim é feito sucessivamente com os (n-1) elementos restantes,");
        System.out.println("até os últimos dois elementos. O algoritmo possui complexidade O(n^2)");
        
        System.out.println("");
        System.out.println("#####################InsertSort##############################");
        System.out.println("Insertion sort, ou ordenação por inserção, é um simples algoritmo de ");
        System.out.println("ordenação, eficiente quando aplicado a um pequeno número de elementos.");
        System.out.println("Em termos gerais, ele percorre um vetor de elementos da esquerda ");
        System.out.println("para a direita e à medida que avança vai deixando os elementos mais à ");
        System.out.println("esquerda ordenados. Menor número de trocas e comparações entre os algoritmos");
        System.out.println("de ordenação O(n) quando o vetor está ordenado. Pior caso O(n²)");
        
        System.out.println("");
        System.out.println("#####################ShellSort###############################");
        System.out.println("Shell sort é o mais eficiente algoritmo de classificação dentre os de ");
        System.out.println("complexidade quadrática. É um refinamento do método de inserção direta.");
        System.out.println("Shell sort é uma ótima opção para arquivos de tamanho moderado.");
        System.out.println("Nos grupos menores é aplicado o método da ordenação por inserção.");

        
    }
}
