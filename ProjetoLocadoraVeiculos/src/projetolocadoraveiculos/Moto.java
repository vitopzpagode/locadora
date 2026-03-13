
package projetolocadoraveiculos;

public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String modelo, String marca, int ano, double diariaBase, int cilindradas) {
        super(modelo, marca, ano, diariaBase);
        this.cilindradas = cilindradas;
    }

    @Override
    public double calcularDiaria() {
        return super.diariaBase() * 0.8;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Cilindradas: " + cilindradas + "cc");
    }
}
