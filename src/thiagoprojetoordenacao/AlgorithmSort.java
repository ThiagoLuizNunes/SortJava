/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiagoprojetoordenacao;

import java.util.ArrayList;

/**
 *
 * @author fogo
 */
public class AlgorithmSort {
    
    
    public ArrayList bubblerSort(ArrayList<Aluno> array){
        
        int i, x;
        
        for(i=0; i<array.size(); i++){
            for(x=0; x<array.size()-1; x++){
                if(array.get(x).getMatricula() > array.get(x+1).getMatricula()){
                    //Aluno a = new Aluno(array.get(x+1).getNome(), array.get(x+1).getMatricula(), array.get(x+1).getData());
                    Aluno a = array.get(x+1);
                    
                    array.set(x+1, array.get(x));
                    array.set(x, a);
                }
            }
        }
        return array;
    }
}
