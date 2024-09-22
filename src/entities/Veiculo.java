package entities;

public class Veiculo {
    private String modelo;
    private Proprietario proprietario;

    public Veiculo(String modelo, Proprietario proprietario) {
        setModelo(modelo);
        setProprietario(proprietario);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("Modelo não pode ser vazio");
        }
        this.modelo = modelo;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        if (proprietario == null) {
            throw new IllegalArgumentException("Proprietário não pode ser nulo");
        }
        this.proprietario = proprietario;
    }

    public String getTipo() {
        return "Veículo";
    }
}
