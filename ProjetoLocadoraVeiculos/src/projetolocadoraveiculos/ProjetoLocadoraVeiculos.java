package projetolocadoraveiculos;

import java.util.ArrayList;
import java.util.Scanner;

public class ProjetoLocadoraVeiculos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Cria objeto para entrada de dados

        // Listas para armazenar clientes, veículos e locações
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        ArrayList<Locacao> locacoes = new ArrayList<>();

        int opcao; // Variável para armazenar a opção do menu

        // Loop principal do sistema (menu)
        do {
            System.out.println("\n=== Sistema de Locadora ===");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Cadastrar veículo");
            System.out.println("3. Listar clientes");
            System.out.println("4. Listar veículos");
            System.out.println("5. Realizar locação");
            System.out.println("6. Exibir locações");
            System.out.println("7. Encerrar");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt(); // Lê a opção digitada
            sc.nextLine(); // Limpa o buffer do teclado

            switch (opcao) {

                case 1:
                    // Cadastro de cliente
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    // Cria objeto Cliente e adiciona na lista
                    Cliente c = new Cliente(nome, cpf, telefone);
                    clientes.add(c);

                    System.out.println("Cliente cadastrado com sucesso!");
                    c.exibirDetalhes(); // Mostra dados do cliente
                    break;

                case 2:
                    // Cadastro de veículo
                    System.out.println("Tipo de veículo: 1-Carro 2-Moto 3-Caminhão");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();

                    System.out.print("Marca: ");
                    String marca = sc.nextLine();

                    System.out.print("Ano: ");
                    int ano = sc.nextInt();

                    System.out.print("Diária base: ");
                    double diaria = sc.nextDouble();
                    sc.nextLine();

                    Veiculo v = null; // Variável genérica de veículo

                    // Escolhe o tipo de veículo
                    switch (tipo) {
                        case 1:
                            // Criação de carro
                            System.out.print("Portas: ");
                            int portas = sc.nextInt();
                            sc.nextLine();
                            v = new Carro(modelo, marca, ano, diaria, portas);
                            break;

                        case 2:
                            // Criação de moto
                            System.out.print("Cilindradas: ");
                            int cil = sc.nextInt();
                            sc.nextLine();
                            v = new Moto(modelo, marca, ano, diaria, cil);
                            break;

                        case 3:
                            // Criação de caminhão
                            System.out.print("Carga máxima (kg): ");
                            double carga = sc.nextDouble();
                            sc.nextLine();
                            v = new Caminhao(modelo, marca, ano, diaria, carga);
                            break;

                        default:
                            System.out.println("Tipo inválido!");
                    }

                    // Se o veículo foi criado corretamente
                    if (v != null) {
                        veiculos.add(v); // Adiciona à lista
                        System.out.println("Veículo cadastrado com sucesso!");
                        v.exibirDetalhes(); // Mostra dados do veículo
                    }
                    break;

                case 3:
                    // Lista todos os clientes
                    System.out.println("=== Lista de Clientes ===");
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println("ID: " + i); // Mostra índice como ID
                        clientes.get(i).exibirDetalhes();
                        System.out.println("---------------------");
                    }
                    break;

                case 4:
                    // Lista todos os veículos
                    System.out.println("=== Lista de Veículos ===");
                    for (int i = 0; i < veiculos.size(); i++) {
                        System.out.println("ID: " + i); // Mostra índice como ID
                        veiculos.get(i).exibirDetalhes();
                        System.out.println("---------------------");
                    }
                    break;

                case 5:
                    // Realizar uma locação

                    // Verifica se existem clientes e veículos cadastrados
                    if (clientes.isEmpty() || veiculos.isEmpty()) {
                        System.out.println("Cadastre pelo menos um cliente e um veículo primeiro!");
                        break;
                    }

                    int idCliente = -1;
                    int idVeiculo = -1;

                    // Escolha do cliente com validação
                    do {
                        System.out.println("Escolha o cliente (ID):");
                        for (int i = 0; i < clientes.size(); i++) {
                            System.out.println(i + ": " + clientes.get(i).getNome());
                        }
                        idCliente = sc.nextInt();

                        // Validação do ID
                        if (idCliente < 0 || idCliente >= clientes.size()) {
                            System.out.println("ID inválido! Tente novamente.");
                        }
                    } while (idCliente < 0 || idCliente >= clientes.size());

                    // Escolha do veículo com validação
                    do {
                        System.out.println("Escolha o veículo (ID):");
                        for (int i = 0; i < veiculos.size(); i++) {
                            System.out.println(i + ": " + veiculos.get(i).getModelo());
                        }
                        idVeiculo = sc.nextInt();

                        // Validação do ID
                        if (idVeiculo < 0 || idVeiculo >= veiculos.size()) {
                            System.out.println("ID inválido! Tente novamente.");
                        }
                    } while (idVeiculo < 0 || idVeiculo >= veiculos.size());

                    // Entrada da quantidade de dias da locação
                    System.out.print("Quantidade de dias: ");
                    int dias = sc.nextInt();
                    sc.nextLine();

                    // Cria a locação
                    Locacao loc = new Locacao(clientes.get(idCliente), veiculos.get(idVeiculo), dias);
                    locacoes.add(loc);

                    System.out.println("Locação realizada com sucesso!");
                    loc.exibirLocacao(); // Mostra dados da locação
                    break;

                case 6:
                    // Exibe todas as locações
                    System.out.println("=== Todas as Locações ===");
                    for (Locacao l : locacoes) {
                        l.exibirLocacao();
                    }
                    break;

                case 7:
                    // Encerra o sistema
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    // Caso o usuário digite uma opção inválida
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 7); // Continua até escolher sair

        sc.close(); // Fecha o Scanner
    }
}