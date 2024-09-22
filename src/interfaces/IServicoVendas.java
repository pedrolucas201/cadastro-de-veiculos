package interfaces;

import entities.Veiculo;

import java.util.List;

public interface IServicoVendas {
    void registrarVenda(Veiculo veiculo);
    List<Veiculo> listarVeiculos();
}
