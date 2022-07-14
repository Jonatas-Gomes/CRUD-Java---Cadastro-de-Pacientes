/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.principal;

import java.util.Comparator;
public class ListarAaZFuncionario implements Comparator<Funcionario> {//compara de A a Z os Funcionarios

    public int compare(Funcionario Fun1, Funcionario Fun2) {
        if (Fun1.getNome().compareToIgnoreCase(Fun2.getNome()) > 0) {
            return 1;
        }

        return -1;
    }

}
