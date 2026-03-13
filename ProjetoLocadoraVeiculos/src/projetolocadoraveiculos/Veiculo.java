
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

    public abstract double calcularDiaria();

    public void exibirDetalhes() {
        System.out.println("Modelo: " + modelo);
        System.out.println("Marca: " + marca);
        System.out.println("Ano: " + ano);
        System.out.println("Diária base: R$ " + diariaBase);
    }

    public String getModelo() {
        return modelo;
    }

    double diariaBase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
