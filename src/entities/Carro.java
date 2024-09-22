package entities;

public class Carro extends Veiculo {
    private int assentos;
    private double potenciaMotor;

    public Carro(String modelo, Proprietario proprietario, int assentos, double potenciaMotor) {
        super(modelo, proprietario);
        this.assentos = assentos;
        this.potenciaMotor = potenciaMotor;
    }

    public int getAssentos() {
        return assentos;
    }

    public void setAssentos(int assentos) {
        this.assentos = assentos;
    }

    public double getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(double potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    @Override
    public String getTipo() {
        return "Carro";
    }
}
