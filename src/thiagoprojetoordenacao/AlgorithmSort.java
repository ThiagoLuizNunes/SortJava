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
        
        //Quantidade de trocas
        int changes = 0;
        int i, x;
        
        for(i=0; i<array.size(); i++){
            for(x=0; x<array.size()-1; x++){
                if(array.get(x).getMatricula() > array.get(x+1).getMatricula()){
                    //Aluno a = new Aluno(array.get(x+1).getNome(), array.get(x+1).getMatricula(), array.get(x+1).getData());
                    Aluno aux = array.get(x+1);
                    
                    array.set(x+1, array.get(x));
                    array.set(x, aux);
                    
                    changes++;
                }
            }
        }
        System.out.println("Número de trocas: " + changes);
        return array;
    }
    
    public ArrayList selectionSort(ArrayList<Aluno> array){
        
        //Quantidade de trocas
        int changes = 0;
        int i, x;
        int menor;
        
        for(i=0; i<array.size(); i++){
            menor = array.get(i).getMatricula();
            
            for(x=i+1; x<array.size(); x++){
                if(array.get(x).getMatricula() < menor){
                    
                    menor = array.get(x).getMatricula();
                    
                    Aluno aux = array.get(x);
                    array.set(x, array.get(i));
                    array.set(i, aux);
                    changes++;
                }
            }
        }
        System.out.println("Número de trocas: " + changes);
        return array;
    }
    
    public ArrayList insertionSort(ArrayList<Aluno> array){
        //Quantidade de trocas
        int changes = 0;
        int i, x;
        
        for(i=1; i<array.size(); i++){
            Aluno al = array.get(i);
            
            for(x=i-1; x>=0 && array.get(x).getMatricula() > al.getMatricula(); x--){
                array.set(x+1, array.get(x));
                changes++;
            }
            array.set(x+1, al);
            changes++;
        }
        System.out.println("Número de trocas: " + changes);
        return array;
    }
    
    public ArrayList shellSort(ArrayList<Aluno> array){
        
        //Quantidade de trocas
        int changes = 0;
        int i, x, h = 1;
        
        while( h < array.size()){
            h = h*3 +1;
        }
        
        h = (h-1)/3;
        
        Aluno al = null;
        
        while(h > 0){
            for(i=h; i<array.size(); i++){
                
                al = array.get(i);
                x = i;
                
                while(x>=h && array.get(x - h).getMatricula() > al.getMatricula()){
                    array.set(x, array.get(x - h));
                    x = x - h;
                    changes++;
                }
                array.set(x, al);
                changes++;
            }
            h = h/3;
        }
        System.out.println("Número de trocas: " + changes);
        return array;
    }
}
