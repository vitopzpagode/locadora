
package projetolocadoraveiculos;

public abstract class Veiculo {
    private String modelo;
    private String marca;
    private int ano;
    private double diariaBase;

    public Veiculo(String modelo, String marca, int ano, double diariaBase) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.diariaBase = diariaBase;
    }

    // Cada subclasse deve implementar sua forma de calcular a diária
    public abstract double calcularDiaria();

    // Exibe detalhes do veículo
    public void exibirDetalhes() {
        System.out.println("Modelo: " + modelo);
        System.out.println("Marca: " + marca);
        System.out.println("Ano: " + ano);
        System.out.println("Diária base: R$ " + diariaBase);
    }

    // Getters
    public String getModelo() {
        return modelo;
    }

    // Retorna a diária base (corrigido para não lançar exceção)
    public double diariaBase() {
        return diariaBase;
    }
}
