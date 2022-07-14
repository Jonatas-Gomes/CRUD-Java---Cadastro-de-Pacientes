/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.principal;
public class Paciente extends Pessoa {

    private String ServicoRe;
    private String Motivo;

    //contrutor com elementos da classe mae
    public Paciente(String nome, String cep, String ServicoRe, String Motivo, String cpf, String idade) {
        super(nome, cep, cpf, idade);
        this.ServicoRe = ServicoRe;
        this.Motivo = Motivo;
    }

    public String getServicoRe() {
        return ServicoRe;
    }

    public void setServicoRe(String ServicoRe) {
        this.ServicoRe = ServicoRe;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

    public String ImprimirPaciente() {// funcao imprimir invocando metodos da classe mãe
        String impressao = "";
        impressao += super.imprimir();
        impressao += Principal.ANSI_CYAN+"\nServico Realizado: " +Principal.ANSI_RESET+ this.ServicoRe;

        return impressao;
    }

    public String ImprimirPacienteCompleto() {// funcao imprimir completo invocando metodos da classe mãe
        String impressao = "";
        impressao += super.imprimirCompleto();
        impressao += Principal.ANSI_CYAN+"\nServico Realizado: " + Principal.ANSI_RESET+this.ServicoRe + Principal.ANSI_CYAN+"\nMotivo: " +Principal.ANSI_RESET+ this.Motivo;

        return impressao;
    }

}
