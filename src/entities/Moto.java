package entities;

public class Moto extends Veiculo {
    public enum TipoMoto {
        NAKED, TRAIL, BIGTRAIL, OFFROAD
    }

    private TipoMoto tipoMoto;

    public Moto(String modelo, Proprietario proprietario, TipoMoto tipoMoto) {
        super(modelo, proprietario);
        this.tipoMoto = tipoMoto;
    }

    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }

    public void setTipoMoto(TipoMoto tipoMoto) {
        this.tipoMoto = tipoMoto;
    }

    @Override
    public String getTipo() {
        return "Moto";
    }
}
