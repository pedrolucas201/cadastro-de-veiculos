package entities;

public abstract class Veiculo {
    private String modelo;
    private Proprietario proprietario;

    public Veiculo(String modelo, Proprietario proprietario) {
        this.modelo = modelo;
        this.proprietario = proprietario;
    }

    // Getters e Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public abstract String getTipo();

    public abstract void setTipo(String tipo);
}
