/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiagoprojetoordenacao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fogo
 */
public class ThiagoProjetoOrdenacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BufferedReader br = null;
        String everything = new String();
        ArrayList<Aluno> matriculados = new ArrayList();
        
        try {

            br = new BufferedReader(new FileReader("/home/fogo/Desktop/alunos"));
            StringBuffer buffer = new StringBuffer();
            String line = br.readLine();
            
            while(line != null){
                String[] tokens = line.split(" ");
                Aluno aluno = new Aluno(tokens[0]+tokens[1], Integer.parseInt(tokens[2]), tokens[3]);
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
        
        matriculados = new AlgorithmSort().bubblerSort(matriculados);
        for(int i=0; i<matriculados.size(); i++){
            System.out.println(matriculados.get(i).getNome()+ " "+matriculados.get(i).getMatricula());
        }
        
    }
    
}
