
package projetolocadoraveiculos;

public class Locacao {
    private Cliente cliente;
    private Veiculo veiculo;
    private int dias;

    public Locacao(Cliente cliente, Veiculo veiculo, int dias) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dias = dias;
    }

    public void exibirLocacao() {
        System.out.println("=== Locação ===");
        cliente.exibirDetalhes();
        veiculo.exibirDetalhes();
        System.out.println("Dias: " + dias);
        System.out.println("Valor total: R$ " + (veiculo.calcularDiaria() * dias));
        System.out.println("================");
    }
}

