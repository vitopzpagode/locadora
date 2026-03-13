
package projetolocadoraveiculos;

public class Carro extends Veiculo {
    private int portas;

    public Carro(String modelo, String marca, int ano, double diariaBase, int portas) {
        super(modelo, marca, ano, diariaBase);
        this.portas = portas;
    }

    @Override
    public double calcularDiaria() {
        return super.diariaBase();
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Portas: " + portas);
    }
}
