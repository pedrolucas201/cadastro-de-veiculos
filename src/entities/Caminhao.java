package entities;

public class Caminhao extends Veiculo {
    public Caminhao(String modelo, Proprietario proprietario) {
        super(modelo, proprietario);
    }

    @Override
    public String getTipo() {
        return "Caminhão";
    }

    @Override
    public void setTipo(String tipo) {
        // Implementação opcional, se necessário
    }
}
