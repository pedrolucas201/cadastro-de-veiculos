package entities;

public class Caminhao extends Veiculo {
    private int numEixos;

    public Caminhao(String modelo, Proprietario proprietario, int numEixos) {
        super(modelo, proprietario);
        setNumEixos(numEixos);
    }

    public int getNumEixos() {
        return numEixos;
    }

    public void setNumEixos(int numEixos) {
        if (numEixos <= 0) {
            throw new IllegalArgumentException("Número de eixos deve ser maior que zero");
        }
        this.numEixos = numEixos;
    }

    @Override
    public String getTipo() {
        return "Caminhão";
    }
}
