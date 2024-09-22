package entities;

public class Caminhao extends Veiculo {
    private int numEixos;

    public Caminhao(String modelo, Proprietario proprietario, int numEixos) {
        super(modelo, proprietario);
        this.numEixos = numEixos;
    }

    public int getNumEixos() {
        return numEixos;
    }

    public void setNumEixos(int numEixos) {
        this.numEixos = numEixos;
    }

    @Override
    public String getTipo() {
        return "Caminhão";
    }
}
