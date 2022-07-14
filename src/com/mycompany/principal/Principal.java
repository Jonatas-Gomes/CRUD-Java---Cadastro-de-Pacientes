/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.principal;
import java.util.*;

public class Principal {

    public static void main(String[] args) throws InterruptedException {

        Scanner scan = new Scanner(System.in);
        int opcao = 0;
        int back = 0;
        Paciente paciente;
        Funcionario funcionario;

        preload();

        do {

            Thread.sleep(1300);

            int tempo = 1;
            if (back == 7) {
                break;
            }
            Exibirmenu();

            boolean tag = false; //variavel usada no metodo de tratamento de erro
            //variavel usada para calculo de timeout
            while (tag == false) {

                if (back == 7) {
                    break;//referente a area de funcionarios
                }
                try {// tenta salvar a entrada na variavel "opcao"
                    System.out.print("Opção: ");
                    opcao = scan.nextInt();
                    if (opcao > 7 || opcao < 1) { //verifica se está dentro da atuação do switch

                        System.out.println(ANSI_RED + "Opção inválida !" + ANSI_RESET);
                        Thread.sleep(150); //pausa para fluidez
                        tempo++;
                        if (tempo > 4) {//se a quantidade de erros for maior que 4 encerra a aplicação
                            Sair();
                            opcao = 7;
                            break;
                        } else {
                            Exibirmenu();
                        }
                    } else {
                        tag = true;
                    }

                } catch (Exception Error) {
                    System.out.println(ANSI_BRANCO + ANSI_RED_BACKGROUND + "Opção inválida!, DIGITE APENAS NUMEROS." + ANSI_RESET);
                    scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO
                    tempo++;
                    Thread.sleep(450);
                    if (tempo > 5) {//se a quantidade de erros for maior que 5 encerra a aplicação
                        Sair();
                        opcao = 7;
                        break;
                    }

                }

            };
            tempo = 1;
            switch (opcao) {
                case 1: // OPCAO -------- CADASTRAR PACIENTE

                    scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO
                    System.out.println(ANSI_YELLOW + "---------- Cadastro de Paciente ----------" + ANSI_RESET);//MARCAÇÃO DO INICIO
                    System.out.println("Digite o Nome do Paciente:"); //inicio da captura de dados referente ao paciente
                    String nome = scan.nextLine();

                    System.out.println("Digite o Cep do Paciente:");
                    String cep = scan.nextLine();

                    System.out.println("Digite o Serviço a ser Realizado:");
                    String servico = scan.nextLine();

                    System.out.println("Digite o Motivo da Consulta:");
                    String motivo = scan.nextLine();

                    String cpf = "";
                    while (opcao == 1) {
                        //validacao de entrada. Capturar apenas numeros
                        try {

                            System.out.println("Digite o CPF referente ao paciente");
                            cpf = scan.next();
                            double entrada = Double.parseDouble(cpf);

                            if (!(Agenda.validar(cpf))) {
                                opcao = 0;
                                scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO
                            } else {
                                System.out.println(ANSI_RED + "Erro! CPF já cadastrado" + ANSI_RESET);
                            }

                        } catch (Exception Error) {
                            System.out.println(ANSI_BRANCO + ANSI_RED_BACKGROUND + "CPF inválido!, DIGITE APENAS NUMEROS." + ANSI_RESET);
                            scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO

                        }

                    }

                    System.out.println("Digite a Idade do Paciente");
                    String idade = scan.nextLine();// fim da captura de dados referente ao paciente

                    //Criar objeto da classe Paciente
                    paciente = new Paciente(nome, cep, servico, motivo, cpf, idade);

                    //Guardar o paciente
                    Agenda.adicionar(paciente);
                    Carregar();//ANIMAÇÃO DE CARREGAMENTO
                    //Mensagem ao usuario
                    System.out.println("------------------*******------------------");
                    System.out.println("   ");
                    System.out.println(ANSI_VERDE + "Paciente Adcionado Com sucesso" + ANSI_RESET);
                    System.out.println("   ");
                    System.out.println("------------------*******------------------");

                    break;

                case 2: // OPCAO -------- LISTAR PACIENTES

                    System.out.println(ANSI_YELLOW + "----------- Pacientes Cadastrados ---------" + ANSI_RESET);
                    Thread.sleep(200);
                    System.out.print(Agenda.listar());// exibe a lista de pacientes cadastrados
                    while (tag == true) {
                        //validacao de entrada. Capturar apenas numeros
                        try {
                            System.out.println(ANSI_YELLOW + "Deseja Alterar a ordem?" + ANSI_RESET + "\n 1- Sim\n 2- Não");
                            System.out.print("Opção: ");
                            opcao = scan.nextInt();
                            if (opcao == 1) {
                                System.out.println(ANSI_YELLOW + "Escolha uma das Ordens a seguir:" + ANSI_RESET + "\n1- Alfabética A --> Z :\n2- Alfabética Z --> A :");
                                System.out.print("Opção: ");
                                opcao = scan.nextInt();
                                if (opcao == 1) {
                                    System.out.println(Agenda.PaciCrescente());//impressao em ordem crescente

                                } else {
                                    if (opcao == 2) {
                                        System.out.println(Agenda.PaciDecrescente());// impressao em ordem decrescente
                                    } else {
                                        System.out.println(ANSI_RED + "Opção inválida !" + ANSI_RESET);
                                        tag = false;
                                    }
                                }

                            } else {
                                if (opcao == 2) {
                                    break;
                                } else {
                                    System.out.println(ANSI_RED + "Opção inválida !" + ANSI_RESET);
                                    tag = false;
                                }
                            }

                        } catch (Exception Error) {
                            System.out.println(ANSI_BRANCO + ANSI_RED_BACKGROUND + "Opção inválida!, DIGITE APENAS NUMEROS." + ANSI_RESET
                            );
                            scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO
                        }
                    }

                    break;

                case 3: // OPCAO -------- BUSCAR POR PACIENTE

                    cpf = "";
                    scan.nextLine();
                    System.out.println(ANSI_YELLOW + "----------- Buscar por Paciente -----------" + ANSI_RESET);

                    cpf = "";
                    while (opcao == 3) {
                        //validacao de entrada. Capturar apenas numeros
                        try {

                            System.out.println("Digite o CPF referente ao paciente");
                            cpf = scan.next();
                            double entrada = Double.parseDouble(cpf);

                            opcao = 0;

                        } catch (Exception Error) {
                            System.out.println(ANSI_BRANCO + ANSI_RED_BACKGROUND + "CPF inválido!, DIGITE APENAS NUMEROS." + ANSI_RESET);
                            scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO

                        }

                    }

                    Carregar();

                    if (!(Agenda.getAgenda().isEmpty())) {// se a agenda não estiver vazia
                        System.out.println(Agenda.buscar(cpf));

                        if (!(Agenda.buscar(cpf).contains("Paciente não encontrado ou não cadastrado"))) {
                            while (tag == true) {
                                //validacao de entrada. Capturar apenas numeros
                                try {
                                    System.out.println(ANSI_YELLOW + "Deseja Alterar as Informações?" + ANSI_RESET + "\n 1- Sim\n 2- Não");
                                    System.out.print("Opção: ");
                                    opcao = scan.nextInt();

                                    if (opcao == 1) {
                                        scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO
                                        System.out.println(ANSI_YELLOW + "-- Modificação de Registros do Paciente ---" + ANSI_RESET);//MARCAÇÃO DO INICIO
                                        System.out.println("Digite o Nome do Paciente:"); //inicio da captura de dados referente ao paciente
                                        nome = scan.nextLine();

                                        System.out.println("Digite o Cep do Paciente:");
                                        cep = scan.nextLine();

                                        System.out.println("Digite o Serviço a ser Realizado:");
                                        servico = scan.nextLine();

                                        System.out.println("Digite o Motivo da Consulta:");
                                        motivo = scan.nextLine();

                                        String entrada = "";
                                        while (opcao == 1) {
                                            //validacao de entrada. Capturar apenas numeros
                                            try {

                                                System.out.println("Digite o CPF referente ao paciente");
                                                entrada = scan.next();
                                                double a = Double.parseDouble(entrada);
                                                if (!(entrada.equalsIgnoreCase(cpf))) {
                                                    if (!(Agenda.validar(entrada))) {
                                                        opcao = 0;

                                                    } else {
                                                        System.out.println(ANSI_RED + "Erro! CPF já cadastrado" + ANSI_RESET);
                                                    }

                                                } else {
                                                    opcao = 0;
                                                }

                                            } catch (Exception Error) {
                                                System.out.println(ANSI_BRANCO + ANSI_RED_BACKGROUND + "CPF inválido!, DIGITE APENAS NUMEROS." + ANSI_RESET);
                                                scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO
                                            }
                                        }

                                        scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO
                                        System.out.println("Digite a Idade do Paciente");
                                        idade = scan.nextLine();// fim da captura de dados referente ao paciente

                                        //Criar objeto da classe Paciente
                                        //Guardar o paciente
                                        Agenda.AlterarPaciente(nome, cep, servico, motivo, cpf, idade, entrada);

                                        Carregar();//ANIMAÇÃO DE CARREGAMENTO
                                        //Mensagem ao usuario
                                        System.out.println("------------------*******------------------");
                                        System.out.println("   ");
                                        System.out.println(ANSI_VERDE + "Paciente Alterado Com sucesso" + ANSI_RESET);
                                        System.out.println("   ");
                                        System.out.println("------------------*******------------------");

                                        break;

                                    }
                                    if (opcao == 2) {
                                        break;

                                    } else {
                                        System.out.println(ANSI_RED + "Opção inválida !" + ANSI_RESET);
                                        tag = false;
                                    }

                                } catch (Exception Error) {
                                    System.out.println(ANSI_BRANCO + ANSI_RED_BACKGROUND + "Opção inválida!, DIGITE APENAS NUMEROS." + ANSI_RESET);
                                    scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO
                                }
                            }

                        }
                    }

                    break;

                case 4: // OPCAO -------- BUSCA GERAL

                    String BuscaGeral = "";
                    scan.nextLine();
                    System.out.println(ANSI_YELLOW + "----------- Busca Geral -----------" + ANSI_RESET);
                    System.out.println("Digite Alguma informação relevante");
                    BuscaGeral = scan.nextLine();
                    Carregar();

                    if (!(Agenda.getAgenda().isEmpty())) {// se a agenda não estiver vazia
                        System.out.println(Agenda.buscaGeral(BuscaGeral));
                    }
                    break;

                case 5: // OPCAO -------- EXCLUIR PACIENTE

                    cpf = "";
                    scan.nextLine();
                    System.out.println(ANSI_YELLOW + "---------- Exclusão de Paciente ----------" + ANSI_RESET);

                    cpf = "";
                    while (opcao == 5) {

                        try {

                            System.out.println("Digite o CPF referente ao paciente");
                            double entrada = scan.nextDouble();
                            cpf = Double.toString(entrada);
                            opcao = 0;
                        } catch (Exception Error) {
                            System.out.println(ANSI_BRANCO + ANSI_RED_BACKGROUND + "CPF inválido!, DIGITE APENAS NUMEROS." + ANSI_RESET);
                            scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO
                        }
                    }
                    Carregar();
                    if (!(Agenda.getAgenda().isEmpty())) {// se a agenda não estiver vazia
                        System.out.println(Agenda.buscar(cpf));
                        if (!(Agenda.buscar(cpf).contains("Paciente não encontrado ou não cadastrado"))) {
                            while (opcao == 0) {
                                //validacao de entrada. Capturar apenas numeros
                                try {
                                    System.out.println(ANSI_YELLOW + "Deseja Excluir registro?" + ANSI_RESET + "\n 1- Sim\n 2- Não");
                                    System.out.print("Opção: ");
                                    opcao = scan.nextInt();

                                } catch (Exception Error) {
                                    System.out.println(ANSI_BRANCO + ANSI_RED_BACKGROUND + "CPF inválido!, DIGITE APENAS NUMEROS." + ANSI_RESET);
                                    scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO
                                }
                            }
                            if (opcao == 1) {// se a opcao for 1
                                Agenda.remover(cpf);
                                System.out.println("------------------*******------------------");
                                System.out.println(ANSI_RED + "Registro removido com sucesso!!" + ANSI_RESET);
                                System.out.println("------------------*******------------------");
                            } else {
                                break;
                            }
                        }
                        break;
                    }
                case 6: // OPCAO -------- AREA DE FUNCIONARIOS

                    do {
                        Thread.sleep(300);
                        opcao = 0;
                        MenuFuncionarios();
                        tag = false; //variavel usada no metodo de tratamento de erro
                        tempo = 2; //variavel usada para calculo de timeout

                        while (tag == false) {

                            try {// tenta salvar a entrada na variavel "opcao"
                                System.out.print("Opção: ");
                                opcao = scan.nextInt();
                                if (opcao > 6 || opcao < 1) { //verifica se está dentro da atuação do switch

                                    System.out.println(ANSI_RED + "Opção inválida !" + ANSI_RESET);
                                    Thread.sleep(150); //pausa para fluidez
                                    tempo++;
                                    if (tempo > 4) {//se a quantidade de erros for maior que 7 encerra a aplicação
                                        Sair();
                                        opcao = 6;
                                        back = 7;
                                        break;
                                    } else {
                                        MenuFuncionarios();
                                    }
                                } else {
                                    tag = true;
                                }

                            } catch (Exception Error) {
                                System.out.println(ANSI_BRANCO + ANSI_RED_BACKGROUND + "Opção inválida!, DIGITE APENAS NUMEROS." + ANSI_RESET);
                                scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO
                                tempo++;
                                Thread.sleep(450);
                                if (tempo > 5) {//se a quantidade de erros for maior que 7 encerra a aplicação
                                    Sair();
                                    opcao = 6;
                                    back = 7;
                                    break;
                                }

                            }

                        };
                        tempo = 1;
                        back = 1;
                        switch (opcao) {

                            case 1:  // OPCAO -------- CADASTRAR FUNCIONARIO

                                scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO
                                System.out.println(ANSI_YELLOW + "--------- Cadastro de Funcionário ---------" + ANSI_RESET);//MARCAÇÃO DO INICIO
                                System.out.println("Digite o Nome do Funcionário:"); //inicio da captura de dados referente ao paciente
                                nome = scan.nextLine();
                                System.out.println("Digite o Cep do Funcionário:");
                                cep = scan.nextLine();
                                System.out.println("Digite a Especialidade do Profissional:");
                                String Especialidade = scan.nextLine();
                                System.out.println("Digite o telefone do Profissional:");
                                String telefone = scan.nextLine();
                                cpf = "";
                                while (opcao == 1) {
                                    //validacao de entrada. Capturar apenas numeros
                                    try {
                                        System.out.println("Digite o CPF referente ao Funcionário");
                                        cpf = scan.next();
                                        double entrada = Double.parseDouble(cpf);

                                        if (!(Agenda.validarFuncionario(cpf))) {
                                            opcao = 0;
                                            scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO
                                        } else {
                                            System.out.println(ANSI_RED + "Erro! CPF já cadastrado" + ANSI_RESET);
                                        }
                                    } catch (Exception Error) {
                                        System.out.println(ANSI_BRANCO + ANSI_RED_BACKGROUND + "CPF inválido!, DIGITE APENAS NUMEROS." + ANSI_RESET);
                                        scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO
                                    }
                                }
                                System.out.println("Digite a Idade do Funcionário");
                                idade = scan.nextLine();// fim da captura de dados referente ao paciente

                                //Criar objeto da classe Paciente
                                funcionario = new Funcionario(nome, cep, Especialidade, telefone, cpf, idade);
                                //Guardar o paciente
                                Agenda.adicionarFuncionario(funcionario);
                                Carregar();//ANIMAÇÃO DE CARREGAMENTO
                                //Mensagem ao usuario
                                System.out.println("------------------*******------------------");
                                System.out.println("   ");
                                System.out.println(ANSI_VERDE + "Funcionário Adicionado Com sucesso" + ANSI_RESET);
                                System.out.println("   ");
                                System.out.println("------------------*******------------------");
                                break;

                            case 2: // OPCAO -------- LISTAR FUNCIONARIOS

                                tag = false;
                                System.out.println(ANSI_YELLOW + "-------- Funcionários Cadastrados ---------" + ANSI_RESET);
                                System.out.print(Agenda.listarFuncionario());// exibe a lista de pacientes cadastrados
                                while (tag == false) {
                                    //validacao de entrada. Capturar apenas numeros
                                    try {
                                        System.out.println(ANSI_YELLOW + "Deseja Alterar a ordem?" + ANSI_RESET + "\n 1- Sim\n 2- Não");
                                        System.out.print("Opção: ");
                                        opcao = scan.nextInt();
                                        if (opcao == 1) {
                                            System.out.println(ANSI_YELLOW + "Escolha uma das Ordens a seguir:" + ANSI_RESET + "\n1- Alfabética A --> Z :\n2- Alfabética Z --> A :");
                                            System.out.print("Opção: ");
                                            opcao = scan.nextInt();
                                            if (opcao == 1) {
                                                System.out.println(Agenda.FuncCrescente());

                                            } else {
                                                if (opcao == 2) {
                                                    System.out.println(Agenda.FuncDecrescente());
                                                } else {
                                                    System.out.println(ANSI_RED + "Opção inválida !" + ANSI_RESET);
                                                    tag = false;
                                                }
                                            }

                                        } else {
                                            if (opcao == 2) {
                                                break;
                                            } else {
                                                System.out.println(ANSI_RED + "Opção inválida !" + ANSI_RESET);
                                                tag = false;
                                            }
                                        }

                                    } catch (Exception Error) {
                                        System.out.println(ANSI_BRANCO + ANSI_RED_BACKGROUND + "Opção inválida!, DIGITE APENAS NUMEROS." + ANSI_RESET);
                                        scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO
                                    }
                                }
                                break;

                            case 3:  // OPCAO -------- BUSCAR FUNCIONARIOS

                                System.out.println(ANSI_YELLOW + "--------- Buscar por Funcionário ----------" + ANSI_RESET);
                                cpf = "";
                                while (opcao == 3) {
                                    //validacao de entrada. Capturar apenas numeros
                                    try {

                                        System.out.println("Digite o CPF referente ao Funcionário");
                                        cpf = scan.next();
                                        double entrada = Double.parseDouble(cpf);
                                        opcao = 0;
                                    } catch (Exception Error) {
                                        System.out.println(ANSI_BRANCO + ANSI_RED_BACKGROUND + "CPF inválido!, DIGITE APENAS NUMEROS." + ANSI_RESET);
                                        scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO
                                    }
                                }
                                Carregar();
                                if (!(Agenda.getAgenda().isEmpty())) {// se a agenda não estiver vazia
                                    System.out.println(Agenda.buscarFuncionario(cpf));
                                }

                                if (!(Agenda.buscarFuncionario(cpf).contains("Funcionário não encontrado ou não cadastrado"))) {
                                    while (opcao == 0) {

                                        try {
                                            System.out.println(ANSI_YELLOW + "Deseja Alterar as Informações?" + ANSI_RESET + "\n 1- Sim\n 2- Não");
                                            System.out.print("Opção: ");
                                            opcao = scan.nextInt();

                                            if (opcao == 1) {
                                                scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO
                                                System.out.println(ANSI_YELLOW + "- Modificação de registros de Funcionário -" + ANSI_RESET);//MARCAÇÃO DO INICIO
                                                System.out.println("Digite o Nome do Funcionário:"); //inicio da captura de dados referente ao funcionario
                                                nome = scan.nextLine();
                                                System.out.println("Digite o Cep do Funcionário:");
                                                cep = scan.nextLine();
                                                System.out.println("Digite a Especialidade do Profissional:");
                                                Especialidade = scan.nextLine();
                                                System.out.println("Digite o telefone do Profissional:");
                                                telefone = scan.nextLine();
                                                String entrada = "";
                                                while (opcao == 1) {
                                                    //validacao de entrada. Capturar apenas numeros
                                                    try {
                                                        System.out.println("Digite o CPF referente ao Funcionário");
                                                        entrada = scan.next();
                                                        double a = Double.parseDouble(entrada);
                                                        if (!(entrada.equalsIgnoreCase(cpf))) {//se a entrada for diferente do cpf anterior, confira se essa entrada nn ja ta cadastrada
                                                            if (!(Agenda.validarFuncionario(entrada))) {

                                                                opcao = 0;

                                                            } else {
                                                                System.out.println(ANSI_RED + "Erro! CPF já cadastrado" + ANSI_RESET);
                                                            }
                                                        } else {
                                                            opcao = 0;
                                                        }
                                                    } catch (Exception Error) {
                                                        System.out.println(ANSI_BRANCO + ANSI_RED_BACKGROUND + "CPF inválido!, DIGITE APENAS NUMEROS." + ANSI_RESET);
                                                        scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO
                                                    }
                                                }
                                                scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO
                                                System.out.println("Digite a Idade do Funcionário");
                                                idade = scan.nextLine();// fim da captura de dados referente ao paciente

                                                //alterar o novo funcionario
                                                Agenda.AlterarFuncionario(nome, cep, Especialidade, telefone, cpf, idade, entrada);

                                                Carregar();//ANIMAÇÃO DE CARREGAMENTO
                                                //Mensagem ao usuario
                                                System.out.println("------------------*******------------------");
                                                System.out.println("   ");
                                                System.out.println(ANSI_VERDE + "Funcionário Alterado Com sucesso" + ANSI_RESET);
                                                System.out.println("   ");
                                                System.out.println("------------------*******------------------");

                                                break;
                                            }
                                            if (opcao == 2) {
                                                break;
                                            } else {
                                                System.out.println("Opção inválida!");
                                                tag = false;
                                            }
                                        } catch (Exception Error) {
                                            System.out.println(ANSI_BRANCO + ANSI_RED_BACKGROUND + "Opção inválida!, DIGITE APENAS NUMEROS." + ANSI_RESET);
                                            scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO
                                        }
                                    }
                                }
                                break;

                            case 4: // OPCAO -------- BUSCA GERAL

                                BuscaGeral = "";
                                scan.nextLine();
                                System.out.println(ANSI_YELLOW + "----------- Busca Geral -----------" + ANSI_RESET);
                                System.out.println("Digite Alguma informação relevante");
                                BuscaGeral = scan.nextLine();
                                Carregar();

                                if (!(Agenda.getAgenda().isEmpty())) {// se a agenda não estiver vazia
                                    System.out.println(Agenda.buscaGeralFuncionario(BuscaGeral));
                                }
                                break;

                            case 5:  // OPCAO -------- EXCLUSAO DE FUNCIONARIOS

                                cpf = "";
                                scan.nextLine();
                                System.out.println(ANSI_YELLOW + "--------- Exclusão de Funcionário ---------" + ANSI_RESET);
                                cpf = "";
                                while (opcao == 5) {
                                    try {
                                        System.out.println("Digite o CPF referente ao Funcionário");
                                        double entrada = scan.nextDouble();
                                        cpf = Double.toString(entrada);
                                        opcao = 0;
                                    } catch (Exception Error) {
                                        System.out.println(ANSI_BRANCO + ANSI_RED_BACKGROUND + "CPF inválido!, DIGITE APENAS NUMEROS." + ANSI_RESET);
                                        scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO
                                    }
                                }
                                Carregar();
                                if (!(Agenda.getAgenda().isEmpty())) {// se a agenda não estiver vazia
                                    System.out.println(Agenda.buscarFuncionario(cpf));
                                    if (!"Funcionário não encontrado ou não cadastrado".equals(Agenda.buscarFuncionario(cpf))) {
                                        while (opcao == 0) {
                                            //validacao de entrada. Capturar apenas numeros
                                            try {
                                                System.out.println(ANSI_YELLOW + "Deseja Excluir registro?" + ANSI_RESET + "\n 1- Sim\n 2- Não");
                                                System.out.print("Opção: ");
                                                opcao = scan.nextInt();

                                            } catch (Exception Error) {
                                                System.out.println(ANSI_BRANCO + ANSI_RED_BACKGROUND + "Opção inválida!, DIGITE APENAS NUMEROS." + ANSI_RESET);
                                                scan.nextLine(); // LIMPANDO O BUFFER DO TECLADO
                                            }
                                        }
                                        if (opcao == 1) {// se a opcao for 1
                                            Agenda.removerFuncionario(cpf);
                                            System.out.println("------------------*******------------------");
                                            System.out.println(ANSI_RED + "Registro removido com sucesso!!" + ANSI_RESET);
                                            System.out.println("------------------*******------------------");
                                        } else {
                                            break;
                                        }
                                    }
                                    break;
                                }

                                break;
                            case 6: // OPCAO -------- FUNCAO VOLTAR
                                break;
                        }
                    } while (opcao != 6);
                    break;

            }
        } while (opcao != 7);
    }

    public static void Exibirmenu() {//menu principal
        System.out.println(ANSI_YELLOW + "------------ Bem-vindo ao SAP ------------" + ANSI_RESET);
        System.out.println("Digite uma das Opções abaixo:"
                + " \n 1-Cadastrar Paciente"
                + " \n 2-Listar Cadastrados"
                + " \n 3-Buscar por CPF"
                + " \n 4-Busca Geral"
                + " \n 5-Excluir Registro"
                + " \n 6-Area de Funcionários"
                + " \n 7-Sair do Programa");
        System.out.println("------------ **************** ------------");

    }

    public static void MenuFuncionarios() {//menu secundario
        System.out.println(ANSI_YELLOW + "---- Bem-vindo a Area de Funcionários -----" + ANSI_RESET);
        System.out.println("Digite uma das Opções abaixo:"
                + " \n 1-Cadastrar Funcionário"
                + " \n 2-Listar Cadastrados"
                + " \n 3-Buscar por CPF"
                + " \n 4-Busca Geral"
                + " \n 5-Excluir Registro "
                + " \n 6-Voltar");
        System.out.println("------------ **************** ------------");

    }

    static void Carregar() throws InterruptedException {// animação de carregamento
        System.out.print(ANSI_YELLOW + "Por favor aguarde.");
        for (int z = 0; z < 7; z++) {
            Thread.sleep(300);
            System.out.print(".");
        }
        System.out.println("   " + ANSI_RESET);
        System.out.println("   ");
        Thread.sleep(500);

    }

    static void Sair() throws InterruptedException {// animação de saida
        System.out.print("Saindo");
        for (int a = 0; a < 10; a++) {
            Thread.sleep(300);
            System.out.print(".");
        }
        System.out.println("");
        System.out.println("Obrigado!");
    }

    public static void preload() {
        Paciente paciente;
        Funcionario funcionario;

        funcionario = new Funcionario("Carlos Santos", "42110-020", "Oncologia Clínica", "71999443515", "1111", "55");
        Agenda.adicionarFuncionario(funcionario);
        funcionario = new Funcionario("Rogrigo Soares", "44585-020", "Patologia Clínica/Medicina Laboratorial", "71985857554", "2222", "33");
        Agenda.adicionarFuncionario(funcionario);
        funcionario = new Funcionario("Marta lima", "42560-100", "Urologia", "73995545528", "3333", "45");
        Agenda.adicionarFuncionario(funcionario);
        funcionario = new Funcionario("Deise Moreno", "48528-254", "Endoscopia", "77985545485", "4444", "55");
        Agenda.adicionarFuncionario(funcionario);
        funcionario = new Funcionario("Claudio Santos", "45658-452", "Alergia e Imunologia", "71988588758", "5555", "39");
        Agenda.adicionarFuncionario(funcionario);
        funcionario = new Funcionario("Carlinhos Santos", "41257-757", "Pediatria", "71999899855", "6666", "41");
        Agenda.adicionarFuncionario(funcionario);

        paciente = new Paciente("Matheus", "42510-020", "HEMOGRAMA", "Exame de rotina", "1111", "19");
        Agenda.adicionar(paciente);
        paciente = new Paciente("Rafaela", "40325-115", "GLICEMIA EM JEJUM", "Exame de rotina", "2222", "38");
        Agenda.adicionar(paciente);
        paciente = new Paciente("Fernanda", "40276-040", "COLESTEROL E TRIGLICERÍDEOS", "Exame de rotina", "3333", "33");
        Agenda.adicionar(paciente);
        paciente = new Paciente("Flavio", "40711-126", "UREIA E CREATINA", "Exame de rotina", "4444", "33");
        Agenda.adicionar(paciente);
        paciente = new Paciente("Maria", "41227-310", "ELETROCARDIOGRAMA", "Vai entrar na academia", "5555", "85");
        Agenda.adicionar(paciente);
        paciente = new Paciente("Maria", "40320-500", "ECOCARDIOGRAMA", "Semento de fraqueza ", "6666", "23");
        Agenda.adicionar(paciente);
        paciente = new Paciente("Felipe", "41310-176", "TESTE ERGOMÉTRICO", "Exame Admissional", "7777", "21");
        Agenda.adicionar(paciente);

    }

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_RED_BACKGROUND
            = "\u001B[41m";

    public static final String ANSI_RED
            = "\u001B[31m";
    public static final String ANSI_VERDE
            = "\u001B[32m";
    public static final String ANSI_BRANCO
            = "\u001B[37m";
    public static final String ANSI_YELLOW
            = "\u001B[33m";
    public static final String ANSI_CYAN
            = "\u001B[36m";
    public static final String ANSI_GREEN_BACKGROUND
            = "\u001B[42m";

}
