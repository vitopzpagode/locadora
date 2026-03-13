
package projetolocadoraveiculos;

import java.util.ArrayList;
import java.util.Scanner;

public class ProjetoLocadoraVeiculos {

    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        ArrayList<Locacao> locacoes = new ArrayList<>();

        int opcao;

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
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    Cliente c = new Cliente(nome, cpf, telefone);
                    clientes.add(c);
                    System.out.println("Cliente cadastrado com sucesso!");
                    c.exibirDetalhes();
                    break;

                case 2:
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

                    Veiculo v = null;
                    switch (tipo) {
                        case 1:
                            System.out.print("Portas: ");
                            int portas = sc.nextInt();
                            sc.nextLine();
                            v = new Carro(modelo, marca, ano, diaria, portas);
                            break;
                        case 2:
                            System.out.print("Cilindradas: ");
                            int cil = sc.nextInt();
                            sc.nextLine();
                            v = new Moto(modelo, marca, ano, diaria, cil);
                            break;
                        case 3:
                            System.out.print("Carga máxima (kg): ");
                            double carga = sc.nextDouble();
                            sc.nextLine();
                            v = new Caminhao(modelo, marca, ano, diaria, carga);
                            break;
                        default:
                            System.out.println("Tipo inválido!");
                    }
                    if (v != null) {
                        veiculos.add(v);
                        System.out.println("Veículo cadastrado com sucesso!");
                        v.exibirDetalhes();
                    }
                    break;

                case 3:
                    System.out.println("=== Lista de Clientes ===");
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println("ID: " + i);
                        clientes.get(i).exibirDetalhes();
                        System.out.println("---------------------");
                    }
                    break;

                case 4:
                    System.out.println("=== Lista de Veículos ===");
                    for (int i = 0; i < veiculos.size(); i++) {
                        System.out.println("ID: " + i);
                        veiculos.get(i).exibirDetalhes();
                        System.out.println("---------------------");
                    }
                    break;

                case 5:
                    if (clientes.isEmpty() || veiculos.isEmpty()) {
                        System.out.println("Cadastre pelo menos um cliente e um veículo primeiro!");
                        break;
                    }
                    System.out.println("Escolha o cliente (ID):");
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println(i + ": " + clientes.get(i).getNome());
                    }
                    int idCliente = sc.nextInt();
                    System.out.println("Escolha o veículo (ID):");
                    for (int i = 0; i < veiculos.size(); i++) {
                        System.out.println(i + ": " + veiculos.get(i).getModelo());
                    }
                    int idVeiculo = sc.nextInt();
                    System.out.print("Quantidade de dias: ");
                    int dias = sc.nextInt();
                    sc.nextLine();
                    Locacao loc = new Locacao(clientes.get(idCliente), veiculos.get(idVeiculo), dias);
                    locacoes.add(loc);
                    System.out.println("Locação realizada com sucesso!");
                    loc.exibirLocacao();
                    break;

                case 6:
                    System.out.println("=== Todas as Locações ===");
                    for (Locacao l : locacoes) {
                        l.exibirLocacao();
                    }
                    break;

                case 7:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 7);

        sc.close();
    }
}
