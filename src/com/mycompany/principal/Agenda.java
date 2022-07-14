/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.principal;

import java.util.ArrayList;
import java.util.Collections;

public class Agenda {

    private static ArrayList<Paciente> Agenda = new ArrayList<>();
    private static ArrayList<Funcionario> AgendaRH = new ArrayList<>();

    //metodo GET
    public static ArrayList<Funcionario> getAgendaRH() {
        return AgendaRH;
    }

    public static ArrayList<Paciente> getAgenda() {
        return Agenda;
    }

    //Adicicionar Paciente
    static public void adicionar(Paciente x) {

        Agenda.add(x);

    }

    //Listar pacientes cadastrados
    static public String listar() {
        String impressao = ""; //variavel para adicionar os valores e formatar
        int i = 1; //contador

        for (Paciente x : Agenda) {
            impressao +=  "=============================="+Principal.ANSI_YELLOW +"\nPaciente N° " + (i++) + Principal.ANSI_RESET; //formatação de impressao
            impressao += x.ImprimirPaciente() + "\n" + "------------------*******------------------\n";

        }
        return impressao;
    }

    static public String buscar(String cpf) {
        String impressao = Principal.ANSI_RED + "Paciente não encontrado ou não cadastrado" + Principal.ANSI_RESET;

        for (Paciente x : Agenda) {
            if (x.getCpf().equals(cpf)) { //comparador de valores *se o "cpf" informado for igual ao armazenado, imprima.

                impressao = Principal.ANSI_YELLOW + "------------ Ficha do Paciente ------------\n" + Principal.ANSI_RESET;
                impressao += x.ImprimirPacienteCompleto();
                impressao += "\n------------------*******------------------";
                return impressao;

            }

        }
        return impressao;

    }

    static public String buscaGeral(String BuscaGeral) {//busca por qualquer atributo
        String impressao = "";

        for (Paciente x : Agenda) {
            if (x.getCpf().equalsIgnoreCase(BuscaGeral)
                    || x.getCep().equalsIgnoreCase(BuscaGeral)
                    || x.getIdade().equalsIgnoreCase(BuscaGeral)
                    || x.getNome().equalsIgnoreCase(BuscaGeral)
                    || x.getMotivo().equalsIgnoreCase(BuscaGeral)
                    || x.getServicoRe().equalsIgnoreCase(BuscaGeral)) { //comparador de valores *se o "cpf" informado for igual ao armazenado, imprima.

                impressao += Principal.ANSI_YELLOW + "------------ Ficha do Paciente ------------\n" + Principal.ANSI_RESET;
                impressao += x.ImprimirPacienteCompleto();
                impressao += "\n------------------*******------------------\n";

            }
        }

        if (impressao == "") {
            impressao = Principal.ANSI_RED + "Paciente não encontrado ou não cadastrado" + Principal.ANSI_RESET;
        }
        return impressao;
    }

    static public boolean remover(String cpf) {
        for (Paciente x : Agenda) { //comparador de valores * se o "cpf" informado for igual ao armazenado, delete.
            if (x.getCpf().equals(cpf)) {
                Agenda.remove(x);
                return true;

            }
        }
        return false;
    }

    static public boolean validar(String cpf) {
        for (Paciente x : Agenda) { //comparador de valores * se o "cpf" informado for igual ao armazenado, delete.
            if (x.getCpf().equals(cpf)) {

                return true;

            }
        }
        return false;
    }

    static public String PaciCrescente() {//ordenador crescente de pacientes

        System.out.println("Ordenado de A --> Z");
        Collections.sort(Agenda, new ListarAaZPaciente());
        String impressao = ""; //variavel para adicionar os valores e formatar
        int i = 1; //contador

        for (Paciente x : Agenda) {
            impressao += "=============================="+Principal.ANSI_YELLOW +"\nPaciente N° " + (i++) + Principal.ANSI_RESET; //formatação de impressao
            impressao += x.ImprimirPaciente() + "\n" + "------------------*******------------------\n";

        }
        return impressao;

    }

    static public String PaciDecrescente() {//ordenador decrescente de pacientes

        System.out.println("Ordenado de Z --> A");
        Collections.sort(Agenda, new ListarZaAPaciente());
        String impressao = ""; //variavel para adicionar os valores e formatar
        int i = 1; //contador

        for (Paciente x : Agenda) {
            impressao += "=============================="+Principal.ANSI_YELLOW +"\nPaciente N° " + (i++) + Principal.ANSI_RESET; //formatação de impressao
            impressao += x.ImprimirPaciente() + "\n" + "------------------*******------------------\n";

        }
        return impressao;
    }

    public static void AlterarPaciente(String nome, String cep, String ServicoRe, String Motivo, String cpf, String idade, String entrada) {//funcao para alterar dados do paciente

        for (Paciente x : Agenda) {
            if (x.getCpf().equalsIgnoreCase(cpf)) {
                x.setNome(nome);
                x.setCep(cep);
                x.setIdade(idade);
                x.setMotivo(Motivo);
                x.setServicoRe(ServicoRe);
                x.setCpf(entrada);

            }
        }

    }

    ////AGENDA DE FUNCIONARIOS
    static public void adicionarFuncionario(Funcionario y) {

        AgendaRH.add(y);
    }

    //Listar funcionarios cadastrados
    static public String listarFuncionario() {
        String impressao = ""; //variavel para adicionar os valores e formatar
        int i = 1; //contador

        for (Funcionario y : AgendaRH) {
            impressao +=  "=============================="+Principal.ANSI_YELLOW +"\nFuncionário N° " + (i++) + Principal.ANSI_RESET; //formatação de impressao
            impressao += y.ImprimirFuncionario() + "\n" + "------------------*******------------------\n";

        }
        return impressao;
    }

    static public String buscarFuncionario(String cpf) {
        String impressao = Principal.ANSI_RED + "Funcionário não encontrado ou não cadastrado" + Principal.ANSI_RESET;

        for (Funcionario x : AgendaRH) {
            if (x.getCpf().equals(cpf)) { //comparador de valores *se o "cpf" informado for igual ao armazenado, imprima.

                impressao = Principal.ANSI_YELLOW + "---------- Ficha do Funcionário -----------\n" + Principal.ANSI_RESET;
                impressao += x.ImprimirFuncionarioCompleto();
                impressao += "\n------------------*******------------------";
                return impressao;

            }

        }
        return impressao;

    }

    static public String buscaGeralFuncionario(String BuscaGeral) {
        String impressao = "";

        for (Funcionario y : AgendaRH) {
            if (y.getCpf().equalsIgnoreCase(BuscaGeral)
                    || y.getCep().equalsIgnoreCase(BuscaGeral)
                    || y.getIdade().equalsIgnoreCase(BuscaGeral)
                    || y.getNome().equalsIgnoreCase(BuscaGeral)
                    || y.getEspecialidade().equalsIgnoreCase(BuscaGeral)
                    || y.getTelefone().equalsIgnoreCase(BuscaGeral)) { //comparador de valores *se o "cpf" informado for igual ao armazenado, imprima.

                impressao += Principal.ANSI_YELLOW + "---------- Ficha do Funcionário -----------\n" + Principal.ANSI_RESET;
                impressao += y.ImprimirFuncionarioCompleto();
                impressao += "\n------------------*******------------------\n";

            }
        }

        if (impressao == "") {
            impressao = Principal.ANSI_RED + "Funcionário não encontrado ou não cadastrado" + Principal.ANSI_RESET;
        }
        return impressao;
    }

    static public boolean removerFuncionario(String cpf) {
        for (Funcionario y : AgendaRH) { //comparador de valores * se o "cpf" informado for igual ao armazenado, delete.
            if (y.getCpf().equals(cpf)) {
                AgendaRH.remove(y);
                return true;

            }
        }
        return false;
    }

    static public boolean validarFuncionario(String cpf) {
        for (Funcionario y : AgendaRH) { //comparador de valores * se o "cpf" informado for igual ao armazenado, delete.
            if (y.getCpf().equals(cpf)) {

                return true;

            }
        }
        return false;
    }

    static public String FuncCrescente() {//ordenador crescente funcionarios

        System.out.println("Ordenado de A --> Z");
        Collections.sort(AgendaRH, new ListarAaZFuncionario());
        int i = 1;
        String impressao = "";
        for (Funcionario y : AgendaRH) {
            impressao += "=============================="+Principal.ANSI_YELLOW +"\nFuncionário N° " + (i++) + Principal.ANSI_RESET;; //formatação de impressao
            impressao += y.ImprimirFuncionario() + "\n" + "------------------*******------------------\n";

        }
        return impressao;
    }

    static public String FuncDecrescente() {//ordenador decrescente de funcionarios

        System.out.println("Ordenado de Z --> A");
        Collections.sort(AgendaRH, new ListarZaAFuncionario());
        int i = 1;
        String impressao = "";
        for (Funcionario y : AgendaRH) {
            impressao += "=============================="+Principal.ANSI_YELLOW +"\nFuncionário N° " + (i++) + Principal.ANSI_RESET;; //formatação de impressao
            impressao += y.ImprimirFuncionario() + "\n" + "------------------*******------------------\n";

        }
        return impressao;
    }

    public static void AlterarFuncionario(String nome, String cep, String Especialidade, String telefone, String cpf, String idade, String entrada) {// funcao para alterar dados do funcionario

        for (Funcionario y : AgendaRH) {
            if (y.getCpf().equalsIgnoreCase(cpf)) {
                y.setNome(nome);
                y.setCep(cep);
                y.setEspecialidade(Especialidade);
                y.setTelefone(telefone);
                y.setCpf(entrada);
                y.setIdade(idade);

            }

        }
    }
}
