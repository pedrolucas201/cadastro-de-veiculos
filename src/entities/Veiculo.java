package entities;

public class Veiculo {
    private String modelo;
    private Proprietario proprietario;

    public Veiculo(String modelo, Proprietario proprietario) {
        this.modelo = modelo;
        this.proprietario = proprietario;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public String getTipo() {
        return "Veículo";
    }
}
