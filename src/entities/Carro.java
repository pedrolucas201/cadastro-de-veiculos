package entities;

public class Carro extends Veiculo {
    private int assentos;
    private double potenciaMotor;

    public Carro(String modelo, Proprietario proprietario, int assentos, double potenciaMotor) {
        super(modelo, proprietario);
        setAssentos(assentos);
        setPotenciaMotor(potenciaMotor);
    }

    public int getAssentos() {
        return assentos;
    }

    public void setAssentos(int assentos) {
        if (assentos <= 0) {
            throw new IllegalArgumentException("Número de assentos deve ser maior que zero");
        }
        this.assentos = assentos;
    }

    public double getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(double potenciaMotor) {
        if (potenciaMotor <= 0) {
            throw new IllegalArgumentException("Potência do motor deve ser maior que zero");
        }
        this.potenciaMotor = potenciaMotor;
    }

    @Override
    public String getTipo() {
        return "Carro";
    }
}
