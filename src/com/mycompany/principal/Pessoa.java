/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.principal;

public abstract class Pessoa {

    //Atributos
    private String nome;
    private String cep;
    private String cpf;
    private String idade;

    //contrutor
    public Pessoa(String nome, String cep, String cpf, String idade) {
        this.nome = nome;
        this.cep = cep;
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String imprimir() {
        return Principal.ANSI_CYAN+"\nNome: " +Principal.ANSI_RESET+ this.nome + Principal.ANSI_CYAN+"\nIdade: " + Principal.ANSI_RESET+this.idade;
    }

    public String imprimirCompleto() {
        return Principal.ANSI_CYAN+"\nNome: " +Principal.ANSI_RESET+ this.nome + Principal.ANSI_CYAN+"\nIdade: " + Principal.ANSI_RESET+this.idade +Principal.ANSI_CYAN+ "\nCep: " + Principal.ANSI_RESET+this.cep + Principal.ANSI_CYAN+"\nCPF: " +Principal.ANSI_RESET+ this.cpf;
    }

}
