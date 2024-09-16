package interfaces;

import entities.Veiculo;

import java.util.List;

public interface ServicoVendas {
    void registrarVenda(Veiculo veiculo);
    List<Veiculo> listarVeiculos();
}
