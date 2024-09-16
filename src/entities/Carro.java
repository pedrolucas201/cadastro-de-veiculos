package entities;

public class Carro extends Veiculo {
    public Carro(String modelo, Proprietario proprietario) {
        super(modelo, proprietario);
    }

    @Override
    public String getTipo() {
        return "Carro";
    }

    @Override
    public void setTipo(String tipo) {
        // Implementação opcional, se necessário
    }
}
