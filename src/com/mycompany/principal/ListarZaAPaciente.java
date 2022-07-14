/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.principal;

import java.util.Comparator;
public class ListarZaAPaciente implements Comparator<Paciente> {//compara de Z a A os Pacientes

    public int compare(Paciente Pac1, Paciente Pac2) {
        if (Pac1.getNome().compareToIgnoreCase(Pac2.getNome()) > 0) {// 
            return -1;
        }

        return 1;
    }

}
