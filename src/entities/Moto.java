package entities;

public class Moto extends Veiculo {
    public Moto(String modelo, Proprietario proprietario) {
        super(modelo, proprietario);
    }

    @Override
    public String getTipo() {
        return "Moto";
    }

    @Override
    public void setTipo(String tipo) {
        // Implementação opcional, se necessário
    }
}
