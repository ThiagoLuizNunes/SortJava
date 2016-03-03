/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiagoprojetoordenacao;

/**
 *
 * @author fogo
 */
public class Aluno {
    
    private String nome;
    private int matricula;
    private String data;

    public Aluno(String nome, int matricula, String data) {
        this.nome = nome;
        this.matricula = matricula;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
