package entities;

public class Moto extends Veiculo {
    public enum TipoMoto {
        NAKED, TRAIL, BIGTRAIL, OFFROAD
    }

    private TipoMoto tipoMoto;

    public Moto(String modelo, Proprietario proprietario, TipoMoto tipoMoto) {
        super(modelo, proprietario);
        setTipoMoto(tipoMoto);
    }

    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }

    public void setTipoMoto(TipoMoto tipoMoto) {
        if (tipoMoto == null) {
            throw new IllegalArgumentException("Tipo de moto não pode ser nulo");
        }
        this.tipoMoto = tipoMoto;
    }

    @Override
    public String getTipo() {
        return "Moto";
    }
}
