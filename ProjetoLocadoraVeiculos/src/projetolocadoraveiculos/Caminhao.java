
package projetolocadoraveiculos;

public class Caminhao extends Veiculo {
    private double cargaMaxima;

    public Caminhao(String modelo, String marca, int ano, double diariaBase, double cargaMaxima) {
        super(modelo, marca, ano, diariaBase);
        this.cargaMaxima = cargaMaxima;
    }

    @Override
    public double calcularDiaria() {
        return super.diariaBase() * 1.5;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Carga máxima: " + cargaMaxima + " kg");
    }
}
