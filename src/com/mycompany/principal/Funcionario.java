/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.principal;
public class Funcionario extends Pessoa {

    //Atributos
    private String Especialidade;
    private String telefone;

    //contrutor com elementos da classe mae
    public Funcionario(String nome, String cep, String Especialidade, String telefone, String cpf, String idade) {
        super(nome, cep, cpf, idade);
        this.Especialidade = Especialidade;
        this.telefone = telefone;
    }

    public String getEspecialidade() {
        return Especialidade;
    }

    public void setEspecialidade(String Especialidade) {
        this.Especialidade = Especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String ImprimirFuncionario() { // funcao imprimir invocando metodos da classe mãe
        String impressao = "";
        impressao += super.imprimir();
        impressao += Principal.ANSI_CYAN+"\nEspecialidade: " + Principal.ANSI_RESET+this.Especialidade;

        return impressao;
    }

    public String ImprimirFuncionarioCompleto() { // funcao imprimir completo invocando metodos da classe mãe
        String impressao = "";
        impressao += super.imprimirCompleto();
        impressao += Principal.ANSI_CYAN+"\nEspecialidade: " + Principal.ANSI_RESET+this.Especialidade + Principal.ANSI_CYAN+"\nTelefone:" + Principal.ANSI_RESET+this.telefone;

        return impressao;
    }

}
